import { FileInfo } from './interface';
export declare const isImageFileType: (type: string) => boolean;
export declare const isImageFile: (file: FileInfo) => boolean;
export declare function createImageDataUrl(file: File): Promise<string>;
export declare const environmentSupportFile: false | {
    new (fileBits: BlobPart[], fileName: string, options?: FilePropertyBag | undefined): File;
    prototype: File;
};
