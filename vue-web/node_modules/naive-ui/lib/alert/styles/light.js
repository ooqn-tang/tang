"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const seemly_1 = require("seemly");
const common_1 = require("../../_styles/common");
const _common_1 = __importDefault(require("./_common"));
const self = (vars) => {
    const { lineHeight, borderRadius, fontWeightStrong, baseColor, dividerColor, actionColor, textColor1, textColor2, closeColor, closeColorHover, closeColorPressed, infoColor, successColor, warningColor, errorColor, fontSize } = vars;
    return Object.assign(Object.assign({}, _common_1.default), { fontSize,
        lineHeight, titleFontWeight: fontWeightStrong, borderRadius, border: `1px solid ${dividerColor}`, color: actionColor, titleTextColor: textColor1, iconColor: textColor2, contentTextColor: textColor2, closeColor,
        closeColorHover,
        closeColorPressed, borderInfo: `1px solid ${(0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(infoColor, { alpha: 0.25 }))}`, colorInfo: (0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(infoColor, { alpha: 0.08 })), titleTextColorInfo: textColor1, iconColorInfo: infoColor, contentTextColorInfo: textColor2, closeColorInfo: closeColor, closeColorHoverInfo: closeColorHover, closeColorPressedInfo: closeColorPressed, borderSuccess: `1px solid ${(0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(successColor, { alpha: 0.25 }))}`, colorSuccess: (0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(successColor, { alpha: 0.08 })), titleTextColorSuccess: textColor1, iconColorSuccess: successColor, contentTextColorSuccess: textColor2, closeColorSuccess: closeColor, closeColorHoverSuccess: closeColorHover, closeColorPressedSuccess: closeColorPressed, borderWarning: `1px solid ${(0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(warningColor, { alpha: 0.33 }))}`, colorWarning: (0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(warningColor, { alpha: 0.08 })), titleTextColorWarning: textColor1, iconColorWarning: warningColor, contentTextColorWarning: textColor2, closeColorWarning: closeColor, closeColorHoverWarning: closeColorHover, closeColorPressedWarning: closeColorPressed, borderError: `1px solid ${(0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(errorColor, { alpha: 0.25 }))}`, colorError: (0, seemly_1.composite)(baseColor, (0, seemly_1.changeColor)(errorColor, { alpha: 0.08 })), titleTextColorError: textColor1, iconColorError: errorColor, contentTextColorError: textColor2, closeColorError: closeColor, closeColorHoverError: closeColorHover, closeColorPressedError: closeColorPressed });
};
const alertLight = {
    name: 'Alert',
    common: common_1.commonLight,
    self
};
exports.default = alertLight;
