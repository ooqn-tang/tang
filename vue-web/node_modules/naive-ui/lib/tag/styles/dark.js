"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const _common_1 = __importDefault(require("./_common"));
const seemly_1 = require("seemly");
const common_1 = require("../../_styles/common");
const tagDark = {
    name: 'Tag',
    common: common_1.commonDark,
    self(vars) {
        const { textColor2, primaryColorHover, primaryColorPressed, primaryColor, infoColor, successColor, warningColor, errorColor, baseColor, borderColor, opacityDisabled, closeColor, closeColorHover, closeColorPressed, borderRadiusSmall: borderRadius, fontSizeTiny, fontSizeSmall, fontSizeMedium, heightTiny, heightSmall, heightMedium } = vars;
        return Object.assign(Object.assign({}, _common_1.default), { heightSmall: heightTiny, heightMedium: heightSmall, heightLarge: heightMedium, borderRadius,
            opacityDisabled, fontSizeSmall: fontSizeTiny, fontSizeMedium: fontSizeSmall, fontSizeLarge: fontSizeMedium, 
            // checked
            textColorCheckable: textColor2, textColorHoverCheckable: primaryColorHover, textColorPressedCheckable: primaryColorPressed, textColorChecked: baseColor, colorCheckable: '#0000', colorHoverCheckable: '#0000', colorPressedCheckable: '#0000', colorChecked: primaryColor, colorCheckedHover: primaryColorHover, colorCheckedPressed: primaryColorPressed, 
            // default
            border: `1px solid ${borderColor}`, textColor: textColor2, color: '#0000', closeColor: closeColor, closeColorHover: closeColorHover, closeColorPressed: closeColorPressed, borderPrimary: `1px solid ${(0, seemly_1.changeColor)(primaryColor, { alpha: 0.3 })}`, textColorPrimary: primaryColor, colorPrimary: '#0000', closeColorPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.7 }), closeColorHoverPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.85 }), closeColorPressedPrimary: (0, seemly_1.changeColor)(primaryColor, { alpha: 0.57 }), borderInfo: `1px solid ${(0, seemly_1.changeColor)(infoColor, { alpha: 0.3 })}`, textColorInfo: infoColor, colorInfo: '#0000', closeColorInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.7 }), closeColorHoverInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.85 }), closeColorPressedInfo: (0, seemly_1.changeColor)(infoColor, { alpha: 0.57 }), borderSuccess: `1px solid ${(0, seemly_1.changeColor)(successColor, { alpha: 0.3 })}`, textColorSuccess: successColor, colorSuccess: '#0000', closeColorSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.7 }), closeColorHoverSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.85 }), closeColorPressedSuccess: (0, seemly_1.changeColor)(successColor, { alpha: 0.57 }), borderWarning: `1px solid ${(0, seemly_1.changeColor)(warningColor, { alpha: 0.3 })}`, textColorWarning: warningColor, colorWarning: '#0000', closeColorWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.7 }), closeColorHoverWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.85 }), closeColorPressedWarning: (0, seemly_1.changeColor)(warningColor, { alpha: 0.57 }), borderError: `1px solid ${(0, seemly_1.changeColor)(errorColor, { alpha: 0.3 })}`, textColorError: errorColor, colorError: '#0000', closeColorError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.7 }), closeColorHoverError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.85 }), closeColorPressedError: (0, seemly_1.changeColor)(errorColor, { alpha: 0.57 }) });
    }
};
exports.default = tagDark;
