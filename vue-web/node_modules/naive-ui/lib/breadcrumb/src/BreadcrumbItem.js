"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const _utils_1 = require("../../_utils");
const use_browser_location_1 = require("../../_utils/composable/use-browser-location");
const Breadcrumb_1 = require("./Breadcrumb");
const breadcrumbItemProps = {
    separator: String,
    href: String
};
exports.default = (0, vue_1.defineComponent)({
    name: 'BreadcrumbItem',
    props: breadcrumbItemProps,
    setup(props, { slots }) {
        const NBreadcrumb = (0, vue_1.inject)(Breadcrumb_1.breadcrumbInjectionKey, null);
        if (!NBreadcrumb) {
            if (process.env.NODE_ENV !== 'production') {
                (0, _utils_1.warn)('breadcrumb', '`n-breadcrumb-item` must be placed inside `n-breadcrumb`.');
            }
            return () => null;
        }
        const { separatorRef, mergedClsPrefixRef } = NBreadcrumb;
        const browserLocationRef = (0, use_browser_location_1.useBrowserLocation)();
        const htmlTagRef = (0, vue_1.computed)(() => (props.href ? 'a' : 'span'));
        const ariaCurrentRef = (0, vue_1.computed)(() => browserLocationRef.value.href === props.href ? 'location' : null);
        return () => {
            var _a;
            const { value: mergedClsPrefix } = mergedClsPrefixRef;
            return ((0, vue_1.h)("li", { class: `${mergedClsPrefix}-breadcrumb-item` },
                (0, vue_1.h)(htmlTagRef.value, {
                    class: `${mergedClsPrefix}-breadcrumb-item__link`,
                    'aria-current': ariaCurrentRef.value,
                    href: props.href
                }, slots),
                (0, vue_1.h)("span", { class: `${mergedClsPrefix}-breadcrumb-item__separator`, "aria-hidden": "true" }, slots.separator
                    ? slots.separator()
                    : (_a = props.separator) !== null && _a !== void 0 ? _a : separatorRef.value)));
        };
    }
});
