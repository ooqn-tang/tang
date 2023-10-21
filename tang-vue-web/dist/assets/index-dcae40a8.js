import{k as _,l as s,j as E,t as V,h as I,V as Z,i as F,G as we,w as ge,o as le,B as ae,C as Q,b as Ke,J as Ve,p as De,v as j,D as G,A as ee,E as k,S as Ue,H as pe,N as qe,I as Ge,r as Ye}from"./github-2cfdd9fa.js";import{s as We,t as Xe,d as Je,u as Se,N as He,a as Ae,C as Ze,b as ne,c as O,r as D,e as ie,f as Qe,g as eo,h as oo,k as oe,i as ce,j as to,l as ro,m as be}from"./Dropdown-1287d635.js";import{c as p,a as no,b as Re,d as $e,e as xe,f as te,g as Y,h as v,i as S,u as U,j as de,k as se,l as d,m as re,n as X,N as Ce}from"./admin-ba9dc0e6.js";import"./notice-8b177a27.js";import"./request-55ac77c7.js";const io=_({name:"ChevronDownFilled",render(){return s("svg",{viewBox:"0 0 16 16",fill:"none",xmlns:"http://www.w3.org/2000/svg"},s("path",{d:"M3.20041 5.73966C3.48226 5.43613 3.95681 5.41856 4.26034 5.70041L8 9.22652L11.7397 5.70041C12.0432 5.41856 12.5177 5.43613 12.7996 5.73966C13.0815 6.0432 13.0639 6.51775 12.7603 6.7996L8.51034 10.7996C8.22258 11.0668 7.77743 11.0668 7.48967 10.7996L3.23966 6.7996C2.93613 6.51775 2.91856 6.0432 3.20041 5.73966Z",fill:"currentColor"}))}}),{cubicBezierEaseInOut:L,cubicBezierEaseOut:lo,cubicBezierEaseIn:ao}=no;function co({overflow:e="hidden",duration:t=".3s",originalTransition:o="",leavingDelay:n="0s",foldPadding:l=!1,enterToProps:a=void 0,leaveToProps:m=void 0,reverse:h=!1}={}){const c=h?"leave":"enter",g=h?"enter":"leave";return[p(`&.fade-in-height-expand-transition-${g}-from,
 &.fade-in-height-expand-transition-${c}-to`,Object.assign(Object.assign({},a),{opacity:1})),p(`&.fade-in-height-expand-transition-${g}-to,
 &.fade-in-height-expand-transition-${c}-from`,Object.assign(Object.assign({},m),{opacity:0,marginTop:"0 !important",marginBottom:"0 !important",paddingTop:l?"0 !important":void 0,paddingBottom:l?"0 !important":void 0})),p(`&.fade-in-height-expand-transition-${g}-active`,`
 overflow: ${e};
 transition:
 max-height ${t} ${L} ${n},
 opacity ${t} ${lo} ${n},
 margin-top ${t} ${L} ${n},
 margin-bottom ${t} ${L} ${n},
 padding-top ${t} ${L} ${n},
 padding-bottom ${t} ${L} ${n}
 ${o?","+o:""}
 `),p(`&.fade-in-height-expand-transition-${c}-active`,`
 overflow: ${e};
 transition:
 max-height ${t} ${L},
 opacity ${t} ${ao},
 margin-top ${t} ${L},
 margin-bottom ${t} ${L},
 padding-top ${t} ${L},
 padding-bottom ${t} ${L}
 ${o?","+o:""}
 `)]}const so=e=>{const{baseColor:t,textColor2:o,bodyColor:n,cardColor:l,dividerColor:a,actionColor:m,scrollbarColor:h,scrollbarColorHover:c,invertedColor:g}=e;return{textColor:o,textColorInverted:"#FFF",color:n,colorEmbedded:m,headerColor:l,headerColorInverted:g,footerColor:m,footerColorInverted:g,headerBorderColor:a,headerBorderColorInverted:g,footerBorderColor:a,footerBorderColorInverted:g,siderBorderColor:a,siderBorderColorInverted:g,siderColor:l,siderColorInverted:g,siderToggleButtonBorder:`1px solid ${a}`,siderToggleButtonColor:t,siderToggleButtonIconColor:o,siderToggleButtonIconColorInverted:o,siderToggleBarColor:xe(n,h),siderToggleBarColorHover:xe(n,c),__invertScrollbar:"true"}},uo=Re({name:"Layout",common:$e,peers:{Scrollbar:We},self:so}),Te=uo;function vo(e,t,o,n){return{itemColorHoverInverted:"#0000",itemColorActiveInverted:t,itemColorActiveHoverInverted:t,itemColorActiveCollapsedInverted:t,itemTextColorInverted:e,itemTextColorHoverInverted:o,itemTextColorChildActiveInverted:o,itemTextColorChildActiveHoverInverted:o,itemTextColorActiveInverted:o,itemTextColorActiveHoverInverted:o,itemTextColorHorizontalInverted:e,itemTextColorHoverHorizontalInverted:o,itemTextColorChildActiveHorizontalInverted:o,itemTextColorChildActiveHoverHorizontalInverted:o,itemTextColorActiveHorizontalInverted:o,itemTextColorActiveHoverHorizontalInverted:o,itemIconColorInverted:e,itemIconColorHoverInverted:o,itemIconColorActiveInverted:o,itemIconColorActiveHoverInverted:o,itemIconColorChildActiveInverted:o,itemIconColorChildActiveHoverInverted:o,itemIconColorCollapsedInverted:e,itemIconColorHorizontalInverted:e,itemIconColorHoverHorizontalInverted:o,itemIconColorActiveHorizontalInverted:o,itemIconColorActiveHoverHorizontalInverted:o,itemIconColorChildActiveHorizontalInverted:o,itemIconColorChildActiveHoverHorizontalInverted:o,arrowColorInverted:e,arrowColorHoverInverted:o,arrowColorActiveInverted:o,arrowColorActiveHoverInverted:o,arrowColorChildActiveInverted:o,arrowColorChildActiveHoverInverted:o,groupTextColorInverted:n}}const mo=e=>{const{borderRadius:t,textColor3:o,primaryColor:n,textColor2:l,textColor1:a,fontSize:m,dividerColor:h,hoverColor:c,primaryColorHover:g}=e;return Object.assign({borderRadius:t,color:"#0000",groupTextColor:o,itemColorHover:c,itemColorActive:te(n,{alpha:.1}),itemColorActiveHover:te(n,{alpha:.1}),itemColorActiveCollapsed:te(n,{alpha:.1}),itemTextColor:l,itemTextColorHover:l,itemTextColorActive:n,itemTextColorActiveHover:n,itemTextColorChildActive:n,itemTextColorChildActiveHover:n,itemTextColorHorizontal:l,itemTextColorHoverHorizontal:g,itemTextColorActiveHorizontal:n,itemTextColorActiveHoverHorizontal:n,itemTextColorChildActiveHorizontal:n,itemTextColorChildActiveHoverHorizontal:n,itemIconColor:a,itemIconColorHover:a,itemIconColorActive:n,itemIconColorActiveHover:n,itemIconColorChildActive:n,itemIconColorChildActiveHover:n,itemIconColorCollapsed:a,itemIconColorHorizontal:a,itemIconColorHoverHorizontal:g,itemIconColorActiveHorizontal:n,itemIconColorActiveHoverHorizontal:n,itemIconColorChildActiveHorizontal:n,itemIconColorChildActiveHoverHorizontal:n,itemHeight:"42px",arrowColor:l,arrowColorHover:l,arrowColorActive:n,arrowColorActiveHover:n,arrowColorChildActive:n,arrowColorChildActiveHover:n,colorInverted:"#0000",borderColorHorizontal:"#0000",fontSize:m,dividerColor:h},vo("#BBB",n,"#FFF","#AAA"))},ho=Re({name:"Menu",common:$e,peers:{Tooltip:Xe,Dropdown:Je},self:mo}),fo=ho,Pe=Y("n-layout-sider"),Ne={type:String,default:"static"},go=v("layout",`
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
`,[v("layout-scroll-container",`
 overflow-x: hidden;
 box-sizing: border-box;
 height: 100%;
 `),S("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),po={embedded:Boolean,position:Ne,nativeScrollbar:{type:Boolean,default:!0},scrollbarProps:Object,onScroll:Function,contentStyle:{type:[String,Object],default:""},hasSider:Boolean,siderPlacement:{type:String,default:"left"}},ke=Y("n-layout");function bo(e){return _({name:e?"LayoutContent":"Layout",props:Object.assign(Object.assign({},U.props),po),setup(t){const o=E(null),n=E(null),{mergedClsPrefixRef:l,inlineThemeDisabled:a}=de(t),m=U("Layout","-layout",go,Te,t,l);function h(y,H){if(t.nativeScrollbar){const{value:T}=o;T&&(H===void 0?T.scrollTo(y):T.scrollTo(y,H))}else{const{value:T}=n;T&&T.scrollTo(y,H)}}V(ke,t);let c=0,g=0;const N=y=>{var H;const T=y.target;c=T.scrollLeft,g=T.scrollTop,(H=t.onScroll)===null||H===void 0||H.call(t,y)};Se(()=>{if(t.nativeScrollbar){const y=o.value;y&&(y.scrollTop=g,y.scrollLeft=c)}});const R={display:"flex",flexWrap:"nowrap",width:"100%",flexDirection:"row"},u={scrollTo:h},x=I(()=>{const{common:{cubicBezierEaseInOut:y},self:H}=m.value;return{"--n-bezier":y,"--n-color":t.embedded?H.colorEmbedded:H.color,"--n-text-color":H.textColor}}),$=a?se("layout",I(()=>t.embedded?"e":""),x,t):void 0;return Object.assign({mergedClsPrefix:l,scrollableElRef:o,scrollbarInstRef:n,hasSiderStyle:R,mergedTheme:m,handleNativeElScroll:N,cssVars:a?void 0:x,themeClass:$==null?void 0:$.themeClass,onRender:$==null?void 0:$.onRender},u)},render(){var t;const{mergedClsPrefix:o,hasSider:n}=this;(t=this.onRender)===null||t===void 0||t.call(this);const l=n?this.hasSiderStyle:void 0,a=[this.themeClass,e&&`${o}-layout-content`,`${o}-layout`,`${o}-layout--${this.position}-positioned`];return s("div",{class:a,style:this.cssVars},this.nativeScrollbar?s("div",{ref:"scrollableElRef",class:`${o}-layout-scroll-container`,style:[this.contentStyle,l],onScroll:this.handleNativeElScroll},this.$slots):s(He,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,contentStyle:[this.contentStyle,l]}),this.$slots))}})}const ye=bo(!1),xo=v("layout-sider",`
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
`,[S("bordered",[d("border",`
 content: "";
 position: absolute;
 top: 0;
 bottom: 0;
 width: 1px;
 background-color: var(--n-border-color);
 transition: background-color .3s var(--n-bezier);
 `)]),d("left-placement",[S("bordered",[d("border",`
 right: 0;
 `)])]),S("right-placement",`
 justify-content: flex-start;
 `,[S("bordered",[d("border",`
 left: 0;
 `)]),S("collapsed",[v("layout-toggle-button",[v("base-icon",`
 transform: rotate(180deg);
 `)]),v("layout-toggle-bar",[p("&:hover",[d("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),d("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])])]),v("layout-toggle-button",`
 left: 0;
 transform: translateX(-50%) translateY(-50%);
 `,[v("base-icon",`
 transform: rotate(0);
 `)]),v("layout-toggle-bar",`
 left: -28px;
 transform: rotate(180deg);
 `,[p("&:hover",[d("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),d("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})])])]),S("collapsed",[v("layout-toggle-bar",[p("&:hover",[d("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),d("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])]),v("layout-toggle-button",[v("base-icon",`
 transform: rotate(0);
 `)])]),v("layout-toggle-button",`
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
 `,[v("base-icon",`
 transition: transform .3s var(--n-bezier);
 transform: rotate(180deg);
 `)]),v("layout-toggle-bar",`
 cursor: pointer;
 height: 72px;
 width: 32px;
 position: absolute;
 top: calc(50% - 36px);
 right: -28px;
 `,[d("top, bottom",`
 position: absolute;
 width: 4px;
 border-radius: 2px;
 height: 38px;
 left: 14px;
 transition: 
 background-color .3s var(--n-bezier),
 transform .3s var(--n-bezier);
 `),d("bottom",`
 position: absolute;
 top: 34px;
 `),p("&:hover",[d("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),d("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})]),d("top, bottom",{backgroundColor:"var(--n-toggle-bar-color)"}),p("&:hover",[d("top, bottom",{backgroundColor:"var(--n-toggle-bar-color-hover)"})])]),d("border",`
 position: absolute;
 top: 0;
 right: 0;
 bottom: 0;
 width: 1px;
 transition: background-color .3s var(--n-bezier);
 `),v("layout-sider-scroll-container",`
 flex-grow: 1;
 flex-shrink: 0;
 box-sizing: border-box;
 height: 100%;
 opacity: 0;
 transition: opacity .3s var(--n-bezier);
 max-width: 100%;
 `),S("show-content",[v("layout-sider-scroll-container",{opacity:1})]),S("absolute-positioned",`
 position: absolute;
 left: 0;
 top: 0;
 bottom: 0;
 `)]),Co=_({name:"LayoutToggleButton",props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return s("div",{class:`${e}-layout-toggle-button`,onClick:this.onClick},s(Ae,{clsPrefix:e},{default:()=>s(Ze,null)}))}}),yo=_({props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return s("div",{onClick:this.onClick,class:`${e}-layout-toggle-bar`},s("div",{class:`${e}-layout-toggle-bar__top`}),s("div",{class:`${e}-layout-toggle-bar__bottom`}))}}),zo={position:Ne,bordered:Boolean,collapsedWidth:{type:Number,default:48},width:{type:[Number,String],default:272},contentStyle:{type:[String,Object],default:""},collapseMode:{type:String,default:"transform"},collapsed:{type:Boolean,default:void 0},defaultCollapsed:Boolean,showCollapsedContent:{type:Boolean,default:!0},showTrigger:{type:[Boolean,String],default:!1},nativeScrollbar:{type:Boolean,default:!0},inverted:Boolean,scrollbarProps:Object,triggerStyle:[String,Object],collapsedTriggerStyle:[String,Object],"onUpdate:collapsed":[Function,Array],onUpdateCollapsed:[Function,Array],onAfterEnter:Function,onAfterLeave:Function,onExpand:[Function,Array],onCollapse:[Function,Array],onScroll:Function},Io=_({name:"LayoutSider",props:Object.assign(Object.assign({},U.props),zo),setup(e){const t=F(ke),o=E(null),n=E(null),l=I(()=>re(c.value?e.collapsedWidth:e.width)),a=I(()=>e.collapseMode!=="transform"?{}:{minWidth:re(e.width)}),m=I(()=>t?t.siderPlacement:"left"),h=E(e.defaultCollapsed),c=ne(Z(e,"collapsed"),h);function g(A,z){if(e.nativeScrollbar){const{value:w}=o;w&&(z===void 0?w.scrollTo(A):w.scrollTo(A,z))}else{const{value:w}=n;w&&w.scrollTo(A,z)}}function N(){const{"onUpdate:collapsed":A,onUpdateCollapsed:z,onExpand:w,onCollapse:b}=e,{value:C}=c;z&&O(z,!C),A&&O(A,!C),h.value=!C,C?w&&O(w):b&&O(b)}let R=0,u=0;const x=A=>{var z;const w=A.target;R=w.scrollLeft,u=w.scrollTop,(z=e.onScroll)===null||z===void 0||z.call(e,A)};Se(()=>{if(e.nativeScrollbar){const A=o.value;A&&(A.scrollTop=u,A.scrollLeft=R)}}),V(Pe,{collapsedRef:c,collapseModeRef:Z(e,"collapseMode")});const{mergedClsPrefixRef:$,inlineThemeDisabled:y}=de(e),H=U("Layout","-layout-sider",xo,Te,e,$);function T(A){var z,w;A.propertyName==="max-width"&&(c.value?(z=e.onAfterLeave)===null||z===void 0||z.call(e):(w=e.onAfterEnter)===null||w===void 0||w.call(e))}const q={scrollTo:g},M=I(()=>{const{common:{cubicBezierEaseInOut:A},self:z}=H.value,{siderToggleButtonColor:w,siderToggleButtonBorder:b,siderToggleBarColor:C,siderToggleBarColorHover:r}=z,f={"--n-bezier":A,"--n-toggle-button-color":w,"--n-toggle-button-border":b,"--n-toggle-bar-color":C,"--n-toggle-bar-color-hover":r};return e.inverted?(f["--n-color"]=z.siderColorInverted,f["--n-text-color"]=z.textColorInverted,f["--n-border-color"]=z.siderBorderColorInverted,f["--n-toggle-button-icon-color"]=z.siderToggleButtonIconColorInverted,f.__invertScrollbar=z.__invertScrollbar):(f["--n-color"]=z.siderColor,f["--n-text-color"]=z.textColor,f["--n-border-color"]=z.siderBorderColor,f["--n-toggle-button-icon-color"]=z.siderToggleButtonIconColor),f}),B=y?se("layout-sider",I(()=>e.inverted?"a":"b"),M,e):void 0;return Object.assign({scrollableElRef:o,scrollbarInstRef:n,mergedClsPrefix:$,mergedTheme:H,styleMaxWidth:l,mergedCollapsed:c,scrollContainerStyle:a,siderPlacement:m,handleNativeElScroll:x,handleTransitionend:T,handleTriggerClick:N,inlineThemeDisabled:y,cssVars:M,themeClass:B==null?void 0:B.themeClass,onRender:B==null?void 0:B.onRender},q)},render(){var e;const{mergedClsPrefix:t,mergedCollapsed:o,showTrigger:n}=this;return(e=this.onRender)===null||e===void 0||e.call(this),s("aside",{class:[`${t}-layout-sider`,this.themeClass,`${t}-layout-sider--${this.position}-positioned`,`${t}-layout-sider--${this.siderPlacement}-placement`,this.bordered&&`${t}-layout-sider--bordered`,o&&`${t}-layout-sider--collapsed`,(!o||this.showCollapsedContent)&&`${t}-layout-sider--show-content`],onTransitionend:this.handleTransitionend,style:[this.inlineThemeDisabled?void 0:this.cssVars,{maxWidth:this.styleMaxWidth,width:re(this.width)}]},this.nativeScrollbar?s("div",{class:`${t}-layout-sider-scroll-container`,onScroll:this.handleNativeElScroll,style:[this.scrollContainerStyle,{overflow:"auto"},this.contentStyle],ref:"scrollableElRef"},this.$slots):s(He,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",style:this.scrollContainerStyle,contentStyle:this.contentStyle,theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,builtinThemeOverrides:this.inverted&&this.cssVars.__invertScrollbar==="true"?{colorHover:"rgba(255, 255, 255, .4)",color:"rgba(255, 255, 255, .3)"}:void 0}),this.$slots),n?n==="bar"?s(yo,{clsPrefix:t,style:o?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):s(Co,{clsPrefix:t,style:o?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):null,this.bordered?s("div",{class:`${t}-layout-sider__border`}):null)}}),W=Y("n-menu"),ue=Y("n-submenu"),ve=Y("n-menu-item-group"),J=8;function me(e){const t=F(W),{props:o,mergedCollapsedRef:n}=t,l=F(ue,null),a=F(ve,null),m=I(()=>o.mode==="horizontal"),h=I(()=>m.value?o.dropdownPlacement:"tmNodes"in e?"right-start":"right"),c=I(()=>{var u;return Math.max((u=o.collapsedIconSize)!==null&&u!==void 0?u:o.iconSize,o.iconSize)}),g=I(()=>{var u;return!m.value&&e.root&&n.value&&(u=o.collapsedIconSize)!==null&&u!==void 0?u:o.iconSize}),N=I(()=>{if(m.value)return;const{collapsedWidth:u,indent:x,rootIndent:$}=o,{root:y,isGroup:H}=e,T=$===void 0?x:$;if(y)return n.value?u/2-c.value/2:T;if(a)return x/2+a.paddingLeftRef.value;if(l)return(H?x/2:x)+l.paddingLeftRef.value}),R=I(()=>{const{collapsedWidth:u,indent:x,rootIndent:$}=o,{value:y}=c,{root:H}=e;return m.value||!H||!n.value?J:($===void 0?x:$)+y+J-(u+y)/2});return{dropdownPlacement:h,activeIconSize:g,maxIconSize:c,paddingLeft:N,iconMarginRight:R,NMenu:t,NSubmenu:l}}const he={internalKey:{type:[String,Number],required:!0},root:Boolean,isGroup:Boolean,level:{type:Number,required:!0},title:[String,Function],extra:[String,Function]},_e=Object.assign(Object.assign({},he),{tmNode:{type:Object,required:!0},tmNodes:{type:Array,required:!0}}),wo=_({name:"MenuOptionGroup",props:_e,setup(e){V(ue,null);const t=me(e);V(ve,{paddingLeftRef:t.paddingLeft});const{mergedClsPrefixRef:o,props:n}=F(W);return function(){const{value:l}=o,a=t.paddingLeft.value,{nodeProps:m}=n,h=m==null?void 0:m(e.tmNode.rawNode);return s("div",{class:`${l}-menu-item-group`,role:"group"},s("div",Object.assign({},h,{class:[`${l}-menu-item-group-title`,h==null?void 0:h.class],style:[(h==null?void 0:h.style)||"",a!==void 0?`padding-left: ${a}px;`:""]}),D(e.title),e.extra?s(we,null," ",D(e.extra)):null),s("div",null,e.tmNodes.map(c=>fe(c,n))))}}}),Be=_({name:"MenuOptionContent",props:{collapsed:Boolean,disabled:Boolean,title:[String,Function],icon:Function,extra:[String,Function],showArrow:Boolean,childActive:Boolean,hover:Boolean,paddingLeft:Number,selected:Boolean,maxIconSize:{type:Number,required:!0},activeIconSize:{type:Number,required:!0},iconMarginRight:{type:Number,required:!0},clsPrefix:{type:String,required:!0},onClick:Function,tmNode:{type:Object,required:!0}},setup(e){const{props:t}=F(W);return{menuProps:t,style:I(()=>{const{paddingLeft:o}=e;return{paddingLeft:o&&`${o}px`}}),iconStyle:I(()=>{const{maxIconSize:o,activeIconSize:n,iconMarginRight:l}=e;return{width:`${o}px`,height:`${o}px`,fontSize:`${n}px`,marginRight:`${l}px`}})}},render(){const{clsPrefix:e,tmNode:t,menuProps:{renderIcon:o,renderLabel:n,renderExtra:l,expandIcon:a}}=this,m=o?o(t.rawNode):D(this.icon);return s("div",{onClick:h=>{var c;(c=this.onClick)===null||c===void 0||c.call(this,h)},role:"none",class:[`${e}-menu-item-content`,{[`${e}-menu-item-content--selected`]:this.selected,[`${e}-menu-item-content--collapsed`]:this.collapsed,[`${e}-menu-item-content--child-active`]:this.childActive,[`${e}-menu-item-content--disabled`]:this.disabled,[`${e}-menu-item-content--hover`]:this.hover}],style:this.style},m&&s("div",{class:`${e}-menu-item-content__icon`,style:this.iconStyle,role:"none"},[m]),s("div",{class:`${e}-menu-item-content-header`,role:"none"},n?n(t.rawNode):D(this.title),this.extra||l?s("span",{class:`${e}-menu-item-content-header__extra`}," ",l?l(t.rawNode):D(this.extra)):null),this.showArrow?s(Ae,{ariaHidden:!0,class:`${e}-menu-item-content__arrow`,clsPrefix:e},{default:()=>a?a(t.rawNode):s(io,null)}):null)}}),Oe=Object.assign(Object.assign({},he),{rawNodes:{type:Array,default:()=>[]},tmNodes:{type:Array,default:()=>[]},tmNode:{type:Object,required:!0},disabled:{type:Boolean,default:!1},icon:Function,onClick:Function}),So=_({name:"Submenu",props:Oe,setup(e){const t=me(e),{NMenu:o,NSubmenu:n}=t,{props:l,mergedCollapsedRef:a,mergedThemeRef:m}=o,h=I(()=>{const{disabled:u}=e;return n!=null&&n.mergedDisabledRef.value||l.disabled?!0:u}),c=E(!1);V(ue,{paddingLeftRef:t.paddingLeft,mergedDisabledRef:h}),V(ve,null);function g(){const{onClick:u}=e;u&&u()}function N(){h.value||(a.value||o.toggleExpand(e.internalKey),g())}function R(u){c.value=u}return{menuProps:l,mergedTheme:m,doSelect:o.doSelect,inverted:o.invertedRef,isHorizontal:o.isHorizontalRef,mergedClsPrefix:o.mergedClsPrefixRef,maxIconSize:t.maxIconSize,activeIconSize:t.activeIconSize,iconMarginRight:t.iconMarginRight,dropdownPlacement:t.dropdownPlacement,dropdownShow:c,paddingLeft:t.paddingLeft,mergedDisabled:h,mergedValue:o.mergedValueRef,childActive:ie(()=>o.activePathRef.value.includes(e.internalKey)),collapsed:I(()=>l.mode==="horizontal"?!1:a.value?!0:!o.mergedExpandedKeysRef.value.includes(e.internalKey)),dropdownEnabled:I(()=>!h.value&&(l.mode==="horizontal"||a.value)),handlePopoverShowChange:R,handleClick:N}},render(){var e;const{mergedClsPrefix:t,menuProps:{renderIcon:o,renderLabel:n}}=this,l=()=>{const{isHorizontal:m,paddingLeft:h,collapsed:c,mergedDisabled:g,maxIconSize:N,activeIconSize:R,title:u,childActive:x,icon:$,handleClick:y,menuProps:{nodeProps:H},dropdownShow:T,iconMarginRight:q,tmNode:M,mergedClsPrefix:B}=this,A=H==null?void 0:H(M.rawNode);return s("div",Object.assign({},A,{class:[`${B}-menu-item`,A==null?void 0:A.class],role:"menuitem"}),s(Be,{tmNode:M,paddingLeft:h,collapsed:c,disabled:g,iconMarginRight:q,maxIconSize:N,activeIconSize:R,title:u,extra:this.extra,showArrow:!m,childActive:x,clsPrefix:B,icon:$,hover:T,onClick:y}))},a=()=>s(eo,null,{default:()=>{const{tmNodes:m,collapsed:h}=this;return h?null:s("div",{class:`${t}-submenu-children`,role:"menu"},m.map(c=>fe(c,this.menuProps)))}});return this.root?s(Qe,Object.assign({size:"large",trigger:"hover"},(e=this.menuProps)===null||e===void 0?void 0:e.dropdownProps,{themeOverrides:this.mergedTheme.peerOverrides.Dropdown,theme:this.mergedTheme.peers.Dropdown,builtinThemeOverrides:{fontSizeLarge:"14px",optionIconSizeLarge:"18px"},value:this.mergedValue,disabled:!this.dropdownEnabled,placement:this.dropdownPlacement,keyField:this.menuProps.keyField,labelField:this.menuProps.labelField,childrenField:this.menuProps.childrenField,onUpdateShow:this.handlePopoverShowChange,options:this.rawNodes,onSelect:this.doSelect,inverted:this.inverted,renderIcon:o,renderLabel:n}),{default:()=>s("div",{class:`${t}-submenu`,role:"menuitem","aria-expanded":!this.collapsed},l(),this.isHorizontal?null:a())}):s("div",{class:`${t}-submenu`,role:"menuitem","aria-expanded":!this.collapsed},l(),a())}}),Ee=Object.assign(Object.assign({},he),{tmNode:{type:Object,required:!0},disabled:Boolean,icon:Function,onClick:Function}),Ho=_({name:"MenuOption",props:Ee,setup(e){const t=me(e),{NSubmenu:o,NMenu:n}=t,{props:l,mergedClsPrefixRef:a,mergedCollapsedRef:m}=n,h=o?o.mergedDisabledRef:{value:!1},c=I(()=>h.value||e.disabled);function g(R){const{onClick:u}=e;u&&u(R)}function N(R){c.value||(n.doSelect(e.internalKey,e.tmNode.rawNode),g(R))}return{mergedClsPrefix:a,dropdownPlacement:t.dropdownPlacement,paddingLeft:t.paddingLeft,iconMarginRight:t.iconMarginRight,maxIconSize:t.maxIconSize,activeIconSize:t.activeIconSize,mergedTheme:n.mergedThemeRef,menuProps:l,dropdownEnabled:ie(()=>e.root&&m.value&&l.mode!=="horizontal"&&!c.value),selected:ie(()=>n.mergedValueRef.value===e.internalKey),mergedDisabled:c,handleClick:N}},render(){const{mergedClsPrefix:e,mergedTheme:t,tmNode:o,menuProps:{renderLabel:n,nodeProps:l}}=this,a=l==null?void 0:l(o.rawNode);return s("div",Object.assign({},a,{role:"menuitem",class:[`${e}-menu-item`,a==null?void 0:a.class]}),s(oo,{theme:t.peers.Tooltip,themeOverrides:t.peerOverrides.Tooltip,trigger:"hover",placement:this.dropdownPlacement,disabled:!this.dropdownEnabled||this.title===void 0,internalExtraClass:["menu-tooltip"]},{default:()=>n?n(o.rawNode):D(this.title),trigger:()=>s(Be,{tmNode:o,clsPrefix:e,paddingLeft:this.paddingLeft,iconMarginRight:this.iconMarginRight,maxIconSize:this.maxIconSize,activeIconSize:this.activeIconSize,selected:this.selected,title:this.title,extra:this.extra,disabled:this.mergedDisabled,icon:this.icon,onClick:this.handleClick})}))}}),Ao=_({name:"MenuDivider",setup(){const e=F(W),{mergedClsPrefixRef:t,isHorizontalRef:o}=e;return()=>o.value?null:s("div",{class:`${t.value}-menu-divider`})}}),Ro=ce(_e),$o=ce(Ee),To=ce(Oe);function Le(e){return e.type==="divider"||e.type==="render"}function Po(e){return e.type==="divider"}function fe(e,t){const{rawNode:o}=e,{show:n}=o;if(n===!1)return null;if(Le(o))return Po(o)?s(Ao,Object.assign({key:e.key},o.props)):null;const{labelField:l}=t,{key:a,level:m,isGroup:h}=e,c=Object.assign(Object.assign({},o),{title:o.title||o[l],extra:o.titleExtra||o.extra,key:a,internalKey:a,level:m,root:m===0,isGroup:h});return e.children?e.isGroup?s(wo,oe(c,Ro,{tmNode:e,tmNodes:e.children,key:a})):s(So,oe(c,To,{key:a,rawNodes:o[t.childrenField],tmNodes:e.children,tmNode:e})):s(Ho,oe(c,$o,{key:a,tmNode:e}))}const ze=[p("&::before","background-color: var(--n-item-color-hover);"),d("arrow",`
 color: var(--n-arrow-color-hover);
 `),d("icon",`
 color: var(--n-item-icon-color-hover);
 `),v("menu-item-content-header",`
 color: var(--n-item-text-color-hover);
 `,[p("a",`
 color: var(--n-item-text-color-hover);
 `),d("extra",`
 color: var(--n-item-text-color-hover);
 `)])],Ie=[d("icon",`
 color: var(--n-item-icon-color-hover-horizontal);
 `),v("menu-item-content-header",`
 color: var(--n-item-text-color-hover-horizontal);
 `,[p("a",`
 color: var(--n-item-text-color-hover-horizontal);
 `),d("extra",`
 color: var(--n-item-text-color-hover-horizontal);
 `)])],No=p([v("menu",`
 background-color: var(--n-color);
 color: var(--n-item-text-color);
 overflow: hidden;
 transition: background-color .3s var(--n-bezier);
 box-sizing: border-box;
 font-size: var(--n-font-size);
 padding-bottom: 6px;
 `,[S("horizontal",`
 display: inline-flex;
 padding-bottom: 0;
 `,[v("submenu","margin: 0;"),v("menu-item","margin: 0;"),v("menu-item-content",`
 padding: 0 20px;
 border-bottom: 2px solid #0000;
 `,[p("&::before","display: none;"),S("selected","border-bottom: 2px solid var(--n-border-color-horizontal)")]),v("menu-item-content",[S("selected",[d("icon","color: var(--n-item-icon-color-active-horizontal);"),v("menu-item-content-header",`
 color: var(--n-item-text-color-active-horizontal);
 `,[p("a","color: var(--n-item-text-color-active-horizontal);"),d("extra","color: var(--n-item-text-color-active-horizontal);")])]),S("child-active",`
 border-bottom: 2px solid var(--n-border-color-horizontal);
 `,[v("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-horizontal);
 `,[p("a",`
 color: var(--n-item-text-color-child-active-horizontal);
 `),d("extra",`
 color: var(--n-item-text-color-child-active-horizontal);
 `)]),d("icon",`
 color: var(--n-item-icon-color-child-active-horizontal);
 `)]),X("disabled",[X("selected, child-active",[p("&:focus-within",Ie)]),S("selected",[K(null,[d("icon","color: var(--n-item-icon-color-active-hover-horizontal);"),v("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover-horizontal);
 `,[p("a","color: var(--n-item-text-color-active-hover-horizontal);"),d("extra","color: var(--n-item-text-color-active-hover-horizontal);")])])]),S("child-active",[K(null,[d("icon","color: var(--n-item-icon-color-child-active-hover-horizontal);"),v("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover-horizontal);
 `,[p("a","color: var(--n-item-text-color-child-active-hover-horizontal);"),d("extra","color: var(--n-item-text-color-child-active-hover-horizontal);")])])]),K("border-bottom: 2px solid var(--n-border-color-horizontal);",Ie)]),v("menu-item-content-header",[p("a","color: var(--n-item-text-color-horizontal);")])])]),S("collapsed",[v("menu-item-content",[S("selected",[p("&::before",`
 background-color: var(--n-item-color-active-collapsed) !important;
 `)]),v("menu-item-content-header","opacity: 0;"),d("arrow","opacity: 0;"),d("icon","color: var(--n-item-icon-color-collapsed);")])]),v("menu-item",`
 height: var(--n-item-height);
 margin-top: 6px;
 position: relative;
 `),v("menu-item-content",`
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
 `,[p("> *","z-index: 1;"),p("&::before",`
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
 `),S("disabled",`
 opacity: .45;
 cursor: not-allowed;
 `),S("collapsed",[d("arrow","transform: rotate(0);")]),S("selected",[p("&::before","background-color: var(--n-item-color-active);"),d("arrow","color: var(--n-arrow-color-active);"),d("icon","color: var(--n-item-icon-color-active);"),v("menu-item-content-header",`
 color: var(--n-item-text-color-active);
 `,[p("a","color: var(--n-item-text-color-active);"),d("extra","color: var(--n-item-text-color-active);")])]),S("child-active",[v("menu-item-content-header",`
 color: var(--n-item-text-color-child-active);
 `,[p("a",`
 color: var(--n-item-text-color-child-active);
 `),d("extra",`
 color: var(--n-item-text-color-child-active);
 `)]),d("arrow",`
 color: var(--n-arrow-color-child-active);
 `),d("icon",`
 color: var(--n-item-icon-color-child-active);
 `)]),X("disabled",[X("selected, child-active",[p("&:focus-within",ze)]),S("selected",[K(null,[d("arrow","color: var(--n-arrow-color-active-hover);"),d("icon","color: var(--n-item-icon-color-active-hover);"),v("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover);
 `,[p("a","color: var(--n-item-text-color-active-hover);"),d("extra","color: var(--n-item-text-color-active-hover);")])])]),S("child-active",[K(null,[d("arrow","color: var(--n-arrow-color-child-active-hover);"),d("icon","color: var(--n-item-icon-color-child-active-hover);"),v("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover);
 `,[p("a","color: var(--n-item-text-color-child-active-hover);"),d("extra","color: var(--n-item-text-color-child-active-hover);")])])]),S("selected",[K(null,[p("&::before","background-color: var(--n-item-color-active-hover);")])]),K(null,ze)]),d("icon",`
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
 `),d("arrow",`
 grid-area: arrow;
 font-size: 16px;
 color: var(--n-arrow-color);
 transform: rotate(180deg);
 opacity: 1;
 transition:
 color .3s var(--n-bezier),
 transform 0.2s var(--n-bezier),
 opacity 0.2s var(--n-bezier);
 `),v("menu-item-content-header",`
 grid-area: content;
 transition:
 color .3s var(--n-bezier),
 opacity .3s var(--n-bezier);
 opacity: 1;
 white-space: nowrap;
 overflow: hidden;
 text-overflow: ellipsis;
 color: var(--n-item-text-color);
 `,[p("a",`
 outline: none;
 text-decoration: none;
 transition: color .3s var(--n-bezier);
 color: var(--n-item-text-color);
 `,[p("&::before",`
 content: "";
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),d("extra",`
 font-size: .93em;
 color: var(--n-group-text-color);
 transition: color .3s var(--n-bezier);
 `)])]),v("submenu",`
 cursor: pointer;
 position: relative;
 margin-top: 6px;
 `,[v("menu-item-content",`
 height: var(--n-item-height);
 `),v("submenu-children",`
 overflow: hidden;
 padding: 0;
 `,[co({duration:".2s"})])]),v("menu-item-group",[v("menu-item-group-title",`
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
 `)])]),v("menu-tooltip",[p("a",`
 color: inherit;
 text-decoration: none;
 `)]),v("menu-divider",`
 transition: background-color .3s var(--n-bezier);
 background-color: var(--n-divider-color);
 height: 1px;
 margin: 6px 18px;
 `)]);function K(e,t){return[S("hover",e,t),p("&:hover",e,t)]}const ko=Object.assign(Object.assign({},U.props),{options:{type:Array,default:()=>[]},collapsed:{type:Boolean,default:void 0},collapsedWidth:{type:Number,default:48},iconSize:{type:Number,default:20},collapsedIconSize:{type:Number,default:24},rootIndent:Number,indent:{type:Number,default:32},labelField:{type:String,default:"label"},keyField:{type:String,default:"key"},childrenField:{type:String,default:"children"},disabledField:{type:String,default:"disabled"},defaultExpandAll:Boolean,defaultExpandedKeys:Array,expandedKeys:Array,value:[String,Number],defaultValue:{type:[String,Number],default:null},mode:{type:String,default:"vertical"},watchProps:{type:Array,default:void 0},disabled:Boolean,show:{type:Boolean,default:!0},inverted:Boolean,"onUpdate:expandedKeys":[Function,Array],onUpdateExpandedKeys:[Function,Array],onUpdateValue:[Function,Array],"onUpdate:value":[Function,Array],expandIcon:Function,renderIcon:Function,renderLabel:Function,renderExtra:Function,dropdownProps:Object,accordion:Boolean,nodeProps:Function,items:Array,onOpenNamesChange:[Function,Array],onSelect:[Function,Array],onExpandedNamesChange:[Function,Array],expandedNames:Array,defaultExpandedNames:Array,dropdownPlacement:{type:String,default:"bottom"}}),_o=_({name:"Menu",props:ko,setup(e){const{mergedClsPrefixRef:t,inlineThemeDisabled:o}=de(e),n=U("Menu","-menu",No,fo,e,t),l=F(Pe,null),a=I(()=>{var b;const{collapsed:C}=e;if(C!==void 0)return C;if(l){const{collapseModeRef:r,collapsedRef:f}=l;if(r.value==="width")return(b=f.value)!==null&&b!==void 0?b:!1}return!1}),m=I(()=>{const{keyField:b,childrenField:C,disabledField:r}=e;return ro(e.items||e.options,{getIgnored(f){return Le(f)},getChildren(f){return f[C]},getDisabled(f){return f[r]},getKey(f){var P;return(P=f[b])!==null&&P!==void 0?P:f.name}})}),h=I(()=>new Set(m.value.treeNodes.map(b=>b.key))),{watchProps:c}=e,g=E(null);c!=null&&c.includes("defaultValue")?ge(()=>{g.value=e.defaultValue}):g.value=e.defaultValue;const N=Z(e,"value"),R=ne(N,g),u=E([]),x=()=>{u.value=e.defaultExpandAll?m.value.getNonLeafKeys():e.defaultExpandedNames||e.defaultExpandedKeys||m.value.getPath(R.value,{includeSelf:!1}).keyPath};c!=null&&c.includes("defaultExpandedKeys")?ge(x):x();const $=to(e,["expandedNames","expandedKeys"]),y=ne($,u),H=I(()=>m.value.treeNodes),T=I(()=>m.value.getPath(R.value).keyPath);V(W,{props:e,mergedCollapsedRef:a,mergedThemeRef:n,mergedValueRef:R,mergedExpandedKeysRef:y,activePathRef:T,mergedClsPrefixRef:t,isHorizontalRef:I(()=>e.mode==="horizontal"),invertedRef:Z(e,"inverted"),doSelect:q,toggleExpand:B});function q(b,C){const{"onUpdate:value":r,onUpdateValue:f,onSelect:P}=e;f&&O(f,b,C),r&&O(r,b,C),P&&O(P,b,C),g.value=b}function M(b){const{"onUpdate:expandedKeys":C,onUpdateExpandedKeys:r,onExpandedNamesChange:f,onOpenNamesChange:P}=e;C&&O(C,b),r&&O(r,b),f&&O(f,b),P&&O(P,b),u.value=b}function B(b){const C=Array.from(y.value),r=C.findIndex(f=>f===b);if(~r)C.splice(r,1);else{if(e.accordion&&h.value.has(b)){const f=C.findIndex(P=>h.value.has(P));f>-1&&C.splice(f,1)}C.push(b)}M(C)}const A=b=>{const C=m.value.getPath(b??R.value,{includeSelf:!1}).keyPath;if(!C.length)return;const r=Array.from(y.value),f=new Set([...r,...C]);e.accordion&&h.value.forEach(P=>{f.has(P)&&!C.includes(P)&&f.delete(P)}),M(Array.from(f))},z=I(()=>{const{inverted:b}=e,{common:{cubicBezierEaseInOut:C},self:r}=n.value,{borderRadius:f,borderColorHorizontal:P,fontSize:Me,itemHeight:Fe,dividerColor:je}=r,i={"--n-divider-color":je,"--n-bezier":C,"--n-font-size":Me,"--n-border-color-horizontal":P,"--n-border-radius":f,"--n-item-height":Fe};return b?(i["--n-group-text-color"]=r.groupTextColorInverted,i["--n-color"]=r.colorInverted,i["--n-item-text-color"]=r.itemTextColorInverted,i["--n-item-text-color-hover"]=r.itemTextColorHoverInverted,i["--n-item-text-color-active"]=r.itemTextColorActiveInverted,i["--n-item-text-color-child-active"]=r.itemTextColorChildActiveInverted,i["--n-item-text-color-child-active-hover"]=r.itemTextColorChildActiveInverted,i["--n-item-text-color-active-hover"]=r.itemTextColorActiveHoverInverted,i["--n-item-icon-color"]=r.itemIconColorInverted,i["--n-item-icon-color-hover"]=r.itemIconColorHoverInverted,i["--n-item-icon-color-active"]=r.itemIconColorActiveInverted,i["--n-item-icon-color-active-hover"]=r.itemIconColorActiveHoverInverted,i["--n-item-icon-color-child-active"]=r.itemIconColorChildActiveInverted,i["--n-item-icon-color-child-active-hover"]=r.itemIconColorChildActiveHoverInverted,i["--n-item-icon-color-collapsed"]=r.itemIconColorCollapsedInverted,i["--n-item-text-color-horizontal"]=r.itemTextColorHorizontalInverted,i["--n-item-text-color-hover-horizontal"]=r.itemTextColorHoverHorizontalInverted,i["--n-item-text-color-active-horizontal"]=r.itemTextColorActiveHorizontalInverted,i["--n-item-text-color-child-active-horizontal"]=r.itemTextColorChildActiveHorizontalInverted,i["--n-item-text-color-child-active-hover-horizontal"]=r.itemTextColorChildActiveHoverHorizontalInverted,i["--n-item-text-color-active-hover-horizontal"]=r.itemTextColorActiveHoverHorizontalInverted,i["--n-item-icon-color-horizontal"]=r.itemIconColorHorizontalInverted,i["--n-item-icon-color-hover-horizontal"]=r.itemIconColorHoverHorizontalInverted,i["--n-item-icon-color-active-horizontal"]=r.itemIconColorActiveHorizontalInverted,i["--n-item-icon-color-active-hover-horizontal"]=r.itemIconColorActiveHoverHorizontalInverted,i["--n-item-icon-color-child-active-horizontal"]=r.itemIconColorChildActiveHorizontalInverted,i["--n-item-icon-color-child-active-hover-horizontal"]=r.itemIconColorChildActiveHoverHorizontalInverted,i["--n-arrow-color"]=r.arrowColorInverted,i["--n-arrow-color-hover"]=r.arrowColorHoverInverted,i["--n-arrow-color-active"]=r.arrowColorActiveInverted,i["--n-arrow-color-active-hover"]=r.arrowColorActiveHoverInverted,i["--n-arrow-color-child-active"]=r.arrowColorChildActiveInverted,i["--n-arrow-color-child-active-hover"]=r.arrowColorChildActiveHoverInverted,i["--n-item-color-hover"]=r.itemColorHoverInverted,i["--n-item-color-active"]=r.itemColorActiveInverted,i["--n-item-color-active-hover"]=r.itemColorActiveHoverInverted,i["--n-item-color-active-collapsed"]=r.itemColorActiveCollapsedInverted):(i["--n-group-text-color"]=r.groupTextColor,i["--n-color"]=r.color,i["--n-item-text-color"]=r.itemTextColor,i["--n-item-text-color-hover"]=r.itemTextColorHover,i["--n-item-text-color-active"]=r.itemTextColorActive,i["--n-item-text-color-child-active"]=r.itemTextColorChildActive,i["--n-item-text-color-child-active-hover"]=r.itemTextColorChildActiveHover,i["--n-item-text-color-active-hover"]=r.itemTextColorActiveHover,i["--n-item-icon-color"]=r.itemIconColor,i["--n-item-icon-color-hover"]=r.itemIconColorHover,i["--n-item-icon-color-active"]=r.itemIconColorActive,i["--n-item-icon-color-active-hover"]=r.itemIconColorActiveHover,i["--n-item-icon-color-child-active"]=r.itemIconColorChildActive,i["--n-item-icon-color-child-active-hover"]=r.itemIconColorChildActiveHover,i["--n-item-icon-color-collapsed"]=r.itemIconColorCollapsed,i["--n-item-text-color-horizontal"]=r.itemTextColorHorizontal,i["--n-item-text-color-hover-horizontal"]=r.itemTextColorHoverHorizontal,i["--n-item-text-color-active-horizontal"]=r.itemTextColorActiveHorizontal,i["--n-item-text-color-child-active-horizontal"]=r.itemTextColorChildActiveHorizontal,i["--n-item-text-color-child-active-hover-horizontal"]=r.itemTextColorChildActiveHoverHorizontal,i["--n-item-text-color-active-hover-horizontal"]=r.itemTextColorActiveHoverHorizontal,i["--n-item-icon-color-horizontal"]=r.itemIconColorHorizontal,i["--n-item-icon-color-hover-horizontal"]=r.itemIconColorHoverHorizontal,i["--n-item-icon-color-active-horizontal"]=r.itemIconColorActiveHorizontal,i["--n-item-icon-color-active-hover-horizontal"]=r.itemIconColorActiveHoverHorizontal,i["--n-item-icon-color-child-active-horizontal"]=r.itemIconColorChildActiveHorizontal,i["--n-item-icon-color-child-active-hover-horizontal"]=r.itemIconColorChildActiveHoverHorizontal,i["--n-arrow-color"]=r.arrowColor,i["--n-arrow-color-hover"]=r.arrowColorHover,i["--n-arrow-color-active"]=r.arrowColorActive,i["--n-arrow-color-active-hover"]=r.arrowColorActiveHover,i["--n-arrow-color-child-active"]=r.arrowColorChildActive,i["--n-arrow-color-child-active-hover"]=r.arrowColorChildActiveHover,i["--n-item-color-hover"]=r.itemColorHover,i["--n-item-color-active"]=r.itemColorActive,i["--n-item-color-active-hover"]=r.itemColorActiveHover,i["--n-item-color-active-collapsed"]=r.itemColorActiveCollapsed),i}),w=o?se("menu",I(()=>e.inverted?"a":"b"),z,e):void 0;return{mergedClsPrefix:t,controlledExpandedKeys:$,uncontrolledExpanededKeys:u,mergedExpandedKeys:y,uncontrolledValue:g,mergedValue:R,activePath:T,tmNodes:H,mergedTheme:n,mergedCollapsed:a,cssVars:o?void 0:z,themeClass:w==null?void 0:w.themeClass,onRender:w==null?void 0:w.onRender,showOption:A}},render(){const{mergedClsPrefix:e,mode:t,themeClass:o,onRender:n}=this;return n==null||n(),s("div",{role:t==="horizontal"?"menubar":"menu",class:[`${e}-menu`,o,`${e}-menu--${t}`,this.mergedCollapsed&&`${e}-menu--collapsed`],style:this.cssVars},this.tmNodes.map(l=>fe(l,this.$props)))}}),Bo={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},Oo=Q("path",{d:"M352 48H160a48 48 0 0 0-48 48v368l144-128l144 128V96a48 48 0 0 0-48-48z",fill:"none",stroke:"currentColor","stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"32"},null,-1),Eo=[Oo],Lo=_({name:"BookmarkOutline",render:function(t,o){return le(),ae("svg",Bo,Eo)}}),Mo={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},Fo=Q("path",{d:"M98 190.06l139.78 163.12a24 24 0 0 0 36.44 0L414 190.06c13.34-15.57 2.28-39.62-18.22-39.62h-279.6c-20.5 0-31.56 24.05-18.18 39.62z",fill:"currentColor"},null,-1),jo=[Fo],Ko=_({name:"CaretDownOutline",render:function(t,o){return le(),ae("svg",Mo,jo)}});const Vo={class:"admin-nav"},Do={__name:"index",setup(e){let t=qe(),o=Ue(),n=Ge(),l=E(!1),a=E([]),m=u=>{o.push({name:u})},h=()=>{localStorage.removeItem("jwt"),localStorage.removeItem("author"),n.state.username="",window.location.href="/"};Ve(()=>{let u=o.getRoutes().filter(x=>{if(x.name=="admin")return x});a.value=u[0].children;for(let x of a.value)x.mate.isM&&c.value.push({label:x.mate.name,key:x.mate.key,name:x.name})}),De(t,(u,x)=>{});const c=E([]);let g=u=>"href"in u?s("a",{href:u.href,target:"_blank"},u.label):u.label,N=u=>u.key==="sheep-man"?!0:u.key==="food"?null:s(Ce,null,{default:()=>s(Lo)}),R=()=>s(Ce,null,{default:()=>s(Ko)});return(u,x)=>{const $=Ye("router-view");return le(),ae(we,null,[Q("div",Vo,[Q("div",null,[j(k(be),{type:"info",round:"",onClick:x[0]||(x[0]=y=>ee(l)?l.value=!k(l):l=!k(l))},{default:G(()=>[pe("内容管理系统")]),_:1}),j(k(be),{round:"",onClick:k(h),type:"info",style:{float:"right"}},{default:G(()=>[pe("退出")]),_:1},8,["onClick"])])]),j(k(ye),{"has-sider":"",style:{height:"calc(100% - 54px)"}},{default:G(()=>[j(k(Io),{bordered:"","collapse-mode":"width","collapsed-width":50,width:180,collapsed:k(l),"show-trigger":"",onCollapse:x[1]||(x[1]=y=>ee(l)?l.value=!0:l=!0),onExpand:x[2]||(x[2]=y=>ee(l)?l.value=!1:l=!1)},{default:G(()=>[j(k(_o),{"onUpdate:value":k(m),collapsed:k(l),"collapsed-width":50,"collapsed-icon-size":22,options:c.value,"render-label":k(g),"render-icon":k(N),"expand-icon":k(R)},null,8,["onUpdate:value","collapsed","options","render-label","render-icon","expand-icon"])]),_:1},8,["collapsed"]),j(k(ye),{style:{padding:"5px"}},{default:G(()=>[j($)]),_:1})]),_:1})],64)}}},Xo=Ke(Do,[["__scopeId","data-v-80077022"]]);export{Xo as default};
