"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const _utils_1 = require("../../../_utils");
const interface_1 = require("./interface");
exports.default = (0, vue_1.defineComponent)({
    name: 'NBaseSelectGroupHeader',
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
    setup() {
        const { renderLabelRef, renderOptionRef
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
         } = (0, vue_1.inject)(interface_1.internalSelectionMenuInjectionKey);
        return {
            renderLabel: renderLabelRef,
            renderOption: renderOptionRef
        };
    },
    render() {
        const { clsPrefix, renderLabel, renderOption, tmNode: { rawNode } } = this;
        const children = renderLabel
            ? renderLabel(rawNode, false)
            : (0, _utils_1.render)(rawNode.label, rawNode, false);
        const node = ((0, vue_1.h)("div", { class: `${clsPrefix}-base-select-group-header` }, children));
        return rawNode.render
            ? rawNode.render({ node, option: rawNode })
            : renderOption
                ? renderOption({ node, option: rawNode, selected: false })
                : node;
    }
});
