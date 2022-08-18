"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const lodash_1 = require("lodash");
const ellipsis_1 = require("../../../ellipsis");
exports.default = (0, vue_1.defineComponent)({
    name: 'DataTableCell',
    props: {
        row: {
            type: Object,
            required: true
        },
        index: {
            type: Number,
            required: true
        },
        column: {
            type: Object,
            required: true
        },
        isSummary: Boolean,
        mergedTheme: {
            type: Object,
            required: true
        }
    },
    render() {
        const { isSummary, column: { render, key, ellipsis }, row } = this;
        let cell;
        if (render && !isSummary) {
            cell = render(row, this.index);
        }
        else {
            if (isSummary) {
                cell = row[key].value;
            }
            else {
                cell = (0, lodash_1.get)(row, key);
            }
        }
        if (ellipsis && typeof ellipsis === 'object') {
            const { mergedTheme } = this;
            return ((0, vue_1.h)(ellipsis_1.NEllipsis, Object.assign({}, ellipsis, { theme: mergedTheme.peers.Ellipsis, themeOverrides: mergedTheme.peerOverrides.Ellipsis }), { default: () => cell }));
        }
        return cell;
    }
});
