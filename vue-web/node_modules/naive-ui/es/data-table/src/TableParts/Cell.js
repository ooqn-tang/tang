import { defineComponent, h } from 'vue';
import { get } from 'lodash-es';
import { NEllipsis } from '../../../ellipsis';
export default defineComponent({
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
                cell = get(row, key);
            }
        }
        if (ellipsis && typeof ellipsis === 'object') {
            const { mergedTheme } = this;
            return (h(NEllipsis, Object.assign({}, ellipsis, { theme: mergedTheme.peers.Ellipsis, themeOverrides: mergedTheme.peerOverrides.Ellipsis }), { default: () => cell }));
        }
        return cell;
    }
});
