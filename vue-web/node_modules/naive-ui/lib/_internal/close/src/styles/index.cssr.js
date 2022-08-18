"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

const cssr_1 = require("../../../../_utils/cssr"); // vars:
// --n-close-color
// --n-close-color-hover
// --n-close-color-pressed
// --n-close-color-disabled


exports.default = (0, cssr_1.cB)('base-close', `
 cursor: pointer;
 color: var(--n-close-color);
`, [(0, cssr_1.c)('&:hover', {
  color: 'var(--n-close-color-hover)'
}), (0, cssr_1.c)('&:active', {
  color: 'var(--n-close-color-pressed)'
}), (0, cssr_1.cM)('disabled', {
  cursor: 'not-allowed!important',
  color: 'var(--n-close-color-disabled)'
})]);