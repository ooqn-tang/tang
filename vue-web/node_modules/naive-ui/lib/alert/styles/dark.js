"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const seemly_1 = require("seemly");
const common_1 = require("../../_styles/common");
const _common_1 = __importDefault(require("./_common"));
const alertDark = {
    name: 'Alert',
    common: common_1.commonDark,
    self(vars) {
        const { lineHeight, borderRadius, fontWeightStrong, dividerColor, inputColor, textColor1, textColor2, closeColor, closeColorHover, closeColorPressed, infoColorSuppl, successColorSuppl, warningColorSuppl, errorColorSuppl, fontSize } = vars;
        return Object.assign(Object.assign({}, _common_1.default), { fontSize,
            lineHeight, titleFontWeight: fontWeightStrong, borderRadius, border: `1px solid ${dividerColor}`, color: inputColor, titleTextColor: textColor1, iconColor: textColor2, contentTextColor: textColor2, closeColor: closeColor, closeColorHover: closeColorHover, closeColorPressed: closeColorPressed, borderInfo: `1px solid ${(0, seemly_1.changeColor)(infoColorSuppl, { alpha: 0.35 })}`, colorInfo: (0, seemly_1.changeColor)(infoColorSuppl, { alpha: 0.25 }), titleTextColorInfo: textColor1, iconColorInfo: infoColorSuppl, contentTextColorInfo: textColor2, closeColorInfo: closeColor, closeColorHoverInfo: closeColorHover, closeColorPressedInfo: closeColorPressed, borderSuccess: `1px solid ${(0, seemly_1.changeColor)(successColorSuppl, {
                alpha: 0.35
            })}`, colorSuccess: (0, seemly_1.changeColor)(successColorSuppl, { alpha: 0.25 }), titleTextColorSuccess: textColor1, iconColorSuccess: successColorSuppl, contentTextColorSuccess: textColor2, closeColorSuccess: closeColor, closeColorHoverSuccess: closeColorHover, closeColorPressedSuccess: closeColorPressed, borderWarning: `1px solid ${(0, seemly_1.changeColor)(warningColorSuppl, {
                alpha: 0.35
            })}`, colorWarning: (0, seemly_1.changeColor)(warningColorSuppl, { alpha: 0.25 }), titleTextColorWarning: textColor1, iconColorWarning: warningColorSuppl, contentTextColorWarning: textColor2, closeColorWarning: closeColor, closeColorHoverWarning: closeColorHover, closeColorPressedWarning: closeColorPressed, borderError: `1px solid ${(0, seemly_1.changeColor)(errorColorSuppl, { alpha: 0.35 })}`, colorError: (0, seemly_1.changeColor)(errorColorSuppl, { alpha: 0.25 }), titleTextColorError: textColor1, iconColorError: errorColorSuppl, contentTextColorError: textColor2, closeColorError: closeColor, closeColorHoverError: closeColorHover, closeColorPressedError: closeColorPressed });
    }
};
exports.default = alertDark;
