import { h, defineComponent } from 'vue';
export default defineComponent({
    name: 'FormItemFeedback',
    props: {
        clsPrefix: {
            type: String,
            required: true
        },
        explains: Array,
        feedback: String
    },
    render() {
        var _a;
        const { $slots, feedback, clsPrefix } = this;
        if ($slots.default) {
            return $slots.default();
        }
        return feedback ? (h("div", { key: feedback, class: `${clsPrefix}-form-item-feedback__line` }, feedback)) : ((_a = this.explains) === null || _a === void 0 ? void 0 : _a.map((explain) => (h("div", { key: explain, class: `${clsPrefix}-form-item-feedback__line` }, explain))));
    }
});
