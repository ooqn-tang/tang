"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

const cssr_1 = require("../../../_utils/cssr"); // vars:
// --n-font-size
// --n-bezier
// --n-item-text-color
// --n-item-text-color-hover
// --n-item-text-color-pressed
// --n-item-text-color-active
// --n-separator-color
// --n-font-weight-active


exports.default = (0, cssr_1.cB)('breadcrumb', `
 white-space: nowrap;
`, [(0, cssr_1.c)('ul', `
 list-style: none;
 padding: 0;
 margin: 0;
 `), (0, cssr_1.c)('a', `
 color: inherit;
 text-decoration: inherit;
 `), (0, cssr_1.cB)('breadcrumb-item', {
  fontSize: 'var(--n-font-size)',
  transition: 'color .3s var(--n-bezier)',
  display: 'inline-block'
}, [(0, cssr_1.cB)('icon', `
 font-size: 18px;
 vertical-align: -.2em;
 transition: color .3s var(--n-bezier);
 color: var(--n-item-text-color);
 `), (0, cssr_1.cE)('link', {
  cursor: 'pointer',
  transition: 'color .3s var(--n-bezier)',
  color: 'var(--n-item-text-color)'
}), (0, cssr_1.cE)('separator', {
  margin: '0 8px',
  color: 'var(--n-separator-color)',
  transition: 'color .3s var(--n-bezier)'
}), (0, cssr_1.c)('&:hover', [(0, cssr_1.cB)('icon', {
  color: 'var(--n-item-text-color-hover)'
}), (0, cssr_1.cE)('link', {
  color: 'var(--n-item-text-color-hover)'
})]), (0, cssr_1.c)('&:active', [(0, cssr_1.cB)('icon', {
  color: 'var(--n-item-text-color-pressed)'
}), (0, cssr_1.cE)('link', {
  color: 'var(--n-item-text-color-pressed)'
})]), (0, cssr_1.c)('&:last-child', [(0, cssr_1.cE)('link', `
 font-weight: var(--n-font-weight-active);
 cursor: unset;
 color: var(--n-item-text-color-active);
 `), (0, cssr_1.cB)('icon', {
  color: 'var(--n-item-text-color-active)'
}), (0, cssr_1.cE)('separator', {
  display: 'none'
})])])]);