import{d as R,j as y,k as t,c as i,p as k}from"./admin-3c01a676.js";import{D as L,x as w,N as x}from"./Scrollbar-df727b44.js";import{e as d,i as B,h as l,W as $}from"./router-7246853f.js";function ce(e,r=[],o){const n={};return Object.getOwnPropertyNames(e).forEach(a=>{r.includes(a)||(n[a]=e[a])}),Object.assign(n,o)}function S(e,r,o){var n=-1,s=e.length;r<0&&(r=-r>s?0:s+r),o=o>s?s:o,o<0&&(o+=s),s=r>o?0:o-r>>>0,r>>>=0;for(var a=Array(s);++n<s;)a[n]=e[n+r];return a}function z(e,r,o){var n=e.length;return o=o===void 0?n:o,!r&&o>=n?e:S(e,r,o)}var M="\\ud800-\\udfff",j="\\u0300-\\u036f",A="\\ufe20-\\ufe2f",O="\\u20d0-\\u20ff",N=j+A+O,P="\\ufe0e\\ufe0f",T="\\u200d",F=RegExp("["+T+M+N+P+"]");function f(e){return F.test(e)}function I(e){return e.split("")}var b="\\ud800-\\udfff",E="\\u0300-\\u036f",U="\\ufe20-\\ufe2f",H="\\u20d0-\\u20ff",J=E+U+H,V="\\ufe0e\\ufe0f",W="["+b+"]",c="["+J+"]",u="\\ud83c[\\udffb-\\udfff]",Z="(?:"+c+"|"+u+")",v="[^"+b+"]",g="(?:\\ud83c[\\udde6-\\uddff]){2}",p="[\\ud800-\\udbff][\\udc00-\\udfff]",q="\\u200d",h=Z+"?",m="["+V+"]?",D="(?:"+q+"(?:"+[v,g,p].join("|")+")"+m+h+")*",_=m+h+D,K="(?:"+[v+c+"?",c,g,p,W].join("|")+")",X=RegExp(u+"(?="+u+")|"+K+_,"g");function Y(e){return e.match(X)||[]}function G(e){return f(e)?Y(e):I(e)}function Q(e){return function(r){r=L(r);var o=f(r)?G(r):void 0,n=o?o[0]:r.charAt(0),s=o?z(o,1).join(""):r.slice(1);return n[e]()+s}}var ee=Q("toUpperCase");const oe=ee;function re(e,r){return d({name:oe(e),setup(){var o;const n=(o=B(R,null))===null||o===void 0?void 0:o.mergedIconsRef;return()=>{var s;const a=(s=n==null?void 0:n.value)===null||s===void 0?void 0:s[e];return a?a():r}}})}const ne=re("close",l("svg",{viewBox:"0 0 12 12",version:"1.1",xmlns:"http://www.w3.org/2000/svg","aria-hidden":!0},l("g",{stroke:"none","stroke-width":"1",fill:"none","fill-rule":"evenodd"},l("g",{fill:"currentColor","fill-rule":"nonzero"},l("path",{d:"M2.08859116,2.2156945 L2.14644661,2.14644661 C2.32001296,1.97288026 2.58943736,1.95359511 2.7843055,2.08859116 L2.85355339,2.14644661 L6,5.293 L9.14644661,2.14644661 C9.34170876,1.95118446 9.65829124,1.95118446 9.85355339,2.14644661 C10.0488155,2.34170876 10.0488155,2.65829124 9.85355339,2.85355339 L6.707,6 L9.85355339,9.14644661 C10.0271197,9.32001296 10.0464049,9.58943736 9.91140884,9.7843055 L9.85355339,9.85355339 C9.67998704,10.0271197 9.41056264,10.0464049 9.2156945,9.91140884 L9.14644661,9.85355339 L6,6.707 L2.85355339,9.85355339 C2.65829124,10.0488155 2.34170876,10.0488155 2.14644661,9.85355339 C1.95118446,9.65829124 1.95118446,9.34170876 2.14644661,9.14644661 L5.293,6 L2.14644661,2.85355339 C1.97288026,2.67998704 1.95359511,2.41056264 2.08859116,2.2156945 L2.14644661,2.14644661 L2.08859116,2.2156945 Z"}))))),se=y("base-close",`
 display: flex;
 align-items: center;
 justify-content: center;
 cursor: pointer;
 background-color: transparent;
 color: var(--n-close-icon-color);
 border-radius: var(--n-close-border-radius);
 height: var(--n-close-size);
 width: var(--n-close-size);
 font-size: var(--n-close-icon-size);
 outline: none;
 border: none;
 position: relative;
 padding: 0;
`,[t("absolute",`
 height: var(--n-close-icon-size);
 width: var(--n-close-icon-size);
 `),i("&::before",`
 content: "";
 position: absolute;
 width: var(--n-close-size);
 height: var(--n-close-size);
 left: 50%;
 top: 50%;
 transform: translateY(-50%) translateX(-50%);
 transition: inherit;
 border-radius: inherit;
 `),k("disabled",[i("&:hover",`
 color: var(--n-close-icon-color-hover);
 `),i("&:hover::before",`
 background-color: var(--n-close-color-hover);
 `),i("&:focus::before",`
 background-color: var(--n-close-color-hover);
 `),i("&:active",`
 color: var(--n-close-icon-color-pressed);
 `),i("&:active::before",`
 background-color: var(--n-close-color-pressed);
 `)]),t("disabled",`
 cursor: not-allowed;
 color: var(--n-close-icon-color-disabled);
 background-color: transparent;
 `),t("round",[i("&::before",`
 border-radius: 50%;
 `)])]),ue=d({name:"BaseClose",props:{isButtonTag:{type:Boolean,default:!0},clsPrefix:{type:String,required:!0},disabled:{type:Boolean,default:void 0},focusable:{type:Boolean,default:!0},round:Boolean,onClick:Function,absolute:Boolean},setup(e){return w("-base-close",se,$(e,"clsPrefix")),()=>{const{clsPrefix:r,disabled:o,absolute:n,round:s,isButtonTag:a}=e;return l(a?"button":"div",{type:a?"button":void 0,tabindex:o||!e.focusable?-1:0,"aria-disabled":o,"aria-label":"close",role:a?void 0:"button",disabled:o,class:[`${r}-base-close`,n&&`${r}-base-close--absolute`,o&&`${r}-base-close--disabled`,s&&`${r}-base-close--round`],onMousedown:C=>{e.focusable||C.preventDefault()},onClick:e.onClick},l(x,{clsPrefix:r},{default:()=>l(ne,null)}))}}});export{ue as N,ce as o,re as r};
