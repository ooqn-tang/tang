"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const utils_1 = require("./utils");
const descriptionItemProps = {
    label: String,
    span: {
        type: Number,
        default: 1
    },
    labelStyle: [Object, String],
    contentStyle: [Object, String]
};
exports.default = (0, vue_1.defineComponent)({
    name: 'DescriptionsItem',
    [utils_1.DESCRIPTION_ITEM_FLAG]: true,
    props: descriptionItemProps,
    render() {
        return null;
    }
});
