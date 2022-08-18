"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.render = void 0;
const parse_1 = require("./parse");
const kebabRegex = /[A-Z]/g;
function kebabCase(pattern) {
    return pattern.replace(kebabRegex, match => '-' + match.toLowerCase());
}
/** TODO: refine it to solve nested object */
function upwrapProperty(prop, indent = '  ') {
    if (typeof prop === 'object' && prop !== null) {
        return (' {\n' +
            Object.entries(prop).map(v => {
                return indent + `  ${kebabCase(v[0])}: ${v[1]};`;
            }).join('\n') +
            '\n' + indent + '}');
    }
    return `: ${prop};`;
}
/** unwrap properties */
function upwrapProperties(props, instance, params) {
    if (typeof props === 'function') {
        return props({
            context: instance.context,
            props: params
        });
    }
    return props;
}
function createStyle(selector, props, instance, params) {
    if (!props)
        return '';
    // eslint-disable-next-line
    const unwrappedProps = upwrapProperties(props, instance, params);
    if (!unwrappedProps)
        return '';
    if (typeof unwrappedProps === 'string') {
        return `${selector} {\n${unwrappedProps}\n}`;
    }
    const propertyNames = Object.keys(unwrappedProps);
    if (propertyNames.length === 0) {
        if (instance.config.keepEmptyBlock)
            return selector + ' {\n}';
        return '';
    }
    const statements = selector
        ? [
            selector + ' {'
        ]
        : [];
    propertyNames.forEach(propertyName => {
        const property = unwrappedProps[propertyName];
        if (propertyName === 'raw') {
            statements.push('\n' + property + '\n');
            return;
        }
        propertyName = kebabCase(propertyName);
        if (property !== null && property !== undefined) {
            statements.push(`  ${propertyName}${upwrapProperty(property)}`);
        }
    });
    if (selector) {
        statements.push('}');
    }
    return statements.join('\n');
}
function loopCNodeListWithCallback(children, options, callback) {
    /* istanbul ignore if */
    if (!children)
        return;
    children.forEach(child => {
        if (Array.isArray(child)) {
            loopCNodeListWithCallback(child, options, callback);
        }
        else if (typeof child === 'function') {
            const grandChildren = child(options);
            if (Array.isArray(grandChildren)) {
                loopCNodeListWithCallback(grandChildren, options, callback);
            }
            else if (grandChildren) {
                callback(grandChildren);
            }
        }
        else if (child) {
            callback(child);
        }
    });
}
function traverseCNode(node, selectorPaths, styles, instance, params, styleSheet) {
    const $ = node.$;
    if (!$ || typeof $ === 'string') {
        // as a string selector
        selectorPaths.push($);
    }
    else if (typeof $ === 'function') {
        // as a lazy selector
        selectorPaths.push($({
            context: instance.context,
            props: params
        }));
    }
    else { // as a option selector
        if ($.before)
            $.before(instance.context);
        if (!$.$ || typeof $.$ === 'string') {
            selectorPaths.push($.$);
        }
        else /* istanbul ignore else */ if ($.$) {
            selectorPaths.push($.$({
                context: instance.context,
                props: params
            }));
        }
    }
    const selector = parse_1.parseSelectorPath(selectorPaths);
    const style = createStyle(selector, node.props, instance, params);
    if (styleSheet && style) {
        styleSheet.insertRule(style);
    }
    if (!styleSheet && style.length)
        styles.push(style);
    if (node.children) {
        loopCNodeListWithCallback(node.children, {
            context: instance.context,
            props: params
        }, childNode => {
            if (typeof childNode === 'string') {
                const style = createStyle(selector, { raw: childNode }, instance, params);
                if (styleSheet) {
                    styleSheet.insertRule(style);
                }
                else {
                    styles.push(style);
                }
            }
            else {
                traverseCNode(childNode, selectorPaths, styles, instance, params, styleSheet);
            }
        });
    }
    selectorPaths.pop();
    if ($ && $.after)
        $.after(instance.context);
}
function render(node, instance, props, insertRule = false) {
    const styles = [];
    traverseCNode(node, [], styles, instance, props, insertRule
        ? node.instance.__styleSheet
        : undefined);
    if (insertRule)
        return '';
    return styles.join('\n\n');
}
exports.render = render;
