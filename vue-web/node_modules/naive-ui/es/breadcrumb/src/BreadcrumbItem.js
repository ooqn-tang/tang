import { h, defineComponent, inject, computed } from 'vue';
import { warn } from '../../_utils';
import { useBrowserLocation } from '../../_utils/composable/use-browser-location';
import { breadcrumbInjectionKey } from './Breadcrumb';
const breadcrumbItemProps = {
    separator: String,
    href: String
};
export default defineComponent({
    name: 'BreadcrumbItem',
    props: breadcrumbItemProps,
    setup(props, { slots }) {
        const NBreadcrumb = inject(breadcrumbInjectionKey, null);
        if (!NBreadcrumb) {
            if (process.env.NODE_ENV !== 'production') {
                warn('breadcrumb', '`n-breadcrumb-item` must be placed inside `n-breadcrumb`.');
            }
            return () => null;
        }
        const { separatorRef, mergedClsPrefixRef } = NBreadcrumb;
        const browserLocationRef = useBrowserLocation();
        const htmlTagRef = computed(() => (props.href ? 'a' : 'span'));
        const ariaCurrentRef = computed(() => browserLocationRef.value.href === props.href ? 'location' : null);
        return () => {
            var _a;
            const { value: mergedClsPrefix } = mergedClsPrefixRef;
            return (h("li", { class: `${mergedClsPrefix}-breadcrumb-item` },
                h(htmlTagRef.value, {
                    class: `${mergedClsPrefix}-breadcrumb-item__link`,
                    'aria-current': ariaCurrentRef.value,
                    href: props.href
                }, slots),
                h("span", { class: `${mergedClsPrefix}-breadcrumb-item__separator`, "aria-hidden": "true" }, slots.separator
                    ? slots.separator()
                    : (_a = props.separator) !== null && _a !== void 0 ? _a : separatorRef.value)));
        };
    }
});
