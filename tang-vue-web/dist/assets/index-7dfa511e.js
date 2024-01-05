import{v as oo,c as b,a as k,f as Ao,d as E,h as v,i as W,S as Ve,p as U,U as $o,H as _e,V as ne,m as Ke,W as Ge,F as to,w as We,T as Po,b as _o,q as Oe,t as ro,x as no,G as Oo,O as No,u as To,l as ko,L as Bo,A as V,z as N,j as F,P as ue,C as Ce,D as Eo}from"./preload-helper-bcb988a1.js";import{c as z,a as jo,b as Ue,m as Lo,d as He,e as qe,w as Mo,f as ie,u as ee,g as Ne,h as io,i as Ye,j as xe,k as x,l as P,n as Y,o as se,p as C,q as ye,r as le,N as Xe}from"./admin-c95e2250.js";import{i as Fo,u as X,p as re,a as Do,V as lo,b as Vo,f as Ko,g as Go,s as Wo,t as Uo,d as qo,c as ao,N as so,e as Te,C as Yo,h as Ae,j as G,r as Z,k as Xo,l as co,m as Qo,n as Ie,o as ke,q as we,v as Jo,w as uo,x as Zo,y as et,z as ot,A as Q,B as tt,D as rt,E as nt,F as it,G as Se}from"./Dropdown-75613afe.js";import{m as vo,a as lt}from"./context-8f703eab.js";import{I as at,S as st,W as ct,E as dt}from"./Warning-030d5e75.js";function ut(e){if(typeof e=="number")return{"":e.toString()};const o={};return e.split(/ +/).forEach(t=>{if(t==="")return;const[r,n]=t.split(":");n===void 0?o[""]=r:o[r]=n}),o}function te(e,o){var t;if(e==null)return;const r=ut(e);if(o===void 0)return r[""];if(typeof o=="string")return(t=r[o])!==null&&t!==void 0?t:r[""];if(Array.isArray(o)){for(let n=o.length-1;n>=0;--n){const l=o[n];if(l in r)return r[l]}return r[""]}else{let n,l=-1;return Object.keys(r).forEach(d=>{const c=Number(d);!Number.isNaN(c)&&o>=c&&c>=l&&(l=c,n=r[d])}),n}}function vt(e){var o;const t=(o=e.dirs)===null||o===void 0?void 0:o.find(({dir:r})=>r===oo);return!!(t&&t.value===!1)}const mt={xs:0,s:640,m:1024,l:1280,xl:1536,"2xl":1920};function ft(e){return`(min-width: ${e}px)`}const ae={};function ht(e=mt){if(!Fo)return b(()=>[]);if(typeof window.matchMedia!="function")return b(()=>[]);const o=k({}),t=Object.keys(e),r=(n,l)=>{n.matches?o.value[l]=!0:o.value[l]=!1};return t.forEach(n=>{const l=e[n];let d,c;ae[l]===void 0?(d=window.matchMedia(ft(l)),d.addEventListener?d.addEventListener("change",i=>{c.forEach(a=>{a(i,n)})}):d.addListener&&d.addListener(i=>{c.forEach(a=>{a(i,n)})}),c=new Set,ae[l]={mql:d,cbs:c}):(d=ae[l].mql,c=ae[l].cbs),c.add(r),d.matches&&c.forEach(i=>{i(d,n)})}),Ao(()=>{t.forEach(n=>{const{cbs:l}=ae[e[n]];l.has(r)&&l.delete(r)})}),b(()=>{const{value:n}=o;return t.filter(l=>n[l])})}const gt=E({name:"ChevronDownFilled",render(){return v("svg",{viewBox:"0 0 16 16",fill:"none",xmlns:"http://www.w3.org/2000/svg"},v("path",{d:"M3.20041 5.73966C3.48226 5.43613 3.95681 5.41856 4.26034 5.70041L8 9.22652L11.7397 5.70041C12.0432 5.41856 12.5177 5.43613 12.7996 5.73966C13.0815 6.0432 13.0639 6.51775 12.7603 6.7996L8.51034 10.7996C8.22258 11.0668 7.77743 11.0668 7.48967 10.7996L3.23966 6.7996C2.93613 6.51775 2.91856 6.0432 3.20041 5.73966Z",fill:"currentColor"}))}}),{cubicBezierEaseInOut:q,cubicBezierEaseOut:pt,cubicBezierEaseIn:bt}=jo;function mo({overflow:e="hidden",duration:o=".3s",originalTransition:t="",leavingDelay:r="0s",foldPadding:n=!1,enterToProps:l=void 0,leaveToProps:d=void 0,reverse:c=!1}={}){const i=c?"leave":"enter",a=c?"enter":"leave";return[z(`&.fade-in-height-expand-transition-${a}-from,
 &.fade-in-height-expand-transition-${i}-to`,Object.assign(Object.assign({},l),{opacity:1})),z(`&.fade-in-height-expand-transition-${a}-to,
 &.fade-in-height-expand-transition-${i}-from`,Object.assign(Object.assign({},d),{opacity:0,marginTop:"0 !important",marginBottom:"0 !important",paddingTop:n?"0 !important":void 0,paddingBottom:n?"0 !important":void 0})),z(`&.fade-in-height-expand-transition-${a}-active`,`
 overflow: ${e};
 transition:
 max-height ${o} ${q} ${r},
 opacity ${o} ${pt} ${r},
 margin-top ${o} ${q} ${r},
 margin-bottom ${o} ${q} ${r},
 padding-top ${o} ${q} ${r},
 padding-bottom ${o} ${q} ${r}
 ${t?","+t:""}
 `),z(`&.fade-in-height-expand-transition-${i}-active`,`
 overflow: ${e};
 transition:
 max-height ${o} ${q},
 opacity ${o} ${bt},
 margin-top ${o} ${q},
 margin-bottom ${o} ${q},
 padding-top ${o} ${q},
 padding-bottom ${o} ${q}
 ${t?","+t:""}
 `)]}const Ct={abstract:Boolean,bordered:{type:Boolean,default:void 0},clsPrefix:{type:String,default:He},locale:Object,dateLocale:Object,namespace:String,rtl:Array,tag:{type:String,default:"div"},hljs:Object,katex:Object,theme:Object,themeOverrides:Object,componentOptions:Object,icons:Object,breakpoints:Object,preflightStyleDisabled:Boolean,inlineThemeDisabled:{type:Boolean,default:void 0},as:{type:String,validator:()=>(Mo("config-provider","`as` is deprecated, please use `tag` instead."),!0),default:void 0}},xt=E({name:"ConfigProvider",alias:["App"],props:Ct,setup(e){const o=W(Ue,null),t=b(()=>{const{theme:u}=e;if(u===null)return;const h=o==null?void 0:o.mergedThemeRef.value;return u===void 0?h:h===void 0?u:Object.assign({},h,u)}),r=b(()=>{const{themeOverrides:u}=e;if(u!==null){if(u===void 0)return o==null?void 0:o.mergedThemeOverridesRef.value;{const h=o==null?void 0:o.mergedThemeOverridesRef.value;return h===void 0?u:Lo({},h,u)}}}),n=X(()=>{const{namespace:u}=e;return u===void 0?o==null?void 0:o.mergedNamespaceRef.value:u}),l=X(()=>{const{bordered:u}=e;return u===void 0?o==null?void 0:o.mergedBorderedRef.value:u}),d=b(()=>{const{icons:u}=e;return u===void 0?o==null?void 0:o.mergedIconsRef.value:u}),c=b(()=>{const{componentOptions:u}=e;return u!==void 0?u:o==null?void 0:o.mergedComponentPropsRef.value}),i=b(()=>{const{clsPrefix:u}=e;return u!==void 0?u:o?o.mergedClsPrefixRef.value:He}),a=b(()=>{var u;const{rtl:h}=e;if(h===void 0)return o==null?void 0:o.mergedRtlRef.value;const w={};for(const y of h)w[y.name]=Ve(y),(u=y.peers)===null||u===void 0||u.forEach(A=>{A.name in w||(w[A.name]=Ve(A))});return w}),p=b(()=>e.breakpoints||(o==null?void 0:o.mergedBreakpointsRef.value)),g=e.inlineThemeDisabled||(o==null?void 0:o.inlineThemeDisabled),m=e.preflightStyleDisabled||(o==null?void 0:o.preflightStyleDisabled),R=b(()=>{const{value:u}=t,{value:h}=r,w=h&&Object.keys(h).length!==0,y=u==null?void 0:u.name;return y?w?`${y}-${qe(JSON.stringify(r.value))}`:y:w?qe(JSON.stringify(r.value)):""});return U(Ue,{mergedThemeHashRef:R,mergedBreakpointsRef:p,mergedRtlRef:a,mergedIconsRef:d,mergedComponentPropsRef:c,mergedBorderedRef:l,mergedNamespaceRef:n,mergedClsPrefixRef:i,mergedLocaleRef:b(()=>{const{locale:u}=e;if(u!==null)return u===void 0?o==null?void 0:o.mergedLocaleRef.value:u}),mergedDateLocaleRef:b(()=>{const{dateLocale:u}=e;if(u!==null)return u===void 0?o==null?void 0:o.mergedDateLocaleRef.value:u}),mergedHljsRef:b(()=>{const{hljs:u}=e;return u===void 0?o==null?void 0:o.mergedHljsRef.value:u}),mergedKatexRef:b(()=>{const{katex:u}=e;return u===void 0?o==null?void 0:o.mergedKatexRef.value:u}),mergedThemeRef:t,mergedThemeOverridesRef:r,inlineThemeDisabled:g||!1,preflightStyleDisabled:m||!1}),{mergedClsPrefix:i,mergedBordered:l,mergedNamespace:n,mergedTheme:t,mergedThemeOverrides:r}},render(){var e,o,t,r;return this.abstract?(r=(t=this.$slots).default)===null||r===void 0?void 0:r.call(t):v(this.as||this.tag,{class:`${this.mergedClsPrefix||He}-config-provider`},(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e))}}),Qe=1,fo=ie("n-grid"),ho=1,yt={span:{type:[Number,String],default:ho},offset:{type:[Number,String],default:0},suffix:Boolean,privateOffset:Number,privateSpan:Number,privateColStart:Number,privateShow:{type:Boolean,default:!0}},Je=E({__GRID_ITEM__:!0,name:"GridItem",alias:["Gi"],props:yt,setup(){const{isSsrRef:e,xGapRef:o,itemStyleRef:t,overflowRef:r,layoutShiftDisabledRef:n}=W(fo),l=$o();return{overflow:r,itemStyle:t,layoutShiftDisabled:n,mergedXGap:b(()=>re(o.value||0)),deriveStyle:()=>{e.value;const{privateSpan:d=ho,privateShow:c=!0,privateColStart:i=void 0,privateOffset:a=0}=l.vnode.props,{value:p}=o,g=re(p||0);return{display:c?"":"none",gridColumn:`${i??`span ${d}`} / span ${d}`,marginLeft:a?`calc((100% - (${d} - 1) * ${g}) / ${d} * ${a} + ${g} * ${a})`:""}}}},render(){var e,o;if(this.layoutShiftDisabled){const{span:t,offset:r,mergedXGap:n}=this;return v("div",{style:{gridColumn:`span ${t} / span ${t}`,marginLeft:r?`calc((100% - (${t} - 1) * ${n}) / ${t} * ${r} + ${n} * ${r})`:""}},this.$slots)}return v("div",{style:[this.itemStyle,this.deriveStyle()]},(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e,{overflow:this.overflow}))}}),It={xs:0,s:640,m:1024,l:1280,xl:1536,xxl:1920},go=24,ze="__ssr__",wt={layoutShiftDisabled:Boolean,responsive:{type:[String,Boolean],default:"self"},cols:{type:[Number,String],default:go},itemResponsive:Boolean,collapsed:Boolean,collapsedRows:{type:Number,default:1},itemStyle:[Object,String],xGap:{type:[Number,String],default:0},yGap:{type:[Number,String],default:0}},St=E({name:"Grid",inheritAttrs:!1,props:wt,setup(e){const{mergedClsPrefixRef:o,mergedBreakpointsRef:t}=ee(e),r=/^\d+$/,n=k(void 0),l=ht((t==null?void 0:t.value)||It),d=X(()=>!!(e.itemResponsive||!r.test(e.cols.toString())||!r.test(e.xGap.toString())||!r.test(e.yGap.toString()))),c=b(()=>{if(d.value)return e.responsive==="self"?n.value:l.value}),i=X(()=>{var y;return(y=Number(te(e.cols.toString(),c.value)))!==null&&y!==void 0?y:go}),a=X(()=>te(e.xGap.toString(),c.value)),p=X(()=>te(e.yGap.toString(),c.value)),g=y=>{n.value=y.contentRect.width},m=y=>{Vo(g,y)},R=k(!1),u=b(()=>{if(e.responsive==="self")return m}),h=k(!1),w=k();return _e(()=>{const{value:y}=w;y&&y.hasAttribute(ze)&&(y.removeAttribute(ze),h.value=!0)}),U(fo,{layoutShiftDisabledRef:ne(e,"layoutShiftDisabled"),isSsrRef:h,itemStyleRef:ne(e,"itemStyle"),xGapRef:a,overflowRef:R}),{isSsr:!Do,contentEl:w,mergedClsPrefix:o,style:b(()=>e.layoutShiftDisabled?{width:"100%",display:"grid",gridTemplateColumns:`repeat(${e.cols}, minmax(0, 1fr))`,columnGap:re(e.xGap),rowGap:re(e.yGap)}:{width:"100%",display:"grid",gridTemplateColumns:`repeat(${i.value}, minmax(0, 1fr))`,columnGap:re(a.value),rowGap:re(p.value)}),isResponsive:d,responsiveQuery:c,responsiveCols:i,handleResize:u,overflow:R}},render(){if(this.layoutShiftDisabled)return v("div",Ke({ref:"contentEl",class:`${this.mergedClsPrefix}-grid`,style:this.style},this.$attrs),this.$slots);const e=()=>{var o,t,r,n,l,d,c;this.overflow=!1;const i=Ko(Go(this)),a=[],{collapsed:p,collapsedRows:g,responsiveCols:m,responsiveQuery:R}=this;i.forEach(A=>{var j,B,_,S,$;if(((j=A==null?void 0:A.type)===null||j===void 0?void 0:j.__GRID_ITEM__)!==!0)return;if(vt(A)){const K=Ge(A);K.props?K.props.privateShow=!1:K.props={privateShow:!1},a.push({child:K,rawChildSpan:0});return}A.dirs=((B=A.dirs)===null||B===void 0?void 0:B.filter(({dir:K})=>K!==oo))||null,((_=A.dirs)===null||_===void 0?void 0:_.length)===0&&(A.dirs=null);const D=Ge(A),M=Number(($=te((S=D.props)===null||S===void 0?void 0:S.span,R))!==null&&$!==void 0?$:Qe);M!==0&&a.push({child:D,rawChildSpan:M})});let u=0;const h=(o=a[a.length-1])===null||o===void 0?void 0:o.child;if(h!=null&&h.props){const A=(t=h.props)===null||t===void 0?void 0:t.suffix;A!==void 0&&A!==!1&&(u=Number((n=te((r=h.props)===null||r===void 0?void 0:r.span,R))!==null&&n!==void 0?n:Qe),h.props.privateSpan=u,h.props.privateColStart=m+1-u,h.props.privateShow=(l=h.props.privateShow)!==null&&l!==void 0?l:!0)}let w=0,y=!1;for(const{child:A,rawChildSpan:j}of a){if(y&&(this.overflow=!0),!y){const B=Number((c=te((d=A.props)===null||d===void 0?void 0:d.offset,R))!==null&&c!==void 0?c:0),_=Math.min(j+B,m);if(A.props?(A.props.privateSpan=_,A.props.privateOffset=B):A.props={privateSpan:_,privateOffset:B},p){const S=w%m;_+S>m&&(w+=m-S),_+w+u>g*m?y=!0:w+=_}}y&&(A.props?A.props.privateShow!==!0&&(A.props.privateShow=!1):A.props={privateShow:!1})}return v("div",Ke({ref:"contentEl",class:`${this.mergedClsPrefix}-grid`,style:this.style,[ze]:this.isSsr||void 0},this.$attrs),a.map(({child:A})=>A))};return this.isResponsive&&this.responsive==="self"?v(lo,{onResize:this.handleResize},{default:e}):e()}}),zt={margin:"0 0 8px 0",padding:"10px 20px",maxWidth:"720px",minWidth:"420px",iconMargin:"0 10px 0 0",closeMargin:"0 0 0 10px",closeSize:"20px",closeIconSize:"16px",iconSize:"20px",fontSize:"14px"},Rt=e=>{const{textColor2:o,closeIconColor:t,closeIconColorHover:r,closeIconColorPressed:n,infoColor:l,successColor:d,errorColor:c,warningColor:i,popoverColor:a,boxShadow2:p,primaryColor:g,lineHeight:m,borderRadius:R,closeColorHover:u,closeColorPressed:h}=e;return Object.assign(Object.assign({},zt),{closeBorderRadius:R,textColor:o,textColorInfo:o,textColorSuccess:o,textColorError:o,textColorWarning:o,textColorLoading:o,color:a,colorInfo:a,colorSuccess:a,colorError:a,colorWarning:a,colorLoading:a,boxShadow:p,boxShadowInfo:p,boxShadowSuccess:p,boxShadowError:p,boxShadowWarning:p,boxShadowLoading:p,iconColor:o,iconColorInfo:l,iconColorSuccess:d,iconColorWarning:i,iconColorError:c,iconColorLoading:g,closeColorHover:u,closeColorPressed:h,closeIconColor:t,closeIconColorHover:r,closeIconColorPressed:n,closeColorHoverInfo:u,closeColorPressedInfo:h,closeIconColorInfo:t,closeIconColorHoverInfo:r,closeIconColorPressedInfo:n,closeColorHoverSuccess:u,closeColorPressedSuccess:h,closeIconColorSuccess:t,closeIconColorHoverSuccess:r,closeIconColorPressedSuccess:n,closeColorHoverError:u,closeColorPressedError:h,closeIconColorError:t,closeIconColorHoverError:r,closeIconColorPressedError:n,closeColorHoverWarning:u,closeColorPressedWarning:h,closeIconColorWarning:t,closeIconColorHoverWarning:r,closeIconColorPressedWarning:n,closeColorHoverLoading:u,closeColorPressedLoading:h,closeIconColorLoading:t,closeIconColorHoverLoading:r,closeIconColorPressedLoading:n,loadingColor:g,lineHeight:m,borderRadius:R})},Ht={name:"Message",common:Ne,self:Rt},At=Ht,$t=e=>{const{baseColor:o,textColor2:t,bodyColor:r,cardColor:n,dividerColor:l,actionColor:d,scrollbarColor:c,scrollbarColorHover:i,invertedColor:a}=e;return{textColor:t,textColorInverted:"#FFF",color:r,colorEmbedded:d,headerColor:n,headerColorInverted:a,footerColor:d,footerColorInverted:a,headerBorderColor:l,headerBorderColorInverted:a,footerBorderColor:l,footerBorderColorInverted:a,siderBorderColor:l,siderBorderColorInverted:a,siderColor:n,siderColorInverted:a,siderToggleButtonBorder:`1px solid ${l}`,siderToggleButtonColor:o,siderToggleButtonIconColor:t,siderToggleButtonIconColorInverted:t,siderToggleBarColor:Ye(r,c),siderToggleBarColorHover:Ye(r,i),__invertScrollbar:"true"}},Pt=io({name:"Layout",common:Ne,peers:{Scrollbar:Wo},self:$t}),Be=Pt;function _t(e,o,t,r){return{itemColorHoverInverted:"#0000",itemColorActiveInverted:o,itemColorActiveHoverInverted:o,itemColorActiveCollapsedInverted:o,itemTextColorInverted:e,itemTextColorHoverInverted:t,itemTextColorChildActiveInverted:t,itemTextColorChildActiveHoverInverted:t,itemTextColorActiveInverted:t,itemTextColorActiveHoverInverted:t,itemTextColorHorizontalInverted:e,itemTextColorHoverHorizontalInverted:t,itemTextColorChildActiveHorizontalInverted:t,itemTextColorChildActiveHoverHorizontalInverted:t,itemTextColorActiveHorizontalInverted:t,itemTextColorActiveHoverHorizontalInverted:t,itemIconColorInverted:e,itemIconColorHoverInverted:t,itemIconColorActiveInverted:t,itemIconColorActiveHoverInverted:t,itemIconColorChildActiveInverted:t,itemIconColorChildActiveHoverInverted:t,itemIconColorCollapsedInverted:e,itemIconColorHorizontalInverted:e,itemIconColorHoverHorizontalInverted:t,itemIconColorActiveHorizontalInverted:t,itemIconColorActiveHoverHorizontalInverted:t,itemIconColorChildActiveHorizontalInverted:t,itemIconColorChildActiveHoverHorizontalInverted:t,arrowColorInverted:e,arrowColorHoverInverted:t,arrowColorActiveInverted:t,arrowColorActiveHoverInverted:t,arrowColorChildActiveInverted:t,arrowColorChildActiveHoverInverted:t,groupTextColorInverted:r}}const Ot=e=>{const{borderRadius:o,textColor3:t,primaryColor:r,textColor2:n,textColor1:l,fontSize:d,dividerColor:c,hoverColor:i,primaryColorHover:a}=e;return Object.assign({borderRadius:o,color:"#0000",groupTextColor:t,itemColorHover:i,itemColorActive:xe(r,{alpha:.1}),itemColorActiveHover:xe(r,{alpha:.1}),itemColorActiveCollapsed:xe(r,{alpha:.1}),itemTextColor:n,itemTextColorHover:n,itemTextColorActive:r,itemTextColorActiveHover:r,itemTextColorChildActive:r,itemTextColorChildActiveHover:r,itemTextColorHorizontal:n,itemTextColorHoverHorizontal:a,itemTextColorActiveHorizontal:r,itemTextColorActiveHoverHorizontal:r,itemTextColorChildActiveHorizontal:r,itemTextColorChildActiveHoverHorizontal:r,itemIconColor:l,itemIconColorHover:l,itemIconColorActive:r,itemIconColorActiveHover:r,itemIconColorChildActive:r,itemIconColorChildActiveHover:r,itemIconColorCollapsed:l,itemIconColorHorizontal:l,itemIconColorHoverHorizontal:a,itemIconColorActiveHorizontal:r,itemIconColorActiveHoverHorizontal:r,itemIconColorChildActiveHorizontal:r,itemIconColorChildActiveHoverHorizontal:r,itemHeight:"42px",arrowColor:n,arrowColorHover:n,arrowColorActive:r,arrowColorActiveHover:r,arrowColorChildActive:r,arrowColorChildActiveHover:r,colorInverted:"#0000",borderColorHorizontal:"#0000",fontSize:d,dividerColor:c},_t("#BBB",r,"#FFF","#AAA"))},Nt=io({name:"Menu",common:Ne,peers:{Tooltip:Uo,Dropdown:qo},self:Ot}),Tt=Nt,po=ie("n-layout-sider"),Ee={type:String,default:"static"},kt=x("layout",`
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
`,[x("layout-scroll-container",`
 overflow-x: hidden;
 box-sizing: border-box;
 height: 100%;
 `),P("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),Bt={embedded:Boolean,position:Ee,nativeScrollbar:{type:Boolean,default:!0},scrollbarProps:Object,onScroll:Function,contentClass:String,contentStyle:{type:[String,Object],default:""},hasSider:Boolean,siderPlacement:{type:String,default:"left"}},bo=ie("n-layout");function Et(e){return E({name:e?"LayoutContent":"Layout",props:Object.assign(Object.assign({},Y.props),Bt),setup(o){const t=k(null),r=k(null),{mergedClsPrefixRef:n,inlineThemeDisabled:l}=ee(o),d=Y("Layout","-layout",kt,Be,o,n);function c(h,w){if(o.nativeScrollbar){const{value:y}=t;y&&(w===void 0?y.scrollTo(h):y.scrollTo(h,w))}else{const{value:y}=r;y&&y.scrollTo(h,w)}}U(bo,o);let i=0,a=0;const p=h=>{var w;const y=h.target;i=y.scrollLeft,a=y.scrollTop,(w=o.onScroll)===null||w===void 0||w.call(o,h)};ao(()=>{if(o.nativeScrollbar){const h=t.value;h&&(h.scrollTop=a,h.scrollLeft=i)}});const g={display:"flex",flexWrap:"nowrap",width:"100%",flexDirection:"row"},m={scrollTo:c},R=b(()=>{const{common:{cubicBezierEaseInOut:h},self:w}=d.value;return{"--n-bezier":h,"--n-color":o.embedded?w.colorEmbedded:w.color,"--n-text-color":w.textColor}}),u=l?se("layout",b(()=>o.embedded?"e":""),R,o):void 0;return Object.assign({mergedClsPrefix:n,scrollableElRef:t,scrollbarInstRef:r,hasSiderStyle:g,mergedTheme:d,handleNativeElScroll:p,cssVars:l?void 0:R,themeClass:u==null?void 0:u.themeClass,onRender:u==null?void 0:u.onRender},m)},render(){var o;const{mergedClsPrefix:t,hasSider:r}=this;(o=this.onRender)===null||o===void 0||o.call(this);const n=r?this.hasSiderStyle:void 0,l=[this.themeClass,e&&`${t}-layout-content`,`${t}-layout`,`${t}-layout--${this.position}-positioned`];return v("div",{class:l,style:this.cssVars},this.nativeScrollbar?v("div",{ref:"scrollableElRef",class:[`${t}-layout-scroll-container`,this.contentClass],style:[this.contentStyle,n],onScroll:this.handleNativeElScroll},this.$slots):v(so,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,contentClass:this.contentClass,contentStyle:[this.contentStyle,n]}),this.$slots))}})}const Re=Et(!1),jt=x("layout-header",`
 transition:
 color .3s var(--n-bezier),
 background-color .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier),
 border-color .3s var(--n-bezier);
 box-sizing: border-box;
 width: 100%;
 background-color: var(--n-color);
 color: var(--n-text-color);
`,[P("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 `),P("bordered",`
 border-bottom: solid 1px var(--n-border-color);
 `)]),Lt={position:Ee,inverted:Boolean,bordered:{type:Boolean,default:!1}},Mt=E({name:"LayoutHeader",props:Object.assign(Object.assign({},Y.props),Lt),setup(e){const{mergedClsPrefixRef:o,inlineThemeDisabled:t}=ee(e),r=Y("Layout","-layout-header",jt,Be,e,o),n=b(()=>{const{common:{cubicBezierEaseInOut:d},self:c}=r.value,i={"--n-bezier":d};return e.inverted?(i["--n-color"]=c.headerColorInverted,i["--n-text-color"]=c.textColorInverted,i["--n-border-color"]=c.headerBorderColorInverted):(i["--n-color"]=c.headerColor,i["--n-text-color"]=c.textColor,i["--n-border-color"]=c.headerBorderColor),i}),l=t?se("layout-header",b(()=>e.inverted?"a":"b"),n,e):void 0;return{mergedClsPrefix:o,cssVars:t?void 0:n,themeClass:l==null?void 0:l.themeClass,onRender:l==null?void 0:l.onRender}},render(){var e;const{mergedClsPrefix:o}=this;return(e=this.onRender)===null||e===void 0||e.call(this),v("div",{class:[`${o}-layout-header`,this.themeClass,this.position&&`${o}-layout-header--${this.position}-positioned`,this.bordered&&`${o}-layout-header--bordered`],style:this.cssVars},this.$slots)}}),Ft=x("layout-sider",`
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
`,[P("bordered",[C("border",`
 content: "";
 position: absolute;
 top: 0;
 bottom: 0;
 width: 1px;
 background-color: var(--n-border-color);
 transition: background-color .3s var(--n-bezier);
 `)]),C("left-placement",[P("bordered",[C("border",`
 right: 0;
 `)])]),P("right-placement",`
 justify-content: flex-start;
 `,[P("bordered",[C("border",`
 left: 0;
 `)]),P("collapsed",[x("layout-toggle-button",[x("base-icon",`
 transform: rotate(180deg);
 `)]),x("layout-toggle-bar",[z("&:hover",[C("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),C("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])])]),x("layout-toggle-button",`
 left: 0;
 transform: translateX(-50%) translateY(-50%);
 `,[x("base-icon",`
 transform: rotate(0);
 `)]),x("layout-toggle-bar",`
 left: -28px;
 transform: rotate(180deg);
 `,[z("&:hover",[C("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),C("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})])])]),P("collapsed",[x("layout-toggle-bar",[z("&:hover",[C("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),C("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])]),x("layout-toggle-button",[x("base-icon",`
 transform: rotate(0);
 `)])]),x("layout-toggle-button",`
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
 `,[x("base-icon",`
 transition: transform .3s var(--n-bezier);
 transform: rotate(180deg);
 `)]),x("layout-toggle-bar",`
 cursor: pointer;
 height: 72px;
 width: 32px;
 position: absolute;
 top: calc(50% - 36px);
 right: -28px;
 `,[C("top, bottom",`
 position: absolute;
 width: 4px;
 border-radius: 2px;
 height: 38px;
 left: 14px;
 transition: 
 background-color .3s var(--n-bezier),
 transform .3s var(--n-bezier);
 `),C("bottom",`
 position: absolute;
 top: 34px;
 `),z("&:hover",[C("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),C("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})]),C("top, bottom",{backgroundColor:"var(--n-toggle-bar-color)"}),z("&:hover",[C("top, bottom",{backgroundColor:"var(--n-toggle-bar-color-hover)"})])]),C("border",`
 position: absolute;
 top: 0;
 right: 0;
 bottom: 0;
 width: 1px;
 transition: background-color .3s var(--n-bezier);
 `),x("layout-sider-scroll-container",`
 flex-grow: 1;
 flex-shrink: 0;
 box-sizing: border-box;
 height: 100%;
 opacity: 0;
 transition: opacity .3s var(--n-bezier);
 max-width: 100%;
 `),P("show-content",[x("layout-sider-scroll-container",{opacity:1})]),P("absolute-positioned",`
 position: absolute;
 left: 0;
 top: 0;
 bottom: 0;
 `)]),Dt=E({name:"LayoutToggleButton",props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return v("div",{class:`${e}-layout-toggle-button`,onClick:this.onClick},v(Te,{clsPrefix:e},{default:()=>v(Yo,null)}))}}),Vt=E({props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return v("div",{onClick:this.onClick,class:`${e}-layout-toggle-bar`},v("div",{class:`${e}-layout-toggle-bar__top`}),v("div",{class:`${e}-layout-toggle-bar__bottom`}))}}),Kt={position:Ee,bordered:Boolean,collapsedWidth:{type:Number,default:48},width:{type:[Number,String],default:272},contentClass:String,contentStyle:{type:[String,Object],default:""},collapseMode:{type:String,default:"transform"},collapsed:{type:Boolean,default:void 0},defaultCollapsed:Boolean,showCollapsedContent:{type:Boolean,default:!0},showTrigger:{type:[Boolean,String],default:!1},nativeScrollbar:{type:Boolean,default:!0},inverted:Boolean,scrollbarProps:Object,triggerClass:String,triggerStyle:[String,Object],collapsedTriggerClass:String,collapsedTriggerStyle:[String,Object],"onUpdate:collapsed":[Function,Array],onUpdateCollapsed:[Function,Array],onAfterEnter:Function,onAfterLeave:Function,onExpand:[Function,Array],onCollapse:[Function,Array],onScroll:Function},Gt=E({name:"LayoutSider",props:Object.assign(Object.assign({},Y.props),Kt),setup(e){const o=W(bo),t=k(null),r=k(null),n=b(()=>ye(i.value?e.collapsedWidth:e.width)),l=b(()=>e.collapseMode!=="transform"?{}:{minWidth:ye(e.width)}),d=b(()=>o?o.siderPlacement:"left"),c=k(e.defaultCollapsed),i=Ae(ne(e,"collapsed"),c);function a(_,S){if(e.nativeScrollbar){const{value:$}=t;$&&(S===void 0?$.scrollTo(_):$.scrollTo(_,S))}else{const{value:$}=r;$&&$.scrollTo(_,S)}}function p(){const{"onUpdate:collapsed":_,onUpdateCollapsed:S,onExpand:$,onCollapse:D}=e,{value:M}=i;S&&G(S,!M),_&&G(_,!M),c.value=!M,M?$&&G($):D&&G(D)}let g=0,m=0;const R=_=>{var S;const $=_.target;g=$.scrollLeft,m=$.scrollTop,(S=e.onScroll)===null||S===void 0||S.call(e,_)};ao(()=>{if(e.nativeScrollbar){const _=t.value;_&&(_.scrollTop=m,_.scrollLeft=g)}}),U(po,{collapsedRef:i,collapseModeRef:ne(e,"collapseMode")});const{mergedClsPrefixRef:u,inlineThemeDisabled:h}=ee(e),w=Y("Layout","-layout-sider",Ft,Be,e,u);function y(_){var S,$;_.propertyName==="max-width"&&(i.value?(S=e.onAfterLeave)===null||S===void 0||S.call(e):($=e.onAfterEnter)===null||$===void 0||$.call(e))}const A={scrollTo:a},j=b(()=>{const{common:{cubicBezierEaseInOut:_},self:S}=w.value,{siderToggleButtonColor:$,siderToggleButtonBorder:D,siderToggleBarColor:M,siderToggleBarColorHover:K}=S,L={"--n-bezier":_,"--n-toggle-button-color":$,"--n-toggle-button-border":D,"--n-toggle-bar-color":M,"--n-toggle-bar-color-hover":K};return e.inverted?(L["--n-color"]=S.siderColorInverted,L["--n-text-color"]=S.textColorInverted,L["--n-border-color"]=S.siderBorderColorInverted,L["--n-toggle-button-icon-color"]=S.siderToggleButtonIconColorInverted,L.__invertScrollbar=S.__invertScrollbar):(L["--n-color"]=S.siderColor,L["--n-text-color"]=S.textColor,L["--n-border-color"]=S.siderBorderColor,L["--n-toggle-button-icon-color"]=S.siderToggleButtonIconColor),L}),B=h?se("layout-sider",b(()=>e.inverted?"a":"b"),j,e):void 0;return Object.assign({scrollableElRef:t,scrollbarInstRef:r,mergedClsPrefix:u,mergedTheme:w,styleMaxWidth:n,mergedCollapsed:i,scrollContainerStyle:l,siderPlacement:d,handleNativeElScroll:R,handleTransitionend:y,handleTriggerClick:p,inlineThemeDisabled:h,cssVars:j,themeClass:B==null?void 0:B.themeClass,onRender:B==null?void 0:B.onRender},A)},render(){var e;const{mergedClsPrefix:o,mergedCollapsed:t,showTrigger:r}=this;return(e=this.onRender)===null||e===void 0||e.call(this),v("aside",{class:[`${o}-layout-sider`,this.themeClass,`${o}-layout-sider--${this.position}-positioned`,`${o}-layout-sider--${this.siderPlacement}-placement`,this.bordered&&`${o}-layout-sider--bordered`,t&&`${o}-layout-sider--collapsed`,(!t||this.showCollapsedContent)&&`${o}-layout-sider--show-content`],onTransitionend:this.handleTransitionend,style:[this.inlineThemeDisabled?void 0:this.cssVars,{maxWidth:this.styleMaxWidth,width:ye(this.width)}]},this.nativeScrollbar?v("div",{class:[`${o}-layout-sider-scroll-container`,this.contentClass],onScroll:this.handleNativeElScroll,style:[this.scrollContainerStyle,{overflow:"auto"},this.contentStyle],ref:"scrollableElRef"},this.$slots):v(so,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",style:this.scrollContainerStyle,contentStyle:this.contentStyle,contentClass:this.contentClass,theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,builtinThemeOverrides:this.inverted&&this.cssVars.__invertScrollbar==="true"?{colorHover:"rgba(255, 255, 255, .4)",color:"rgba(255, 255, 255, .3)"}:void 0}),this.$slots),r?r==="bar"?v(Vt,{clsPrefix:o,class:t?this.collapsedTriggerClass:this.triggerClass,style:t?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):v(Dt,{clsPrefix:o,class:t?this.collapsedTriggerClass:this.triggerClass,style:t?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):null,this.bordered?v("div",{class:`${o}-layout-sider__border`}):null)}}),ce=ie("n-menu"),je=ie("n-submenu"),Le=ie("n-menu-item-group"),ve=8;function Me(e){const o=W(ce),{props:t,mergedCollapsedRef:r}=o,n=W(je,null),l=W(Le,null),d=b(()=>t.mode==="horizontal"),c=b(()=>d.value?t.dropdownPlacement:"tmNodes"in e?"right-start":"right"),i=b(()=>{var m;return Math.max((m=t.collapsedIconSize)!==null&&m!==void 0?m:t.iconSize,t.iconSize)}),a=b(()=>{var m;return!d.value&&e.root&&r.value&&(m=t.collapsedIconSize)!==null&&m!==void 0?m:t.iconSize}),p=b(()=>{if(d.value)return;const{collapsedWidth:m,indent:R,rootIndent:u}=t,{root:h,isGroup:w}=e,y=u===void 0?R:u;return h?r.value?m/2-i.value/2:y:l&&typeof l.paddingLeftRef.value=="number"?R/2+l.paddingLeftRef.value:n&&typeof n.paddingLeftRef.value=="number"?(w?R/2:R)+n.paddingLeftRef.value:0}),g=b(()=>{const{collapsedWidth:m,indent:R,rootIndent:u}=t,{value:h}=i,{root:w}=e;return d.value||!w||!r.value?ve:(u===void 0?R:u)+h+ve-(m+h)/2});return{dropdownPlacement:c,activeIconSize:a,maxIconSize:i,paddingLeft:p,iconMarginRight:g,NMenu:o,NSubmenu:n}}const Fe={internalKey:{type:[String,Number],required:!0},root:Boolean,isGroup:Boolean,level:{type:Number,required:!0},title:[String,Function],extra:[String,Function]},Co=Object.assign(Object.assign({},Fe),{tmNode:{type:Object,required:!0},tmNodes:{type:Array,required:!0}}),Wt=E({name:"MenuOptionGroup",props:Co,setup(e){U(je,null);const o=Me(e);U(Le,{paddingLeftRef:o.paddingLeft});const{mergedClsPrefixRef:t,props:r}=W(ce);return function(){const{value:n}=t,l=o.paddingLeft.value,{nodeProps:d}=r,c=d==null?void 0:d(e.tmNode.rawNode);return v("div",{class:`${n}-menu-item-group`,role:"group"},v("div",Object.assign({},c,{class:[`${n}-menu-item-group-title`,c==null?void 0:c.class],style:[(c==null?void 0:c.style)||"",l!==void 0?`padding-left: ${l}px;`:""]}),Z(e.title),e.extra?v(to,null," ",Z(e.extra)):null),v("div",null,e.tmNodes.map(i=>De(i,r))))}}}),xo=E({name:"MenuOptionContent",props:{collapsed:Boolean,disabled:Boolean,title:[String,Function],icon:Function,extra:[String,Function],showArrow:Boolean,childActive:Boolean,hover:Boolean,paddingLeft:Number,selected:Boolean,maxIconSize:{type:Number,required:!0},activeIconSize:{type:Number,required:!0},iconMarginRight:{type:Number,required:!0},clsPrefix:{type:String,required:!0},onClick:Function,tmNode:{type:Object,required:!0},isEllipsisPlaceholder:Boolean},setup(e){const{props:o}=W(ce);return{menuProps:o,style:b(()=>{const{paddingLeft:t}=e;return{paddingLeft:t&&`${t}px`}}),iconStyle:b(()=>{const{maxIconSize:t,activeIconSize:r,iconMarginRight:n}=e;return{width:`${t}px`,height:`${t}px`,fontSize:`${r}px`,marginRight:`${n}px`}})}},render(){const{clsPrefix:e,tmNode:o,menuProps:{renderIcon:t,renderLabel:r,renderExtra:n,expandIcon:l}}=this,d=t?t(o.rawNode):Z(this.icon);return v("div",{onClick:c=>{var i;(i=this.onClick)===null||i===void 0||i.call(this,c)},role:"none",class:[`${e}-menu-item-content`,{[`${e}-menu-item-content--selected`]:this.selected,[`${e}-menu-item-content--collapsed`]:this.collapsed,[`${e}-menu-item-content--child-active`]:this.childActive,[`${e}-menu-item-content--disabled`]:this.disabled,[`${e}-menu-item-content--hover`]:this.hover}],style:this.style},d&&v("div",{class:`${e}-menu-item-content__icon`,style:this.iconStyle,role:"none"},[d]),v("div",{class:`${e}-menu-item-content-header`,role:"none"},this.isEllipsisPlaceholder?this.title:r?r(o.rawNode):Z(this.title),this.extra||n?v("span",{class:`${e}-menu-item-content-header__extra`}," ",n?n(o.rawNode):Z(this.extra)):null),this.showArrow?v(Te,{ariaHidden:!0,class:`${e}-menu-item-content__arrow`,clsPrefix:e},{default:()=>l?l(o.rawNode):v(gt,null)}):null)}}),yo=Object.assign(Object.assign({},Fe),{rawNodes:{type:Array,default:()=>[]},tmNodes:{type:Array,default:()=>[]},tmNode:{type:Object,required:!0},disabled:Boolean,icon:Function,onClick:Function,domId:String,virtualChildActive:{type:Boolean,default:void 0},isEllipsisPlaceholder:Boolean}),$e=E({name:"Submenu",props:yo,setup(e){const o=Me(e),{NMenu:t,NSubmenu:r}=o,{props:n,mergedCollapsedRef:l,mergedThemeRef:d}=t,c=b(()=>{const{disabled:m}=e;return r!=null&&r.mergedDisabledRef.value||n.disabled?!0:m}),i=k(!1);U(je,{paddingLeftRef:o.paddingLeft,mergedDisabledRef:c}),U(Le,null);function a(){const{onClick:m}=e;m&&m()}function p(){c.value||(l.value||t.toggleExpand(e.internalKey),a())}function g(m){i.value=m}return{menuProps:n,mergedTheme:d,doSelect:t.doSelect,inverted:t.invertedRef,isHorizontal:t.isHorizontalRef,mergedClsPrefix:t.mergedClsPrefixRef,maxIconSize:o.maxIconSize,activeIconSize:o.activeIconSize,iconMarginRight:o.iconMarginRight,dropdownPlacement:o.dropdownPlacement,dropdownShow:i,paddingLeft:o.paddingLeft,mergedDisabled:c,mergedValue:t.mergedValueRef,childActive:X(()=>{var m;return(m=e.virtualChildActive)!==null&&m!==void 0?m:t.activePathRef.value.includes(e.internalKey)}),collapsed:b(()=>n.mode==="horizontal"?!1:l.value?!0:!t.mergedExpandedKeysRef.value.includes(e.internalKey)),dropdownEnabled:b(()=>!c.value&&(n.mode==="horizontal"||l.value)),handlePopoverShowChange:g,handleClick:p}},render(){var e;const{mergedClsPrefix:o,menuProps:{renderIcon:t,renderLabel:r}}=this,n=()=>{const{isHorizontal:d,paddingLeft:c,collapsed:i,mergedDisabled:a,maxIconSize:p,activeIconSize:g,title:m,childActive:R,icon:u,handleClick:h,menuProps:{nodeProps:w},dropdownShow:y,iconMarginRight:A,tmNode:j,mergedClsPrefix:B,isEllipsisPlaceholder:_,extra:S}=this,$=w==null?void 0:w(j.rawNode);return v("div",Object.assign({},$,{class:[`${B}-menu-item`,$==null?void 0:$.class],role:"menuitem"}),v(xo,{tmNode:j,paddingLeft:c,collapsed:i,disabled:a,iconMarginRight:A,maxIconSize:p,activeIconSize:g,title:m,extra:S,showArrow:!d,childActive:R,clsPrefix:B,icon:u,hover:y,onClick:h,isEllipsisPlaceholder:_}))},l=()=>v(co,null,{default:()=>{const{tmNodes:d,collapsed:c}=this;return c?null:v("div",{class:`${o}-submenu-children`,role:"menu"},d.map(i=>De(i,this.menuProps)))}});return this.root?v(Xo,Object.assign({size:"large",trigger:"hover"},(e=this.menuProps)===null||e===void 0?void 0:e.dropdownProps,{themeOverrides:this.mergedTheme.peerOverrides.Dropdown,theme:this.mergedTheme.peers.Dropdown,builtinThemeOverrides:{fontSizeLarge:"14px",optionIconSizeLarge:"18px"},value:this.mergedValue,disabled:!this.dropdownEnabled,placement:this.dropdownPlacement,keyField:this.menuProps.keyField,labelField:this.menuProps.labelField,childrenField:this.menuProps.childrenField,onUpdateShow:this.handlePopoverShowChange,options:this.rawNodes,onSelect:this.doSelect,inverted:this.inverted,renderIcon:t,renderLabel:r}),{default:()=>v("div",{class:`${o}-submenu`,role:"menuitem","aria-expanded":!this.collapsed,id:this.domId},n(),this.isHorizontal?null:l())}):v("div",{class:`${o}-submenu`,role:"menuitem","aria-expanded":!this.collapsed,id:this.domId},n(),l())}}),Io=Object.assign(Object.assign({},Fe),{tmNode:{type:Object,required:!0},disabled:Boolean,icon:Function,onClick:Function}),Ut=E({name:"MenuOption",props:Io,setup(e){const o=Me(e),{NSubmenu:t,NMenu:r}=o,{props:n,mergedClsPrefixRef:l,mergedCollapsedRef:d}=r,c=t?t.mergedDisabledRef:{value:!1},i=b(()=>c.value||e.disabled);function a(g){const{onClick:m}=e;m&&m(g)}function p(g){i.value||(r.doSelect(e.internalKey,e.tmNode.rawNode),a(g))}return{mergedClsPrefix:l,dropdownPlacement:o.dropdownPlacement,paddingLeft:o.paddingLeft,iconMarginRight:o.iconMarginRight,maxIconSize:o.maxIconSize,activeIconSize:o.activeIconSize,mergedTheme:r.mergedThemeRef,menuProps:n,dropdownEnabled:X(()=>e.root&&d.value&&n.mode!=="horizontal"&&!i.value),selected:X(()=>r.mergedValueRef.value===e.internalKey),mergedDisabled:i,handleClick:p}},render(){const{mergedClsPrefix:e,mergedTheme:o,tmNode:t,menuProps:{renderLabel:r,nodeProps:n}}=this,l=n==null?void 0:n(t.rawNode);return v("div",Object.assign({},l,{role:"menuitem",class:[`${e}-menu-item`,l==null?void 0:l.class]}),v(Qo,{theme:o.peers.Tooltip,themeOverrides:o.peerOverrides.Tooltip,trigger:"hover",placement:this.dropdownPlacement,disabled:!this.dropdownEnabled||this.title===void 0,internalExtraClass:["menu-tooltip"]},{default:()=>r?r(t.rawNode):Z(this.title),trigger:()=>v(xo,{tmNode:t,clsPrefix:e,paddingLeft:this.paddingLeft,iconMarginRight:this.iconMarginRight,maxIconSize:this.maxIconSize,activeIconSize:this.activeIconSize,selected:this.selected,title:this.title,extra:this.extra,disabled:this.mergedDisabled,icon:this.icon,onClick:this.handleClick})}))}}),qt=E({name:"MenuDivider",setup(){const e=W(ce),{mergedClsPrefixRef:o,isHorizontalRef:t}=e;return()=>t.value?null:v("div",{class:`${o.value}-menu-divider`})}}),Yt=ke(Co),Xt=ke(Io),Qt=ke(yo);function Pe(e){return e.type==="divider"||e.type==="render"}function Jt(e){return e.type==="divider"}function De(e,o){const{rawNode:t}=e,{show:r}=t;if(r===!1)return null;if(Pe(t))return Jt(t)?v(qt,Object.assign({key:e.key},t.props)):null;const{labelField:n}=o,{key:l,level:d,isGroup:c}=e,i=Object.assign(Object.assign({},t),{title:t.title||t[n],extra:t.titleExtra||t.extra,key:l,internalKey:l,level:d,root:d===0,isGroup:c});return e.children?e.isGroup?v(Wt,Ie(i,Yt,{tmNode:e,tmNodes:e.children,key:l})):v($e,Ie(i,Qt,{key:l,rawNodes:t[o.childrenField],tmNodes:e.children,tmNode:e})):v(Ut,Ie(i,Xt,{key:l,tmNode:e}))}const Ze=[z("&::before","background-color: var(--n-item-color-hover);"),C("arrow",`
 color: var(--n-arrow-color-hover);
 `),C("icon",`
 color: var(--n-item-icon-color-hover);
 `),x("menu-item-content-header",`
 color: var(--n-item-text-color-hover);
 `,[z("a",`
 color: var(--n-item-text-color-hover);
 `),C("extra",`
 color: var(--n-item-text-color-hover);
 `)])],eo=[C("icon",`
 color: var(--n-item-icon-color-hover-horizontal);
 `),x("menu-item-content-header",`
 color: var(--n-item-text-color-hover-horizontal);
 `,[z("a",`
 color: var(--n-item-text-color-hover-horizontal);
 `),C("extra",`
 color: var(--n-item-text-color-hover-horizontal);
 `)])],Zt=z([x("menu",`
 background-color: var(--n-color);
 color: var(--n-item-text-color);
 overflow: hidden;
 transition: background-color .3s var(--n-bezier);
 box-sizing: border-box;
 font-size: var(--n-font-size);
 padding-bottom: 6px;
 `,[P("horizontal",`
 max-width: 100%;
 width: 100%;
 display: flex;
 overflow: hidden;
 padding-bottom: 0;
 `,[x("submenu","margin: 0;"),x("menu-item","margin: 0;"),x("menu-item-content",`
 padding: 0 20px;
 border-bottom: 2px solid #0000;
 `,[z("&::before","display: none;"),P("selected","border-bottom: 2px solid var(--n-border-color-horizontal)")]),x("menu-item-content",[P("selected",[C("icon","color: var(--n-item-icon-color-active-horizontal);"),x("menu-item-content-header",`
 color: var(--n-item-text-color-active-horizontal);
 `,[z("a","color: var(--n-item-text-color-active-horizontal);"),C("extra","color: var(--n-item-text-color-active-horizontal);")])]),P("child-active",`
 border-bottom: 2px solid var(--n-border-color-horizontal);
 `,[x("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-horizontal);
 `,[z("a",`
 color: var(--n-item-text-color-child-active-horizontal);
 `),C("extra",`
 color: var(--n-item-text-color-child-active-horizontal);
 `)]),C("icon",`
 color: var(--n-item-icon-color-child-active-horizontal);
 `)]),le("disabled",[le("selected, child-active",[z("&:focus-within",eo)]),P("selected",[J(null,[C("icon","color: var(--n-item-icon-color-active-hover-horizontal);"),x("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover-horizontal);
 `,[z("a","color: var(--n-item-text-color-active-hover-horizontal);"),C("extra","color: var(--n-item-text-color-active-hover-horizontal);")])])]),P("child-active",[J(null,[C("icon","color: var(--n-item-icon-color-child-active-hover-horizontal);"),x("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover-horizontal);
 `,[z("a","color: var(--n-item-text-color-child-active-hover-horizontal);"),C("extra","color: var(--n-item-text-color-child-active-hover-horizontal);")])])]),J("border-bottom: 2px solid var(--n-border-color-horizontal);",eo)]),x("menu-item-content-header",[z("a","color: var(--n-item-text-color-horizontal);")])])]),le("responsive",[x("menu-item-content-header",`
 overflow: hidden;
 text-overflow: ellipsis;
 `)]),P("collapsed",[x("menu-item-content",[P("selected",[z("&::before",`
 background-color: var(--n-item-color-active-collapsed) !important;
 `)]),x("menu-item-content-header","opacity: 0;"),C("arrow","opacity: 0;"),C("icon","color: var(--n-item-icon-color-collapsed);")])]),x("menu-item",`
 height: var(--n-item-height);
 margin-top: 6px;
 position: relative;
 `),x("menu-item-content",`
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
 `,[z("> *","z-index: 1;"),z("&::before",`
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
 `),P("disabled",`
 opacity: .45;
 cursor: not-allowed;
 `),P("collapsed",[C("arrow","transform: rotate(0);")]),P("selected",[z("&::before","background-color: var(--n-item-color-active);"),C("arrow","color: var(--n-arrow-color-active);"),C("icon","color: var(--n-item-icon-color-active);"),x("menu-item-content-header",`
 color: var(--n-item-text-color-active);
 `,[z("a","color: var(--n-item-text-color-active);"),C("extra","color: var(--n-item-text-color-active);")])]),P("child-active",[x("menu-item-content-header",`
 color: var(--n-item-text-color-child-active);
 `,[z("a",`
 color: var(--n-item-text-color-child-active);
 `),C("extra",`
 color: var(--n-item-text-color-child-active);
 `)]),C("arrow",`
 color: var(--n-arrow-color-child-active);
 `),C("icon",`
 color: var(--n-item-icon-color-child-active);
 `)]),le("disabled",[le("selected, child-active",[z("&:focus-within",Ze)]),P("selected",[J(null,[C("arrow","color: var(--n-arrow-color-active-hover);"),C("icon","color: var(--n-item-icon-color-active-hover);"),x("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover);
 `,[z("a","color: var(--n-item-text-color-active-hover);"),C("extra","color: var(--n-item-text-color-active-hover);")])])]),P("child-active",[J(null,[C("arrow","color: var(--n-arrow-color-child-active-hover);"),C("icon","color: var(--n-item-icon-color-child-active-hover);"),x("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover);
 `,[z("a","color: var(--n-item-text-color-child-active-hover);"),C("extra","color: var(--n-item-text-color-child-active-hover);")])])]),P("selected",[J(null,[z("&::before","background-color: var(--n-item-color-active-hover);")])]),J(null,Ze)]),C("icon",`
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
 `),C("arrow",`
 grid-area: arrow;
 font-size: 16px;
 color: var(--n-arrow-color);
 transform: rotate(180deg);
 opacity: 1;
 transition:
 color .3s var(--n-bezier),
 transform 0.2s var(--n-bezier),
 opacity 0.2s var(--n-bezier);
 `),x("menu-item-content-header",`
 grid-area: content;
 transition:
 color .3s var(--n-bezier),
 opacity .3s var(--n-bezier);
 opacity: 1;
 white-space: nowrap;
 color: var(--n-item-text-color);
 `,[z("a",`
 outline: none;
 text-decoration: none;
 transition: color .3s var(--n-bezier);
 color: var(--n-item-text-color);
 `,[z("&::before",`
 content: "";
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),C("extra",`
 font-size: .93em;
 color: var(--n-group-text-color);
 transition: color .3s var(--n-bezier);
 `)])]),x("submenu",`
 cursor: pointer;
 position: relative;
 margin-top: 6px;
 `,[x("menu-item-content",`
 height: var(--n-item-height);
 `),x("submenu-children",`
 overflow: hidden;
 padding: 0;
 `,[mo({duration:".2s"})])]),x("menu-item-group",[x("menu-item-group-title",`
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
 `)])]),x("menu-tooltip",[z("a",`
 color: inherit;
 text-decoration: none;
 `)]),x("menu-divider",`
 transition: background-color .3s var(--n-bezier);
 background-color: var(--n-divider-color);
 height: 1px;
 margin: 6px 18px;
 `)]);function J(e,o){return[P("hover",e,o),z("&:hover",e,o)]}const er=Object.assign(Object.assign({},Y.props),{options:{type:Array,default:()=>[]},collapsed:{type:Boolean,default:void 0},collapsedWidth:{type:Number,default:48},iconSize:{type:Number,default:20},collapsedIconSize:{type:Number,default:24},rootIndent:Number,indent:{type:Number,default:32},labelField:{type:String,default:"label"},keyField:{type:String,default:"key"},childrenField:{type:String,default:"children"},disabledField:{type:String,default:"disabled"},defaultExpandAll:Boolean,defaultExpandedKeys:Array,expandedKeys:Array,value:[String,Number],defaultValue:{type:[String,Number],default:null},mode:{type:String,default:"vertical"},watchProps:{type:Array,default:void 0},disabled:Boolean,show:{type:Boolean,default:!0},inverted:Boolean,"onUpdate:expandedKeys":[Function,Array],onUpdateExpandedKeys:[Function,Array],onUpdateValue:[Function,Array],"onUpdate:value":[Function,Array],expandIcon:Function,renderIcon:Function,renderLabel:Function,renderExtra:Function,dropdownProps:Object,accordion:Boolean,nodeProps:Function,dropdownPlacement:{type:String,default:"bottom"},responsive:Boolean,items:Array,onOpenNamesChange:[Function,Array],onSelect:[Function,Array],onExpandedNamesChange:[Function,Array],expandedNames:Array,defaultExpandedNames:Array}),or=E({name:"Menu",props:er,setup(e){const{mergedClsPrefixRef:o,inlineThemeDisabled:t}=ee(e),r=Y("Menu","-menu",Zt,Tt,e,o),n=W(po,null),l=b(()=>{var I;const{collapsed:O}=e;if(O!==void 0)return O;if(n){const{collapseModeRef:s,collapsedRef:H}=n;if(s.value==="width")return(I=H.value)!==null&&I!==void 0?I:!1}return!1}),d=b(()=>{const{keyField:I,childrenField:O,disabledField:s}=e;return we(e.items||e.options,{getIgnored(H){return Pe(H)},getChildren(H){return H[O]},getDisabled(H){return H[s]},getKey(H){var T;return(T=H[I])!==null&&T!==void 0?T:H.name}})}),c=b(()=>new Set(d.value.treeNodes.map(I=>I.key))),{watchProps:i}=e,a=k(null);i!=null&&i.includes("defaultValue")?We(()=>{a.value=e.defaultValue}):a.value=e.defaultValue;const p=ne(e,"value"),g=Ae(p,a),m=k([]),R=()=>{m.value=e.defaultExpandAll?d.value.getNonLeafKeys():e.defaultExpandedNames||e.defaultExpandedKeys||d.value.getPath(g.value,{includeSelf:!1}).keyPath};i!=null&&i.includes("defaultExpandedKeys")?We(R):R();const u=Jo(e,["expandedNames","expandedKeys"]),h=Ae(u,m),w=b(()=>d.value.treeNodes),y=b(()=>d.value.getPath(g.value).keyPath);U(ce,{props:e,mergedCollapsedRef:l,mergedThemeRef:r,mergedValueRef:g,mergedExpandedKeysRef:h,activePathRef:y,mergedClsPrefixRef:o,isHorizontalRef:b(()=>e.mode==="horizontal"),invertedRef:ne(e,"inverted"),doSelect:A,toggleExpand:B});function A(I,O){const{"onUpdate:value":s,onUpdateValue:H,onSelect:T}=e;H&&G(H,I,O),s&&G(s,I,O),T&&G(T,I,O),a.value=I}function j(I){const{"onUpdate:expandedKeys":O,onUpdateExpandedKeys:s,onExpandedNamesChange:H,onOpenNamesChange:T}=e;O&&G(O,I),s&&G(s,I),H&&G(H,I),T&&G(T,I),m.value=I}function B(I){const O=Array.from(h.value),s=O.findIndex(H=>H===I);if(~s)O.splice(s,1);else{if(e.accordion&&c.value.has(I)){const H=O.findIndex(T=>c.value.has(T));H>-1&&O.splice(H,1)}O.push(I)}j(O)}const _=I=>{const O=d.value.getPath(I??g.value,{includeSelf:!1}).keyPath;if(!O.length)return;const s=Array.from(h.value),H=new Set([...s,...O]);e.accordion&&c.value.forEach(T=>{H.has(T)&&!O.includes(T)&&H.delete(T)}),j(Array.from(H))},S=b(()=>{const{inverted:I}=e,{common:{cubicBezierEaseInOut:O},self:s}=r.value,{borderRadius:H,borderColorHorizontal:T,fontSize:zo,itemHeight:Ro,dividerColor:Ho}=s,f={"--n-divider-color":Ho,"--n-bezier":O,"--n-font-size":zo,"--n-border-color-horizontal":T,"--n-border-radius":H,"--n-item-height":Ro};return I?(f["--n-group-text-color"]=s.groupTextColorInverted,f["--n-color"]=s.colorInverted,f["--n-item-text-color"]=s.itemTextColorInverted,f["--n-item-text-color-hover"]=s.itemTextColorHoverInverted,f["--n-item-text-color-active"]=s.itemTextColorActiveInverted,f["--n-item-text-color-child-active"]=s.itemTextColorChildActiveInverted,f["--n-item-text-color-child-active-hover"]=s.itemTextColorChildActiveInverted,f["--n-item-text-color-active-hover"]=s.itemTextColorActiveHoverInverted,f["--n-item-icon-color"]=s.itemIconColorInverted,f["--n-item-icon-color-hover"]=s.itemIconColorHoverInverted,f["--n-item-icon-color-active"]=s.itemIconColorActiveInverted,f["--n-item-icon-color-active-hover"]=s.itemIconColorActiveHoverInverted,f["--n-item-icon-color-child-active"]=s.itemIconColorChildActiveInverted,f["--n-item-icon-color-child-active-hover"]=s.itemIconColorChildActiveHoverInverted,f["--n-item-icon-color-collapsed"]=s.itemIconColorCollapsedInverted,f["--n-item-text-color-horizontal"]=s.itemTextColorHorizontalInverted,f["--n-item-text-color-hover-horizontal"]=s.itemTextColorHoverHorizontalInverted,f["--n-item-text-color-active-horizontal"]=s.itemTextColorActiveHorizontalInverted,f["--n-item-text-color-child-active-horizontal"]=s.itemTextColorChildActiveHorizontalInverted,f["--n-item-text-color-child-active-hover-horizontal"]=s.itemTextColorChildActiveHoverHorizontalInverted,f["--n-item-text-color-active-hover-horizontal"]=s.itemTextColorActiveHoverHorizontalInverted,f["--n-item-icon-color-horizontal"]=s.itemIconColorHorizontalInverted,f["--n-item-icon-color-hover-horizontal"]=s.itemIconColorHoverHorizontalInverted,f["--n-item-icon-color-active-horizontal"]=s.itemIconColorActiveHorizontalInverted,f["--n-item-icon-color-active-hover-horizontal"]=s.itemIconColorActiveHoverHorizontalInverted,f["--n-item-icon-color-child-active-horizontal"]=s.itemIconColorChildActiveHorizontalInverted,f["--n-item-icon-color-child-active-hover-horizontal"]=s.itemIconColorChildActiveHoverHorizontalInverted,f["--n-arrow-color"]=s.arrowColorInverted,f["--n-arrow-color-hover"]=s.arrowColorHoverInverted,f["--n-arrow-color-active"]=s.arrowColorActiveInverted,f["--n-arrow-color-active-hover"]=s.arrowColorActiveHoverInverted,f["--n-arrow-color-child-active"]=s.arrowColorChildActiveInverted,f["--n-arrow-color-child-active-hover"]=s.arrowColorChildActiveHoverInverted,f["--n-item-color-hover"]=s.itemColorHoverInverted,f["--n-item-color-active"]=s.itemColorActiveInverted,f["--n-item-color-active-hover"]=s.itemColorActiveHoverInverted,f["--n-item-color-active-collapsed"]=s.itemColorActiveCollapsedInverted):(f["--n-group-text-color"]=s.groupTextColor,f["--n-color"]=s.color,f["--n-item-text-color"]=s.itemTextColor,f["--n-item-text-color-hover"]=s.itemTextColorHover,f["--n-item-text-color-active"]=s.itemTextColorActive,f["--n-item-text-color-child-active"]=s.itemTextColorChildActive,f["--n-item-text-color-child-active-hover"]=s.itemTextColorChildActiveHover,f["--n-item-text-color-active-hover"]=s.itemTextColorActiveHover,f["--n-item-icon-color"]=s.itemIconColor,f["--n-item-icon-color-hover"]=s.itemIconColorHover,f["--n-item-icon-color-active"]=s.itemIconColorActive,f["--n-item-icon-color-active-hover"]=s.itemIconColorActiveHover,f["--n-item-icon-color-child-active"]=s.itemIconColorChildActive,f["--n-item-icon-color-child-active-hover"]=s.itemIconColorChildActiveHover,f["--n-item-icon-color-collapsed"]=s.itemIconColorCollapsed,f["--n-item-text-color-horizontal"]=s.itemTextColorHorizontal,f["--n-item-text-color-hover-horizontal"]=s.itemTextColorHoverHorizontal,f["--n-item-text-color-active-horizontal"]=s.itemTextColorActiveHorizontal,f["--n-item-text-color-child-active-horizontal"]=s.itemTextColorChildActiveHorizontal,f["--n-item-text-color-child-active-hover-horizontal"]=s.itemTextColorChildActiveHoverHorizontal,f["--n-item-text-color-active-hover-horizontal"]=s.itemTextColorActiveHoverHorizontal,f["--n-item-icon-color-horizontal"]=s.itemIconColorHorizontal,f["--n-item-icon-color-hover-horizontal"]=s.itemIconColorHoverHorizontal,f["--n-item-icon-color-active-horizontal"]=s.itemIconColorActiveHorizontal,f["--n-item-icon-color-active-hover-horizontal"]=s.itemIconColorActiveHoverHorizontal,f["--n-item-icon-color-child-active-horizontal"]=s.itemIconColorChildActiveHorizontal,f["--n-item-icon-color-child-active-hover-horizontal"]=s.itemIconColorChildActiveHoverHorizontal,f["--n-arrow-color"]=s.arrowColor,f["--n-arrow-color-hover"]=s.arrowColorHover,f["--n-arrow-color-active"]=s.arrowColorActive,f["--n-arrow-color-active-hover"]=s.arrowColorActiveHover,f["--n-arrow-color-child-active"]=s.arrowColorChildActive,f["--n-arrow-color-child-active-hover"]=s.arrowColorChildActiveHover,f["--n-item-color-hover"]=s.itemColorHover,f["--n-item-color-active"]=s.itemColorActive,f["--n-item-color-active-hover"]=s.itemColorActiveHover,f["--n-item-color-active-collapsed"]=s.itemColorActiveCollapsed),f}),$=t?se("menu",b(()=>e.inverted?"a":"b"),S,e):void 0,D=uo(),M=k(null),K=k(null);let L=!0;const de=()=>{var I;L?L=!1:(I=M.value)===null||I===void 0||I.sync({showAllItemsBeforeCalculate:!0})};function me(){return document.getElementById(D)}const oe=k(-1);function fe(I){oe.value=e.options.length-I}function he(I){I||(oe.value=-1)}const ge=b(()=>{const I=oe.value;return{children:I===-1?[]:e.options.slice(I)}}),pe=b(()=>{const{childrenField:I,disabledField:O,keyField:s}=e;return we([ge.value],{getIgnored(H){return Pe(H)},getChildren(H){return H[I]},getDisabled(H){return H[O]},getKey(H){var T;return(T=H[s])!==null&&T!==void 0?T:H.name}})}),be=b(()=>we([{}]).treeNodes[0]);function So(){var I;if(oe.value===-1)return v($e,{root:!0,level:0,key:"__ellpisisGroupPlaceholder__",internalKey:"__ellpisisGroupPlaceholder__",title:"···",tmNode:be.value,domId:D,isEllipsisPlaceholder:!0});const O=pe.value.treeNodes[0],s=y.value,H=!!(!((I=O.children)===null||I===void 0)&&I.some(T=>s.includes(T.key)));return v($e,{level:0,root:!0,key:"__ellpisisGroup__",internalKey:"__ellpisisGroup__",title:"···",virtualChildActive:H,tmNode:O,domId:D,rawNodes:O.rawNode.children||[],tmNodes:O.children||[],isEllipsisPlaceholder:!0})}return{mergedClsPrefix:o,controlledExpandedKeys:u,uncontrolledExpanededKeys:m,mergedExpandedKeys:h,uncontrolledValue:a,mergedValue:g,activePath:y,tmNodes:w,mergedTheme:r,mergedCollapsed:l,cssVars:t?void 0:S,themeClass:$==null?void 0:$.themeClass,overflowRef:M,counterRef:K,updateCounter:()=>{},onResize:de,onUpdateOverflow:he,onUpdateCount:fe,renderCounter:So,getCounter:me,onRender:$==null?void 0:$.onRender,showOption:_,deriveResponsiveState:de}},render(){const{mergedClsPrefix:e,mode:o,themeClass:t,onRender:r}=this;r==null||r();const n=()=>this.tmNodes.map(i=>De(i,this.$props)),d=o==="horizontal"&&this.responsive,c=()=>v("div",{role:o==="horizontal"?"menubar":"menu",class:[`${e}-menu`,t,`${e}-menu--${o}`,d&&`${e}-menu--responsive`,this.mergedCollapsed&&`${e}-menu--collapsed`],style:this.cssVars},d?v(Zo,{ref:"overflowRef",onUpdateOverflow:this.onUpdateOverflow,getCounter:this.getCounter,onUpdateCount:this.onUpdateCount,updateCounter:this.updateCounter,style:{width:"100%",display:"flex",overflow:"hidden"}},{default:n,counter:this.renderCounter}):n());return d?v(lo,{onResize:this.onResize},{default:c}):c()}}),wo={icon:Function,type:{type:String,default:"info"},content:[String,Number,Function],showIcon:{type:Boolean,default:!0},closable:Boolean,keepAliveOnHover:Boolean,onClose:Function,onMouseenter:Function,onMouseleave:Function},tr=z([x("message-wrapper",`
 margin: var(--n-margin);
 z-index: 0;
 transform-origin: top center;
 display: flex;
 `,[mo({overflow:"visible",originalTransition:"transform .3s var(--n-bezier)",enterToProps:{transform:"scale(1)"},leaveToProps:{transform:"scale(0.85)"}})]),x("message",`
 box-sizing: border-box;
 display: flex;
 align-items: center;
 transition:
 color .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier),
 background-color .3s var(--n-bezier),
 opacity .3s var(--n-bezier),
 transform .3s var(--n-bezier),
 margin-bottom .3s var(--n-bezier);
 padding: var(--n-padding);
 border-radius: var(--n-border-radius);
 flex-wrap: nowrap;
 overflow: hidden;
 max-width: var(--n-max-width);
 color: var(--n-text-color);
 background-color: var(--n-color);
 box-shadow: var(--n-box-shadow);
 `,[C("content",`
 display: inline-block;
 line-height: var(--n-line-height);
 font-size: var(--n-font-size);
 `),C("icon",`
 position: relative;
 margin: var(--n-icon-margin);
 height: var(--n-icon-size);
 width: var(--n-icon-size);
 font-size: var(--n-icon-size);
 flex-shrink: 0;
 `,[["default","info","success","warning","error","loading"].map(e=>P(`${e}-type`,[z("> *",`
 color: var(--n-icon-color-${e});
 transition: color .3s var(--n-bezier);
 `)])),z("> *",`
 position: absolute;
 left: 0;
 top: 0;
 right: 0;
 bottom: 0;
 `,[et()])]),C("close",`
 margin: var(--n-close-margin);
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
 flex-shrink: 0;
 `,[z("&:hover",`
 color: var(--n-close-icon-color-hover);
 `),z("&:active",`
 color: var(--n-close-icon-color-pressed);
 `)])]),x("message-container",`
 z-index: 6000;
 position: fixed;
 height: 0;
 overflow: visible;
 display: flex;
 flex-direction: column;
 align-items: center;
 `,[P("top",`
 top: 12px;
 left: 0;
 right: 0;
 `),P("top-left",`
 top: 12px;
 left: 12px;
 right: 0;
 align-items: flex-start;
 `),P("top-right",`
 top: 12px;
 left: 0;
 right: 12px;
 align-items: flex-end;
 `),P("bottom",`
 bottom: 4px;
 left: 0;
 right: 0;
 justify-content: flex-end;
 `),P("bottom-left",`
 bottom: 4px;
 left: 12px;
 right: 0;
 justify-content: flex-end;
 align-items: flex-start;
 `),P("bottom-right",`
 bottom: 4px;
 left: 0;
 right: 12px;
 justify-content: flex-end;
 align-items: flex-end;
 `)])]),rr={info:()=>v(at,null),success:()=>v(st,null),warning:()=>v(ct,null),error:()=>v(dt,null),default:()=>null},nr=E({name:"Message",props:Object.assign(Object.assign({},wo),{render:Function}),setup(e){const{inlineThemeDisabled:o,mergedRtlRef:t}=ee(e),{props:r,mergedClsPrefixRef:n}=W(vo),l=ot("Message",t,n),d=Y("Message","-message",tr,At,r,n),c=b(()=>{const{type:a}=e,{common:{cubicBezierEaseInOut:p},self:{padding:g,margin:m,maxWidth:R,iconMargin:u,closeMargin:h,closeSize:w,iconSize:y,fontSize:A,lineHeight:j,borderRadius:B,iconColorInfo:_,iconColorSuccess:S,iconColorWarning:$,iconColorError:D,iconColorLoading:M,closeIconSize:K,closeBorderRadius:L,[Q("textColor",a)]:de,[Q("boxShadow",a)]:me,[Q("color",a)]:oe,[Q("closeColorHover",a)]:fe,[Q("closeColorPressed",a)]:he,[Q("closeIconColor",a)]:ge,[Q("closeIconColorPressed",a)]:pe,[Q("closeIconColorHover",a)]:be}}=d.value;return{"--n-bezier":p,"--n-margin":m,"--n-padding":g,"--n-max-width":R,"--n-font-size":A,"--n-icon-margin":u,"--n-icon-size":y,"--n-close-icon-size":K,"--n-close-border-radius":L,"--n-close-size":w,"--n-close-margin":h,"--n-text-color":de,"--n-color":oe,"--n-box-shadow":me,"--n-icon-color-info":_,"--n-icon-color-success":S,"--n-icon-color-warning":$,"--n-icon-color-error":D,"--n-icon-color-loading":M,"--n-close-color-hover":fe,"--n-close-color-pressed":he,"--n-close-icon-color":ge,"--n-close-icon-color-pressed":pe,"--n-close-icon-color-hover":be,"--n-line-height":j,"--n-border-radius":B}}),i=o?se("message",b(()=>e.type[0]),c,{}):void 0;return{mergedClsPrefix:n,rtlEnabled:l,messageProviderProps:r,handleClose(){var a;(a=e.onClose)===null||a===void 0||a.call(e)},cssVars:o?void 0:c,themeClass:i==null?void 0:i.themeClass,onRender:i==null?void 0:i.onRender,placement:r.placement}},render(){const{render:e,type:o,closable:t,content:r,mergedClsPrefix:n,cssVars:l,themeClass:d,onRender:c,icon:i,handleClose:a,showIcon:p}=this;c==null||c();let g;return v("div",{class:[`${n}-message-wrapper`,d],onMouseenter:this.onMouseenter,onMouseleave:this.onMouseleave,style:[{alignItems:this.placement.startsWith("top")?"flex-start":"flex-end"},l]},e?e(this.$props):v("div",{class:[`${n}-message ${n}-message--${o}-type`,this.rtlEnabled&&`${n}-message--rtl`]},(g=ir(i,o,n))&&p?v("div",{class:`${n}-message__icon ${n}-message__icon--${o}-type`},v(tt,null,{default:()=>g})):null,v("div",{class:`${n}-message__content`},Z(r)),t?v(rt,{clsPrefix:n,class:`${n}-message__close`,onClick:a,absolute:!0}):null))}});function ir(e,o,t){if(typeof e=="function")return e();{const r=o==="loading"?v(nt,{clsPrefix:t,strokeWidth:24,scale:.85}):rr[o]();return r?v(Te,{clsPrefix:t,key:o},{default:()=>r}):null}}const lr=E({name:"MessageEnvironment",props:Object.assign(Object.assign({},wo),{duration:{type:Number,default:3e3},onAfterLeave:Function,onLeave:Function,internalKey:{type:String,required:!0},onInternalAfterLeave:Function,onHide:Function,onAfterHide:Function}),setup(e){let o=null;const t=k(!0);_e(()=>{r()});function r(){const{duration:p}=e;p&&(o=window.setTimeout(d,p))}function n(p){p.currentTarget===p.target&&o!==null&&(window.clearTimeout(o),o=null)}function l(p){p.currentTarget===p.target&&r()}function d(){const{onHide:p}=e;t.value=!1,o&&(window.clearTimeout(o),o=null),p&&p()}function c(){const{onClose:p}=e;p&&p(),d()}function i(){const{onAfterLeave:p,onInternalAfterLeave:g,onAfterHide:m,internalKey:R}=e;p&&p(),g&&g(R),m&&m()}function a(){d()}return{show:t,hide:d,handleClose:c,handleAfterLeave:i,handleMouseleave:l,handleMouseenter:n,deactivate:a}},render(){return v(co,{appear:!0,onAfterLeave:this.handleAfterLeave,onLeave:this.onLeave},{default:()=>[this.show?v(nr,{content:this.content,type:this.type,icon:this.icon,showIcon:this.showIcon,closable:this.closable,onClose:this.handleClose,onMouseenter:this.keepAliveOnHover?this.handleMouseenter:void 0,onMouseleave:this.keepAliveOnHover?this.handleMouseleave:void 0}):null]})}}),ar=Object.assign(Object.assign({},Y.props),{to:[String,Object],duration:{type:Number,default:3e3},keepAliveOnHover:Boolean,max:Number,placement:{type:String,default:"top"},closable:Boolean,containerClass:String,containerStyle:[String,Object]}),sr=E({name:"MessageProvider",props:ar,setup(e){const{mergedClsPrefixRef:o}=ee(e),t=k([]),r=k({}),n={create(i,a){return l(i,Object.assign({type:"default"},a))},info(i,a){return l(i,Object.assign(Object.assign({},a),{type:"info"}))},success(i,a){return l(i,Object.assign(Object.assign({},a),{type:"success"}))},warning(i,a){return l(i,Object.assign(Object.assign({},a),{type:"warning"}))},error(i,a){return l(i,Object.assign(Object.assign({},a),{type:"error"}))},loading(i,a){return l(i,Object.assign(Object.assign({},a),{type:"loading"}))},destroyAll:c};U(vo,{props:e,mergedClsPrefixRef:o}),U(lt,n);function l(i,a){const p=uo(),g=_o(Object.assign(Object.assign({},a),{content:i,key:p,destroy:()=>{var R;(R=r.value[p])===null||R===void 0||R.hide()}})),{max:m}=e;return m&&t.value.length>=m&&t.value.shift(),t.value.push(g),g}function d(i){t.value.splice(t.value.findIndex(a=>a.key===i),1),delete r.value[i]}function c(){Object.values(r.value).forEach(i=>{i.hide()})}return Object.assign({mergedClsPrefix:o,messageRefs:r,messageList:t,handleAfterLeave:d},n)},render(){var e,o,t;return v(to,null,(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e),this.messageList.length?v(Po,{to:(t=this.to)!==null&&t!==void 0?t:"body"},v("div",{class:[`${this.mergedClsPrefix}-message-container`,`${this.mergedClsPrefix}-message-container--${this.placement}`,this.containerClass],key:"message-container",style:this.containerStyle},this.messageList.map(r=>v(lr,Object.assign({ref:n=>{n&&(this.messageRefs[r.key]=n)},internalKey:r.key,onInternalAfterLeave:this.handleAfterLeave},it(r,["destroy"],void 0),{duration:r.duration===void 0?this.duration:r.duration,keepAliveOnHover:r.keepAliveOnHover===void 0?this.keepAliveOnHover:r.keepAliveOnHover,closable:r.closable===void 0?this.closable:r.closable}))))):null)}}),cr={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},dr=no("path",{d:"M352 48H160a48 48 0 0 0-48 48v368l144-128l144 128V96a48 48 0 0 0-48-48z",fill:"none",stroke:"currentColor","stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"32"},null,-1),ur=[dr],vr=E({name:"BookmarkOutline",render:function(o,t){return Oe(),ro("svg",cr,ur)}}),mr={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},fr=no("path",{d:"M98 190.06l139.78 163.12a24 24 0 0 0 36.44 0L414 190.06c13.34-15.57 2.28-39.62-18.22-39.62h-279.6c-20.5 0-31.56 24.05-18.18 39.62z",fill:"currentColor"},null,-1),hr=[fr],gr=E({name:"CaretDownOutline",render:function(o,t){return Oe(),ro("svg",mr,hr)}});const pr={__name:"index",setup(e){let o=No();To();let t=k(!1),r=k([]);const n=k([]);let l=g=>{o.push({name:g})},d=()=>{localStorage.removeItem("jwt"),localStorage.removeItem("author"),window.location.href="/"};const c={common:{primaryColor:"#3a94f1"}};let i=g=>"href"in g?v("a",{href:g.href,target:"_blank"},g.label):g.label,a=g=>g.key==="sheep-man"?!0:g.key==="food"?null:v(Xe,null,{default:()=>v(vr)}),p=()=>v(Xe,null,{default:()=>v(gr)});return _e(()=>{let g=o.getRoutes().filter(m=>{if(m.name=="admin")return m});r.value=g[0].children;for(let m of r.value)m.mate.isM&&n.value.push({label:m.mate.name,key:m.mate.key,name:m.name})}),(g,m)=>{const R=ko("router-view");return Oe(),Bo(N(xt),{"theme-overrides":c,style:{height:"100%",position:"relative"}},{default:V(()=>[F(N(sr),null,{default:V(()=>[F(N(Re),{position:"absolute"},{default:V(()=>[F(N(Mt),{class:"admin-nav",style:{height:"50px",padding:"15px"},bordered:""},{default:V(()=>[F(N(St),{"x-gap":"12",cols:3},{default:V(()=>[F(N(Je),{span:2},{default:V(()=>[F(N(Se),{text:"",onClick:m[0]||(m[0]=u=>ue(t)?t.value=!N(t):t=!N(t)),color:"#ffffff"},{default:V(()=>[Ce(" 内容管理系统 ")]),_:1}),F(N(Se),{text:"",onClick:m[1]||(m[1]=u=>ue(t)?t.value=!N(t):t=!N(t)),color:"#ffffff",style:{"margin-left":"15px"}},{default:V(()=>[Ce(Eo(N(t)?"展开":"关闭"),1)]),_:1})]),_:1}),F(N(Je),{style:{"text-align":"right"}},{default:V(()=>[F(N(Se),{text:"",onClick:N(d),color:"#ffffff"},{default:V(()=>[Ce("退出")]),_:1},8,["onClick"])]),_:1})]),_:1})]),_:1}),F(N(Re),{"has-sider":"",position:"absolute",style:{top:"50px"}},{default:V(()=>[F(N(Gt),{bordered:"","collapse-mode":"width","collapsed-width":54,width:180,collapsed:N(t),"show-trigger":"",onCollapse:m[2]||(m[2]=u=>ue(t)?t.value=!0:t=!0),onExpand:m[3]||(m[3]=u=>ue(t)?t.value=!1:t=!1)},{default:V(()=>[F(N(or),{"onUpdate:value":N(l),collapsed:N(t),"collapsed-width":50,"collapsed-icon-size":22,options:n.value,"render-label":N(i),"render-icon":N(a),"expand-icon":N(p)},null,8,["onUpdate:value","collapsed","options","render-label","render-icon","expand-icon"])]),_:1},8,["collapsed"]),F(N(Re),{"content-style":"padding: 10px;"},{default:V(()=>[F(R)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})}}},wr=Oo(pr,[["__scopeId","data-v-82e5a10b"]]);export{wr as default};
