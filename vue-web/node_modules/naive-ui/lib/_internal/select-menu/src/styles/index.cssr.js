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

const fade_in_scale_up_cssr_1 = __importDefault(require("../../../../_styles/transitions/fade-in-scale-up.cssr")); // --n-loading-color
// --n-loading-size


exports.default = (0, cssr_1.cB)('base-select-menu', `
 line-height: 1.5;
 outline: none;
 z-index: 0;
 position: relative;
 border-radius: var(--n-border-radius);
 transition:
 background-color .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier);
 background-color: var(--n-color);
`, [(0, cssr_1.cM)('multiple', [(0, cssr_1.cB)('base-select-option', `
 padding-right: 28px;
 `)]), (0, cssr_1.cB)('scrollbar', `
 max-height: var(--n-height);
 `), (0, cssr_1.cB)('virtual-list', `
 max-height: var(--n-height);
 `), (0, cssr_1.cB)('base-select-option', `
 min-height: var(--n-option-height);
 font-size: var(--n-option-font-size);
 display: flex;
 align-items: center;
 `, [(0, cssr_1.cE)('content', `
 white-space: nowrap;
 text-overflow: ellipsis;
 overflow: hidden;
 `)]), (0, cssr_1.cB)('base-select-group-header', `
 min-height: var(--n-option-height);
 font-size: .93em;
 display: flex;
 align-items: center;
 `), (0, cssr_1.cB)('base-select-menu-option-wrapper', `
 position: relative;
 width: 100%;
 `), (0, cssr_1.cE)('loading, empty', `
 display: flex;
 padding: 12px 32px;
 flex: 1;
 justify-content: center;
 `), (0, cssr_1.cE)('loading', `
 color: var(--n-loading-color);
 font-size: var(--n-loading-size);
 `), (0, cssr_1.cE)('action', `
 padding: 8px var(--n-option-padding-left);
 font-size: var(--n-option-font-size);
 transition: 
 color .3s var(--n-bezier);
 border-color .3s var(--n-bezier);
 border-top: 1px solid var(--n-action-divider-color);
 color: var(--n-action-text-color);
 `), (0, cssr_1.cB)('base-select-group-header', `
 position: relative;
 cursor: default;
 padding: var(--n-option-padding);
 color: var(--n-group-header-text-color);
 `), (0, cssr_1.cB)('base-select-option', `
 cursor: pointer;
 position: relative;
 padding: var(--n-option-padding);
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier),
 opacity .3s var(--n-bezier);
 box-sizing: border-box;
 color: var(--n-option-text-color);
 opacity: 1;
 `, [(0, cssr_1.c)('&:active', `
 color: var(--n-option-text-color-pressed);
 `), (0, cssr_1.cM)('grouped', `
 padding-left: calc(var(--n-option-padding-left) * 1.5);
 `), (0, cssr_1.cM)('pending', `
 background-color: var(--n-option-color-pending);
 `), (0, cssr_1.cM)('selected', `
 color: var(--n-option-text-color-active);
 background-color: var(--n-option-color-active);
 `), (0, cssr_1.cM)('disabled', `
 cursor: not-allowed;
 `, [(0, cssr_1.cNotM)('selected', `
 color: var(--n-option-text-color-disabled);
 `), (0, cssr_1.cM)('selected', `
 opacity: var(--n-option-opacity-disabled);
 `)]), (0, cssr_1.cE)('check', `
 font-size: 16px;
 position: absolute;
 right: 8px;
 top: calc(50% - 7px);
 color: var(--n-option-check-color);
 transition: color .3s var(--n-bezier);
 `, [(0, fade_in_scale_up_cssr_1.default)({
  enterScale: '0.5'
})])])]);