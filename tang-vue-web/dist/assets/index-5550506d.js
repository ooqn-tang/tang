import{v as Oe,e as g,r as E,k as ro,f as B,h,p as G,i as V,W as we,X as no,L as Be,Y as X,m as Se,Z as ze,F as io,w as Re,G as he,x as Ee,y as je,K as lo,N as ao,C as M,B as T,U as so,n as L,u as te,I as le,H as co,J as uo,E as vo}from"./github-4e847045.js";import{c as $,a as mo,b as $e,d as ho,w as fo,m as po,e as Ae,f as Q,u as ee,g as Le,h as Me,i as He,j as ae,k as b,l as N,n as U,o as ie,p,q as se,r as re,N as _e}from"./admin-432e7d84.js";import{i as go,u as K,p as Y,a as bo,V as xo,f as Co,g as yo,b as Io,s as wo,t as So,d as zo,c as Fe,N as De,e as Ve,C as Ro,h as me,j as F,r as W,k as $o,l as Ao,m as Ho,n as de,o as fe,q as _o,v as No,w as ce}from"./Dropdown-883d1f90.js";import"./notice-9b8ada36.js";import"./request-55ac77c7.js";function To(e){if(typeof e=="number")return{"":e.toString()};const o={};return e.split(/ +/).forEach(t=>{if(t==="")return;const[r,n]=t.split(":");n===void 0?o[""]=r:o[r]=n}),o}function J(e,o){var t;if(e==null)return;const r=To(e);if(o===void 0)return r[""];if(typeof o=="string")return(t=r[o])!==null&&t!==void 0?t:r[""];if(Array.isArray(o)){for(let n=o.length-1;n>=0;--n){const l=o[n];if(l in r)return r[l]}return r[""]}else{let n,l=-1;return Object.keys(r).forEach(u=>{const d=Number(u);!Number.isNaN(d)&&o>=d&&d>=l&&(l=d,n=r[u])}),n}}function Po(e){var o;const t=(o=e.dirs)===null||o===void 0?void 0:o.find(({dir:r})=>r===Oe);return!!(t&&t.value===!1)}const ko={xs:0,s:640,m:1024,l:1280,xl:1536,"2xl":1920};function Oo(e){return`(min-width: ${e}px)`}const Z={};function Bo(e=ko){if(!go)return g(()=>[]);if(typeof window.matchMedia!="function")return g(()=>[]);const o=E({}),t=Object.keys(e),r=(n,l)=>{n.matches?o.value[l]=!0:o.value[l]=!1};return t.forEach(n=>{const l=e[n];let u,d;Z[l]===void 0?(u=window.matchMedia(Oo(l)),u.addEventListener?u.addEventListener("change",a=>{d.forEach(f=>{f(a,n)})}):u.addListener&&u.addListener(a=>{d.forEach(f=>{f(a,n)})}),d=new Set,Z[l]={mql:u,cbs:d}):(u=Z[l].mql,d=Z[l].cbs),d.add(r),u.matches&&d.forEach(a=>{a(u,n)})}),ro(()=>{t.forEach(n=>{const{cbs:l}=Z[e[n]];l.has(r)&&l.delete(r)})}),g(()=>{const{value:n}=o;return t.filter(l=>n[l])})}const Eo=B({name:"ChevronDownFilled",render(){return h("svg",{viewBox:"0 0 16 16",fill:"none",xmlns:"http://www.w3.org/2000/svg"},h("path",{d:"M3.20041 5.73966C3.48226 5.43613 3.95681 5.41856 4.26034 5.70041L8 9.22652L11.7397 5.70041C12.0432 5.41856 12.5177 5.43613 12.7996 5.73966C13.0815 6.0432 13.0639 6.51775 12.7603 6.7996L8.51034 10.7996C8.22258 11.0668 7.77743 11.0668 7.48967 10.7996L3.23966 6.7996C2.93613 6.51775 2.91856 6.0432 3.20041 5.73966Z",fill:"currentColor"}))}}),{cubicBezierEaseInOut:D,cubicBezierEaseOut:jo,cubicBezierEaseIn:Lo}=mo;function Mo({overflow:e="hidden",duration:o=".3s",originalTransition:t="",leavingDelay:r="0s",foldPadding:n=!1,enterToProps:l=void 0,leaveToProps:u=void 0,reverse:d=!1}={}){const a=d?"leave":"enter",f=d?"enter":"leave";return[$(`&.fade-in-height-expand-transition-${f}-from,
 &.fade-in-height-expand-transition-${a}-to`,Object.assign(Object.assign({},l),{opacity:1})),$(`&.fade-in-height-expand-transition-${f}-to,
 &.fade-in-height-expand-transition-${a}-from`,Object.assign(Object.assign({},u),{opacity:0,marginTop:"0 !important",marginBottom:"0 !important",paddingTop:n?"0 !important":void 0,paddingBottom:n?"0 !important":void 0})),$(`&.fade-in-height-expand-transition-${f}-active`,`
 overflow: ${e};
 transition:
 max-height ${o} ${D} ${r},
 opacity ${o} ${jo} ${r},
 margin-top ${o} ${D} ${r},
 margin-bottom ${o} ${D} ${r},
 padding-top ${o} ${D} ${r},
 padding-bottom ${o} ${D} ${r}
 ${t?","+t:""}
 `),$(`&.fade-in-height-expand-transition-${a}-active`,`
 overflow: ${e};
 transition:
 max-height ${o} ${D},
 opacity ${o} ${Lo},
 margin-top ${o} ${D},
 margin-bottom ${o} ${D},
 padding-top ${o} ${D},
 padding-bottom ${o} ${D}
 ${t?","+t:""}
 `)]}const Fo={abstract:Boolean,bordered:{type:Boolean,default:void 0},clsPrefix:String,locale:Object,dateLocale:Object,namespace:String,rtl:Array,tag:{type:String,default:"div"},hljs:Object,katex:Object,theme:Object,themeOverrides:Object,componentOptions:Object,icons:Object,breakpoints:Object,preflightStyleDisabled:Boolean,inlineThemeDisabled:{type:Boolean,default:void 0},as:{type:String,validator:()=>(fo("config-provider","`as` is deprecated, please use `tag` instead."),!0),default:void 0}},Do=B({name:"ConfigProvider",alias:["App"],props:Fo,setup(e){const o=V($e,null),t=g(()=>{const{theme:s}=e;if(s===null)return;const m=o==null?void 0:o.mergedThemeRef.value;return s===void 0?m:m===void 0?s:Object.assign({},m,s)}),r=g(()=>{const{themeOverrides:s}=e;if(s!==null){if(s===void 0)return o==null?void 0:o.mergedThemeOverridesRef.value;{const m=o==null?void 0:o.mergedThemeOverridesRef.value;return m===void 0?s:po({},m,s)}}}),n=K(()=>{const{namespace:s}=e;return s===void 0?o==null?void 0:o.mergedNamespaceRef.value:s}),l=K(()=>{const{bordered:s}=e;return s===void 0?o==null?void 0:o.mergedBorderedRef.value:s}),u=g(()=>{const{icons:s}=e;return s===void 0?o==null?void 0:o.mergedIconsRef.value:s}),d=g(()=>{const{componentOptions:s}=e;return s!==void 0?s:o==null?void 0:o.mergedComponentPropsRef.value}),a=g(()=>{const{clsPrefix:s}=e;return s!==void 0?s:o==null?void 0:o.mergedClsPrefixRef.value}),f=g(()=>{var s;const{rtl:m}=e;if(m===void 0)return o==null?void 0:o.mergedRtlRef.value;const y={};for(const x of m)y[x.name]=we(x),(s=x.peers)===null||s===void 0||s.forEach(A=>{A.name in y||(y[A.name]=we(A))});return y}),P=g(()=>e.breakpoints||(o==null?void 0:o.mergedBreakpointsRef.value)),H=e.inlineThemeDisabled||(o==null?void 0:o.inlineThemeDisabled),v=e.preflightStyleDisabled||(o==null?void 0:o.preflightStyleDisabled),C=g(()=>{const{value:s}=t,{value:m}=r,y=m&&Object.keys(m).length!==0,x=s==null?void 0:s.name;return x?y?`${x}-${Ae(JSON.stringify(r.value))}`:x:y?Ae(JSON.stringify(r.value)):""});return G($e,{mergedThemeHashRef:C,mergedBreakpointsRef:P,mergedRtlRef:f,mergedIconsRef:u,mergedComponentPropsRef:d,mergedBorderedRef:l,mergedNamespaceRef:n,mergedClsPrefixRef:a,mergedLocaleRef:g(()=>{const{locale:s}=e;if(s!==null)return s===void 0?o==null?void 0:o.mergedLocaleRef.value:s}),mergedDateLocaleRef:g(()=>{const{dateLocale:s}=e;if(s!==null)return s===void 0?o==null?void 0:o.mergedDateLocaleRef.value:s}),mergedHljsRef:g(()=>{const{hljs:s}=e;return s===void 0?o==null?void 0:o.mergedHljsRef.value:s}),mergedKatexRef:g(()=>{const{katex:s}=e;return s===void 0?o==null?void 0:o.mergedKatexRef.value:s}),mergedThemeRef:t,mergedThemeOverridesRef:r,inlineThemeDisabled:H||!1,preflightStyleDisabled:v||!1}),{mergedClsPrefix:a,mergedBordered:l,mergedNamespace:n,mergedTheme:t,mergedThemeOverrides:r}},render(){var e,o,t,r;return this.abstract?(r=(t=this.$slots).default)===null||r===void 0?void 0:r.call(t):h(this.as||this.tag,{class:`${this.mergedClsPrefix||ho}-config-provider`},(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e))}}),Ne=1,Ke=Q("n-grid"),Ge=1,Vo={span:{type:[Number,String],default:Ge},offset:{type:[Number,String],default:0},suffix:Boolean,privateOffset:Number,privateSpan:Number,privateColStart:Number,privateShow:{type:Boolean,default:!0}},Te=B({__GRID_ITEM__:!0,name:"GridItem",alias:["Gi"],props:Vo,setup(){const{isSsrRef:e,xGapRef:o,itemStyleRef:t,overflowRef:r,layoutShiftDisabledRef:n}=V(Ke),l=no();return{overflow:r,itemStyle:t,layoutShiftDisabled:n,mergedXGap:g(()=>Y(o.value||0)),deriveStyle:()=>{e.value;const{privateSpan:u=Ge,privateShow:d=!0,privateColStart:a=void 0,privateOffset:f=0}=l.vnode.props,{value:P}=o,H=Y(P||0);return{display:d?"":"none",gridColumn:`${a??`span ${u}`} / span ${u}`,marginLeft:f?`calc((100% - (${u} - 1) * ${H}) / ${u} * ${f} + ${H} * ${f})`:""}}}},render(){var e,o;if(this.layoutShiftDisabled){const{span:t,offset:r,mergedXGap:n}=this;return h("div",{style:{gridColumn:`span ${t} / span ${t}`,marginLeft:r?`calc((100% - (${t} - 1) * ${n}) / ${t} * ${r} + ${n} * ${r})`:""}},this.$slots)}return h("div",{style:[this.itemStyle,this.deriveStyle()]},(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e,{overflow:this.overflow}))}}),Ko={xs:0,s:640,m:1024,l:1280,xl:1536,xxl:1920},Ue=24,ue="__ssr__",Go={layoutShiftDisabled:Boolean,responsive:{type:[String,Boolean],default:"self"},cols:{type:[Number,String],default:Ue},itemResponsive:Boolean,collapsed:Boolean,collapsedRows:{type:Number,default:1},itemStyle:[Object,String],xGap:{type:[Number,String],default:0},yGap:{type:[Number,String],default:0}},Uo=B({name:"Grid",inheritAttrs:!1,props:Go,setup(e){const{mergedClsPrefixRef:o,mergedBreakpointsRef:t}=ee(e),r=/^\d+$/,n=E(void 0),l=Bo((t==null?void 0:t.value)||Ko),u=K(()=>!!(e.itemResponsive||!r.test(e.cols.toString())||!r.test(e.xGap.toString())||!r.test(e.yGap.toString()))),d=g(()=>{if(u.value)return e.responsive==="self"?n.value:l.value}),a=K(()=>{var x;return(x=Number(J(e.cols.toString(),d.value)))!==null&&x!==void 0?x:Ue}),f=K(()=>J(e.xGap.toString(),d.value)),P=K(()=>J(e.yGap.toString(),d.value)),H=x=>{n.value=x.contentRect.width},v=x=>{Io(H,x)},C=E(!1),s=g(()=>{if(e.responsive==="self")return v}),m=E(!1),y=E();return Be(()=>{const{value:x}=y;x&&x.hasAttribute(ue)&&(x.removeAttribute(ue),m.value=!0)}),G(Ke,{layoutShiftDisabledRef:X(e,"layoutShiftDisabled"),isSsrRef:m,itemStyleRef:X(e,"itemStyle"),xGapRef:f,overflowRef:C}),{isSsr:!bo,contentEl:y,mergedClsPrefix:o,style:g(()=>e.layoutShiftDisabled?{width:"100%",display:"grid",gridTemplateColumns:`repeat(${e.cols}, minmax(0, 1fr))`,columnGap:Y(e.xGap),rowGap:Y(e.yGap)}:{width:"100%",display:"grid",gridTemplateColumns:`repeat(${a.value}, minmax(0, 1fr))`,columnGap:Y(f.value),rowGap:Y(P.value)}),isResponsive:u,responsiveQuery:d,responsiveCols:a,handleResize:s,overflow:C}},render(){if(this.layoutShiftDisabled)return h("div",Se({ref:"contentEl",class:`${this.mergedClsPrefix}-grid`,style:this.style},this.$attrs),this.$slots);const e=()=>{var o,t,r,n,l,u,d;this.overflow=!1;const a=Co(yo(this)),f=[],{collapsed:P,collapsedRows:H,responsiveCols:v,responsiveQuery:C}=this;a.forEach(A=>{var j,k,R,z;if(((j=A==null?void 0:A.type)===null||j===void 0?void 0:j.__GRID_ITEM__)!==!0)return;if(Po(A)){const I=ze(A);I.props?I.props.privateShow=!1:I.props={privateShow:!1},f.push({child:I,rawChildSpan:0});return}A.dirs=((k=A.dirs)===null||k===void 0?void 0:k.filter(({dir:I})=>I!==Oe))||null;const _=ze(A),S=Number((z=J((R=_.props)===null||R===void 0?void 0:R.span,C))!==null&&z!==void 0?z:Ne);S!==0&&f.push({child:_,rawChildSpan:S})});let s=0;const m=(o=f[f.length-1])===null||o===void 0?void 0:o.child;if(m!=null&&m.props){const A=(t=m.props)===null||t===void 0?void 0:t.suffix;A!==void 0&&A!==!1&&(s=(n=(r=m.props)===null||r===void 0?void 0:r.span)!==null&&n!==void 0?n:Ne,m.props.privateSpan=s,m.props.privateColStart=v+1-s,m.props.privateShow=(l=m.props.privateShow)!==null&&l!==void 0?l:!0)}let y=0,x=!1;for(const{child:A,rawChildSpan:j}of f){if(x&&(this.overflow=!0),!x){const k=Number((d=J((u=A.props)===null||u===void 0?void 0:u.offset,C))!==null&&d!==void 0?d:0),R=Math.min(j+k,v);if(A.props?(A.props.privateSpan=R,A.props.privateOffset=k):A.props={privateSpan:R,privateOffset:k},P){const z=y%v;R+z>v&&(y+=v-z),R+y+s>H*v?x=!0:y+=R}}x&&(A.props?A.props.privateShow!==!0&&(A.props.privateShow=!1):A.props={privateShow:!1})}return h("div",Se({ref:"contentEl",class:`${this.mergedClsPrefix}-grid`,style:this.style,[ue]:this.isSsr||void 0},this.$attrs),f.map(({child:A})=>A))};return this.isResponsive&&this.responsive==="self"?h(xo,{onResize:this.handleResize},{default:e}):e()}}),qo=e=>{const{baseColor:o,textColor2:t,bodyColor:r,cardColor:n,dividerColor:l,actionColor:u,scrollbarColor:d,scrollbarColorHover:a,invertedColor:f}=e;return{textColor:t,textColorInverted:"#FFF",color:r,colorEmbedded:u,headerColor:n,headerColorInverted:f,footerColor:u,footerColorInverted:f,headerBorderColor:l,headerBorderColorInverted:f,footerBorderColor:l,footerBorderColorInverted:f,siderBorderColor:l,siderBorderColorInverted:f,siderColor:n,siderColorInverted:f,siderToggleButtonBorder:`1px solid ${l}`,siderToggleButtonColor:o,siderToggleButtonIconColor:t,siderToggleButtonIconColorInverted:t,siderToggleBarColor:He(r,d),siderToggleBarColorHover:He(r,a),__invertScrollbar:"true"}},Yo=Le({name:"Layout",common:Me,peers:{Scrollbar:wo},self:qo}),pe=Yo;function Wo(e,o,t,r){return{itemColorHoverInverted:"#0000",itemColorActiveInverted:o,itemColorActiveHoverInverted:o,itemColorActiveCollapsedInverted:o,itemTextColorInverted:e,itemTextColorHoverInverted:t,itemTextColorChildActiveInverted:t,itemTextColorChildActiveHoverInverted:t,itemTextColorActiveInverted:t,itemTextColorActiveHoverInverted:t,itemTextColorHorizontalInverted:e,itemTextColorHoverHorizontalInverted:t,itemTextColorChildActiveHorizontalInverted:t,itemTextColorChildActiveHoverHorizontalInverted:t,itemTextColorActiveHorizontalInverted:t,itemTextColorActiveHoverHorizontalInverted:t,itemIconColorInverted:e,itemIconColorHoverInverted:t,itemIconColorActiveInverted:t,itemIconColorActiveHoverInverted:t,itemIconColorChildActiveInverted:t,itemIconColorChildActiveHoverInverted:t,itemIconColorCollapsedInverted:e,itemIconColorHorizontalInverted:e,itemIconColorHoverHorizontalInverted:t,itemIconColorActiveHorizontalInverted:t,itemIconColorActiveHoverHorizontalInverted:t,itemIconColorChildActiveHorizontalInverted:t,itemIconColorChildActiveHoverHorizontalInverted:t,arrowColorInverted:e,arrowColorHoverInverted:t,arrowColorActiveInverted:t,arrowColorActiveHoverInverted:t,arrowColorChildActiveInverted:t,arrowColorChildActiveHoverInverted:t,groupTextColorInverted:r}}const Xo=e=>{const{borderRadius:o,textColor3:t,primaryColor:r,textColor2:n,textColor1:l,fontSize:u,dividerColor:d,hoverColor:a,primaryColorHover:f}=e;return Object.assign({borderRadius:o,color:"#0000",groupTextColor:t,itemColorHover:a,itemColorActive:ae(r,{alpha:.1}),itemColorActiveHover:ae(r,{alpha:.1}),itemColorActiveCollapsed:ae(r,{alpha:.1}),itemTextColor:n,itemTextColorHover:n,itemTextColorActive:r,itemTextColorActiveHover:r,itemTextColorChildActive:r,itemTextColorChildActiveHover:r,itemTextColorHorizontal:n,itemTextColorHoverHorizontal:f,itemTextColorActiveHorizontal:r,itemTextColorActiveHoverHorizontal:r,itemTextColorChildActiveHorizontal:r,itemTextColorChildActiveHoverHorizontal:r,itemIconColor:l,itemIconColorHover:l,itemIconColorActive:r,itemIconColorActiveHover:r,itemIconColorChildActive:r,itemIconColorChildActiveHover:r,itemIconColorCollapsed:l,itemIconColorHorizontal:l,itemIconColorHoverHorizontal:f,itemIconColorActiveHorizontal:r,itemIconColorActiveHoverHorizontal:r,itemIconColorChildActiveHorizontal:r,itemIconColorChildActiveHoverHorizontal:r,itemHeight:"42px",arrowColor:n,arrowColorHover:n,arrowColorActive:r,arrowColorActiveHover:r,arrowColorChildActive:r,arrowColorChildActiveHover:r,colorInverted:"#0000",borderColorHorizontal:"#0000",fontSize:u,dividerColor:d},Wo("#BBB",r,"#FFF","#AAA"))},Qo=Le({name:"Menu",common:Me,peers:{Tooltip:So,Dropdown:zo},self:Xo}),Jo=Qo,qe=Q("n-layout-sider"),ge={type:String,default:"static"},Zo=b("layout",`
 color: var(--n-text-color);
 background-color: var(--n-color);
 box-sizing: border-box;
 position: relative;
 z-index: auto;
 flex: auto;
 overflow: hidden;
 transition:
 box-shadow .3s var(--n-bezier),
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
`,[b("layout-scroll-container",`
 overflow-x: hidden;
 box-sizing: border-box;
 height: 100%;
 `),N("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),et={embedded:Boolean,position:ge,nativeScrollbar:{type:Boolean,default:!0},scrollbarProps:Object,onScroll:Function,contentStyle:{type:[String,Object],default:""},hasSider:Boolean,siderPlacement:{type:String,default:"left"}},Ye=Q("n-layout");function ot(e){return B({name:e?"LayoutContent":"Layout",props:Object.assign(Object.assign({},U.props),et),setup(o){const t=E(null),r=E(null),{mergedClsPrefixRef:n,inlineThemeDisabled:l}=ee(o),u=U("Layout","-layout",Zo,pe,o,n);function d(m,y){if(o.nativeScrollbar){const{value:x}=t;x&&(y===void 0?x.scrollTo(m):x.scrollTo(m,y))}else{const{value:x}=r;x&&x.scrollTo(m,y)}}G(Ye,o);let a=0,f=0;const P=m=>{var y;const x=m.target;a=x.scrollLeft,f=x.scrollTop,(y=o.onScroll)===null||y===void 0||y.call(o,m)};Fe(()=>{if(o.nativeScrollbar){const m=t.value;m&&(m.scrollTop=f,m.scrollLeft=a)}});const H={display:"flex",flexWrap:"nowrap",width:"100%",flexDirection:"row"},v={scrollTo:d},C=g(()=>{const{common:{cubicBezierEaseInOut:m},self:y}=u.value;return{"--n-bezier":m,"--n-color":o.embedded?y.colorEmbedded:y.color,"--n-text-color":y.textColor}}),s=l?ie("layout",g(()=>o.embedded?"e":""),C,o):void 0;return Object.assign({mergedClsPrefix:n,scrollableElRef:t,scrollbarInstRef:r,hasSiderStyle:H,mergedTheme:u,handleNativeElScroll:P,cssVars:l?void 0:C,themeClass:s==null?void 0:s.themeClass,onRender:s==null?void 0:s.onRender},v)},render(){var o;const{mergedClsPrefix:t,hasSider:r}=this;(o=this.onRender)===null||o===void 0||o.call(this);const n=r?this.hasSiderStyle:void 0,l=[this.themeClass,e&&`${t}-layout-content`,`${t}-layout`,`${t}-layout--${this.position}-positioned`];return h("div",{class:l,style:this.cssVars},this.nativeScrollbar?h("div",{ref:"scrollableElRef",class:`${t}-layout-scroll-container`,style:[this.contentStyle,n],onScroll:this.handleNativeElScroll},this.$slots):h(De,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,contentStyle:[this.contentStyle,n]}),this.$slots))}})}const ve=ot(!1),tt=b("layout-header",`
 transition:
 color .3s var(--n-bezier),
 background-color .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier),
 border-color .3s var(--n-bezier);
 box-sizing: border-box;
 width: 100%;
 background-color: var(--n-color);
 color: var(--n-text-color);
`,[N("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 `),N("bordered",`
 border-bottom: solid 1px var(--n-border-color);
 `)]),rt={position:ge,inverted:Boolean,bordered:{type:Boolean,default:!1}},nt=B({name:"LayoutHeader",props:Object.assign(Object.assign({},U.props),rt),setup(e){const{mergedClsPrefixRef:o,inlineThemeDisabled:t}=ee(e),r=U("Layout","-layout-header",tt,pe,e,o),n=g(()=>{const{common:{cubicBezierEaseInOut:u},self:d}=r.value,a={"--n-bezier":u};return e.inverted?(a["--n-color"]=d.headerColorInverted,a["--n-text-color"]=d.textColorInverted,a["--n-border-color"]=d.headerBorderColorInverted):(a["--n-color"]=d.headerColor,a["--n-text-color"]=d.textColor,a["--n-border-color"]=d.headerBorderColor),a}),l=t?ie("layout-header",g(()=>e.inverted?"a":"b"),n,e):void 0;return{mergedClsPrefix:o,cssVars:t?void 0:n,themeClass:l==null?void 0:l.themeClass,onRender:l==null?void 0:l.onRender}},render(){var e;const{mergedClsPrefix:o}=this;return(e=this.onRender)===null||e===void 0||e.call(this),h("div",{class:[`${o}-layout-header`,this.themeClass,this.position&&`${o}-layout-header--${this.position}-positioned`,this.bordered&&`${o}-layout-header--bordered`],style:this.cssVars},this.$slots)}}),it=b("layout-sider",`
 flex-shrink: 0;
 box-sizing: border-box;
 position: relative;
 z-index: 1;
 color: var(--n-text-color);
 transition:
 color .3s var(--n-bezier),
 border-color .3s var(--n-bezier),
 min-width .3s var(--n-bezier),
 max-width .3s var(--n-bezier),
 transform .3s var(--n-bezier),
 background-color .3s var(--n-bezier);
 background-color: var(--n-color);
 display: flex;
 justify-content: flex-end;
`,[N("bordered",[p("border",`
 content: "";
 position: absolute;
 top: 0;
 bottom: 0;
 width: 1px;
 background-color: var(--n-border-color);
 transition: background-color .3s var(--n-bezier);
 `)]),p("left-placement",[N("bordered",[p("border",`
 right: 0;
 `)])]),N("right-placement",`
 justify-content: flex-start;
 `,[N("bordered",[p("border",`
 left: 0;
 `)]),N("collapsed",[b("layout-toggle-button",[b("base-icon",`
 transform: rotate(180deg);
 `)]),b("layout-toggle-bar",[$("&:hover",[p("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),p("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])])]),b("layout-toggle-button",`
 left: 0;
 transform: translateX(-50%) translateY(-50%);
 `,[b("base-icon",`
 transform: rotate(0);
 `)]),b("layout-toggle-bar",`
 left: -28px;
 transform: rotate(180deg);
 `,[$("&:hover",[p("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),p("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})])])]),N("collapsed",[b("layout-toggle-bar",[$("&:hover",[p("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),p("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])]),b("layout-toggle-button",[b("base-icon",`
 transform: rotate(0);
 `)])]),b("layout-toggle-button",`
 transition:
 color .3s var(--n-bezier),
 right .3s var(--n-bezier),
 left .3s var(--n-bezier),
 border-color .3s var(--n-bezier),
 background-color .3s var(--n-bezier);
 cursor: pointer;
 width: 24px;
 height: 24px;
 position: absolute;
 top: 50%;
 right: 0;
 border-radius: 50%;
 display: flex;
 align-items: center;
 justify-content: center;
 font-size: 18px;
 color: var(--n-toggle-button-icon-color);
 border: var(--n-toggle-button-border);
 background-color: var(--n-toggle-button-color);
 box-shadow: 0 2px 4px 0px rgba(0, 0, 0, .06);
 transform: translateX(50%) translateY(-50%);
 z-index: 1;
 `,[b("base-icon",`
 transition: transform .3s var(--n-bezier);
 transform: rotate(180deg);
 `)]),b("layout-toggle-bar",`
 cursor: pointer;
 height: 72px;
 width: 32px;
 position: absolute;
 top: calc(50% - 36px);
 right: -28px;
 `,[p("top, bottom",`
 position: absolute;
 width: 4px;
 border-radius: 2px;
 height: 38px;
 left: 14px;
 transition: 
 background-color .3s var(--n-bezier),
 transform .3s var(--n-bezier);
 `),p("bottom",`
 position: absolute;
 top: 34px;
 `),$("&:hover",[p("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),p("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})]),p("top, bottom",{backgroundColor:"var(--n-toggle-bar-color)"}),$("&:hover",[p("top, bottom",{backgroundColor:"var(--n-toggle-bar-color-hover)"})])]),p("border",`
 position: absolute;
 top: 0;
 right: 0;
 bottom: 0;
 width: 1px;
 transition: background-color .3s var(--n-bezier);
 `),b("layout-sider-scroll-container",`
 flex-grow: 1;
 flex-shrink: 0;
 box-sizing: border-box;
 height: 100%;
 opacity: 0;
 transition: opacity .3s var(--n-bezier);
 max-width: 100%;
 `),N("show-content",[b("layout-sider-scroll-container",{opacity:1})]),N("absolute-positioned",`
 position: absolute;
 left: 0;
 top: 0;
 bottom: 0;
 `)]),lt=B({name:"LayoutToggleButton",props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return h("div",{class:`${e}-layout-toggle-button`,onClick:this.onClick},h(Ve,{clsPrefix:e},{default:()=>h(Ro,null)}))}}),at=B({props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return h("div",{onClick:this.onClick,class:`${e}-layout-toggle-bar`},h("div",{class:`${e}-layout-toggle-bar__top`}),h("div",{class:`${e}-layout-toggle-bar__bottom`}))}}),st={position:ge,bordered:Boolean,collapsedWidth:{type:Number,default:48},width:{type:[Number,String],default:272},contentStyle:{type:[String,Object],default:""},collapseMode:{type:String,default:"transform"},collapsed:{type:Boolean,default:void 0},defaultCollapsed:Boolean,showCollapsedContent:{type:Boolean,default:!0},showTrigger:{type:[Boolean,String],default:!1},nativeScrollbar:{type:Boolean,default:!0},inverted:Boolean,scrollbarProps:Object,triggerStyle:[String,Object],collapsedTriggerStyle:[String,Object],"onUpdate:collapsed":[Function,Array],onUpdateCollapsed:[Function,Array],onAfterEnter:Function,onAfterLeave:Function,onExpand:[Function,Array],onCollapse:[Function,Array],onScroll:Function},dt=B({name:"LayoutSider",props:Object.assign(Object.assign({},U.props),st),setup(e){const o=V(Ye),t=E(null),r=E(null),n=g(()=>se(a.value?e.collapsedWidth:e.width)),l=g(()=>e.collapseMode!=="transform"?{}:{minWidth:se(e.width)}),u=g(()=>o?o.siderPlacement:"left"),d=E(e.defaultCollapsed),a=me(X(e,"collapsed"),d);function f(R,z){if(e.nativeScrollbar){const{value:_}=t;_&&(z===void 0?_.scrollTo(R):_.scrollTo(R,z))}else{const{value:_}=r;_&&_.scrollTo(R,z)}}function P(){const{"onUpdate:collapsed":R,onUpdateCollapsed:z,onExpand:_,onCollapse:S}=e,{value:I}=a;z&&F(z,!I),R&&F(R,!I),d.value=!I,I?_&&F(_):S&&F(S)}let H=0,v=0;const C=R=>{var z;const _=R.target;H=_.scrollLeft,v=_.scrollTop,(z=e.onScroll)===null||z===void 0||z.call(e,R)};Fe(()=>{if(e.nativeScrollbar){const R=t.value;R&&(R.scrollTop=v,R.scrollLeft=H)}}),G(qe,{collapsedRef:a,collapseModeRef:X(e,"collapseMode")});const{mergedClsPrefixRef:s,inlineThemeDisabled:m}=ee(e),y=U("Layout","-layout-sider",it,pe,e,s);function x(R){var z,_;R.propertyName==="max-width"&&(a.value?(z=e.onAfterLeave)===null||z===void 0||z.call(e):(_=e.onAfterEnter)===null||_===void 0||_.call(e))}const A={scrollTo:f},j=g(()=>{const{common:{cubicBezierEaseInOut:R},self:z}=y.value,{siderToggleButtonColor:_,siderToggleButtonBorder:S,siderToggleBarColor:I,siderToggleBarColorHover:i}=z,w={"--n-bezier":R,"--n-toggle-button-color":_,"--n-toggle-button-border":S,"--n-toggle-bar-color":I,"--n-toggle-bar-color-hover":i};return e.inverted?(w["--n-color"]=z.siderColorInverted,w["--n-text-color"]=z.textColorInverted,w["--n-border-color"]=z.siderBorderColorInverted,w["--n-toggle-button-icon-color"]=z.siderToggleButtonIconColorInverted,w.__invertScrollbar=z.__invertScrollbar):(w["--n-color"]=z.siderColor,w["--n-text-color"]=z.textColor,w["--n-border-color"]=z.siderBorderColor,w["--n-toggle-button-icon-color"]=z.siderToggleButtonIconColor),w}),k=m?ie("layout-sider",g(()=>e.inverted?"a":"b"),j,e):void 0;return Object.assign({scrollableElRef:t,scrollbarInstRef:r,mergedClsPrefix:s,mergedTheme:y,styleMaxWidth:n,mergedCollapsed:a,scrollContainerStyle:l,siderPlacement:u,handleNativeElScroll:C,handleTransitionend:x,handleTriggerClick:P,inlineThemeDisabled:m,cssVars:j,themeClass:k==null?void 0:k.themeClass,onRender:k==null?void 0:k.onRender},A)},render(){var e;const{mergedClsPrefix:o,mergedCollapsed:t,showTrigger:r}=this;return(e=this.onRender)===null||e===void 0||e.call(this),h("aside",{class:[`${o}-layout-sider`,this.themeClass,`${o}-layout-sider--${this.position}-positioned`,`${o}-layout-sider--${this.siderPlacement}-placement`,this.bordered&&`${o}-layout-sider--bordered`,t&&`${o}-layout-sider--collapsed`,(!t||this.showCollapsedContent)&&`${o}-layout-sider--show-content`],onTransitionend:this.handleTransitionend,style:[this.inlineThemeDisabled?void 0:this.cssVars,{maxWidth:this.styleMaxWidth,width:se(this.width)}]},this.nativeScrollbar?h("div",{class:`${o}-layout-sider-scroll-container`,onScroll:this.handleNativeElScroll,style:[this.scrollContainerStyle,{overflow:"auto"},this.contentStyle],ref:"scrollableElRef"},this.$slots):h(De,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",style:this.scrollContainerStyle,contentStyle:this.contentStyle,theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,builtinThemeOverrides:this.inverted&&this.cssVars.__invertScrollbar==="true"?{colorHover:"rgba(255, 255, 255, .4)",color:"rgba(255, 255, 255, .3)"}:void 0}),this.$slots),r?r==="bar"?h(at,{clsPrefix:o,style:t?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):h(lt,{clsPrefix:o,style:t?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):null,this.bordered?h("div",{class:`${o}-layout-sider__border`}):null)}}),oe=Q("n-menu"),be=Q("n-submenu"),xe=Q("n-menu-item-group"),ne=8;function Ce(e){const o=V(oe),{props:t,mergedCollapsedRef:r}=o,n=V(be,null),l=V(xe,null),u=g(()=>t.mode==="horizontal"),d=g(()=>u.value?t.dropdownPlacement:"tmNodes"in e?"right-start":"right"),a=g(()=>{var v;return Math.max((v=t.collapsedIconSize)!==null&&v!==void 0?v:t.iconSize,t.iconSize)}),f=g(()=>{var v;return!u.value&&e.root&&r.value&&(v=t.collapsedIconSize)!==null&&v!==void 0?v:t.iconSize}),P=g(()=>{if(u.value)return;const{collapsedWidth:v,indent:C,rootIndent:s}=t,{root:m,isGroup:y}=e,x=s===void 0?C:s;if(m)return r.value?v/2-a.value/2:x;if(l)return C/2+l.paddingLeftRef.value;if(n)return(y?C/2:C)+n.paddingLeftRef.value}),H=g(()=>{const{collapsedWidth:v,indent:C,rootIndent:s}=t,{value:m}=a,{root:y}=e;return u.value||!y||!r.value?ne:(s===void 0?C:s)+m+ne-(v+m)/2});return{dropdownPlacement:d,activeIconSize:f,maxIconSize:a,paddingLeft:P,iconMarginRight:H,NMenu:o,NSubmenu:n}}const ye={internalKey:{type:[String,Number],required:!0},root:Boolean,isGroup:Boolean,level:{type:Number,required:!0},title:[String,Function],extra:[String,Function]},We=Object.assign(Object.assign({},ye),{tmNode:{type:Object,required:!0},tmNodes:{type:Array,required:!0}}),ct=B({name:"MenuOptionGroup",props:We,setup(e){G(be,null);const o=Ce(e);G(xe,{paddingLeftRef:o.paddingLeft});const{mergedClsPrefixRef:t,props:r}=V(oe);return function(){const{value:n}=t,l=o.paddingLeft.value,{nodeProps:u}=r,d=u==null?void 0:u(e.tmNode.rawNode);return h("div",{class:`${n}-menu-item-group`,role:"group"},h("div",Object.assign({},d,{class:[`${n}-menu-item-group-title`,d==null?void 0:d.class],style:[(d==null?void 0:d.style)||"",l!==void 0?`padding-left: ${l}px;`:""]}),W(e.title),e.extra?h(io,null," ",W(e.extra)):null),h("div",null,e.tmNodes.map(a=>Ie(a,r))))}}}),Xe=B({name:"MenuOptionContent",props:{collapsed:Boolean,disabled:Boolean,title:[String,Function],icon:Function,extra:[String,Function],showArrow:Boolean,childActive:Boolean,hover:Boolean,paddingLeft:Number,selected:Boolean,maxIconSize:{type:Number,required:!0},activeIconSize:{type:Number,required:!0},iconMarginRight:{type:Number,required:!0},clsPrefix:{type:String,required:!0},onClick:Function,tmNode:{type:Object,required:!0}},setup(e){const{props:o}=V(oe);return{menuProps:o,style:g(()=>{const{paddingLeft:t}=e;return{paddingLeft:t&&`${t}px`}}),iconStyle:g(()=>{const{maxIconSize:t,activeIconSize:r,iconMarginRight:n}=e;return{width:`${t}px`,height:`${t}px`,fontSize:`${r}px`,marginRight:`${n}px`}})}},render(){const{clsPrefix:e,tmNode:o,menuProps:{renderIcon:t,renderLabel:r,renderExtra:n,expandIcon:l}}=this,u=t?t(o.rawNode):W(this.icon);return h("div",{onClick:d=>{var a;(a=this.onClick)===null||a===void 0||a.call(this,d)},role:"none",class:[`${e}-menu-item-content`,{[`${e}-menu-item-content--selected`]:this.selected,[`${e}-menu-item-content--collapsed`]:this.collapsed,[`${e}-menu-item-content--child-active`]:this.childActive,[`${e}-menu-item-content--disabled`]:this.disabled,[`${e}-menu-item-content--hover`]:this.hover}],style:this.style},u&&h("div",{class:`${e}-menu-item-content__icon`,style:this.iconStyle,role:"none"},[u]),h("div",{class:`${e}-menu-item-content-header`,role:"none"},r?r(o.rawNode):W(this.title),this.extra||n?h("span",{class:`${e}-menu-item-content-header__extra`}," ",n?n(o.rawNode):W(this.extra)):null),this.showArrow?h(Ve,{ariaHidden:!0,class:`${e}-menu-item-content__arrow`,clsPrefix:e},{default:()=>l?l(o.rawNode):h(Eo,null)}):null)}}),Qe=Object.assign(Object.assign({},ye),{rawNodes:{type:Array,default:()=>[]},tmNodes:{type:Array,default:()=>[]},tmNode:{type:Object,required:!0},disabled:{type:Boolean,default:!1},icon:Function,onClick:Function}),ut=B({name:"Submenu",props:Qe,setup(e){const o=Ce(e),{NMenu:t,NSubmenu:r}=o,{props:n,mergedCollapsedRef:l,mergedThemeRef:u}=t,d=g(()=>{const{disabled:v}=e;return r!=null&&r.mergedDisabledRef.value||n.disabled?!0:v}),a=E(!1);G(be,{paddingLeftRef:o.paddingLeft,mergedDisabledRef:d}),G(xe,null);function f(){const{onClick:v}=e;v&&v()}function P(){d.value||(l.value||t.toggleExpand(e.internalKey),f())}function H(v){a.value=v}return{menuProps:n,mergedTheme:u,doSelect:t.doSelect,inverted:t.invertedRef,isHorizontal:t.isHorizontalRef,mergedClsPrefix:t.mergedClsPrefixRef,maxIconSize:o.maxIconSize,activeIconSize:o.activeIconSize,iconMarginRight:o.iconMarginRight,dropdownPlacement:o.dropdownPlacement,dropdownShow:a,paddingLeft:o.paddingLeft,mergedDisabled:d,mergedValue:t.mergedValueRef,childActive:K(()=>t.activePathRef.value.includes(e.internalKey)),collapsed:g(()=>n.mode==="horizontal"?!1:l.value?!0:!t.mergedExpandedKeysRef.value.includes(e.internalKey)),dropdownEnabled:g(()=>!d.value&&(n.mode==="horizontal"||l.value)),handlePopoverShowChange:H,handleClick:P}},render(){var e;const{mergedClsPrefix:o,menuProps:{renderIcon:t,renderLabel:r}}=this,n=()=>{const{isHorizontal:u,paddingLeft:d,collapsed:a,mergedDisabled:f,maxIconSize:P,activeIconSize:H,title:v,childActive:C,icon:s,handleClick:m,menuProps:{nodeProps:y},dropdownShow:x,iconMarginRight:A,tmNode:j,mergedClsPrefix:k}=this,R=y==null?void 0:y(j.rawNode);return h("div",Object.assign({},R,{class:[`${k}-menu-item`,R==null?void 0:R.class],role:"menuitem"}),h(Xe,{tmNode:j,paddingLeft:d,collapsed:a,disabled:f,iconMarginRight:A,maxIconSize:P,activeIconSize:H,title:v,extra:this.extra,showArrow:!u,childActive:C,clsPrefix:k,icon:s,hover:x,onClick:m}))},l=()=>h(Ao,null,{default:()=>{const{tmNodes:u,collapsed:d}=this;return d?null:h("div",{class:`${o}-submenu-children`,role:"menu"},u.map(a=>Ie(a,this.menuProps)))}});return this.root?h($o,Object.assign({size:"large",trigger:"hover"},(e=this.menuProps)===null||e===void 0?void 0:e.dropdownProps,{themeOverrides:this.mergedTheme.peerOverrides.Dropdown,theme:this.mergedTheme.peers.Dropdown,builtinThemeOverrides:{fontSizeLarge:"14px",optionIconSizeLarge:"18px"},value:this.mergedValue,disabled:!this.dropdownEnabled,placement:this.dropdownPlacement,keyField:this.menuProps.keyField,labelField:this.menuProps.labelField,childrenField:this.menuProps.childrenField,onUpdateShow:this.handlePopoverShowChange,options:this.rawNodes,onSelect:this.doSelect,inverted:this.inverted,renderIcon:t,renderLabel:r}),{default:()=>h("div",{class:`${o}-submenu`,role:"menuitem","aria-expanded":!this.collapsed},n(),this.isHorizontal?null:l())}):h("div",{class:`${o}-submenu`,role:"menuitem","aria-expanded":!this.collapsed},n(),l())}}),Je=Object.assign(Object.assign({},ye),{tmNode:{type:Object,required:!0},disabled:Boolean,icon:Function,onClick:Function}),vt=B({name:"MenuOption",props:Je,setup(e){const o=Ce(e),{NSubmenu:t,NMenu:r}=o,{props:n,mergedClsPrefixRef:l,mergedCollapsedRef:u}=r,d=t?t.mergedDisabledRef:{value:!1},a=g(()=>d.value||e.disabled);function f(H){const{onClick:v}=e;v&&v(H)}function P(H){a.value||(r.doSelect(e.internalKey,e.tmNode.rawNode),f(H))}return{mergedClsPrefix:l,dropdownPlacement:o.dropdownPlacement,paddingLeft:o.paddingLeft,iconMarginRight:o.iconMarginRight,maxIconSize:o.maxIconSize,activeIconSize:o.activeIconSize,mergedTheme:r.mergedThemeRef,menuProps:n,dropdownEnabled:K(()=>e.root&&u.value&&n.mode!=="horizontal"&&!a.value),selected:K(()=>r.mergedValueRef.value===e.internalKey),mergedDisabled:a,handleClick:P}},render(){const{mergedClsPrefix:e,mergedTheme:o,tmNode:t,menuProps:{renderLabel:r,nodeProps:n}}=this,l=n==null?void 0:n(t.rawNode);return h("div",Object.assign({},l,{role:"menuitem",class:[`${e}-menu-item`,l==null?void 0:l.class]}),h(Ho,{theme:o.peers.Tooltip,themeOverrides:o.peerOverrides.Tooltip,trigger:"hover",placement:this.dropdownPlacement,disabled:!this.dropdownEnabled||this.title===void 0,internalExtraClass:["menu-tooltip"]},{default:()=>r?r(t.rawNode):W(this.title),trigger:()=>h(Xe,{tmNode:t,clsPrefix:e,paddingLeft:this.paddingLeft,iconMarginRight:this.iconMarginRight,maxIconSize:this.maxIconSize,activeIconSize:this.activeIconSize,selected:this.selected,title:this.title,extra:this.extra,disabled:this.mergedDisabled,icon:this.icon,onClick:this.handleClick})}))}}),mt=B({name:"MenuDivider",setup(){const e=V(oe),{mergedClsPrefixRef:o,isHorizontalRef:t}=e;return()=>t.value?null:h("div",{class:`${o.value}-menu-divider`})}}),ht=fe(We),ft=fe(Je),pt=fe(Qe);function Ze(e){return e.type==="divider"||e.type==="render"}function gt(e){return e.type==="divider"}function Ie(e,o){const{rawNode:t}=e,{show:r}=t;if(r===!1)return null;if(Ze(t))return gt(t)?h(mt,Object.assign({key:e.key},t.props)):null;const{labelField:n}=o,{key:l,level:u,isGroup:d}=e,a=Object.assign(Object.assign({},t),{title:t.title||t[n],extra:t.titleExtra||t.extra,key:l,internalKey:l,level:u,root:u===0,isGroup:d});return e.children?e.isGroup?h(ct,de(a,ht,{tmNode:e,tmNodes:e.children,key:l})):h(ut,de(a,pt,{key:l,rawNodes:t[o.childrenField],tmNodes:e.children,tmNode:e})):h(vt,de(a,ft,{key:l,tmNode:e}))}const Pe=[$("&::before","background-color: var(--n-item-color-hover);"),p("arrow",`
 color: var(--n-arrow-color-hover);
 `),p("icon",`
 color: var(--n-item-icon-color-hover);
 `),b("menu-item-content-header",`
 color: var(--n-item-text-color-hover);
 `,[$("a",`
 color: var(--n-item-text-color-hover);
 `),p("extra",`
 color: var(--n-item-text-color-hover);
 `)])],ke=[p("icon",`
 color: var(--n-item-icon-color-hover-horizontal);
 `),b("menu-item-content-header",`
 color: var(--n-item-text-color-hover-horizontal);
 `,[$("a",`
 color: var(--n-item-text-color-hover-horizontal);
 `),p("extra",`
 color: var(--n-item-text-color-hover-horizontal);
 `)])],bt=$([b("menu",`
 background-color: var(--n-color);
 color: var(--n-item-text-color);
 overflow: hidden;
 transition: background-color .3s var(--n-bezier);
 box-sizing: border-box;
 font-size: var(--n-font-size);
 padding-bottom: 6px;
 `,[N("horizontal",`
 display: inline-flex;
 padding-bottom: 0;
 `,[b("submenu","margin: 0;"),b("menu-item","margin: 0;"),b("menu-item-content",`
 padding: 0 20px;
 border-bottom: 2px solid #0000;
 `,[$("&::before","display: none;"),N("selected","border-bottom: 2px solid var(--n-border-color-horizontal)")]),b("menu-item-content",[N("selected",[p("icon","color: var(--n-item-icon-color-active-horizontal);"),b("menu-item-content-header",`
 color: var(--n-item-text-color-active-horizontal);
 `,[$("a","color: var(--n-item-text-color-active-horizontal);"),p("extra","color: var(--n-item-text-color-active-horizontal);")])]),N("child-active",`
 border-bottom: 2px solid var(--n-border-color-horizontal);
 `,[b("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-horizontal);
 `,[$("a",`
 color: var(--n-item-text-color-child-active-horizontal);
 `),p("extra",`
 color: var(--n-item-text-color-child-active-horizontal);
 `)]),p("icon",`
 color: var(--n-item-icon-color-child-active-horizontal);
 `)]),re("disabled",[re("selected, child-active",[$("&:focus-within",ke)]),N("selected",[q(null,[p("icon","color: var(--n-item-icon-color-active-hover-horizontal);"),b("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover-horizontal);
 `,[$("a","color: var(--n-item-text-color-active-hover-horizontal);"),p("extra","color: var(--n-item-text-color-active-hover-horizontal);")])])]),N("child-active",[q(null,[p("icon","color: var(--n-item-icon-color-child-active-hover-horizontal);"),b("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover-horizontal);
 `,[$("a","color: var(--n-item-text-color-child-active-hover-horizontal);"),p("extra","color: var(--n-item-text-color-child-active-hover-horizontal);")])])]),q("border-bottom: 2px solid var(--n-border-color-horizontal);",ke)]),b("menu-item-content-header",[$("a","color: var(--n-item-text-color-horizontal);")])])]),N("collapsed",[b("menu-item-content",[N("selected",[$("&::before",`
 background-color: var(--n-item-color-active-collapsed) !important;
 `)]),b("menu-item-content-header","opacity: 0;"),p("arrow","opacity: 0;"),p("icon","color: var(--n-item-icon-color-collapsed);")])]),b("menu-item",`
 height: var(--n-item-height);
 margin-top: 6px;
 position: relative;
 `),b("menu-item-content",`
 box-sizing: border-box;
 line-height: 1.75;
 height: 100%;
 display: grid;
 grid-template-areas: "icon content arrow";
 grid-template-columns: auto 1fr auto;
 align-items: center;
 cursor: pointer;
 position: relative;
 padding-right: 18px;
 transition:
 background-color .3s var(--n-bezier),
 padding-left .3s var(--n-bezier),
 border-color .3s var(--n-bezier);
 `,[$("> *","z-index: 1;"),$("&::before",`
 z-index: auto;
 content: "";
 background-color: #0000;
 position: absolute;
 left: 8px;
 right: 8px;
 top: 0;
 bottom: 0;
 pointer-events: none;
 border-radius: var(--n-border-radius);
 transition: background-color .3s var(--n-bezier);
 `),N("disabled",`
 opacity: .45;
 cursor: not-allowed;
 `),N("collapsed",[p("arrow","transform: rotate(0);")]),N("selected",[$("&::before","background-color: var(--n-item-color-active);"),p("arrow","color: var(--n-arrow-color-active);"),p("icon","color: var(--n-item-icon-color-active);"),b("menu-item-content-header",`
 color: var(--n-item-text-color-active);
 `,[$("a","color: var(--n-item-text-color-active);"),p("extra","color: var(--n-item-text-color-active);")])]),N("child-active",[b("menu-item-content-header",`
 color: var(--n-item-text-color-child-active);
 `,[$("a",`
 color: var(--n-item-text-color-child-active);
 `),p("extra",`
 color: var(--n-item-text-color-child-active);
 `)]),p("arrow",`
 color: var(--n-arrow-color-child-active);
 `),p("icon",`
 color: var(--n-item-icon-color-child-active);
 `)]),re("disabled",[re("selected, child-active",[$("&:focus-within",Pe)]),N("selected",[q(null,[p("arrow","color: var(--n-arrow-color-active-hover);"),p("icon","color: var(--n-item-icon-color-active-hover);"),b("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover);
 `,[$("a","color: var(--n-item-text-color-active-hover);"),p("extra","color: var(--n-item-text-color-active-hover);")])])]),N("child-active",[q(null,[p("arrow","color: var(--n-arrow-color-child-active-hover);"),p("icon","color: var(--n-item-icon-color-child-active-hover);"),b("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover);
 `,[$("a","color: var(--n-item-text-color-child-active-hover);"),p("extra","color: var(--n-item-text-color-child-active-hover);")])])]),N("selected",[q(null,[$("&::before","background-color: var(--n-item-color-active-hover);")])]),q(null,Pe)]),p("icon",`
 grid-area: icon;
 color: var(--n-item-icon-color);
 transition:
 color .3s var(--n-bezier),
 font-size .3s var(--n-bezier),
 margin-right .3s var(--n-bezier);
 box-sizing: content-box;
 display: inline-flex;
 align-items: center;
 justify-content: center;
 `),p("arrow",`
 grid-area: arrow;
 font-size: 16px;
 color: var(--n-arrow-color);
 transform: rotate(180deg);
 opacity: 1;
 transition:
 color .3s var(--n-bezier),
 transform 0.2s var(--n-bezier),
 opacity 0.2s var(--n-bezier);
 `),b("menu-item-content-header",`
 grid-area: content;
 transition:
 color .3s var(--n-bezier),
 opacity .3s var(--n-bezier);
 opacity: 1;
 white-space: nowrap;
 overflow: hidden;
 text-overflow: ellipsis;
 color: var(--n-item-text-color);
 `,[$("a",`
 outline: none;
 text-decoration: none;
 transition: color .3s var(--n-bezier);
 color: var(--n-item-text-color);
 `,[$("&::before",`
 content: "";
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),p("extra",`
 font-size: .93em;
 color: var(--n-group-text-color);
 transition: color .3s var(--n-bezier);
 `)])]),b("submenu",`
 cursor: pointer;
 position: relative;
 margin-top: 6px;
 `,[b("menu-item-content",`
 height: var(--n-item-height);
 `),b("submenu-children",`
 overflow: hidden;
 padding: 0;
 `,[Mo({duration:".2s"})])]),b("menu-item-group",[b("menu-item-group-title",`
 margin-top: 6px;
 color: var(--n-group-text-color);
 cursor: default;
 font-size: .93em;
 height: 36px;
 display: flex;
 align-items: center;
 transition:
 padding-left .3s var(--n-bezier),
 color .3s var(--n-bezier);
 `)])]),b("menu-tooltip",[$("a",`
 color: inherit;
 text-decoration: none;
 `)]),b("menu-divider",`
 transition: background-color .3s var(--n-bezier);
 background-color: var(--n-divider-color);
 height: 1px;
 margin: 6px 18px;
 `)]);function q(e,o){return[N("hover",e,o),$("&:hover",e,o)]}const xt=Object.assign(Object.assign({},U.props),{options:{type:Array,default:()=>[]},collapsed:{type:Boolean,default:void 0},collapsedWidth:{type:Number,default:48},iconSize:{type:Number,default:20},collapsedIconSize:{type:Number,default:24},rootIndent:Number,indent:{type:Number,default:32},labelField:{type:String,default:"label"},keyField:{type:String,default:"key"},childrenField:{type:String,default:"children"},disabledField:{type:String,default:"disabled"},defaultExpandAll:Boolean,defaultExpandedKeys:Array,expandedKeys:Array,value:[String,Number],defaultValue:{type:[String,Number],default:null},mode:{type:String,default:"vertical"},watchProps:{type:Array,default:void 0},disabled:Boolean,show:{type:Boolean,default:!0},inverted:Boolean,"onUpdate:expandedKeys":[Function,Array],onUpdateExpandedKeys:[Function,Array],onUpdateValue:[Function,Array],"onUpdate:value":[Function,Array],expandIcon:Function,renderIcon:Function,renderLabel:Function,renderExtra:Function,dropdownProps:Object,accordion:Boolean,nodeProps:Function,items:Array,onOpenNamesChange:[Function,Array],onSelect:[Function,Array],onExpandedNamesChange:[Function,Array],expandedNames:Array,defaultExpandedNames:Array,dropdownPlacement:{type:String,default:"bottom"}}),Ct=B({name:"Menu",props:xt,setup(e){const{mergedClsPrefixRef:o,inlineThemeDisabled:t}=ee(e),r=U("Menu","-menu",bt,Jo,e,o),n=V(qe,null),l=g(()=>{var S;const{collapsed:I}=e;if(I!==void 0)return I;if(n){const{collapseModeRef:i,collapsedRef:w}=n;if(i.value==="width")return(S=w.value)!==null&&S!==void 0?S:!1}return!1}),u=g(()=>{const{keyField:S,childrenField:I,disabledField:i}=e;return No(e.items||e.options,{getIgnored(w){return Ze(w)},getChildren(w){return w[I]},getDisabled(w){return w[i]},getKey(w){var O;return(O=w[S])!==null&&O!==void 0?O:w.name}})}),d=g(()=>new Set(u.value.treeNodes.map(S=>S.key))),{watchProps:a}=e,f=E(null);a!=null&&a.includes("defaultValue")?Re(()=>{f.value=e.defaultValue}):f.value=e.defaultValue;const P=X(e,"value"),H=me(P,f),v=E([]),C=()=>{v.value=e.defaultExpandAll?u.value.getNonLeafKeys():e.defaultExpandedNames||e.defaultExpandedKeys||u.value.getPath(H.value,{includeSelf:!1}).keyPath};a!=null&&a.includes("defaultExpandedKeys")?Re(C):C();const s=_o(e,["expandedNames","expandedKeys"]),m=me(s,v),y=g(()=>u.value.treeNodes),x=g(()=>u.value.getPath(H.value).keyPath);G(oe,{props:e,mergedCollapsedRef:l,mergedThemeRef:r,mergedValueRef:H,mergedExpandedKeysRef:m,activePathRef:x,mergedClsPrefixRef:o,isHorizontalRef:g(()=>e.mode==="horizontal"),invertedRef:X(e,"inverted"),doSelect:A,toggleExpand:k});function A(S,I){const{"onUpdate:value":i,onUpdateValue:w,onSelect:O}=e;w&&F(w,S,I),i&&F(i,S,I),O&&F(O,S,I),f.value=S}function j(S){const{"onUpdate:expandedKeys":I,onUpdateExpandedKeys:i,onExpandedNamesChange:w,onOpenNamesChange:O}=e;I&&F(I,S),i&&F(i,S),w&&F(w,S),O&&F(O,S),v.value=S}function k(S){const I=Array.from(m.value),i=I.findIndex(w=>w===S);if(~i)I.splice(i,1);else{if(e.accordion&&d.value.has(S)){const w=I.findIndex(O=>d.value.has(O));w>-1&&I.splice(w,1)}I.push(S)}j(I)}const R=S=>{const I=u.value.getPath(S??H.value,{includeSelf:!1}).keyPath;if(!I.length)return;const i=Array.from(m.value),w=new Set([...i,...I]);e.accordion&&d.value.forEach(O=>{w.has(O)&&!I.includes(O)&&w.delete(O)}),j(Array.from(w))},z=g(()=>{const{inverted:S}=e,{common:{cubicBezierEaseInOut:I},self:i}=r.value,{borderRadius:w,borderColorHorizontal:O,fontSize:eo,itemHeight:oo,dividerColor:to}=i,c={"--n-divider-color":to,"--n-bezier":I,"--n-font-size":eo,"--n-border-color-horizontal":O,"--n-border-radius":w,"--n-item-height":oo};return S?(c["--n-group-text-color"]=i.groupTextColorInverted,c["--n-color"]=i.colorInverted,c["--n-item-text-color"]=i.itemTextColorInverted,c["--n-item-text-color-hover"]=i.itemTextColorHoverInverted,c["--n-item-text-color-active"]=i.itemTextColorActiveInverted,c["--n-item-text-color-child-active"]=i.itemTextColorChildActiveInverted,c["--n-item-text-color-child-active-hover"]=i.itemTextColorChildActiveInverted,c["--n-item-text-color-active-hover"]=i.itemTextColorActiveHoverInverted,c["--n-item-icon-color"]=i.itemIconColorInverted,c["--n-item-icon-color-hover"]=i.itemIconColorHoverInverted,c["--n-item-icon-color-active"]=i.itemIconColorActiveInverted,c["--n-item-icon-color-active-hover"]=i.itemIconColorActiveHoverInverted,c["--n-item-icon-color-child-active"]=i.itemIconColorChildActiveInverted,c["--n-item-icon-color-child-active-hover"]=i.itemIconColorChildActiveHoverInverted,c["--n-item-icon-color-collapsed"]=i.itemIconColorCollapsedInverted,c["--n-item-text-color-horizontal"]=i.itemTextColorHorizontalInverted,c["--n-item-text-color-hover-horizontal"]=i.itemTextColorHoverHorizontalInverted,c["--n-item-text-color-active-horizontal"]=i.itemTextColorActiveHorizontalInverted,c["--n-item-text-color-child-active-horizontal"]=i.itemTextColorChildActiveHorizontalInverted,c["--n-item-text-color-child-active-hover-horizontal"]=i.itemTextColorChildActiveHoverHorizontalInverted,c["--n-item-text-color-active-hover-horizontal"]=i.itemTextColorActiveHoverHorizontalInverted,c["--n-item-icon-color-horizontal"]=i.itemIconColorHorizontalInverted,c["--n-item-icon-color-hover-horizontal"]=i.itemIconColorHoverHorizontalInverted,c["--n-item-icon-color-active-horizontal"]=i.itemIconColorActiveHorizontalInverted,c["--n-item-icon-color-active-hover-horizontal"]=i.itemIconColorActiveHoverHorizontalInverted,c["--n-item-icon-color-child-active-horizontal"]=i.itemIconColorChildActiveHorizontalInverted,c["--n-item-icon-color-child-active-hover-horizontal"]=i.itemIconColorChildActiveHoverHorizontalInverted,c["--n-arrow-color"]=i.arrowColorInverted,c["--n-arrow-color-hover"]=i.arrowColorHoverInverted,c["--n-arrow-color-active"]=i.arrowColorActiveInverted,c["--n-arrow-color-active-hover"]=i.arrowColorActiveHoverInverted,c["--n-arrow-color-child-active"]=i.arrowColorChildActiveInverted,c["--n-arrow-color-child-active-hover"]=i.arrowColorChildActiveHoverInverted,c["--n-item-color-hover"]=i.itemColorHoverInverted,c["--n-item-color-active"]=i.itemColorActiveInverted,c["--n-item-color-active-hover"]=i.itemColorActiveHoverInverted,c["--n-item-color-active-collapsed"]=i.itemColorActiveCollapsedInverted):(c["--n-group-text-color"]=i.groupTextColor,c["--n-color"]=i.color,c["--n-item-text-color"]=i.itemTextColor,c["--n-item-text-color-hover"]=i.itemTextColorHover,c["--n-item-text-color-active"]=i.itemTextColorActive,c["--n-item-text-color-child-active"]=i.itemTextColorChildActive,c["--n-item-text-color-child-active-hover"]=i.itemTextColorChildActiveHover,c["--n-item-text-color-active-hover"]=i.itemTextColorActiveHover,c["--n-item-icon-color"]=i.itemIconColor,c["--n-item-icon-color-hover"]=i.itemIconColorHover,c["--n-item-icon-color-active"]=i.itemIconColorActive,c["--n-item-icon-color-active-hover"]=i.itemIconColorActiveHover,c["--n-item-icon-color-child-active"]=i.itemIconColorChildActive,c["--n-item-icon-color-child-active-hover"]=i.itemIconColorChildActiveHover,c["--n-item-icon-color-collapsed"]=i.itemIconColorCollapsed,c["--n-item-text-color-horizontal"]=i.itemTextColorHorizontal,c["--n-item-text-color-hover-horizontal"]=i.itemTextColorHoverHorizontal,c["--n-item-text-color-active-horizontal"]=i.itemTextColorActiveHorizontal,c["--n-item-text-color-child-active-horizontal"]=i.itemTextColorChildActiveHorizontal,c["--n-item-text-color-child-active-hover-horizontal"]=i.itemTextColorChildActiveHoverHorizontal,c["--n-item-text-color-active-hover-horizontal"]=i.itemTextColorActiveHoverHorizontal,c["--n-item-icon-color-horizontal"]=i.itemIconColorHorizontal,c["--n-item-icon-color-hover-horizontal"]=i.itemIconColorHoverHorizontal,c["--n-item-icon-color-active-horizontal"]=i.itemIconColorActiveHorizontal,c["--n-item-icon-color-active-hover-horizontal"]=i.itemIconColorActiveHoverHorizontal,c["--n-item-icon-color-child-active-horizontal"]=i.itemIconColorChildActiveHorizontal,c["--n-item-icon-color-child-active-hover-horizontal"]=i.itemIconColorChildActiveHoverHorizontal,c["--n-arrow-color"]=i.arrowColor,c["--n-arrow-color-hover"]=i.arrowColorHover,c["--n-arrow-color-active"]=i.arrowColorActive,c["--n-arrow-color-active-hover"]=i.arrowColorActiveHover,c["--n-arrow-color-child-active"]=i.arrowColorChildActive,c["--n-arrow-color-child-active-hover"]=i.arrowColorChildActiveHover,c["--n-item-color-hover"]=i.itemColorHover,c["--n-item-color-active"]=i.itemColorActive,c["--n-item-color-active-hover"]=i.itemColorActiveHover,c["--n-item-color-active-collapsed"]=i.itemColorActiveCollapsed),c}),_=t?ie("menu",g(()=>e.inverted?"a":"b"),z,e):void 0;return{mergedClsPrefix:o,controlledExpandedKeys:s,uncontrolledExpanededKeys:v,mergedExpandedKeys:m,uncontrolledValue:f,mergedValue:H,activePath:x,tmNodes:y,mergedTheme:r,mergedCollapsed:l,cssVars:t?void 0:z,themeClass:_==null?void 0:_.themeClass,onRender:_==null?void 0:_.onRender,showOption:R}},render(){const{mergedClsPrefix:e,mode:o,themeClass:t,onRender:r}=this;return r==null||r(),h("div",{role:o==="horizontal"?"menubar":"menu",class:[`${e}-menu`,t,`${e}-menu--${o}`,this.mergedCollapsed&&`${e}-menu--collapsed`],style:this.cssVars},this.tmNodes.map(n=>Ie(n,this.$props)))}}),yt={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},It=je("path",{d:"M352 48H160a48 48 0 0 0-48 48v368l144-128l144 128V96a48 48 0 0 0-48-48z",fill:"none",stroke:"currentColor","stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"32"},null,-1),wt=[It],St=B({name:"BookmarkOutline",render:function(o,t){return he(),Ee("svg",yt,wt)}}),zt={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},Rt=je("path",{d:"M98 190.06l139.78 163.12a24 24 0 0 0 36.44 0L414 190.06c13.34-15.57 2.28-39.62-18.22-39.62h-279.6c-20.5 0-31.56 24.05-18.18 39.62z",fill:"currentColor"},null,-1),$t=[Rt],At=B({name:"CaretDownOutline",render:function(o,t){return he(),Ee("svg",zt,$t)}});const Ht={__name:"index",setup(e){let o=so(),t=uo(),r=E(!1),n=E([]);const l=E([]);let u=v=>{o.push({name:v})},d=()=>{localStorage.removeItem("jwt"),localStorage.removeItem("author"),t.state.username="",window.location.href="/"};const a={common:{primaryColor:"#3a94f1"}};let f=v=>"href"in v?h("a",{href:v.href,target:"_blank"},v.label):v.label,P=v=>v.key==="sheep-man"?!0:v.key==="food"?null:h(_e,null,{default:()=>h(St)}),H=()=>h(_e,null,{default:()=>h(At)});return Be(()=>{let v=o.getRoutes().filter(C=>{if(C.name=="admin")return C});n.value=v[0].children;for(let C of n.value)C.mate.isM&&l.value.push({label:C.mate.name,key:C.mate.key,name:C.name})}),(v,C)=>{const s=vo("router-view");return he(),ao(T(Do),{"theme-overrides":a,style:{height:"100%",position:"relative"}},{default:M(()=>[L(T(ve),{position:"absolute"},{default:M(()=>[L(T(nt),{class:"admin-nav",style:{height:"50px",padding:"15px"},bordered:""},{default:M(()=>[L(T(Uo),{"x-gap":"12",cols:3},{default:M(()=>[L(T(Te),{span:2},{default:M(()=>[L(T(ce),{text:"",onClick:C[0]||(C[0]=m=>te(r)?r.value=!T(r):r=!T(r)),color:"#ffffff"},{default:M(()=>[le(" 内容管理系统 ")]),_:1}),L(T(ce),{text:"",onClick:C[1]||(C[1]=m=>te(r)?r.value=!T(r):r=!T(r)),color:"#ffffff",style:{"margin-left":"15px"}},{default:M(()=>[le(co(T(r)?"展开":"关闭"),1)]),_:1})]),_:1}),L(T(Te),{style:{"text-align":"right"}},{default:M(()=>[L(T(ce),{text:"",onClick:T(d),color:"#ffffff"},{default:M(()=>[le("退出")]),_:1},8,["onClick"])]),_:1})]),_:1})]),_:1}),L(T(ve),{"has-sider":"",position:"absolute",style:{top:"50px"}},{default:M(()=>[L(T(dt),{bordered:"","collapse-mode":"width","collapsed-width":54,width:180,collapsed:T(r),"show-trigger":"",onCollapse:C[2]||(C[2]=m=>te(r)?r.value=!0:r=!0),onExpand:C[3]||(C[3]=m=>te(r)?r.value=!1:r=!1)},{default:M(()=>[L(T(Ct),{"onUpdate:value":T(u),collapsed:T(r),"collapsed-width":50,"collapsed-icon-size":22,options:l.value,"render-label":T(f),"render-icon":T(P),"expand-icon":T(H)},null,8,["onUpdate:value","collapsed","options","render-label","render-icon","expand-icon"])]),_:1},8,["collapsed"]),L(T(ve),{"content-style":"padding: 10px;"},{default:M(()=>[L(s)]),_:1})]),_:1})]),_:1})]),_:1})}}},Ot=lo(Ht,[["__scopeId","data-v-455f1b05"]]);export{Ot as default};
