import { defineComponent, h, inject, ref, toRef, watchEffect } from 'vue';
import NImagePreview from './ImagePreview';
import { imageGroupInjectionKey } from './ImageGroup';
import { useConfig } from '../../_mixins';
import { imagePreviewSharedProps } from './interface';
const imageProps = Object.assign({ alt: String, height: [String, Number], imgProps: Object, objectFit: {
        type: String,
        default: 'fill'
    }, previewSrc: String, fallbackSrc: String, width: [String, Number], src: String, previewDisabled: Boolean, loadDescription: String, onError: Function, onLoad: Function }, imagePreviewSharedProps);
export default defineComponent({
    name: 'Image',
    props: imageProps,
    inheritAttrs: false,
    setup(props) {
        const imageRef = ref(null);
        const showErrorRef = ref(false);
        const imgPropsRef = toRef(props, 'imgProps');
        const previewInstRef = ref(null);
        const imageGroupHandle = inject(imageGroupInjectionKey, null);
        const { mergedClsPrefixRef } = imageGroupHandle || useConfig(props);
        const exposedMethods = {
            click: () => {
                if (props.previewDisabled || showErrorRef.value)
                    return;
                const mergedPreviewSrc = props.previewSrc || props.src;
                if (imageGroupHandle) {
                    imageGroupHandle.setPreviewSrc(mergedPreviewSrc);
                    imageGroupHandle.setThumbnailEl(imageRef.value);
                    imageGroupHandle.toggleShow();
                    return;
                }
                const { value: previewInst } = previewInstRef;
                if (!previewInst)
                    return;
                previewInst.setPreviewSrc(mergedPreviewSrc);
                previewInst.setThumbnailEl(imageRef.value);
                previewInst.toggleShow();
            }
        };
        watchEffect(() => {
            var _a;
            void props.src;
            void ((_a = props.imgProps) === null || _a === void 0 ? void 0 : _a.src);
            showErrorRef.value = false;
        });
        return Object.assign({ mergedClsPrefix: mergedClsPrefixRef, groupId: imageGroupHandle === null || imageGroupHandle === void 0 ? void 0 : imageGroupHandle.groupId, previewInstRef,
            imageRef, imgProps: imgPropsRef, showError: showErrorRef, mergedOnError: (e) => {
                showErrorRef.value = true;
                const { onError, imgProps: { onError: imgPropsOnError } = {} } = props;
                onError === null || onError === void 0 ? void 0 : onError(e);
                imgPropsOnError === null || imgPropsOnError === void 0 ? void 0 : imgPropsOnError(e);
            }, mergedOnLoad: (e) => {
                const { onLoad, imgProps: { onLoad: imgPropsOnLoad } = {} } = props;
                onLoad === null || onLoad === void 0 ? void 0 : onLoad(e);
                imgPropsOnLoad === null || imgPropsOnLoad === void 0 ? void 0 : imgPropsOnLoad(e);
            } }, exposedMethods);
    },
    render() {
        const { mergedClsPrefix, imgProps = {}, $attrs } = this;
        const imgNode = (h("img", Object.assign({}, imgProps, { class: [this.groupId, imgProps.class], ref: "imageRef", width: this.width || imgProps.width, height: this.height || imgProps.height, src: this.showError ? this.fallbackSrc : this.src || imgProps.src, alt: this.alt || imgProps.alt, "aria-label": this.alt || imgProps.alt, onClick: this.click, onError: this.mergedOnError, onLoad: this.mergedOnLoad, style: [imgProps.style || '', { objectFit: this.objectFit }], "data-error": this.showError, "data-preview-src": this.previewSrc || this.src })));
        return (h("div", Object.assign({}, $attrs, { role: "none", class: [
                $attrs.class,
                `${mergedClsPrefix}-image`,
                (this.previewDisabled || this.showError) &&
                    `${mergedClsPrefix}-image--preview-disabled`
            ] }), this.groupId ? (imgNode) : (h(NImagePreview, { theme: this.theme, themeOverrides: this.themeOverrides, clsPrefix: mergedClsPrefix, ref: "previewInstRef", showToolbar: this.showToolbar, showToolbarTooltip: this.showToolbarTooltip }, {
            default: () => imgNode
        }))));
    }
});
