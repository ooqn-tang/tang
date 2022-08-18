"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.isEmptyValue = exports.len = void 0;
function len(s) {
    let count = 0;
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    for (const _ of s) {
        count++;
    }
    return count;
}
exports.len = len;
function isEmptyValue(value) {
    return ['', undefined, null].includes(value);
}
exports.isEmptyValue = isEmptyValue;
