"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.useExpand = void 0;
const vue_1 = require("vue");
const vooks_1 = require("vooks");
const _utils_1 = require("../../_utils");
// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
function useExpand(props) {
    const renderExpandRef = (0, vooks_1.useMemo)(() => {
        for (const col of props.columns) {
            if (col.type === 'expand') {
                if (process.env.NODE_ENV !== 'production' && !col.renderExpand) {
                    (0, _utils_1.warn)('data-table', 'column with type `expand` has no `renderExpand` prop.');
                }
                return col.renderExpand;
            }
        }
    });
    const uncontrolledExpandedRowKeysRef = (0, vue_1.ref)(props.defaultExpandedRowKeys);
    const controlledExpandedRowKeysRef = (0, vue_1.toRef)(props, 'expandedRowKeys');
    const mergedExpandedRowKeysRef = (0, vooks_1.useMergedState)(controlledExpandedRowKeysRef, uncontrolledExpandedRowKeysRef);
    function doUpdateExpandedRowKeys(expandedKeys) {
        const { onUpdateExpandedRowKeys, 'onUpdate:expandedRowKeys': _onUpdateExpandedRowKeys } = props;
        if (onUpdateExpandedRowKeys) {
            (0, _utils_1.call)(onUpdateExpandedRowKeys, expandedKeys);
        }
        if (_onUpdateExpandedRowKeys) {
            (0, _utils_1.call)(_onUpdateExpandedRowKeys, expandedKeys);
        }
        uncontrolledExpandedRowKeysRef.value = expandedKeys;
    }
    return {
        mergedExpandedRowKeysRef,
        renderExpandRef,
        doUpdateExpandedRowKeys
    };
}
exports.useExpand = useExpand;
