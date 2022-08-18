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
// --n-font-size
// --n-padding
// --n-border-radius
// --n-option-height
// --n-option-prefix-width
// --n-option-icon-prefix-width
// --n-option-suffix-width
// --n-option-icon-suffix-width
// --n-color
// --n-option-color-hover
// --n-option-color-active
// --n-divider-color
// --n-option-text-color
// --n-option-text-color-hover
// --n-option-text-color-active
// --n-option-text-color-child-active
// --n-prefix-color
// --n-suffix-color
// --n-option-icon-size
// --n-option-opacity-disabled
// shared with popover
// --n-box-shadow


exports.default = (0, cssr_1.cB)('dropdown-menu', `
 transform-origin: inherit;
 padding: var(--n-padding);
 background-color: var(--n-color);
 border-radius: var(--n-border-radius);
 box-shadow: var(--n-box-shadow);
 transition:
 background-color .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier);
`, [(0, fade_in_scale_up_cssr_1.default)(), (0, cssr_1.cB)('dropdown-option', `
 position: relative;
 `, [(0, cssr_1.c)('a', `
 text-decoration: none;
 color: inherit;
 `, [(0, cssr_1.c)('&::before', `
 content: "";
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]), (0, cssr_1.cB)('dropdown-option-body', `
 display: flex;
 cursor: pointer;
 height: var(--n-option-height);
 line-height: var(--n-option-height);
 font-size: var(--n-font-size);
 color: var(--n-option-text-color);
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
 `, [(0, cssr_1.cM)('pending', [(0, cssr_1.cNotM)('disabled', {
  color: 'var(--n-option-text-color-hover)',
  backgroundColor: 'var(--n-option-color-hover)'
}), (0, cssr_1.cE)('prefix, suffix', {
  color: 'var(--n-option-text-color-hover)'
})]), (0, cssr_1.cM)('active', [(0, cssr_1.cNotM)('disabled', {
  color: 'var(--n-option-text-color-active)',
  backgroundColor: 'var(--n-option-color-active)'
}), (0, cssr_1.cE)('prefix, suffix', {
  color: 'var(--n-option-text-color-active)'
})]), (0, cssr_1.cM)('disabled', {
  cursor: 'not-allowed',
  opacity: 'var(--n-option-opacity-disabled)'
}), (0, cssr_1.cM)('child-active', {
  color: 'var(--n-option-text-color-child-active)'
}, [(0, cssr_1.cE)('prefix, suffix', {
  color: 'var(--n-option-text-color-child-active)'
})]), (0, cssr_1.cM)('group', {
  fontSize: 'calc(var(--n-font-size) - 1px)',
  color: 'var(--n-group-header-text-color)'
}, [(0, cssr_1.cE)('prefix', {
  width: 'calc(var(--n-option-prefix-width) / 2)'
}, [(0, cssr_1.cM)('show-icon', {
  width: 'calc(var(--n-option-icon-prefix-width) / 2)'
})])]), (0, cssr_1.cE)('prefix', `
 width: var(--n-option-prefix-width);
 display: flex;
 justify-content: center;
 align-items: center;
 color: var(--n-prefix-color);
 transition: color .3s var(--n-bezier);
 `, [(0, cssr_1.cM)('show-icon', {
  width: 'var(--n-option-icon-prefix-width)'
}), (0, cssr_1.cB)('icon', {
  fontSize: 'var(--n-option-icon-size)'
})]), (0, cssr_1.cE)('label', {
  whiteSpace: 'nowrap',
  flex: 1
}), (0, cssr_1.cE)('suffix', `
 box-sizing: border-box;
 flex-grow: 0;
 flex-shrink: 0;
 display: flex;
 justify-content: flex-end;
 align-items: center;
 min-width: var(--n-option-suffix-width);
 padding: 0 8px;
 transition: color .3s var(--n-bezier);
 color: var(--n-suffix-color);
 `, [(0, cssr_1.cM)('has-submenu', {
  width: 'var(--n-option-icon-suffix-width)'
}), (0, cssr_1.cB)('icon', {
  fontSize: 'var(--n-option-icon-size)'
})]), (0, cssr_1.cB)('dropdown-menu', {
  pointerEvents: 'all'
})]), (0, cssr_1.cB)('dropdown-offset-container', `
 pointer-events: none;
 position: absolute;
 left: 0;
 right: 0;
 top: -4px;
 bottom: -4px;
 `)]), (0, cssr_1.cB)('dropdown-divider', `
 transition: background-color .3s var(--n-bezier);
 background-color: var(--n-divider-color);
 height: 1px;
 margin: 4px 0;
 `), (0, cssr_1.cB)('dropdown-menu-wrapper', `
 transform-origin: inherit;
 width: fit-content;
 `)]);