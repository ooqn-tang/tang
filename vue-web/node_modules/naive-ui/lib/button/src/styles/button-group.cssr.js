"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});

const index_1 = require("../../../_utils/cssr/index");

const zero = '0!important';
const n1 = '-1px!important';

function createLeftBorderStyle(type) {
  return (0, index_1.cM)(type + '-type', [(0, index_1.c)('& +', [(0, index_1.cB)('button', {}, [(0, index_1.cM)(type + '-type', [(0, index_1.cE)('border', {
    borderLeftWidth: zero
  }), (0, index_1.cE)('state-border', {
    left: n1
  })])])])]);
}

function createTopBorderStyle(type) {
  return (0, index_1.cM)(type + '-type', [(0, index_1.c)('& +', [(0, index_1.cB)('button', [(0, index_1.cM)(type + '-type', [(0, index_1.cE)('border', {
    borderTopWidth: zero
  }), (0, index_1.cE)('state-border', {
    top: n1
  })])])])]);
}

exports.default = (0, index_1.cB)('button-group', `
 flex-wrap: nowrap;
 display: inline-flex;
 position: relative;
`, [(0, index_1.cNotM)('vertical', {
  flexDirection: 'row'
}, [(0, index_1.cB)('button', [(0, index_1.c)('&:first-child:not(:last-child)', `
 margin-right: ${zero};
 border-top-right-radius: ${zero};
 border-bottom-right-radius: ${zero};
 `), (0, index_1.c)('&:last-child:not(:first-child)', `
 margin-left: ${zero};
 border-top-left-radius: ${zero};
 border-bottom-left-radius: ${zero};
 `), (0, index_1.c)('&:not(:first-child):not(:last-child)', `
 margin-left: ${zero};
 margin-right: ${zero};
 border-radius: ${zero};
 `), createLeftBorderStyle('default'), (0, index_1.cM)('ghost', [createLeftBorderStyle('primary'), createLeftBorderStyle('info'), createLeftBorderStyle('success'), createLeftBorderStyle('warning'), createLeftBorderStyle('error')])])]), (0, index_1.cM)('vertical', {
  flexDirection: 'column'
}, [(0, index_1.cB)('button', [(0, index_1.c)('&:first-child:not(:last-child)', `
 margin-bottom: ${zero};
 margin-left: ${zero};
 margin-right: ${zero};
 border-bottom-left-radius: ${zero};
 border-bottom-right-radius: ${zero};
 `), (0, index_1.c)('&:last-child:not(:first-child)', `
 margin-top: ${zero};
 margin-left: ${zero};
 margin-right: ${zero};
 border-top-left-radius: ${zero};
 border-top-right-radius: ${zero};
 `), (0, index_1.c)('&:not(:first-child):not(:last-child)', `
 margin: ${zero};
 border-radius: ${zero};
 `), createTopBorderStyle('default'), (0, index_1.cM)('ghost', [createTopBorderStyle('primary'), createTopBorderStyle('info'), createTopBorderStyle('success'), createTopBorderStyle('warning'), createTopBorderStyle('error')])])])]);