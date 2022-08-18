"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.defaultFilter = exports.createValOptMap = exports.filterOptions = exports.patternMatched = exports.tmOptions = exports.getIgnored = exports.getIsGroup = exports.getKey = void 0;
function getKey(option) {
    if (getIsGroup(option)) {
        return (option.name ||
            option.key ||
            'key-required');
    }
    return option.value;
}
exports.getKey = getKey;
function getIsGroup(option) {
    return option.type === 'group';
}
exports.getIsGroup = getIsGroup;
function getIgnored(option) {
    return option.type === 'ignored';
}
exports.getIgnored = getIgnored;
exports.tmOptions = {
    getKey,
    getIsGroup,
    getIgnored
};
function patternMatched(pattern, value) {
    try {
        return !!(1 + value.toString().toLowerCase().indexOf(pattern.trim().toLowerCase()));
    }
    catch (err) {
        return false;
    }
}
exports.patternMatched = patternMatched;
function filterOptions(originalOpts, filter, pattern) {
    if (!filter)
        return originalOpts;
    function traverse(options) {
        if (!Array.isArray(options))
            return [];
        const filteredOptions = [];
        for (const option of options) {
            if (getIsGroup(option)) {
                const children = traverse(option.children);
                if (children.length) {
                    filteredOptions.push(Object.assign({}, option, {
                        children
                    }));
                }
            }
            else if (getIgnored(option)) {
                continue;
            }
            else if (filter(pattern, option)) {
                filteredOptions.push(option);
            }
        }
        return filteredOptions;
    }
    return traverse(originalOpts);
}
exports.filterOptions = filterOptions;
function createValOptMap(options) {
    const valOptMap = new Map();
    options.forEach((option) => {
        if (getIsGroup(option)) {
            ;
            option.children.forEach((SelectGroupOption) => {
                valOptMap.set(SelectGroupOption.value, SelectGroupOption);
            });
        }
        else {
            valOptMap.set(option.value, option);
        }
    });
    return valOptMap;
}
exports.createValOptMap = createValOptMap;
function defaultFilter(pattern, option) {
    if (!option)
        return false;
    if (typeof option.label === 'string') {
        return patternMatched(pattern, option.label);
    }
    else if (option.value !== undefined) {
        return patternMatched(pattern, String(option.value));
    }
    return false;
}
exports.defaultFilter = defaultFilter;
