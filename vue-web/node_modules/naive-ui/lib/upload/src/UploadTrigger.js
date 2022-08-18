"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const icons_1 = require("../../_internal/icons");
const _internal_1 = require("../../_internal");
const _utils_1 = require("../../_utils");
const interface_1 = require("./interface");
const UploadDragger_1 = __importDefault(require("./UploadDragger"));
exports.default = (0, vue_1.defineComponent)({
    name: 'UploadTrigger',
    props: {
        abstract: Boolean
    },
    setup(props, { slots }) {
        const NUpload = (0, vue_1.inject)(interface_1.uploadInjectionKey, null);
        if (!NUpload) {
            (0, _utils_1.throwError)('upload-trigger', '`n-upload-trigger` must be placed inside `n-upload`.');
        }
        const { mergedClsPrefixRef, mergedDisabledRef, maxReachedRef, listTypeRef, dragOverRef, openOpenFileDialog, draggerInsideRef, handleFileAddition } = NUpload;
        const isImageCardTypeRef = (0, vue_1.computed)(() => listTypeRef.value === 'image-card');
        function handleTriggerClick() {
            if (mergedDisabledRef.value || maxReachedRef.value)
                return;
            openOpenFileDialog();
        }
        function handleTriggerDragOver(e) {
            e.preventDefault();
            dragOverRef.value = true;
        }
        function handleTriggerDragEnter(e) {
            e.preventDefault();
            dragOverRef.value = true;
        }
        function handleTriggerDragLeave(e) {
            e.preventDefault();
            dragOverRef.value = false;
        }
        function handleTriggerDrop(e) {
            e.preventDefault();
            if (!draggerInsideRef.value ||
                mergedDisabledRef.value ||
                maxReachedRef.value) {
                return;
            }
            const dataTransfer = e.dataTransfer;
            const files = dataTransfer === null || dataTransfer === void 0 ? void 0 : dataTransfer.files;
            if (files) {
                handleFileAddition(files);
            }
            dragOverRef.value = false;
        }
        return () => {
            var _a;
            const { value: mergedClsPrefix } = mergedClsPrefixRef;
            return props.abstract ? ((_a = slots.default) === null || _a === void 0 ? void 0 : _a.call(slots, {
                handleClick: handleTriggerClick,
                handleDrop: handleTriggerDrop,
                handleDragOver: handleTriggerDragOver,
                handleDragEnter: handleTriggerDragEnter,
                handleDragLeave: handleTriggerDragLeave
            })) : ((0, vue_1.h)("div", { class: [
                    `${mergedClsPrefix}-upload-trigger`,
                    (mergedDisabledRef.value || maxReachedRef.value) &&
                        `${mergedClsPrefix}-upload-trigger--disabled`,
                    isImageCardTypeRef.value &&
                        `${mergedClsPrefix}-upload-trigger--image-card`
                ], onClick: handleTriggerClick, onDrop: handleTriggerDrop, onDragover: handleTriggerDragOver, onDragenter: handleTriggerDragEnter, onDragleave: handleTriggerDragLeave }, isImageCardTypeRef.value ? ((0, vue_1.h)(UploadDragger_1.default, null, {
                default: slots.default ||
                    (() => ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: mergedClsPrefix }, { default: () => (0, vue_1.h)(icons_1.AddIcon, null) })))
            })) : (slots)));
        };
    }
});
