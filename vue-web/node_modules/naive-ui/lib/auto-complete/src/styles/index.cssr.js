"use strict";

var __importDefault = this && this.__importDefault || function (mod) {
  return mod && mod.__esModule ? mod : {
    "default": mod
  };
};

Object.defineProperty(exports, "__esModule", {
  value: true
});

const cssr_1 = require("../../../_utils/cssr");

const fade_in_scale_up_cssr_1 = __importDefault(require("../../../_styles/transitions/fade-in-scale-up.cssr")); // vars:
// --n-bezier
// --n-menu-box-shadow


exports.default = (0, cssr_1.c)([(0, cssr_1.cB)('auto-complete', `
 z-index: auto;
 position: relative;
 display: inline-flex;
 width: 100%;
 `), (0, cssr_1.cB)('auto-complete-menu', `
 margin: 4px 0;
 box-shadow: var(--n-menu-box-shadow);
 `, [(0, fade_in_scale_up_cssr_1.default)({
  originalTransition: 'background-color .3s var(--n-bezier)'
})])]);