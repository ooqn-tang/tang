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

const fade_in_cssr_1 = __importDefault(require("../../../_styles/transitions/fade-in.cssr")); // vars:
// --n-height
// --n-color-loading
// --n-color-error


exports.default = (0, cssr_1.cB)('loading-bar-container', `
 z-index: 5999;
 position: fixed;
 top: 0;
 left: 0;
 right: 0;
 height: 2px;
`, [(0, fade_in_cssr_1.default)({
  enterDuration: '0.3s',
  leaveDuration: '0.8s'
}), (0, cssr_1.cB)('loading-bar', `
 width: 100%;
 transition:
 max-width 4s linear,
 background .2s linear;
 height: var(--n-height);
 `, [(0, cssr_1.cM)('starting', `
 background: var(--n-color-loading);
 `), (0, cssr_1.cM)('finishing', `
 background: var(--n-color-loading);
 transition:
 max-width .2s linear,
 background .2s linear;
 `), (0, cssr_1.cM)('error', `
 background: var(--n-color-error);
 transition:
 max-width .2s linear,
 background .2s linear;
 `)])]);