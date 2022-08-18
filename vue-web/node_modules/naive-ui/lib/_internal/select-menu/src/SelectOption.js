"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const vooks_1 = require("vooks");
const icons_1 = require("../../icons");
const icon_1 = __importDefault(require("../../icon"));
const _utils_1 = require("../../../_utils");
const interface_1 = require("./interface");
const checkMarkIcon = (0, vue_1.h)(icons_1.CheckmarkIcon);
function renderCheckMark(show, clsPrefix) {
    return ((0, vue_1.h)(vue_1.Transition, { name: "fade-in-scale-up-transition" }, {
        default: () => show ? ((0, vue_1.h)(icon_1.default, { clsPrefix: clsPrefix, class: `${clsPrefix}-base-select-option__check` }, {
            default: () => checkMarkIcon
        })) : null
    }));
}
exports.default = (0, vue_1.defineComponent)({
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
         } = (0, vue_1.inject)(interface_1.internalSelectionMenuInjectionKey);
        const isPendingRef = (0, vooks_1.useMemo)(() => {
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
            isGrouped: (0, vooks_1.useMemo)(() => {
                const { tmNode } = props;
                const { parent } = tmNode;
                return parent && parent.rawNode.type === 'group';
            }),
            isPending: isPendingRef,
            isSelected: (0, vooks_1.useMemo)(() => {
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
            : [(0, _utils_1.render)(rawNode.label, rawNode, isSelected), checkmark];
        const node = ((0, vue_1.h)("div", { class: [
                `${clsPrefix}-base-select-option`,
                rawNode.class,
                {
                    [`${clsPrefix}-base-select-option--disabled`]: rawNode.disabled,
                    [`${clsPrefix}-base-select-option--selected`]: isSelected,
                    [`${clsPrefix}-base-select-option--grouped`]: isGrouped,
                    [`${clsPrefix}-base-select-option--pending`]: isPending
                }
            ], style: rawNode.style, onClick: handleClick, onMouseenter: handleMouseEnter, onMousemove: handleMouseMove },
            (0, vue_1.h)("div", { class: `${clsPrefix}-base-select-option__content` }, children)));
        return rawNode.render
            ? rawNode.render({ node, option: rawNode, selected: isSelected })
            : renderOption
                ? renderOption({ node, option: rawNode, selected: isSelected })
                : node;
    }
});
