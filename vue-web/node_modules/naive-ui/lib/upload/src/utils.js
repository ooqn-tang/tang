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
Object.defineProperty(exports, "__esModule", { value: true });
exports.environmentSupportFile = exports.createImageDataUrl = exports.isImageFile = exports.isImageFileType = void 0;
const isImageFileType = (type) => type.includes('image/');
exports.isImageFileType = isImageFileType;
const getExtname = (url = '') => {
    const temp = url.split('/');
    const filename = temp[temp.length - 1];
    const filenameWithoutSuffix = filename.split(/#|\?/)[0];
    return (/\.[^./\\]*$/.exec(filenameWithoutSuffix) || [''])[0];
};
const isImageFile = (file) => {
    if (file.type) {
        return (0, exports.isImageFileType)(file.type);
    }
    const url = file.thumbnailUrl || file.url || '';
    const extension = getExtname(url);
    if (/^data:image\//.test(url) ||
        /(webp|svg|png|gif|jpg|jpeg|jfif|bmp|dpg|ico)$/i.test(extension)) {
        return true;
    }
    if (/^data:/.test(url)) {
        return false;
    }
    if (extension) {
        return false;
    }
    return true;
};
exports.isImageFile = isImageFile;
function createImageDataUrl(file) {
    return __awaiter(this, void 0, void 0, function* () {
        return yield new Promise((resolve) => {
            if (!file.type || !(0, exports.isImageFileType)(file.type)) {
                resolve('');
                return;
            }
            const img = new Image();
            img.src = window.URL.createObjectURL(file);
            img.onload = () => {
                const { width, height } = img;
                const canvas = document.createElement('canvas');
                const ctx = canvas.getContext('2d');
                canvas.width = width;
                canvas.height = height;
                canvas.style.cssText = `position: fixed; left: 0; top: 0; width: ${width}px; height: ${height}px; z-index: 9999; display: none;`;
                document.body.appendChild(canvas);
                ctx === null || ctx === void 0 ? void 0 : ctx.drawImage(img, 0, 0, width, height);
                const dataURL = canvas.toDataURL();
                document.body.removeChild(canvas);
                resolve(dataURL);
            };
        });
    });
}
exports.createImageDataUrl = createImageDataUrl;
exports.environmentSupportFile = typeof document !== 'undefined' &&
    typeof window !== 'undefined' &&
    window.FileReader &&
    window.File;
