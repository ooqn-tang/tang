"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.self = void 0;
const _common_1 = __importDefault(require("./_common"));
const common_1 = require("../../_styles/common");
const self = (vars) => {
    const { fontSize, textColor3, primaryColorHover, primaryColorPressed, textColor2 } = vars;
    return Object.assign(Object.assign({}, _common_1.default), { fontSize: fontSize, itemTextColor: textColor3, itemTextColorHover: primaryColorHover, itemTextColorPressed: primaryColorPressed, itemTextColorActive: textColor2, separatorColor: textColor3 });
};
exports.self = self;
const breadcrumbLight = {
    name: 'Breadcrumb',
    common: common_1.commonLight,
    self: exports.self
};
exports.default = breadcrumbLight;
