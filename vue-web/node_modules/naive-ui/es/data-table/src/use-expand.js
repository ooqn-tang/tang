import { toRef, ref } from 'vue';
import { useMemo, useMergedState } from 'vooks';
import { call, warn } from '../../_utils';
// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function useExpand(props) {
    const renderExpandRef = useMemo(() => {
        for (const col of props.columns) {
            if (col.type === 'expand') {
                if (process.env.NODE_ENV !== 'production' && !col.renderExpand) {
                    warn('data-table', 'column with type `expand` has no `renderExpand` prop.');
                }
                return col.renderExpand;
            }
        }
    });
    const uncontrolledExpandedRowKeysRef = ref(props.defaultExpandedRowKeys);
    const controlledExpandedRowKeysRef = toRef(props, 'expandedRowKeys');
    const mergedExpandedRowKeysRef = useMergedState(controlledExpandedRowKeysRef, uncontrolledExpandedRowKeysRef);
    function doUpdateExpandedRowKeys(expandedKeys) {
        const { onUpdateExpandedRowKeys, 'onUpdate:expandedRowKeys': _onUpdateExpandedRowKeys } = props;
        if (onUpdateExpandedRowKeys) {
            call(onUpdateExpandedRowKeys, expandedKeys);
        }
        if (_onUpdateExpandedRowKeys) {
            call(_onUpdateExpandedRowKeys, expandedKeys);
        }
        uncontrolledExpandedRowKeysRef.value = expandedKeys;
    }
    return {
        mergedExpandedRowKeysRef,
        renderExpandRef,
        doUpdateExpandedRowKeys
    };
}
