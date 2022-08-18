"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.self = void 0;
const common_1 = require("../../_styles/common");
const self = (vars) => {
    const { fontWeight, textColor1, textColor2, dividerColor, fontSize } = vars;
    return {
        titleFontSize: fontSize,
        titleFontWeight: fontWeight,
        dividerColor: dividerColor,
        titleTextColor: textColor1,
        fontSize,
        textColor: textColor2,
        arrowColor: textColor2
    };
};
exports.self = self;
const collapseLight = {
    name: 'Collapse',
    common: common_1.commonLight,
    self: exports.self
};
exports.default = collapseLight;
