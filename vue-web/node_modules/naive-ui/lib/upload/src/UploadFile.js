"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const vue_1 = require("vue");
const icons_1 = require("../../_internal/icons");
const button_1 = require("../../button");
const _internal_1 = require("../../_internal");
const _utils_1 = require("../../_utils");
const UploadProgress_1 = __importDefault(require("./UploadProgress"));
const interface_1 = require("./interface");
const icons_2 = require("./icons");
const utils_1 = require("./utils");
const image_1 = require("../../image");
exports.default = (0, vue_1.defineComponent)({
    name: 'UploadFile',
    props: {
        clsPrefix: {
            type: String,
            required: true
        },
        file: {
            type: Object,
            required: true
        },
        listType: {
            type: String,
            required: true
        }
    },
    setup(props) {
        // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
        const NUpload = (0, vue_1.inject)(interface_1.uploadInjectionKey);
        const imageRef = (0, vue_1.ref)(null);
        const thumbnailUrlRef = (0, vue_1.ref)('');
        const progressStatusRef = (0, vue_1.computed)(() => {
            const { file } = props;
            if (file.status === 'finished')
                return 'success';
            if (file.status === 'error')
                return 'error';
            return 'info';
        });
        const buttonTypeRef = (0, vue_1.computed)(() => {
            const { file } = props;
            if (file.status === 'error')
                return 'error';
            return undefined;
        });
        const showProgressRef = (0, vue_1.computed)(() => {
            const { file } = props;
            return file.status === 'uploading';
        });
        const showCancelButtonRef = (0, vue_1.computed)(() => {
            if (!NUpload.showCancelButtonRef.value)
                return false;
            const { file } = props;
            return ['uploading', 'pending', 'error'].includes(file.status);
        });
        const showRemoveButtonRef = (0, vue_1.computed)(() => {
            if (!NUpload.showRemoveButtonRef.value)
                return false;
            const { file } = props;
            return ['finished'].includes(file.status);
        });
        const showDownloadButtonRef = (0, vue_1.computed)(() => {
            if (!NUpload.showDownloadButtonRef.value)
                return false;
            const { file } = props;
            return ['finished'].includes(file.status);
        });
        const showRetryButtonRef = (0, vue_1.computed)(() => {
            if (!NUpload.showRetryButtonRef.value)
                return false;
            const { file } = props;
            return ['error'].includes(file.status);
        });
        const showPreviewButtonRef = (0, vue_1.computed)(() => {
            if (!NUpload.showPreviewButtonRef.value)
                return false;
            const { file: { status, url }, listType } = props;
            return (['finished'].includes(status) &&
                (url || thumbnailUrlRef.value) &&
                listType === 'image-card');
        });
        function handleRetryClick() {
            NUpload.submit(props.file.id);
        }
        function handleRemoveOrCancelClick(e) {
            e.preventDefault();
            const { file } = props;
            if (['finished', 'pending', 'error'].includes(file.status)) {
                handleRemove(file);
            }
            else if (['uploading'].includes(file.status)) {
                handleAbort(file);
            }
            else {
                (0, _utils_1.warn)('upload', 'The button clicked type is unknown.');
            }
        }
        function handleDownloadClick(e) {
            e.preventDefault();
            handleDownload(props.file);
        }
        function handleRemove(file) {
            const { XhrMap, doChange, onRemoveRef: { value: onRemove }, mergedFileListRef: { value: mergedFileList } } = NUpload;
            void Promise.resolve(onRemove
                ? onRemove({
                    file: Object.assign({}, file),
                    fileList: mergedFileList
                })
                : true).then((result) => {
                if (result === false)
                    return;
                const fileAfterChange = Object.assign({}, file, {
                    status: 'removed'
                });
                XhrMap.delete(file.id);
                doChange(fileAfterChange, undefined, {
                    remove: true
                });
            });
        }
        function handleDownload(file) {
            const { onDownloadRef: { value: onDownload } } = NUpload;
            void Promise.resolve(onDownload ? onDownload(Object.assign({}, file)) : true).then((res) => {
                /** I haven't figure out its usage, so just leave it here */
            });
        }
        function handleAbort(file) {
            const { XhrMap } = NUpload;
            const XHR = XhrMap.get(file.id);
            XHR === null || XHR === void 0 ? void 0 : XHR.abort();
            handleRemove(Object.assign({}, file));
        }
        function handlePreviewClick() {
            const { onPreviewRef: { value: onPreview } } = NUpload;
            if (onPreview) {
                onPreview(props.file);
            }
            else if (props.listType === 'image-card') {
                const { value } = imageRef;
                if (!value)
                    return;
                value.click();
            }
        }
        const deriveFileThumbnailUrl = () => __awaiter(this, void 0, void 0, function* () {
            const { listType } = props;
            if (listType !== 'image' && listType !== 'image-card') {
                return;
            }
            if (!utils_1.environmentSupportFile || !(props.file.file instanceof File)) {
                return;
            }
            thumbnailUrlRef.value = yield NUpload.getFileThumbnailUrl(props.file);
        });
        (0, vue_1.watchEffect)(() => {
            void deriveFileThumbnailUrl();
        });
        return {
            mergedTheme: NUpload.mergedThemeRef,
            progressStatus: progressStatusRef,
            buttonType: buttonTypeRef,
            showProgress: showProgressRef,
            disabled: NUpload.mergedDisabledRef,
            showCancelButton: showCancelButtonRef,
            showRemoveButton: showRemoveButtonRef,
            showDownloadButton: showDownloadButtonRef,
            showRetryButton: showRetryButtonRef,
            showPreviewButton: showPreviewButtonRef,
            thumbnailUrl: thumbnailUrlRef,
            imageRef,
            handleRemoveOrCancelClick,
            handleDownloadClick,
            handleRetryClick,
            handlePreviewClick
        };
    },
    render() {
        const { clsPrefix, mergedTheme, listType, file } = this;
        // if there is text list type, show file icon
        let icon;
        const isImageType = listType === 'image';
        const isImageCardType = listType === 'image-card';
        if (isImageType || isImageCardType) {
            icon = !(0, utils_1.isImageFile)(file) ? ((0, vue_1.h)("span", { class: `${clsPrefix}-upload-file-info__thumbnail` },
                (0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix }, { default: () => icons_2.documentIcon }))) : (file.url || this.thumbnailUrl) && file.status !== 'error' ? ((0, vue_1.h)("a", { rel: "noopener noreferer", target: "_blank", href: file.url || undefined, class: `${clsPrefix}-upload-file-info__thumbnail`, onClick: this.handlePreviewClick }, listType === 'image-card' ? ((0, vue_1.h)(image_1.NImage, { src: this.thumbnailUrl || file.thumbnailUrl || file.url || undefined, previewSrc: file.url || undefined, alt: file.name, ref: "imageRef" })) : ((0, vue_1.h)("img", { src: this.thumbnailUrl || file.thumbnailUrl || file.url || undefined, alt: file.name })))) : ((0, vue_1.h)("span", { class: `${clsPrefix}-upload-file-info__thumbnail` },
                (0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix }, { default: () => icons_2.imageIcon })));
        }
        else {
            icon = ((0, vue_1.h)("span", { class: `${clsPrefix}-upload-file-info__thumbnail` },
                (0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix }, { default: () => (0, vue_1.h)(icons_1.AttachIcon, null) })));
        }
        const progress = ((0, vue_1.h)(UploadProgress_1.default, { show: this.showProgress, percentage: file.percentage || 0, status: this.progressStatus }));
        const showName = listType === 'text' || listType === 'image';
        return ((0, vue_1.h)("div", { class: [
                `${clsPrefix}-upload-file`,
                `${clsPrefix}-upload-file--${this.progressStatus}-status`,
                file.url &&
                    file.status !== 'error' &&
                    listType !== 'image-card' &&
                    `${clsPrefix}-upload-file--with-url`,
                `${clsPrefix}-upload-file--${listType}-type`
            ] },
            (0, vue_1.h)("div", { class: `${clsPrefix}-upload-file-info` },
                icon,
                (0, vue_1.h)("div", { class: `${clsPrefix}-upload-file-info__name` },
                    showName &&
                        (file.url && file.status !== 'error' ? ((0, vue_1.h)("a", { rel: "noopener noreferer", target: "_blank", href: file.url || undefined, onClick: this.handlePreviewClick }, file.name)) : ((0, vue_1.h)("span", { onClick: this.handlePreviewClick }, file.name))),
                    isImageType && progress),
                (0, vue_1.h)("div", { class: [
                        `${clsPrefix}-upload-file-info__action`,
                        `${clsPrefix}-upload-file-info__action--${listType}-type`
                    ] },
                    this.showPreviewButton ? ((0, vue_1.h)(button_1.NButton, { key: "preview", text: true, type: this.buttonType, onClick: this.handlePreviewClick, theme: mergedTheme.peers.Button, themeOverrides: mergedTheme.peerOverrides.Button }, {
                        icon: () => ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix }, { default: () => (0, vue_1.h)(icons_1.EyeIcon, null) }))
                    })) : null,
                    (this.showRemoveButton || this.showCancelButton) &&
                        !this.disabled && ((0, vue_1.h)(button_1.NButton, { key: "cancelOrTrash", theme: mergedTheme.peers.Button, themeOverrides: mergedTheme.peerOverrides.Button, text: true, type: this.buttonType, onClick: this.handleRemoveOrCancelClick }, {
                        icon: () => ((0, vue_1.h)(_internal_1.NIconSwitchTransition, null, {
                            default: () => this.showRemoveButton ? ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix, key: "trash" }, { default: () => (0, vue_1.h)(icons_1.TrashIcon, null) })) : ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix, key: "cancel" }, { default: () => (0, vue_1.h)(icons_1.CancelIcon, null) }))
                        }))
                    })),
                    this.showRetryButton && !this.disabled && ((0, vue_1.h)(button_1.NButton, { key: "retry", text: true, type: this.buttonType, onClick: this.handleRetryClick, theme: mergedTheme.peers.Button, themeOverrides: mergedTheme.peerOverrides.Button }, {
                        icon: () => ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix }, { default: () => (0, vue_1.h)(icons_1.RetryIcon, null) }))
                    })),
                    this.showDownloadButton ? ((0, vue_1.h)(button_1.NButton, { key: "download", text: true, type: this.buttonType, onClick: this.handleDownloadClick, theme: mergedTheme.peers.Button, themeOverrides: mergedTheme.peerOverrides.Button }, {
                        icon: () => ((0, vue_1.h)(_internal_1.NBaseIcon, { clsPrefix: clsPrefix }, { default: () => (0, vue_1.h)(icons_1.DownloadIcon, null) }))
                    })) : null)),
            !isImageType && progress));
    }
});
