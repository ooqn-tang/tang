"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

const cssr_1 = require("../../../_utils/cssr");

exports.default = (0, cssr_1.cB)('tag', [(0, cssr_1.cM)('rtl', `
 direction: rtl;
 `, [(0, cssr_1.cE)('close', `
 margin: var(--n-close-margin-rtl);
 `), (0, cssr_1.cE)('avatar', `
 margin-left: 6px;
 margin-right: 0;
 `), (0, cssr_1.cM)('round', [(0, cssr_1.cE)('avatar', {
  marginLeft: '6px',
  marginRight: '-5px'
})])])]);