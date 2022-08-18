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

const fade_in_height_expand_cssr_1 = __importDefault(require("../../../_styles/transitions/fade-in-height-expand.cssr")); // vars:
// --n-font-size
// --n-bezier
// --n-text-color
// --n-divider-color
// --n-title-font-size
// --n-title-text-color
// --n-title-font-weight
// --n-arrow-color


exports.default = (0, cssr_1.cB)('collapse', {
  width: '100%'
}, [(0, cssr_1.cB)('collapse-item', `
 font-size: var(--n-font-size);
 color: var(--n-text-color);
 transition:
 color .3s var(--n-bezier),
 border-color .3s var(--n-bezier);
 margin: 16px 0 0 0;
 `, [(0, cssr_1.cB)('collapse-item', 'margin-left: 32px;'), (0, cssr_1.c)('&:first-child', {
  marginTop: 0
}), (0, cssr_1.c)('&:first-child >', [(0, cssr_1.cE)('header', {
  paddingTop: 0
})]), (0, cssr_1.cM)('left-arrow-placement', [(0, cssr_1.cE)('header', [(0, cssr_1.cB)('collapse-item-arrow', {
  marginRight: '4px'
})])]), (0, cssr_1.cM)('right-arrow-placement', [(0, cssr_1.cE)('header', [(0, cssr_1.cB)('collapse-item-arrow', {
  marginLeft: '4px'
})])]), (0, cssr_1.cE)('content-wrapper', [(0, cssr_1.cE)('content-inner', {
  paddingTop: '16px'
}), (0, fade_in_height_expand_cssr_1.default)({
  duration: '0.15s'
})]), (0, cssr_1.cM)('active', [(0, cssr_1.cE)('header', [(0, cssr_1.cM)('active', [(0, cssr_1.cB)('collapse-item-arrow', {
  transform: 'rotate(90deg)'
})])])]), (0, cssr_1.c)('&:not(:first-child)', {
  borderTop: '1px solid var(--n-divider-color)'
}), (0, cssr_1.cE)('header', `
 font-size: var(--n-title-font-size);
 display: flex;
 flex-wrap: nowrap;
 align-items: center;
 transition: color .3s var(--n-bezier);
 position: relative;
 padding: 16px 0 0 0;
 color: var(--n-title-text-color);
 `, [(0, cssr_1.cE)('header-main', `
 cursor: pointer;
 display: flex;
 flex-wrap: nowrap;
 align-items: center;
 font-weight: var(--n-title-font-weight);
 transition: color .3s var(--n-bezier);
 flex: 1;
 color: var(--n-title-text-color);
 `), (0, cssr_1.cE)('header-extra', `
 cursor: pointer;
 display: flex;
 align-items: center;
 transition: color .3s var(--n-bezier);
 color: var(--n-text-color);
 `), (0, cssr_1.cB)('collapse-item-arrow', `
 display: flex;
 transition:
 transform .15s var(--n-bezier),
 color .3s var(--n-bezier);
 font-size: 18px;
 color: var(--n-arrow-color);
 `)])])]);