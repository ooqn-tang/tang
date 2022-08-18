import { defineComponent } from 'vue';
import { DESCRIPTION_ITEM_FLAG } from './utils';
const descriptionItemProps = {
    label: String,
    span: {
        type: Number,
        default: 1
    },
    labelStyle: [Object, String],
    contentStyle: [Object, String]
};
export default defineComponent({
    name: 'DescriptionsItem',
    [DESCRIPTION_ITEM_FLAG]: true,
    props: descriptionItemProps,
    render() {
        return null;
    }
});
