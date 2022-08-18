"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const ImagePreview_1 = __importDefault(require("./ImagePreview"));
const ImageGroup_1 = require("./ImageGroup");
const _mixins_1 = require("../../_mixins");
const interface_1 = require("./interface");
const imageProps = Object.assign({ alt: String, height: [String, Number], imgProps: Object, objectFit: {
        type: String,
        default: 'fill'
    }, previewSrc: String, fallbackSrc: String, width: [String, Number], src: String, previewDisabled: Boolean, loadDescription: String, onError: Function, onLoad: Function }, interface_1.imagePreviewSharedProps);
exports.default = (0, vue_1.defineComponent)({
    name: 'Image',
    props: imageProps,
    inheritAttrs: false,
    setup(props) {
        const imageRef = (0, vue_1.ref)(null);
        const showErrorRef = (0, vue_1.ref)(false);
        const imgPropsRef = (0, vue_1.toRef)(props, 'imgProps');
        const previewInstRef = (0, vue_1.ref)(null);
        const imageGroupHandle = (0, vue_1.inject)(ImageGroup_1.imageGroupInjectionKey, null);
        const { mergedClsPrefixRef } = imageGroupHandle || (0, _mixins_1.useConfig)(props);
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
        (0, vue_1.watchEffect)(() => {
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
        const imgNode = ((0, vue_1.h)("img", Object.assign({}, imgProps, { class: [this.groupId, imgProps.class], ref: "imageRef", width: this.width || imgProps.width, height: this.height || imgProps.height, src: this.showError ? this.fallbackSrc : this.src || imgProps.src, alt: this.alt || imgProps.alt, "aria-label": this.alt || imgProps.alt, onClick: this.click, onError: this.mergedOnError, onLoad: this.mergedOnLoad, style: [imgProps.style || '', { objectFit: this.objectFit }], "data-error": this.showError, "data-preview-src": this.previewSrc || this.src })));
        return ((0, vue_1.h)("div", Object.assign({}, $attrs, { role: "none", class: [
                $attrs.class,
                `${mergedClsPrefix}-image`,
                (this.previewDisabled || this.showError) &&
                    `${mergedClsPrefix}-image--preview-disabled`
            ] }), this.groupId ? (imgNode) : ((0, vue_1.h)(ImagePreview_1.default, { theme: this.theme, themeOverrides: this.themeOverrides, clsPrefix: mergedClsPrefix, ref: "previewInstRef", showToolbar: this.showToolbar, showToolbarTooltip: this.showToolbarTooltip }, {
            default: () => imgNode
        }))));
    }
});
