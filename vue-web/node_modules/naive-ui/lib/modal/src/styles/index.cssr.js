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

const fade_in_cssr_1 = __importDefault(require("../../../_styles/transitions/fade-in.cssr"));

const fade_in_scale_up_cssr_1 = __importDefault(require("../../../_styles/transitions/fade-in-scale-up.cssr")); // vars:
// --n-bezier-ease-out
// --n-box-shadow
// --n-color
// --n-text-color


exports.default = (0, cssr_1.c)([(0, cssr_1.cB)('modal-container', `
 position: fixed;
 left: 0;
 top: 0;
 height: 0;
 width: 0;
 display: flex;
 `), (0, cssr_1.cB)('modal-mask', `
 position: fixed;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 background-color: rgba(0, 0, 0, .4);
 `, [(0, fade_in_cssr_1.default)({
  enterDuration: '.25s',
  leaveDuration: '.25s',
  enterCubicBezier: 'var(--n-bezier-ease-out)',
  leaveCubicBezier: 'var(--n-bezier-ease-out)'
})]), (0, cssr_1.cB)('modal-body-wrapper', `
 position: fixed;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 overflow: visible;
 `, [(0, cssr_1.cB)('modal-scroll-content', `
 min-height: 100%;
 display: flex;
 position: relative;
 `)]), (0, cssr_1.cB)('modal', `
 align-self: center;
 color: var(--n-text-color);
 margin: auto;
 box-shadow: var(--n-box-shadow);
 `, [(0, fade_in_scale_up_cssr_1.default)({
  duration: '.25s',
  enterScale: '.5'
})])]);