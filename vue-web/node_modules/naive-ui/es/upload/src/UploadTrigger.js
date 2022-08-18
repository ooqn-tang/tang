import { h, defineComponent, inject, computed } from 'vue';
import { AddIcon } from '../../_internal/icons';
import { NBaseIcon } from '../../_internal';
import { throwError } from '../../_utils';
import { uploadInjectionKey } from './interface';
import NUploadDragger from './UploadDragger';
export default defineComponent({
    name: 'UploadTrigger',
    props: {
        abstract: Boolean
    },
    setup(props, { slots }) {
        const NUpload = inject(uploadInjectionKey, null);
        if (!NUpload) {
            throwError('upload-trigger', '`n-upload-trigger` must be placed inside `n-upload`.');
        }
        const { mergedClsPrefixRef, mergedDisabledRef, maxReachedRef, listTypeRef, dragOverRef, openOpenFileDialog, draggerInsideRef, handleFileAddition } = NUpload;
        const isImageCardTypeRef = computed(() => listTypeRef.value === 'image-card');
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
            })) : (h("div", { class: [
                    `${mergedClsPrefix}-upload-trigger`,
                    (mergedDisabledRef.value || maxReachedRef.value) &&
                        `${mergedClsPrefix}-upload-trigger--disabled`,
                    isImageCardTypeRef.value &&
                        `${mergedClsPrefix}-upload-trigger--image-card`
                ], onClick: handleTriggerClick, onDrop: handleTriggerDrop, onDragover: handleTriggerDragOver, onDragenter: handleTriggerDragEnter, onDragleave: handleTriggerDragLeave }, isImageCardTypeRef.value ? (h(NUploadDragger, null, {
                default: slots.default ||
                    (() => (h(NBaseIcon, { clsPrefix: mergedClsPrefix }, { default: () => h(AddIcon, null) })))
            })) : (slots)));
        };
    }
});
