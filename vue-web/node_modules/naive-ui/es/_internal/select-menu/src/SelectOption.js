import { h, inject, defineComponent, Transition } from 'vue';
import { useMemo } from 'vooks';
import { CheckmarkIcon } from '../../icons';
import NBaseIcon from '../../icon';
import { render } from '../../../_utils';
import { internalSelectionMenuInjectionKey } from './interface';
const checkMarkIcon = h(CheckmarkIcon);
function renderCheckMark(show, clsPrefix) {
    return (h(Transition, { name: "fade-in-scale-up-transition" }, {
        default: () => show ? (h(NBaseIcon, { clsPrefix: clsPrefix, class: `${clsPrefix}-base-select-option__check` }, {
            default: () => checkMarkIcon
        })) : null
    }));
}
export default defineComponent({
    name: 'NBaseSelectOption',
    props: {
        clsPrefix: {
            type: String,
            required: true
        },
        tmNode: {
            type: Object,
            required: true
        }
    },
    setup(props) {
        const { valueRef, pendingTmNodeRef, multipleRef, valueSetRef, renderLabelRef, renderOptionRef, handleOptionClick, handleOptionMouseEnter
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
         } = inject(internalSelectionMenuInjectionKey);
        const isPendingRef = useMemo(() => {
            const { value: pendingTmNode } = pendingTmNodeRef;
            if (!pendingTmNode)
                return false;
            return props.tmNode.key === pendingTmNode.key;
        });
        function handleClick(e) {
            const { tmNode } = props;
            if (tmNode.disabled)
                return;
            handleOptionClick(e, tmNode);
        }
        function handleMouseEnter(e) {
            const { tmNode } = props;
            if (tmNode.disabled)
                return;
            handleOptionMouseEnter(e, tmNode);
        }
        function handleMouseMove(e) {
            const { tmNode } = props;
            const { value: isPending } = isPendingRef;
            if (tmNode.disabled || isPending)
                return;
            handleOptionMouseEnter(e, tmNode);
        }
        return {
            multiple: multipleRef,
            isGrouped: useMemo(() => {
                const { tmNode } = props;
                const { parent } = tmNode;
                return parent && parent.rawNode.type === 'group';
            }),
            isPending: isPendingRef,
            isSelected: useMemo(() => {
                const { value } = valueRef;
                const { value: multiple } = multipleRef;
                if (value === null)
                    return false;
                const optionValue = props.tmNode.rawNode.value;
                if (multiple) {
                    const { value: valueSet } = valueSetRef;
                    return valueSet.has(optionValue);
                }
                else {
                    return value === optionValue;
                }
            }),
            renderLabel: renderLabelRef,
            renderOption: renderOptionRef,
            handleMouseMove,
            handleMouseEnter,
            handleClick
        };
    },
    render() {
        const { clsPrefix, tmNode: { rawNode }, isSelected, isPending, isGrouped, multiple, renderOption, renderLabel, handleClick, handleMouseEnter, handleMouseMove } = this;
        const showCheckMark = multiple && isSelected;
        const checkmark = renderCheckMark(showCheckMark, clsPrefix);
        const children = renderLabel
            ? [renderLabel(rawNode, isSelected), checkmark]
            : [render(rawNode.label, rawNode, isSelected), checkmark];
        const node = (h("div", { class: [
                `${clsPrefix}-base-select-option`,
                rawNode.class,
                {
                    [`${clsPrefix}-base-select-option--disabled`]: rawNode.disabled,
                    [`${clsPrefix}-base-select-option--selected`]: isSelected,
                    [`${clsPrefix}-base-select-option--grouped`]: isGrouped,
                    [`${clsPrefix}-base-select-option--pending`]: isPending
                }
            ], style: rawNode.style, onClick: handleClick, onMouseenter: handleMouseEnter, onMousemove: handleMouseMove },
            h("div", { class: `${clsPrefix}-base-select-option__content` }, children)));
        return rawNode.render
            ? rawNode.render({ node, option: rawNode, selected: isSelected })
            : renderOption
                ? renderOption({ node, option: rawNode, selected: isSelected })
                : node;
    }
});
