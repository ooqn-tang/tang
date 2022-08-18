"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const _common_1 = __importDefault(require("./_common"));
const seemly_1 = require("seemly");
const common_1 = require("../../_styles/common");
const self = (vars) => {
    const { textColor2, primaryColorHover, primaryColorPressed, primaryColor, infoColor, successColor, warningColor, errorColor, baseColor, borderColor, opacityDisabled, tagColor, closeColor, closeColorHover, closeColorPressed, borderRadiusSmall: borderRadius, fontSizeTiny, fontSizeSmall, fontSizeMedium, heightTiny, heightSmall, heightMedium } = vars;
    return Object.assign(Object.assign({}, _common_1.default), { heightSmall: heightTiny, heightMedium: heightSmall, heightLarge: heightMedium, borderRadius,
        opacityDisabled, fontSizeSmall: fontSizeTiny, fontSizeMedium: fontSizeSmall, fontSizeLarge: fontSizeMedium, 
        // checked
        textColorCheckable: textColor2, textColorHoverCheckable: primaryColorHover, textColorPressedCheckable: primaryColorPressed, textColorChecked: baseColor, colorCheckable: '#0000', colorHoverCheckable: '#0000', colorPressedCheckable: '#0000', colorChecked: primaryColor, colorCheckedHover: primaryColorHover, colorCheckedPressed: primaryColorPressed, 
        // default
        border: `1px solid ${borderColor}`, textColor: textColor2, color: tagColor, closeColor: closeColor, closeColorHover: closeColorHover, closeColorPressed: closeColorPressed, borderPrimary: `1px solid ${(0, seemly_1.changeColor)(primaryColor, { alpha: 0.3 })}`, textColorPrimary: primaryColor, colorPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.1 }), closeColorPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.75 }), closeColorHoverPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.6 }), closeColorPressedPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.9 }), borderInfo: `1px solid ${(0, seemly_1.changeColor)(infoColor, { alpha: 0.3 })}`, textColorInfo: infoColor, colorInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.1 }), closeColorInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.75 }), closeColorHoverInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.6 }), closeColorPressedInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.9 }), borderSuccess: `1px solid ${(0, seemly_1.changeColor)(successColor, { alpha: 0.3 })}`, textColorSuccess: successColor, colorSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.1 }), closeColorSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.75 }), closeColorHoverSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.6 }), closeColorPressedSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.9 }), borderWarning: `1px solid ${(0, seemly_1.changeColor)(warningColor, { alpha: 0.35 })}`, textColorWarning: warningColor, colorWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.12 }), closeColorWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.75 }), closeColorHoverWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.6 }), closeColorPressedWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.9 }), borderError: `1px solid ${(0, seemly_1.changeColor)(errorColor, { alpha: 0.23 })}`, textColorError: errorColor, colorError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.08 }), closeColorError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.65 }), closeColorHoverError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.5 }), closeColorPressedError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.8 }) });
};
const tagLight = {
    name: 'Tag',
    common: common_1.commonLight,
    self
};
exports.default = tagLight;
