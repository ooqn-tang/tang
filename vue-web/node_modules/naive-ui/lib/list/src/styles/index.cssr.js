"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

const cssr_1 = require("../../../_utils/cssr"); // vars:
// --n-font-size
// --n-bezier
// --n-text-color
// --n-color
// --n-border-radius
// --n-border-color
// --n-border-color-modal
// --n-border-color-popover
// --n-color-modal
// --n-color-popover


exports.default = (0, cssr_1.c)([(0, cssr_1.cB)('list', `
 --n-merged-border-color: var(--n-border-color);
 --n-merged-color: var(--n-color)
 font-size: var(--n-font-size);
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier),
 border-color .3s var(--n-bezier);
 padding: 0;
 list-style-type: none;
 color: var(--n-text-color);
 background-color: var(--n-merged-color);
 `, [(0, cssr_1.cM)('bordered', `
 border-radius: var(--n-border-radius);
 border: 1px solid var(--n-merged-border-color);
 `, [(0, cssr_1.cB)('list-item', `
 padding: 12px 20px;
 `, [(0, cssr_1.c)('&:not(:last-child)', `
 border-bottom: 1px solid var(--n-merged-border-color);
 `)]), (0, cssr_1.cE)('header, footer', `
 padding: 12px 20px;
 `, [(0, cssr_1.c)('&:not(:last-child)', `
 border-bottom: 1px solid var(--n-merged-border-color);
 `)])]), (0, cssr_1.cE)('header, footer', `
 padding: 12px 0;
 box-sizing: border-box;
 transition: border-color .3s var(--n-bezier);
 `, [(0, cssr_1.c)('&:not(:last-child)', `
 border-bottom: 1px solid var(--n-merged-border-color);
 `)]), (0, cssr_1.cB)('list-item', `
 padding: 12px 0; 
 box-sizing: border-box;
 display: flex;
 flex-wrap: nowrap;
 align-items: center;
 transition: border-color .3s var(--n-bezier);
 `, [(0, cssr_1.cE)('prefix', `
 margin-right: 20px;
 flex: 0;
 `), (0, cssr_1.cE)('suffix', `
 margin-left: 20px;
 flex: 0;
 `), (0, cssr_1.cE)('main', `
 flex: 1;
 `), (0, cssr_1.c)('&:not(:last-child)', `
 border-bottom: 1px solid var(--n-merged-border-color);
 `)])]), (0, cssr_1.insideModal)((0, cssr_1.cB)('list', `
 --merged-color: var(--n-color-modal);
 --merged-border-color: var(--n-border-color-modal);
 `)), (0, cssr_1.insidePopover)((0, cssr_1.cB)('list', `
 --merged-color: var(--n-color-popover);
 --merged-border-color: var(--n-border-color-popover);
 `))]);