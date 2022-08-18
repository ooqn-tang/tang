"use strict";

var __importDefault = this && this.__importDefault || function (mod) {
  return mod && mod.__esModule ? mod : {
    "default": mod
  };
};

Object.defineProperty(exports, "__esModule", {
  value: true
});

const cssr_1 = require("../../../../_utils/cssr");

const icon_switch_cssr_1 = __importDefault(require("../../../../_styles/transitions/icon-switch.cssr"));

exports.default = (0, cssr_1.cB)('base-loading', `
 position: relative;
 line-height: 0;
 width: 1em;
 height: 1em;
`, [(0, cssr_1.cE)('placeholder', `
 position: absolute;
 left: 50%;
 top: 50%;
 transform: translateX(-50%) translateY(-50%);
 `, [(0, icon_switch_cssr_1.default)({
  left: '50%',
  top: '50%',
  originalTransform: 'translateX(-50%) translateY(-50%)'
})]), (0, cssr_1.cE)('icon', `
 height: 1em;
 width: 1em;
 `, [(0, icon_switch_cssr_1.default)()])]);