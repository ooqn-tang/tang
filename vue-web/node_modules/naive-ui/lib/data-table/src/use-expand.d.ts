import type { DataTableSetupProps } from './DataTable';
import { RowKey } from './interface';
export declare function useExpand(props: DataTableSetupProps): {
    mergedExpandedRowKeysRef: import("vue").ComputedRef<RowKey[]>;
    renderExpandRef: import("vue").ComputedRef<import("./interface").RenderExpand<any> | undefined>;
    doUpdateExpandedRowKeys: (expandedKeys: RowKey[]) => void;
};
