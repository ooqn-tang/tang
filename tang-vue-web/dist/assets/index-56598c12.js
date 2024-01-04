import{v as De,c as x,a as j,f as mo,d as k,h as m,i as D,R as Pe,p as V,S as fo,H as be,U as J,m as Oe,V as _e,F as Ve,w as Te,T as ho,b as go,s as xe,t as Ke,x as Ge,G as po,O as bo,u as xo,q as Co,L as yo,A as M,z as T,j as E,k as ne,C as de,D as Io}from"./preload-helper-d757ddc9.js";import{c as z,a as wo,b as Ne,m as So,d as ke,e as zo,w as Ro,f as Z,u as X,g as Ce,h as We,i as Be,j as ue,k as C,l as O,n as G,o as te,p as b,q as ve,r as ie,N as je}from"./admin-494be706.js";import{i as Ho,u as W,p as Q,a as Ao,V as $o,b as Po,f as Oo,g as _o,s as To,t as No,d as ko,c as Ue,N as qe,e as ye,C as Bo,h as pe,j as F,r as Y,k as jo,l as Ye,m as Lo,n as me,o as Ie,q as Eo,v as Mo,w as Fo,x as Do,y as U,z as Vo,A as Ko,B as Go,D as Wo,E as Uo,F as fe}from"./Dropdown-2f5d58b1.js";import{m as Xe,a as qo}from"./context-9971e9ce.js";import{I as Yo,S as Xo,W as Qo,E as Jo}from"./Warning-dab8122f.js";function Zo(e){if(typeof e=="number")return{"":e.toString()};const o={};return e.split(/ +/).forEach(t=>{if(t==="")return;const[r,n]=t.split(":");n===void 0?o[""]=r:o[r]=n}),o}function ee(e,o){var t;if(e==null)return;const r=Zo(e);if(o===void 0)return r[""];if(typeof o=="string")return(t=r[o])!==null&&t!==void 0?t:r[""];if(Array.isArray(o)){for(let n=o.length-1;n>=0;--n){const l=o[n];if(l in r)return r[l]}return r[""]}else{let n,l=-1;return Object.keys(r).forEach(u=>{const c=Number(u);!Number.isNaN(c)&&o>=c&&c>=l&&(l=c,n=r[u])}),n}}function et(e){var o;const t=(o=e.dirs)===null||o===void 0?void 0:o.find(({dir:r})=>r===De);return!!(t&&t.value===!1)}const ot={xs:0,s:640,m:1024,l:1280,xl:1536,"2xl":1920};function tt(e){return`(min-width: ${e}px)`}const oe={};function rt(e=ot){if(!Ho)return x(()=>[]);if(typeof window.matchMedia!="function")return x(()=>[]);const o=j({}),t=Object.keys(e),r=(n,l)=>{n.matches?o.value[l]=!0:o.value[l]=!1};return t.forEach(n=>{const l=e[n];let u,c;oe[l]===void 0?(u=window.matchMedia(tt(l)),u.addEventListener?u.addEventListener("change",i=>{c.forEach(a=>{a(i,n)})}):u.addListener&&u.addListener(i=>{c.forEach(a=>{a(i,n)})}),c=new Set,oe[l]={mql:u,cbs:c}):(u=oe[l].mql,c=oe[l].cbs),c.add(r),u.matches&&c.forEach(i=>{i(u,n)})}),mo(()=>{t.forEach(n=>{const{cbs:l}=oe[e[n]];l.has(r)&&l.delete(r)})}),x(()=>{const{value:n}=o;return t.filter(l=>n[l])})}const nt=k({name:"ChevronDownFilled",render(){return m("svg",{viewBox:"0 0 16 16",fill:"none",xmlns:"http://www.w3.org/2000/svg"},m("path",{d:"M3.20041 5.73966C3.48226 5.43613 3.95681 5.41856 4.26034 5.70041L8 9.22652L11.7397 5.70041C12.0432 5.41856 12.5177 5.43613 12.7996 5.73966C13.0815 6.0432 13.0639 6.51775 12.7603 6.7996L8.51034 10.7996C8.22258 11.0668 7.77743 11.0668 7.48967 10.7996L3.23966 6.7996C2.93613 6.51775 2.91856 6.0432 3.20041 5.73966Z",fill:"currentColor"}))}}),{cubicBezierEaseInOut:K,cubicBezierEaseOut:it,cubicBezierEaseIn:lt}=wo;function Qe({overflow:e="hidden",duration:o=".3s",originalTransition:t="",leavingDelay:r="0s",foldPadding:n=!1,enterToProps:l=void 0,leaveToProps:u=void 0,reverse:c=!1}={}){const i=c?"leave":"enter",a=c?"enter":"leave";return[z(`&.fade-in-height-expand-transition-${a}-from,
 &.fade-in-height-expand-transition-${i}-to`,Object.assign(Object.assign({},l),{opacity:1})),z(`&.fade-in-height-expand-transition-${a}-to,
 &.fade-in-height-expand-transition-${i}-from`,Object.assign(Object.assign({},u),{opacity:0,marginTop:"0 !important",marginBottom:"0 !important",paddingTop:n?"0 !important":void 0,paddingBottom:n?"0 !important":void 0})),z(`&.fade-in-height-expand-transition-${a}-active`,`
 overflow: ${e};
 transition:
 max-height ${o} ${K} ${r},
 opacity ${o} ${it} ${r},
 margin-top ${o} ${K} ${r},
 margin-bottom ${o} ${K} ${r},
 padding-top ${o} ${K} ${r},
 padding-bottom ${o} ${K} ${r}
 ${t?","+t:""}
 `),z(`&.fade-in-height-expand-transition-${i}-active`,`
 overflow: ${e};
 transition:
 max-height ${o} ${K},
 opacity ${o} ${lt},
 margin-top ${o} ${K},
 margin-bottom ${o} ${K},
 padding-top ${o} ${K},
 padding-bottom ${o} ${K}
 ${t?","+t:""}
 `)]}const at={abstract:Boolean,bordered:{type:Boolean,default:void 0},clsPrefix:String,locale:Object,dateLocale:Object,namespace:String,rtl:Array,tag:{type:String,default:"div"},hljs:Object,katex:Object,theme:Object,themeOverrides:Object,componentOptions:Object,icons:Object,breakpoints:Object,preflightStyleDisabled:Boolean,inlineThemeDisabled:{type:Boolean,default:void 0},as:{type:String,validator:()=>(Ro("config-provider","`as` is deprecated, please use `tag` instead."),!0),default:void 0}},st=k({name:"ConfigProvider",alias:["App"],props:at,setup(e){const o=D(Ne,null),t=x(()=>{const{theme:d}=e;if(d===null)return;const h=o==null?void 0:o.mergedThemeRef.value;return d===void 0?h:h===void 0?d:Object.assign({},h,d)}),r=x(()=>{const{themeOverrides:d}=e;if(d!==null){if(d===void 0)return o==null?void 0:o.mergedThemeOverridesRef.value;{const h=o==null?void 0:o.mergedThemeOverridesRef.value;return h===void 0?d:So({},h,d)}}}),n=W(()=>{const{namespace:d}=e;return d===void 0?o==null?void 0:o.mergedNamespaceRef.value:d}),l=W(()=>{const{bordered:d}=e;return d===void 0?o==null?void 0:o.mergedBorderedRef.value:d}),u=x(()=>{const{icons:d}=e;return d===void 0?o==null?void 0:o.mergedIconsRef.value:d}),c=x(()=>{const{componentOptions:d}=e;return d!==void 0?d:o==null?void 0:o.mergedComponentPropsRef.value}),i=x(()=>{const{clsPrefix:d}=e;return d!==void 0?d:o==null?void 0:o.mergedClsPrefixRef.value}),a=x(()=>{var d;const{rtl:h}=e;if(h===void 0)return o==null?void 0:o.mergedRtlRef.value;const I={};for(const y of h)I[y.name]=Pe(y),(d=y.peers)===null||d===void 0||d.forEach(P=>{P.name in I||(I[P.name]=Pe(P))});return I}),p=x(()=>e.breakpoints||(o==null?void 0:o.mergedBreakpointsRef.value)),g=e.inlineThemeDisabled||(o==null?void 0:o.inlineThemeDisabled),f=e.preflightStyleDisabled||(o==null?void 0:o.preflightStyleDisabled),H=x(()=>{const{value:d}=t,{value:h}=r,I=h&&Object.keys(h).length!==0,y=d==null?void 0:d.name;return y?I?`${y}-${ke(JSON.stringify(r.value))}`:y:I?ke(JSON.stringify(r.value)):""});return V(Ne,{mergedThemeHashRef:H,mergedBreakpointsRef:p,mergedRtlRef:a,mergedIconsRef:u,mergedComponentPropsRef:c,mergedBorderedRef:l,mergedNamespaceRef:n,mergedClsPrefixRef:i,mergedLocaleRef:x(()=>{const{locale:d}=e;if(d!==null)return d===void 0?o==null?void 0:o.mergedLocaleRef.value:d}),mergedDateLocaleRef:x(()=>{const{dateLocale:d}=e;if(d!==null)return d===void 0?o==null?void 0:o.mergedDateLocaleRef.value:d}),mergedHljsRef:x(()=>{const{hljs:d}=e;return d===void 0?o==null?void 0:o.mergedHljsRef.value:d}),mergedKatexRef:x(()=>{const{katex:d}=e;return d===void 0?o==null?void 0:o.mergedKatexRef.value:d}),mergedThemeRef:t,mergedThemeOverridesRef:r,inlineThemeDisabled:g||!1,preflightStyleDisabled:f||!1}),{mergedClsPrefix:i,mergedBordered:l,mergedNamespace:n,mergedTheme:t,mergedThemeOverrides:r}},render(){var e,o,t,r;return this.abstract?(r=(t=this.$slots).default)===null||r===void 0?void 0:r.call(t):m(this.as||this.tag,{class:`${this.mergedClsPrefix||zo}-config-provider`},(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e))}}),Le=1,Je=Z("n-grid"),Ze=1,ct={span:{type:[Number,String],default:Ze},offset:{type:[Number,String],default:0},suffix:Boolean,privateOffset:Number,privateSpan:Number,privateColStart:Number,privateShow:{type:Boolean,default:!0}},Ee=k({__GRID_ITEM__:!0,name:"GridItem",alias:["Gi"],props:ct,setup(){const{isSsrRef:e,xGapRef:o,itemStyleRef:t,overflowRef:r,layoutShiftDisabledRef:n}=D(Je),l=fo();return{overflow:r,itemStyle:t,layoutShiftDisabled:n,mergedXGap:x(()=>Q(o.value||0)),deriveStyle:()=>{e.value;const{privateSpan:u=Ze,privateShow:c=!0,privateColStart:i=void 0,privateOffset:a=0}=l.vnode.props,{value:p}=o,g=Q(p||0);return{display:c?"":"none",gridColumn:`${i??`span ${u}`} / span ${u}`,marginLeft:a?`calc((100% - (${u} - 1) * ${g}) / ${u} * ${a} + ${g} * ${a})`:""}}}},render(){var e,o;if(this.layoutShiftDisabled){const{span:t,offset:r,mergedXGap:n}=this;return m("div",{style:{gridColumn:`span ${t} / span ${t}`,marginLeft:r?`calc((100% - (${t} - 1) * ${n}) / ${t} * ${r} + ${n} * ${r})`:""}},this.$slots)}return m("div",{style:[this.itemStyle,this.deriveStyle()]},(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e,{overflow:this.overflow}))}}),dt={xs:0,s:640,m:1024,l:1280,xl:1536,xxl:1920},eo=24,he="__ssr__",ut={layoutShiftDisabled:Boolean,responsive:{type:[String,Boolean],default:"self"},cols:{type:[Number,String],default:eo},itemResponsive:Boolean,collapsed:Boolean,collapsedRows:{type:Number,default:1},itemStyle:[Object,String],xGap:{type:[Number,String],default:0},yGap:{type:[Number,String],default:0}},vt=k({name:"Grid",inheritAttrs:!1,props:ut,setup(e){const{mergedClsPrefixRef:o,mergedBreakpointsRef:t}=X(e),r=/^\d+$/,n=j(void 0),l=rt((t==null?void 0:t.value)||dt),u=W(()=>!!(e.itemResponsive||!r.test(e.cols.toString())||!r.test(e.xGap.toString())||!r.test(e.yGap.toString()))),c=x(()=>{if(u.value)return e.responsive==="self"?n.value:l.value}),i=W(()=>{var y;return(y=Number(ee(e.cols.toString(),c.value)))!==null&&y!==void 0?y:eo}),a=W(()=>ee(e.xGap.toString(),c.value)),p=W(()=>ee(e.yGap.toString(),c.value)),g=y=>{n.value=y.contentRect.width},f=y=>{Po(g,y)},H=j(!1),d=x(()=>{if(e.responsive==="self")return f}),h=j(!1),I=j();return be(()=>{const{value:y}=I;y&&y.hasAttribute(he)&&(y.removeAttribute(he),h.value=!0)}),V(Je,{layoutShiftDisabledRef:J(e,"layoutShiftDisabled"),isSsrRef:h,itemStyleRef:J(e,"itemStyle"),xGapRef:a,overflowRef:H}),{isSsr:!Ao,contentEl:I,mergedClsPrefix:o,style:x(()=>e.layoutShiftDisabled?{width:"100%",display:"grid",gridTemplateColumns:`repeat(${e.cols}, minmax(0, 1fr))`,columnGap:Q(e.xGap),rowGap:Q(e.yGap)}:{width:"100%",display:"grid",gridTemplateColumns:`repeat(${i.value}, minmax(0, 1fr))`,columnGap:Q(a.value),rowGap:Q(p.value)}),isResponsive:u,responsiveQuery:c,responsiveCols:i,handleResize:d,overflow:H}},render(){if(this.layoutShiftDisabled)return m("div",Oe({ref:"contentEl",class:`${this.mergedClsPrefix}-grid`,style:this.style},this.$attrs),this.$slots);const e=()=>{var o,t,r,n,l,u,c;this.overflow=!1;const i=Oo(_o(this)),a=[],{collapsed:p,collapsedRows:g,responsiveCols:f,responsiveQuery:H}=this;i.forEach(P=>{var L,N,$,A;if(((L=P==null?void 0:P.type)===null||L===void 0?void 0:L.__GRID_ITEM__)!==!0)return;if(et(P)){const w=_e(P);w.props?w.props.privateShow=!1:w.props={privateShow:!1},a.push({child:w,rawChildSpan:0});return}P.dirs=((N=P.dirs)===null||N===void 0?void 0:N.filter(({dir:w})=>w!==De))||null;const _=_e(P),R=Number((A=ee(($=_.props)===null||$===void 0?void 0:$.span,H))!==null&&A!==void 0?A:Le);R!==0&&a.push({child:_,rawChildSpan:R})});let d=0;const h=(o=a[a.length-1])===null||o===void 0?void 0:o.child;if(h!=null&&h.props){const P=(t=h.props)===null||t===void 0?void 0:t.suffix;P!==void 0&&P!==!1&&(d=(n=(r=h.props)===null||r===void 0?void 0:r.span)!==null&&n!==void 0?n:Le,h.props.privateSpan=d,h.props.privateColStart=f+1-d,h.props.privateShow=(l=h.props.privateShow)!==null&&l!==void 0?l:!0)}let I=0,y=!1;for(const{child:P,rawChildSpan:L}of a){if(y&&(this.overflow=!0),!y){const N=Number((c=ee((u=P.props)===null||u===void 0?void 0:u.offset,H))!==null&&c!==void 0?c:0),$=Math.min(L+N,f);if(P.props?(P.props.privateSpan=$,P.props.privateOffset=N):P.props={privateSpan:$,privateOffset:N},p){const A=I%f;$+A>f&&(I+=f-A),$+I+d>g*f?y=!0:I+=$}}y&&(P.props?P.props.privateShow!==!0&&(P.props.privateShow=!1):P.props={privateShow:!1})}return m("div",Oe({ref:"contentEl",class:`${this.mergedClsPrefix}-grid`,style:this.style,[he]:this.isSsr||void 0},this.$attrs),a.map(({child:P})=>P))};return this.isResponsive&&this.responsive==="self"?m($o,{onResize:this.handleResize},{default:e}):e()}}),mt={margin:"0 0 8px 0",padding:"10px 20px",maxWidth:"720px",minWidth:"420px",iconMargin:"0 10px 0 0",closeMargin:"0 0 0 10px",closeSize:"20px",closeIconSize:"16px",iconSize:"20px",fontSize:"14px"},ft=e=>{const{textColor2:o,closeIconColor:t,closeIconColorHover:r,closeIconColorPressed:n,infoColor:l,successColor:u,errorColor:c,warningColor:i,popoverColor:a,boxShadow2:p,primaryColor:g,lineHeight:f,borderRadius:H,closeColorHover:d,closeColorPressed:h}=e;return Object.assign(Object.assign({},mt),{closeBorderRadius:H,textColor:o,textColorInfo:o,textColorSuccess:o,textColorError:o,textColorWarning:o,textColorLoading:o,color:a,colorInfo:a,colorSuccess:a,colorError:a,colorWarning:a,colorLoading:a,boxShadow:p,boxShadowInfo:p,boxShadowSuccess:p,boxShadowError:p,boxShadowWarning:p,boxShadowLoading:p,iconColor:o,iconColorInfo:l,iconColorSuccess:u,iconColorWarning:i,iconColorError:c,iconColorLoading:g,closeColorHover:d,closeColorPressed:h,closeIconColor:t,closeIconColorHover:r,closeIconColorPressed:n,closeColorHoverInfo:d,closeColorPressedInfo:h,closeIconColorInfo:t,closeIconColorHoverInfo:r,closeIconColorPressedInfo:n,closeColorHoverSuccess:d,closeColorPressedSuccess:h,closeIconColorSuccess:t,closeIconColorHoverSuccess:r,closeIconColorPressedSuccess:n,closeColorHoverError:d,closeColorPressedError:h,closeIconColorError:t,closeIconColorHoverError:r,closeIconColorPressedError:n,closeColorHoverWarning:d,closeColorPressedWarning:h,closeIconColorWarning:t,closeIconColorHoverWarning:r,closeIconColorPressedWarning:n,closeColorHoverLoading:d,closeColorPressedLoading:h,closeIconColorLoading:t,closeIconColorHoverLoading:r,closeIconColorPressedLoading:n,loadingColor:g,lineHeight:f,borderRadius:H})},ht={name:"Message",common:Ce,self:ft},gt=ht,pt=e=>{const{baseColor:o,textColor2:t,bodyColor:r,cardColor:n,dividerColor:l,actionColor:u,scrollbarColor:c,scrollbarColorHover:i,invertedColor:a}=e;return{textColor:t,textColorInverted:"#FFF",color:r,colorEmbedded:u,headerColor:n,headerColorInverted:a,footerColor:u,footerColorInverted:a,headerBorderColor:l,headerBorderColorInverted:a,footerBorderColor:l,footerBorderColorInverted:a,siderBorderColor:l,siderBorderColorInverted:a,siderColor:n,siderColorInverted:a,siderToggleButtonBorder:`1px solid ${l}`,siderToggleButtonColor:o,siderToggleButtonIconColor:t,siderToggleButtonIconColorInverted:t,siderToggleBarColor:Be(r,c),siderToggleBarColorHover:Be(r,i),__invertScrollbar:"true"}},bt=We({name:"Layout",common:Ce,peers:{Scrollbar:To},self:pt}),we=bt;function xt(e,o,t,r){return{itemColorHoverInverted:"#0000",itemColorActiveInverted:o,itemColorActiveHoverInverted:o,itemColorActiveCollapsedInverted:o,itemTextColorInverted:e,itemTextColorHoverInverted:t,itemTextColorChildActiveInverted:t,itemTextColorChildActiveHoverInverted:t,itemTextColorActiveInverted:t,itemTextColorActiveHoverInverted:t,itemTextColorHorizontalInverted:e,itemTextColorHoverHorizontalInverted:t,itemTextColorChildActiveHorizontalInverted:t,itemTextColorChildActiveHoverHorizontalInverted:t,itemTextColorActiveHorizontalInverted:t,itemTextColorActiveHoverHorizontalInverted:t,itemIconColorInverted:e,itemIconColorHoverInverted:t,itemIconColorActiveInverted:t,itemIconColorActiveHoverInverted:t,itemIconColorChildActiveInverted:t,itemIconColorChildActiveHoverInverted:t,itemIconColorCollapsedInverted:e,itemIconColorHorizontalInverted:e,itemIconColorHoverHorizontalInverted:t,itemIconColorActiveHorizontalInverted:t,itemIconColorActiveHoverHorizontalInverted:t,itemIconColorChildActiveHorizontalInverted:t,itemIconColorChildActiveHoverHorizontalInverted:t,arrowColorInverted:e,arrowColorHoverInverted:t,arrowColorActiveInverted:t,arrowColorActiveHoverInverted:t,arrowColorChildActiveInverted:t,arrowColorChildActiveHoverInverted:t,groupTextColorInverted:r}}const Ct=e=>{const{borderRadius:o,textColor3:t,primaryColor:r,textColor2:n,textColor1:l,fontSize:u,dividerColor:c,hoverColor:i,primaryColorHover:a}=e;return Object.assign({borderRadius:o,color:"#0000",groupTextColor:t,itemColorHover:i,itemColorActive:ue(r,{alpha:.1}),itemColorActiveHover:ue(r,{alpha:.1}),itemColorActiveCollapsed:ue(r,{alpha:.1}),itemTextColor:n,itemTextColorHover:n,itemTextColorActive:r,itemTextColorActiveHover:r,itemTextColorChildActive:r,itemTextColorChildActiveHover:r,itemTextColorHorizontal:n,itemTextColorHoverHorizontal:a,itemTextColorActiveHorizontal:r,itemTextColorActiveHoverHorizontal:r,itemTextColorChildActiveHorizontal:r,itemTextColorChildActiveHoverHorizontal:r,itemIconColor:l,itemIconColorHover:l,itemIconColorActive:r,itemIconColorActiveHover:r,itemIconColorChildActive:r,itemIconColorChildActiveHover:r,itemIconColorCollapsed:l,itemIconColorHorizontal:l,itemIconColorHoverHorizontal:a,itemIconColorActiveHorizontal:r,itemIconColorActiveHoverHorizontal:r,itemIconColorChildActiveHorizontal:r,itemIconColorChildActiveHoverHorizontal:r,itemHeight:"42px",arrowColor:n,arrowColorHover:n,arrowColorActive:r,arrowColorActiveHover:r,arrowColorChildActive:r,arrowColorChildActiveHover:r,colorInverted:"#0000",borderColorHorizontal:"#0000",fontSize:u,dividerColor:c},xt("#BBB",r,"#FFF","#AAA"))},yt=We({name:"Menu",common:Ce,peers:{Tooltip:No,Dropdown:ko},self:Ct}),It=yt,oo=Z("n-layout-sider"),Se={type:String,default:"static"},wt=C("layout",`
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
`,[C("layout-scroll-container",`
 overflow-x: hidden;
 box-sizing: border-box;
 height: 100%;
 `),O("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `)]),St={embedded:Boolean,position:Se,nativeScrollbar:{type:Boolean,default:!0},scrollbarProps:Object,onScroll:Function,contentStyle:{type:[String,Object],default:""},hasSider:Boolean,siderPlacement:{type:String,default:"left"}},to=Z("n-layout");function zt(e){return k({name:e?"LayoutContent":"Layout",props:Object.assign(Object.assign({},G.props),St),setup(o){const t=j(null),r=j(null),{mergedClsPrefixRef:n,inlineThemeDisabled:l}=X(o),u=G("Layout","-layout",wt,we,o,n);function c(h,I){if(o.nativeScrollbar){const{value:y}=t;y&&(I===void 0?y.scrollTo(h):y.scrollTo(h,I))}else{const{value:y}=r;y&&y.scrollTo(h,I)}}V(to,o);let i=0,a=0;const p=h=>{var I;const y=h.target;i=y.scrollLeft,a=y.scrollTop,(I=o.onScroll)===null||I===void 0||I.call(o,h)};Ue(()=>{if(o.nativeScrollbar){const h=t.value;h&&(h.scrollTop=a,h.scrollLeft=i)}});const g={display:"flex",flexWrap:"nowrap",width:"100%",flexDirection:"row"},f={scrollTo:c},H=x(()=>{const{common:{cubicBezierEaseInOut:h},self:I}=u.value;return{"--n-bezier":h,"--n-color":o.embedded?I.colorEmbedded:I.color,"--n-text-color":I.textColor}}),d=l?te("layout",x(()=>o.embedded?"e":""),H,o):void 0;return Object.assign({mergedClsPrefix:n,scrollableElRef:t,scrollbarInstRef:r,hasSiderStyle:g,mergedTheme:u,handleNativeElScroll:p,cssVars:l?void 0:H,themeClass:d==null?void 0:d.themeClass,onRender:d==null?void 0:d.onRender},f)},render(){var o;const{mergedClsPrefix:t,hasSider:r}=this;(o=this.onRender)===null||o===void 0||o.call(this);const n=r?this.hasSiderStyle:void 0,l=[this.themeClass,e&&`${t}-layout-content`,`${t}-layout`,`${t}-layout--${this.position}-positioned`];return m("div",{class:l,style:this.cssVars},this.nativeScrollbar?m("div",{ref:"scrollableElRef",class:`${t}-layout-scroll-container`,style:[this.contentStyle,n],onScroll:this.handleNativeElScroll},this.$slots):m(qe,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,contentStyle:[this.contentStyle,n]}),this.$slots))}})}const ge=zt(!1),Rt=C("layout-header",`
 transition:
 color .3s var(--n-bezier),
 background-color .3s var(--n-bezier),
 box-shadow .3s var(--n-bezier),
 border-color .3s var(--n-bezier);
 box-sizing: border-box;
 width: 100%;
 background-color: var(--n-color);
 color: var(--n-text-color);
`,[O("absolute-positioned",`
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 `),O("bordered",`
 border-bottom: solid 1px var(--n-border-color);
 `)]),Ht={position:Se,inverted:Boolean,bordered:{type:Boolean,default:!1}},At=k({name:"LayoutHeader",props:Object.assign(Object.assign({},G.props),Ht),setup(e){const{mergedClsPrefixRef:o,inlineThemeDisabled:t}=X(e),r=G("Layout","-layout-header",Rt,we,e,o),n=x(()=>{const{common:{cubicBezierEaseInOut:u},self:c}=r.value,i={"--n-bezier":u};return e.inverted?(i["--n-color"]=c.headerColorInverted,i["--n-text-color"]=c.textColorInverted,i["--n-border-color"]=c.headerBorderColorInverted):(i["--n-color"]=c.headerColor,i["--n-text-color"]=c.textColor,i["--n-border-color"]=c.headerBorderColor),i}),l=t?te("layout-header",x(()=>e.inverted?"a":"b"),n,e):void 0;return{mergedClsPrefix:o,cssVars:t?void 0:n,themeClass:l==null?void 0:l.themeClass,onRender:l==null?void 0:l.onRender}},render(){var e;const{mergedClsPrefix:o}=this;return(e=this.onRender)===null||e===void 0||e.call(this),m("div",{class:[`${o}-layout-header`,this.themeClass,this.position&&`${o}-layout-header--${this.position}-positioned`,this.bordered&&`${o}-layout-header--bordered`],style:this.cssVars},this.$slots)}}),$t=C("layout-sider",`
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
`,[O("bordered",[b("border",`
 content: "";
 position: absolute;
 top: 0;
 bottom: 0;
 width: 1px;
 background-color: var(--n-border-color);
 transition: background-color .3s var(--n-bezier);
 `)]),b("left-placement",[O("bordered",[b("border",`
 right: 0;
 `)])]),O("right-placement",`
 justify-content: flex-start;
 `,[O("bordered",[b("border",`
 left: 0;
 `)]),O("collapsed",[C("layout-toggle-button",[C("base-icon",`
 transform: rotate(180deg);
 `)]),C("layout-toggle-bar",[z("&:hover",[b("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),b("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])])]),C("layout-toggle-button",`
 left: 0;
 transform: translateX(-50%) translateY(-50%);
 `,[C("base-icon",`
 transform: rotate(0);
 `)]),C("layout-toggle-bar",`
 left: -28px;
 transform: rotate(180deg);
 `,[z("&:hover",[b("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),b("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})])])]),O("collapsed",[C("layout-toggle-bar",[z("&:hover",[b("top",{transform:"rotate(-12deg) scale(1.15) translateY(-2px)"}),b("bottom",{transform:"rotate(12deg) scale(1.15) translateY(2px)"})])]),C("layout-toggle-button",[C("base-icon",`
 transform: rotate(0);
 `)])]),C("layout-toggle-button",`
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
 `,[C("base-icon",`
 transition: transform .3s var(--n-bezier);
 transform: rotate(180deg);
 `)]),C("layout-toggle-bar",`
 cursor: pointer;
 height: 72px;
 width: 32px;
 position: absolute;
 top: calc(50% - 36px);
 right: -28px;
 `,[b("top, bottom",`
 position: absolute;
 width: 4px;
 border-radius: 2px;
 height: 38px;
 left: 14px;
 transition: 
 background-color .3s var(--n-bezier),
 transform .3s var(--n-bezier);
 `),b("bottom",`
 position: absolute;
 top: 34px;
 `),z("&:hover",[b("top",{transform:"rotate(12deg) scale(1.15) translateY(-2px)"}),b("bottom",{transform:"rotate(-12deg) scale(1.15) translateY(2px)"})]),b("top, bottom",{backgroundColor:"var(--n-toggle-bar-color)"}),z("&:hover",[b("top, bottom",{backgroundColor:"var(--n-toggle-bar-color-hover)"})])]),b("border",`
 position: absolute;
 top: 0;
 right: 0;
 bottom: 0;
 width: 1px;
 transition: background-color .3s var(--n-bezier);
 `),C("layout-sider-scroll-container",`
 flex-grow: 1;
 flex-shrink: 0;
 box-sizing: border-box;
 height: 100%;
 opacity: 0;
 transition: opacity .3s var(--n-bezier);
 max-width: 100%;
 `),O("show-content",[C("layout-sider-scroll-container",{opacity:1})]),O("absolute-positioned",`
 position: absolute;
 left: 0;
 top: 0;
 bottom: 0;
 `)]),Pt=k({name:"LayoutToggleButton",props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return m("div",{class:`${e}-layout-toggle-button`,onClick:this.onClick},m(ye,{clsPrefix:e},{default:()=>m(Bo,null)}))}}),Ot=k({props:{clsPrefix:{type:String,required:!0},onClick:Function},render(){const{clsPrefix:e}=this;return m("div",{onClick:this.onClick,class:`${e}-layout-toggle-bar`},m("div",{class:`${e}-layout-toggle-bar__top`}),m("div",{class:`${e}-layout-toggle-bar__bottom`}))}}),_t={position:Se,bordered:Boolean,collapsedWidth:{type:Number,default:48},width:{type:[Number,String],default:272},contentStyle:{type:[String,Object],default:""},collapseMode:{type:String,default:"transform"},collapsed:{type:Boolean,default:void 0},defaultCollapsed:Boolean,showCollapsedContent:{type:Boolean,default:!0},showTrigger:{type:[Boolean,String],default:!1},nativeScrollbar:{type:Boolean,default:!0},inverted:Boolean,scrollbarProps:Object,triggerStyle:[String,Object],collapsedTriggerStyle:[String,Object],"onUpdate:collapsed":[Function,Array],onUpdateCollapsed:[Function,Array],onAfterEnter:Function,onAfterLeave:Function,onExpand:[Function,Array],onCollapse:[Function,Array],onScroll:Function},Tt=k({name:"LayoutSider",props:Object.assign(Object.assign({},G.props),_t),setup(e){const o=D(to),t=j(null),r=j(null),n=x(()=>ve(i.value?e.collapsedWidth:e.width)),l=x(()=>e.collapseMode!=="transform"?{}:{minWidth:ve(e.width)}),u=x(()=>o?o.siderPlacement:"left"),c=j(e.defaultCollapsed),i=pe(J(e,"collapsed"),c);function a($,A){if(e.nativeScrollbar){const{value:_}=t;_&&(A===void 0?_.scrollTo($):_.scrollTo($,A))}else{const{value:_}=r;_&&_.scrollTo($,A)}}function p(){const{"onUpdate:collapsed":$,onUpdateCollapsed:A,onExpand:_,onCollapse:R}=e,{value:w}=i;A&&F(A,!w),$&&F($,!w),c.value=!w,w?_&&F(_):R&&F(R)}let g=0,f=0;const H=$=>{var A;const _=$.target;g=_.scrollLeft,f=_.scrollTop,(A=e.onScroll)===null||A===void 0||A.call(e,$)};Ue(()=>{if(e.nativeScrollbar){const $=t.value;$&&($.scrollTop=f,$.scrollLeft=g)}}),V(oo,{collapsedRef:i,collapseModeRef:J(e,"collapseMode")});const{mergedClsPrefixRef:d,inlineThemeDisabled:h}=X(e),I=G("Layout","-layout-sider",$t,we,e,d);function y($){var A,_;$.propertyName==="max-width"&&(i.value?(A=e.onAfterLeave)===null||A===void 0||A.call(e):(_=e.onAfterEnter)===null||_===void 0||_.call(e))}const P={scrollTo:a},L=x(()=>{const{common:{cubicBezierEaseInOut:$},self:A}=I.value,{siderToggleButtonColor:_,siderToggleButtonBorder:R,siderToggleBarColor:w,siderToggleBarColorHover:s}=A,S={"--n-bezier":$,"--n-toggle-button-color":_,"--n-toggle-button-border":R,"--n-toggle-bar-color":w,"--n-toggle-bar-color-hover":s};return e.inverted?(S["--n-color"]=A.siderColorInverted,S["--n-text-color"]=A.textColorInverted,S["--n-border-color"]=A.siderBorderColorInverted,S["--n-toggle-button-icon-color"]=A.siderToggleButtonIconColorInverted,S.__invertScrollbar=A.__invertScrollbar):(S["--n-color"]=A.siderColor,S["--n-text-color"]=A.textColor,S["--n-border-color"]=A.siderBorderColor,S["--n-toggle-button-icon-color"]=A.siderToggleButtonIconColor),S}),N=h?te("layout-sider",x(()=>e.inverted?"a":"b"),L,e):void 0;return Object.assign({scrollableElRef:t,scrollbarInstRef:r,mergedClsPrefix:d,mergedTheme:I,styleMaxWidth:n,mergedCollapsed:i,scrollContainerStyle:l,siderPlacement:u,handleNativeElScroll:H,handleTransitionend:y,handleTriggerClick:p,inlineThemeDisabled:h,cssVars:L,themeClass:N==null?void 0:N.themeClass,onRender:N==null?void 0:N.onRender},P)},render(){var e;const{mergedClsPrefix:o,mergedCollapsed:t,showTrigger:r}=this;return(e=this.onRender)===null||e===void 0||e.call(this),m("aside",{class:[`${o}-layout-sider`,this.themeClass,`${o}-layout-sider--${this.position}-positioned`,`${o}-layout-sider--${this.siderPlacement}-placement`,this.bordered&&`${o}-layout-sider--bordered`,t&&`${o}-layout-sider--collapsed`,(!t||this.showCollapsedContent)&&`${o}-layout-sider--show-content`],onTransitionend:this.handleTransitionend,style:[this.inlineThemeDisabled?void 0:this.cssVars,{maxWidth:this.styleMaxWidth,width:ve(this.width)}]},this.nativeScrollbar?m("div",{class:`${o}-layout-sider-scroll-container`,onScroll:this.handleNativeElScroll,style:[this.scrollContainerStyle,{overflow:"auto"},this.contentStyle],ref:"scrollableElRef"},this.$slots):m(qe,Object.assign({},this.scrollbarProps,{onScroll:this.onScroll,ref:"scrollbarInstRef",style:this.scrollContainerStyle,contentStyle:this.contentStyle,theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar,builtinThemeOverrides:this.inverted&&this.cssVars.__invertScrollbar==="true"?{colorHover:"rgba(255, 255, 255, .4)",color:"rgba(255, 255, 255, .3)"}:void 0}),this.$slots),r?r==="bar"?m(Ot,{clsPrefix:o,style:t?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):m(Pt,{clsPrefix:o,style:t?this.collapsedTriggerStyle:this.triggerStyle,onClick:this.handleTriggerClick}):null,this.bordered?m("div",{class:`${o}-layout-sider__border`}):null)}}),re=Z("n-menu"),ze=Z("n-submenu"),Re=Z("n-menu-item-group"),le=8;function He(e){const o=D(re),{props:t,mergedCollapsedRef:r}=o,n=D(ze,null),l=D(Re,null),u=x(()=>t.mode==="horizontal"),c=x(()=>u.value?t.dropdownPlacement:"tmNodes"in e?"right-start":"right"),i=x(()=>{var f;return Math.max((f=t.collapsedIconSize)!==null&&f!==void 0?f:t.iconSize,t.iconSize)}),a=x(()=>{var f;return!u.value&&e.root&&r.value&&(f=t.collapsedIconSize)!==null&&f!==void 0?f:t.iconSize}),p=x(()=>{if(u.value)return;const{collapsedWidth:f,indent:H,rootIndent:d}=t,{root:h,isGroup:I}=e,y=d===void 0?H:d;if(h)return r.value?f/2-i.value/2:y;if(l)return H/2+l.paddingLeftRef.value;if(n)return(I?H/2:H)+n.paddingLeftRef.value}),g=x(()=>{const{collapsedWidth:f,indent:H,rootIndent:d}=t,{value:h}=i,{root:I}=e;return u.value||!I||!r.value?le:(d===void 0?H:d)+h+le-(f+h)/2});return{dropdownPlacement:c,activeIconSize:a,maxIconSize:i,paddingLeft:p,iconMarginRight:g,NMenu:o,NSubmenu:n}}const Ae={internalKey:{type:[String,Number],required:!0},root:Boolean,isGroup:Boolean,level:{type:Number,required:!0},title:[String,Function],extra:[String,Function]},ro=Object.assign(Object.assign({},Ae),{tmNode:{type:Object,required:!0},tmNodes:{type:Array,required:!0}}),Nt=k({name:"MenuOptionGroup",props:ro,setup(e){V(ze,null);const o=He(e);V(Re,{paddingLeftRef:o.paddingLeft});const{mergedClsPrefixRef:t,props:r}=D(re);return function(){const{value:n}=t,l=o.paddingLeft.value,{nodeProps:u}=r,c=u==null?void 0:u(e.tmNode.rawNode);return m("div",{class:`${n}-menu-item-group`,role:"group"},m("div",Object.assign({},c,{class:[`${n}-menu-item-group-title`,c==null?void 0:c.class],style:[(c==null?void 0:c.style)||"",l!==void 0?`padding-left: ${l}px;`:""]}),Y(e.title),e.extra?m(Ve,null," ",Y(e.extra)):null),m("div",null,e.tmNodes.map(i=>$e(i,r))))}}}),no=k({name:"MenuOptionContent",props:{collapsed:Boolean,disabled:Boolean,title:[String,Function],icon:Function,extra:[String,Function],showArrow:Boolean,childActive:Boolean,hover:Boolean,paddingLeft:Number,selected:Boolean,maxIconSize:{type:Number,required:!0},activeIconSize:{type:Number,required:!0},iconMarginRight:{type:Number,required:!0},clsPrefix:{type:String,required:!0},onClick:Function,tmNode:{type:Object,required:!0}},setup(e){const{props:o}=D(re);return{menuProps:o,style:x(()=>{const{paddingLeft:t}=e;return{paddingLeft:t&&`${t}px`}}),iconStyle:x(()=>{const{maxIconSize:t,activeIconSize:r,iconMarginRight:n}=e;return{width:`${t}px`,height:`${t}px`,fontSize:`${r}px`,marginRight:`${n}px`}})}},render(){const{clsPrefix:e,tmNode:o,menuProps:{renderIcon:t,renderLabel:r,renderExtra:n,expandIcon:l}}=this,u=t?t(o.rawNode):Y(this.icon);return m("div",{onClick:c=>{var i;(i=this.onClick)===null||i===void 0||i.call(this,c)},role:"none",class:[`${e}-menu-item-content`,{[`${e}-menu-item-content--selected`]:this.selected,[`${e}-menu-item-content--collapsed`]:this.collapsed,[`${e}-menu-item-content--child-active`]:this.childActive,[`${e}-menu-item-content--disabled`]:this.disabled,[`${e}-menu-item-content--hover`]:this.hover}],style:this.style},u&&m("div",{class:`${e}-menu-item-content__icon`,style:this.iconStyle,role:"none"},[u]),m("div",{class:`${e}-menu-item-content-header`,role:"none"},r?r(o.rawNode):Y(this.title),this.extra||n?m("span",{class:`${e}-menu-item-content-header__extra`}," ",n?n(o.rawNode):Y(this.extra)):null),this.showArrow?m(ye,{ariaHidden:!0,class:`${e}-menu-item-content__arrow`,clsPrefix:e},{default:()=>l?l(o.rawNode):m(nt,null)}):null)}}),io=Object.assign(Object.assign({},Ae),{rawNodes:{type:Array,default:()=>[]},tmNodes:{type:Array,default:()=>[]},tmNode:{type:Object,required:!0},disabled:{type:Boolean,default:!1},icon:Function,onClick:Function}),kt=k({name:"Submenu",props:io,setup(e){const o=He(e),{NMenu:t,NSubmenu:r}=o,{props:n,mergedCollapsedRef:l,mergedThemeRef:u}=t,c=x(()=>{const{disabled:f}=e;return r!=null&&r.mergedDisabledRef.value||n.disabled?!0:f}),i=j(!1);V(ze,{paddingLeftRef:o.paddingLeft,mergedDisabledRef:c}),V(Re,null);function a(){const{onClick:f}=e;f&&f()}function p(){c.value||(l.value||t.toggleExpand(e.internalKey),a())}function g(f){i.value=f}return{menuProps:n,mergedTheme:u,doSelect:t.doSelect,inverted:t.invertedRef,isHorizontal:t.isHorizontalRef,mergedClsPrefix:t.mergedClsPrefixRef,maxIconSize:o.maxIconSize,activeIconSize:o.activeIconSize,iconMarginRight:o.iconMarginRight,dropdownPlacement:o.dropdownPlacement,dropdownShow:i,paddingLeft:o.paddingLeft,mergedDisabled:c,mergedValue:t.mergedValueRef,childActive:W(()=>t.activePathRef.value.includes(e.internalKey)),collapsed:x(()=>n.mode==="horizontal"?!1:l.value?!0:!t.mergedExpandedKeysRef.value.includes(e.internalKey)),dropdownEnabled:x(()=>!c.value&&(n.mode==="horizontal"||l.value)),handlePopoverShowChange:g,handleClick:p}},render(){var e;const{mergedClsPrefix:o,menuProps:{renderIcon:t,renderLabel:r}}=this,n=()=>{const{isHorizontal:u,paddingLeft:c,collapsed:i,mergedDisabled:a,maxIconSize:p,activeIconSize:g,title:f,childActive:H,icon:d,handleClick:h,menuProps:{nodeProps:I},dropdownShow:y,iconMarginRight:P,tmNode:L,mergedClsPrefix:N}=this,$=I==null?void 0:I(L.rawNode);return m("div",Object.assign({},$,{class:[`${N}-menu-item`,$==null?void 0:$.class],role:"menuitem"}),m(no,{tmNode:L,paddingLeft:c,collapsed:i,disabled:a,iconMarginRight:P,maxIconSize:p,activeIconSize:g,title:f,extra:this.extra,showArrow:!u,childActive:H,clsPrefix:N,icon:d,hover:y,onClick:h}))},l=()=>m(Ye,null,{default:()=>{const{tmNodes:u,collapsed:c}=this;return c?null:m("div",{class:`${o}-submenu-children`,role:"menu"},u.map(i=>$e(i,this.menuProps)))}});return this.root?m(jo,Object.assign({size:"large",trigger:"hover"},(e=this.menuProps)===null||e===void 0?void 0:e.dropdownProps,{themeOverrides:this.mergedTheme.peerOverrides.Dropdown,theme:this.mergedTheme.peers.Dropdown,builtinThemeOverrides:{fontSizeLarge:"14px",optionIconSizeLarge:"18px"},value:this.mergedValue,disabled:!this.dropdownEnabled,placement:this.dropdownPlacement,keyField:this.menuProps.keyField,labelField:this.menuProps.labelField,childrenField:this.menuProps.childrenField,onUpdateShow:this.handlePopoverShowChange,options:this.rawNodes,onSelect:this.doSelect,inverted:this.inverted,renderIcon:t,renderLabel:r}),{default:()=>m("div",{class:`${o}-submenu`,role:"menuitem","aria-expanded":!this.collapsed},n(),this.isHorizontal?null:l())}):m("div",{class:`${o}-submenu`,role:"menuitem","aria-expanded":!this.collapsed},n(),l())}}),lo=Object.assign(Object.assign({},Ae),{tmNode:{type:Object,required:!0},disabled:Boolean,icon:Function,onClick:Function}),Bt=k({name:"MenuOption",props:lo,setup(e){const o=He(e),{NSubmenu:t,NMenu:r}=o,{props:n,mergedClsPrefixRef:l,mergedCollapsedRef:u}=r,c=t?t.mergedDisabledRef:{value:!1},i=x(()=>c.value||e.disabled);function a(g){const{onClick:f}=e;f&&f(g)}function p(g){i.value||(r.doSelect(e.internalKey,e.tmNode.rawNode),a(g))}return{mergedClsPrefix:l,dropdownPlacement:o.dropdownPlacement,paddingLeft:o.paddingLeft,iconMarginRight:o.iconMarginRight,maxIconSize:o.maxIconSize,activeIconSize:o.activeIconSize,mergedTheme:r.mergedThemeRef,menuProps:n,dropdownEnabled:W(()=>e.root&&u.value&&n.mode!=="horizontal"&&!i.value),selected:W(()=>r.mergedValueRef.value===e.internalKey),mergedDisabled:i,handleClick:p}},render(){const{mergedClsPrefix:e,mergedTheme:o,tmNode:t,menuProps:{renderLabel:r,nodeProps:n}}=this,l=n==null?void 0:n(t.rawNode);return m("div",Object.assign({},l,{role:"menuitem",class:[`${e}-menu-item`,l==null?void 0:l.class]}),m(Lo,{theme:o.peers.Tooltip,themeOverrides:o.peerOverrides.Tooltip,trigger:"hover",placement:this.dropdownPlacement,disabled:!this.dropdownEnabled||this.title===void 0,internalExtraClass:["menu-tooltip"]},{default:()=>r?r(t.rawNode):Y(this.title),trigger:()=>m(no,{tmNode:t,clsPrefix:e,paddingLeft:this.paddingLeft,iconMarginRight:this.iconMarginRight,maxIconSize:this.maxIconSize,activeIconSize:this.activeIconSize,selected:this.selected,title:this.title,extra:this.extra,disabled:this.mergedDisabled,icon:this.icon,onClick:this.handleClick})}))}}),jt=k({name:"MenuDivider",setup(){const e=D(re),{mergedClsPrefixRef:o,isHorizontalRef:t}=e;return()=>t.value?null:m("div",{class:`${o.value}-menu-divider`})}}),Lt=Ie(ro),Et=Ie(lo),Mt=Ie(io);function ao(e){return e.type==="divider"||e.type==="render"}function Ft(e){return e.type==="divider"}function $e(e,o){const{rawNode:t}=e,{show:r}=t;if(r===!1)return null;if(ao(t))return Ft(t)?m(jt,Object.assign({key:e.key},t.props)):null;const{labelField:n}=o,{key:l,level:u,isGroup:c}=e,i=Object.assign(Object.assign({},t),{title:t.title||t[n],extra:t.titleExtra||t.extra,key:l,internalKey:l,level:u,root:u===0,isGroup:c});return e.children?e.isGroup?m(Nt,me(i,Lt,{tmNode:e,tmNodes:e.children,key:l})):m(kt,me(i,Mt,{key:l,rawNodes:t[o.childrenField],tmNodes:e.children,tmNode:e})):m(Bt,me(i,Et,{key:l,tmNode:e}))}const Me=[z("&::before","background-color: var(--n-item-color-hover);"),b("arrow",`
 color: var(--n-arrow-color-hover);
 `),b("icon",`
 color: var(--n-item-icon-color-hover);
 `),C("menu-item-content-header",`
 color: var(--n-item-text-color-hover);
 `,[z("a",`
 color: var(--n-item-text-color-hover);
 `),b("extra",`
 color: var(--n-item-text-color-hover);
 `)])],Fe=[b("icon",`
 color: var(--n-item-icon-color-hover-horizontal);
 `),C("menu-item-content-header",`
 color: var(--n-item-text-color-hover-horizontal);
 `,[z("a",`
 color: var(--n-item-text-color-hover-horizontal);
 `),b("extra",`
 color: var(--n-item-text-color-hover-horizontal);
 `)])],Dt=z([C("menu",`
 background-color: var(--n-color);
 color: var(--n-item-text-color);
 overflow: hidden;
 transition: background-color .3s var(--n-bezier);
 box-sizing: border-box;
 font-size: var(--n-font-size);
 padding-bottom: 6px;
 `,[O("horizontal",`
 display: inline-flex;
 padding-bottom: 0;
 `,[C("submenu","margin: 0;"),C("menu-item","margin: 0;"),C("menu-item-content",`
 padding: 0 20px;
 border-bottom: 2px solid #0000;
 `,[z("&::before","display: none;"),O("selected","border-bottom: 2px solid var(--n-border-color-horizontal)")]),C("menu-item-content",[O("selected",[b("icon","color: var(--n-item-icon-color-active-horizontal);"),C("menu-item-content-header",`
 color: var(--n-item-text-color-active-horizontal);
 `,[z("a","color: var(--n-item-text-color-active-horizontal);"),b("extra","color: var(--n-item-text-color-active-horizontal);")])]),O("child-active",`
 border-bottom: 2px solid var(--n-border-color-horizontal);
 `,[C("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-horizontal);
 `,[z("a",`
 color: var(--n-item-text-color-child-active-horizontal);
 `),b("extra",`
 color: var(--n-item-text-color-child-active-horizontal);
 `)]),b("icon",`
 color: var(--n-item-icon-color-child-active-horizontal);
 `)]),ie("disabled",[ie("selected, child-active",[z("&:focus-within",Fe)]),O("selected",[q(null,[b("icon","color: var(--n-item-icon-color-active-hover-horizontal);"),C("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover-horizontal);
 `,[z("a","color: var(--n-item-text-color-active-hover-horizontal);"),b("extra","color: var(--n-item-text-color-active-hover-horizontal);")])])]),O("child-active",[q(null,[b("icon","color: var(--n-item-icon-color-child-active-hover-horizontal);"),C("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover-horizontal);
 `,[z("a","color: var(--n-item-text-color-child-active-hover-horizontal);"),b("extra","color: var(--n-item-text-color-child-active-hover-horizontal);")])])]),q("border-bottom: 2px solid var(--n-border-color-horizontal);",Fe)]),C("menu-item-content-header",[z("a","color: var(--n-item-text-color-horizontal);")])])]),O("collapsed",[C("menu-item-content",[O("selected",[z("&::before",`
 background-color: var(--n-item-color-active-collapsed) !important;
 `)]),C("menu-item-content-header","opacity: 0;"),b("arrow","opacity: 0;"),b("icon","color: var(--n-item-icon-color-collapsed);")])]),C("menu-item",`
 height: var(--n-item-height);
 margin-top: 6px;
 position: relative;
 `),C("menu-item-content",`
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
 `),O("disabled",`
 opacity: .45;
 cursor: not-allowed;
 `),O("collapsed",[b("arrow","transform: rotate(0);")]),O("selected",[z("&::before","background-color: var(--n-item-color-active);"),b("arrow","color: var(--n-arrow-color-active);"),b("icon","color: var(--n-item-icon-color-active);"),C("menu-item-content-header",`
 color: var(--n-item-text-color-active);
 `,[z("a","color: var(--n-item-text-color-active);"),b("extra","color: var(--n-item-text-color-active);")])]),O("child-active",[C("menu-item-content-header",`
 color: var(--n-item-text-color-child-active);
 `,[z("a",`
 color: var(--n-item-text-color-child-active);
 `),b("extra",`
 color: var(--n-item-text-color-child-active);
 `)]),b("arrow",`
 color: var(--n-arrow-color-child-active);
 `),b("icon",`
 color: var(--n-item-icon-color-child-active);
 `)]),ie("disabled",[ie("selected, child-active",[z("&:focus-within",Me)]),O("selected",[q(null,[b("arrow","color: var(--n-arrow-color-active-hover);"),b("icon","color: var(--n-item-icon-color-active-hover);"),C("menu-item-content-header",`
 color: var(--n-item-text-color-active-hover);
 `,[z("a","color: var(--n-item-text-color-active-hover);"),b("extra","color: var(--n-item-text-color-active-hover);")])])]),O("child-active",[q(null,[b("arrow","color: var(--n-arrow-color-child-active-hover);"),b("icon","color: var(--n-item-icon-color-child-active-hover);"),C("menu-item-content-header",`
 color: var(--n-item-text-color-child-active-hover);
 `,[z("a","color: var(--n-item-text-color-child-active-hover);"),b("extra","color: var(--n-item-text-color-child-active-hover);")])])]),O("selected",[q(null,[z("&::before","background-color: var(--n-item-color-active-hover);")])]),q(null,Me)]),b("icon",`
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
 `),b("arrow",`
 grid-area: arrow;
 font-size: 16px;
 color: var(--n-arrow-color);
 transform: rotate(180deg);
 opacity: 1;
 transition:
 color .3s var(--n-bezier),
 transform 0.2s var(--n-bezier),
 opacity 0.2s var(--n-bezier);
 `),C("menu-item-content-header",`
 grid-area: content;
 transition:
 color .3s var(--n-bezier),
 opacity .3s var(--n-bezier);
 opacity: 1;
 white-space: nowrap;
 overflow: hidden;
 text-overflow: ellipsis;
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
 `)]),b("extra",`
 font-size: .93em;
 color: var(--n-group-text-color);
 transition: color .3s var(--n-bezier);
 `)])]),C("submenu",`
 cursor: pointer;
 position: relative;
 margin-top: 6px;
 `,[C("menu-item-content",`
 height: var(--n-item-height);
 `),C("submenu-children",`
 overflow: hidden;
 padding: 0;
 `,[Qe({duration:".2s"})])]),C("menu-item-group",[C("menu-item-group-title",`
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
 `)])]),C("menu-tooltip",[z("a",`
 color: inherit;
 text-decoration: none;
 `)]),C("menu-divider",`
 transition: background-color .3s var(--n-bezier);
 background-color: var(--n-divider-color);
 height: 1px;
 margin: 6px 18px;
 `)]);function q(e,o){return[O("hover",e,o),z("&:hover",e,o)]}const Vt=Object.assign(Object.assign({},G.props),{options:{type:Array,default:()=>[]},collapsed:{type:Boolean,default:void 0},collapsedWidth:{type:Number,default:48},iconSize:{type:Number,default:20},collapsedIconSize:{type:Number,default:24},rootIndent:Number,indent:{type:Number,default:32},labelField:{type:String,default:"label"},keyField:{type:String,default:"key"},childrenField:{type:String,default:"children"},disabledField:{type:String,default:"disabled"},defaultExpandAll:Boolean,defaultExpandedKeys:Array,expandedKeys:Array,value:[String,Number],defaultValue:{type:[String,Number],default:null},mode:{type:String,default:"vertical"},watchProps:{type:Array,default:void 0},disabled:Boolean,show:{type:Boolean,default:!0},inverted:Boolean,"onUpdate:expandedKeys":[Function,Array],onUpdateExpandedKeys:[Function,Array],onUpdateValue:[Function,Array],"onUpdate:value":[Function,Array],expandIcon:Function,renderIcon:Function,renderLabel:Function,renderExtra:Function,dropdownProps:Object,accordion:Boolean,nodeProps:Function,items:Array,onOpenNamesChange:[Function,Array],onSelect:[Function,Array],onExpandedNamesChange:[Function,Array],expandedNames:Array,defaultExpandedNames:Array,dropdownPlacement:{type:String,default:"bottom"}}),Kt=k({name:"Menu",props:Vt,setup(e){const{mergedClsPrefixRef:o,inlineThemeDisabled:t}=X(e),r=G("Menu","-menu",Dt,It,e,o),n=D(oo,null),l=x(()=>{var R;const{collapsed:w}=e;if(w!==void 0)return w;if(n){const{collapseModeRef:s,collapsedRef:S}=n;if(s.value==="width")return(R=S.value)!==null&&R!==void 0?R:!1}return!1}),u=x(()=>{const{keyField:R,childrenField:w,disabledField:s}=e;return Eo(e.items||e.options,{getIgnored(S){return ao(S)},getChildren(S){return S[w]},getDisabled(S){return S[s]},getKey(S){var B;return(B=S[R])!==null&&B!==void 0?B:S.name}})}),c=x(()=>new Set(u.value.treeNodes.map(R=>R.key))),{watchProps:i}=e,a=j(null);i!=null&&i.includes("defaultValue")?Te(()=>{a.value=e.defaultValue}):a.value=e.defaultValue;const p=J(e,"value"),g=pe(p,a),f=j([]),H=()=>{f.value=e.defaultExpandAll?u.value.getNonLeafKeys():e.defaultExpandedNames||e.defaultExpandedKeys||u.value.getPath(g.value,{includeSelf:!1}).keyPath};i!=null&&i.includes("defaultExpandedKeys")?Te(H):H();const d=Mo(e,["expandedNames","expandedKeys"]),h=pe(d,f),I=x(()=>u.value.treeNodes),y=x(()=>u.value.getPath(g.value).keyPath);V(re,{props:e,mergedCollapsedRef:l,mergedThemeRef:r,mergedValueRef:g,mergedExpandedKeysRef:h,activePathRef:y,mergedClsPrefixRef:o,isHorizontalRef:x(()=>e.mode==="horizontal"),invertedRef:J(e,"inverted"),doSelect:P,toggleExpand:N});function P(R,w){const{"onUpdate:value":s,onUpdateValue:S,onSelect:B}=e;S&&F(S,R,w),s&&F(s,R,w),B&&F(B,R,w),a.value=R}function L(R){const{"onUpdate:expandedKeys":w,onUpdateExpandedKeys:s,onExpandedNamesChange:S,onOpenNamesChange:B}=e;w&&F(w,R),s&&F(s,R),S&&F(S,R),B&&F(B,R),f.value=R}function N(R){const w=Array.from(h.value),s=w.findIndex(S=>S===R);if(~s)w.splice(s,1);else{if(e.accordion&&c.value.has(R)){const S=w.findIndex(B=>c.value.has(B));S>-1&&w.splice(S,1)}w.push(R)}L(w)}const $=R=>{const w=u.value.getPath(R??g.value,{includeSelf:!1}).keyPath;if(!w.length)return;const s=Array.from(h.value),S=new Set([...s,...w]);e.accordion&&c.value.forEach(B=>{S.has(B)&&!w.includes(B)&&S.delete(B)}),L(Array.from(S))},A=x(()=>{const{inverted:R}=e,{common:{cubicBezierEaseInOut:w},self:s}=r.value,{borderRadius:S,borderColorHorizontal:B,fontSize:ae,itemHeight:se,dividerColor:ce}=s,v={"--n-divider-color":ce,"--n-bezier":w,"--n-font-size":ae,"--n-border-color-horizontal":B,"--n-border-radius":S,"--n-item-height":se};return R?(v["--n-group-text-color"]=s.groupTextColorInverted,v["--n-color"]=s.colorInverted,v["--n-item-text-color"]=s.itemTextColorInverted,v["--n-item-text-color-hover"]=s.itemTextColorHoverInverted,v["--n-item-text-color-active"]=s.itemTextColorActiveInverted,v["--n-item-text-color-child-active"]=s.itemTextColorChildActiveInverted,v["--n-item-text-color-child-active-hover"]=s.itemTextColorChildActiveInverted,v["--n-item-text-color-active-hover"]=s.itemTextColorActiveHoverInverted,v["--n-item-icon-color"]=s.itemIconColorInverted,v["--n-item-icon-color-hover"]=s.itemIconColorHoverInverted,v["--n-item-icon-color-active"]=s.itemIconColorActiveInverted,v["--n-item-icon-color-active-hover"]=s.itemIconColorActiveHoverInverted,v["--n-item-icon-color-child-active"]=s.itemIconColorChildActiveInverted,v["--n-item-icon-color-child-active-hover"]=s.itemIconColorChildActiveHoverInverted,v["--n-item-icon-color-collapsed"]=s.itemIconColorCollapsedInverted,v["--n-item-text-color-horizontal"]=s.itemTextColorHorizontalInverted,v["--n-item-text-color-hover-horizontal"]=s.itemTextColorHoverHorizontalInverted,v["--n-item-text-color-active-horizontal"]=s.itemTextColorActiveHorizontalInverted,v["--n-item-text-color-child-active-horizontal"]=s.itemTextColorChildActiveHorizontalInverted,v["--n-item-text-color-child-active-hover-horizontal"]=s.itemTextColorChildActiveHoverHorizontalInverted,v["--n-item-text-color-active-hover-horizontal"]=s.itemTextColorActiveHoverHorizontalInverted,v["--n-item-icon-color-horizontal"]=s.itemIconColorHorizontalInverted,v["--n-item-icon-color-hover-horizontal"]=s.itemIconColorHoverHorizontalInverted,v["--n-item-icon-color-active-horizontal"]=s.itemIconColorActiveHorizontalInverted,v["--n-item-icon-color-active-hover-horizontal"]=s.itemIconColorActiveHoverHorizontalInverted,v["--n-item-icon-color-child-active-horizontal"]=s.itemIconColorChildActiveHorizontalInverted,v["--n-item-icon-color-child-active-hover-horizontal"]=s.itemIconColorChildActiveHoverHorizontalInverted,v["--n-arrow-color"]=s.arrowColorInverted,v["--n-arrow-color-hover"]=s.arrowColorHoverInverted,v["--n-arrow-color-active"]=s.arrowColorActiveInverted,v["--n-arrow-color-active-hover"]=s.arrowColorActiveHoverInverted,v["--n-arrow-color-child-active"]=s.arrowColorChildActiveInverted,v["--n-arrow-color-child-active-hover"]=s.arrowColorChildActiveHoverInverted,v["--n-item-color-hover"]=s.itemColorHoverInverted,v["--n-item-color-active"]=s.itemColorActiveInverted,v["--n-item-color-active-hover"]=s.itemColorActiveHoverInverted,v["--n-item-color-active-collapsed"]=s.itemColorActiveCollapsedInverted):(v["--n-group-text-color"]=s.groupTextColor,v["--n-color"]=s.color,v["--n-item-text-color"]=s.itemTextColor,v["--n-item-text-color-hover"]=s.itemTextColorHover,v["--n-item-text-color-active"]=s.itemTextColorActive,v["--n-item-text-color-child-active"]=s.itemTextColorChildActive,v["--n-item-text-color-child-active-hover"]=s.itemTextColorChildActiveHover,v["--n-item-text-color-active-hover"]=s.itemTextColorActiveHover,v["--n-item-icon-color"]=s.itemIconColor,v["--n-item-icon-color-hover"]=s.itemIconColorHover,v["--n-item-icon-color-active"]=s.itemIconColorActive,v["--n-item-icon-color-active-hover"]=s.itemIconColorActiveHover,v["--n-item-icon-color-child-active"]=s.itemIconColorChildActive,v["--n-item-icon-color-child-active-hover"]=s.itemIconColorChildActiveHover,v["--n-item-icon-color-collapsed"]=s.itemIconColorCollapsed,v["--n-item-text-color-horizontal"]=s.itemTextColorHorizontal,v["--n-item-text-color-hover-horizontal"]=s.itemTextColorHoverHorizontal,v["--n-item-text-color-active-horizontal"]=s.itemTextColorActiveHorizontal,v["--n-item-text-color-child-active-horizontal"]=s.itemTextColorChildActiveHorizontal,v["--n-item-text-color-child-active-hover-horizontal"]=s.itemTextColorChildActiveHoverHorizontal,v["--n-item-text-color-active-hover-horizontal"]=s.itemTextColorActiveHoverHorizontal,v["--n-item-icon-color-horizontal"]=s.itemIconColorHorizontal,v["--n-item-icon-color-hover-horizontal"]=s.itemIconColorHoverHorizontal,v["--n-item-icon-color-active-horizontal"]=s.itemIconColorActiveHorizontal,v["--n-item-icon-color-active-hover-horizontal"]=s.itemIconColorActiveHoverHorizontal,v["--n-item-icon-color-child-active-horizontal"]=s.itemIconColorChildActiveHorizontal,v["--n-item-icon-color-child-active-hover-horizontal"]=s.itemIconColorChildActiveHoverHorizontal,v["--n-arrow-color"]=s.arrowColor,v["--n-arrow-color-hover"]=s.arrowColorHover,v["--n-arrow-color-active"]=s.arrowColorActive,v["--n-arrow-color-active-hover"]=s.arrowColorActiveHover,v["--n-arrow-color-child-active"]=s.arrowColorChildActive,v["--n-arrow-color-child-active-hover"]=s.arrowColorChildActiveHover,v["--n-item-color-hover"]=s.itemColorHover,v["--n-item-color-active"]=s.itemColorActive,v["--n-item-color-active-hover"]=s.itemColorActiveHover,v["--n-item-color-active-collapsed"]=s.itemColorActiveCollapsed),v}),_=t?te("menu",x(()=>e.inverted?"a":"b"),A,e):void 0;return{mergedClsPrefix:o,controlledExpandedKeys:d,uncontrolledExpanededKeys:f,mergedExpandedKeys:h,uncontrolledValue:a,mergedValue:g,activePath:y,tmNodes:I,mergedTheme:r,mergedCollapsed:l,cssVars:t?void 0:A,themeClass:_==null?void 0:_.themeClass,onRender:_==null?void 0:_.onRender,showOption:$}},render(){const{mergedClsPrefix:e,mode:o,themeClass:t,onRender:r}=this;return r==null||r(),m("div",{role:o==="horizontal"?"menubar":"menu",class:[`${e}-menu`,t,`${e}-menu--${o}`,this.mergedCollapsed&&`${e}-menu--collapsed`],style:this.cssVars},this.tmNodes.map(n=>$e(n,this.$props)))}}),so={icon:Function,type:{type:String,default:"info"},content:[String,Number,Function],showIcon:{type:Boolean,default:!0},closable:Boolean,keepAliveOnHover:Boolean,onClose:Function,onMouseenter:Function,onMouseleave:Function},Gt=z([C("message-wrapper",`
 margin: var(--n-margin);
 z-index: 0;
 transform-origin: top center;
 display: flex;
 `,[Qe({overflow:"visible",originalTransition:"transform .3s var(--n-bezier)",enterToProps:{transform:"scale(1)"},leaveToProps:{transform:"scale(0.85)"}})]),C("message",`
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
 `,[b("content",`
 display: inline-block;
 line-height: var(--n-line-height);
 font-size: var(--n-font-size);
 `),b("icon",`
 position: relative;
 margin: var(--n-icon-margin);
 height: var(--n-icon-size);
 width: var(--n-icon-size);
 font-size: var(--n-icon-size);
 flex-shrink: 0;
 `,[["default","info","success","warning","error","loading"].map(e=>O(`${e}-type`,[z("> *",`
 color: var(--n-icon-color-${e});
 transition: color .3s var(--n-bezier);
 `)])),z("> *",`
 position: absolute;
 left: 0;
 top: 0;
 right: 0;
 bottom: 0;
 `,[Fo()])]),b("close",`
 margin: var(--n-close-margin);
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
 flex-shrink: 0;
 `,[z("&:hover",`
 color: var(--n-close-icon-color-hover);
 `),z("&:active",`
 color: var(--n-close-icon-color-pressed);
 `)])]),C("message-container",`
 z-index: 6000;
 position: fixed;
 height: 0;
 overflow: visible;
 display: flex;
 flex-direction: column;
 align-items: center;
 `,[O("top",`
 top: 12px;
 left: 0;
 right: 0;
 `),O("top-left",`
 top: 12px;
 left: 12px;
 right: 0;
 align-items: flex-start;
 `),O("top-right",`
 top: 12px;
 left: 0;
 right: 12px;
 align-items: flex-end;
 `),O("bottom",`
 bottom: 4px;
 left: 0;
 right: 0;
 justify-content: flex-end;
 `),O("bottom-left",`
 bottom: 4px;
 left: 12px;
 right: 0;
 justify-content: flex-end;
 align-items: flex-start;
 `),O("bottom-right",`
 bottom: 4px;
 left: 0;
 right: 12px;
 justify-content: flex-end;
 align-items: flex-end;
 `)])]),Wt={info:()=>m(Yo,null),success:()=>m(Xo,null),warning:()=>m(Qo,null),error:()=>m(Jo,null),default:()=>null},Ut=k({name:"Message",props:Object.assign(Object.assign({},so),{render:Function}),setup(e){const{inlineThemeDisabled:o,mergedRtlRef:t}=X(e),{props:r,mergedClsPrefixRef:n}=D(Xe),l=Do("Message",t,n),u=G("Message","-message",Gt,gt,r,n),c=x(()=>{const{type:a}=e,{common:{cubicBezierEaseInOut:p},self:{padding:g,margin:f,maxWidth:H,iconMargin:d,closeMargin:h,closeSize:I,iconSize:y,fontSize:P,lineHeight:L,borderRadius:N,iconColorInfo:$,iconColorSuccess:A,iconColorWarning:_,iconColorError:R,iconColorLoading:w,closeIconSize:s,closeBorderRadius:S,[U("textColor",a)]:B,[U("boxShadow",a)]:ae,[U("color",a)]:se,[U("closeColorHover",a)]:ce,[U("closeColorPressed",a)]:v,[U("closeIconColor",a)]:co,[U("closeIconColorPressed",a)]:uo,[U("closeIconColorHover",a)]:vo}}=u.value;return{"--n-bezier":p,"--n-margin":f,"--n-padding":g,"--n-max-width":H,"--n-font-size":P,"--n-icon-margin":d,"--n-icon-size":y,"--n-close-icon-size":s,"--n-close-border-radius":S,"--n-close-size":I,"--n-close-margin":h,"--n-text-color":B,"--n-color":se,"--n-box-shadow":ae,"--n-icon-color-info":$,"--n-icon-color-success":A,"--n-icon-color-warning":_,"--n-icon-color-error":R,"--n-icon-color-loading":w,"--n-close-color-hover":ce,"--n-close-color-pressed":v,"--n-close-icon-color":co,"--n-close-icon-color-pressed":uo,"--n-close-icon-color-hover":vo,"--n-line-height":L,"--n-border-radius":N}}),i=o?te("message",x(()=>e.type[0]),c,{}):void 0;return{mergedClsPrefix:n,rtlEnabled:l,messageProviderProps:r,handleClose(){var a;(a=e.onClose)===null||a===void 0||a.call(e)},cssVars:o?void 0:c,themeClass:i==null?void 0:i.themeClass,onRender:i==null?void 0:i.onRender,placement:r.placement}},render(){const{render:e,type:o,closable:t,content:r,mergedClsPrefix:n,cssVars:l,themeClass:u,onRender:c,icon:i,handleClose:a,showIcon:p}=this;c==null||c();let g;return m("div",{class:[`${n}-message-wrapper`,u],onMouseenter:this.onMouseenter,onMouseleave:this.onMouseleave,style:[{alignItems:this.placement.startsWith("top")?"flex-start":"flex-end"},l]},e?e(this.$props):m("div",{class:[`${n}-message ${n}-message--${o}-type`,this.rtlEnabled&&`${n}-message--rtl`]},(g=qt(i,o,n))&&p?m("div",{class:`${n}-message__icon ${n}-message__icon--${o}-type`},m(Vo,null,{default:()=>g})):null,m("div",{class:`${n}-message__content`},Y(r)),t?m(Ko,{clsPrefix:n,class:`${n}-message__close`,onClick:a,absolute:!0}):null))}});function qt(e,o,t){if(typeof e=="function")return e();{const r=o==="loading"?m(Go,{clsPrefix:t,strokeWidth:24,scale:.85}):Wt[o]();return r?m(ye,{clsPrefix:t,key:o},{default:()=>r}):null}}const Yt=k({name:"MessageEnvironment",props:Object.assign(Object.assign({},so),{duration:{type:Number,default:3e3},onAfterLeave:Function,onLeave:Function,internalKey:{type:String,required:!0},onInternalAfterLeave:Function,onHide:Function,onAfterHide:Function}),setup(e){let o=null;const t=j(!0);be(()=>{r()});function r(){const{duration:p}=e;p&&(o=window.setTimeout(u,p))}function n(p){p.currentTarget===p.target&&o!==null&&(window.clearTimeout(o),o=null)}function l(p){p.currentTarget===p.target&&r()}function u(){const{onHide:p}=e;t.value=!1,o&&(window.clearTimeout(o),o=null),p&&p()}function c(){const{onClose:p}=e;p&&p(),u()}function i(){const{onAfterLeave:p,onInternalAfterLeave:g,onAfterHide:f,internalKey:H}=e;p&&p(),g&&g(H),f&&f()}function a(){u()}return{show:t,hide:u,handleClose:c,handleAfterLeave:i,handleMouseleave:l,handleMouseenter:n,deactivate:a}},render(){return m(Ye,{appear:!0,onAfterLeave:this.handleAfterLeave,onLeave:this.onLeave},{default:()=>[this.show?m(Ut,{content:this.content,type:this.type,icon:this.icon,showIcon:this.showIcon,closable:this.closable,onClose:this.handleClose,onMouseenter:this.keepAliveOnHover?this.handleMouseenter:void 0,onMouseleave:this.keepAliveOnHover?this.handleMouseleave:void 0}):null]})}}),Xt=Object.assign(Object.assign({},G.props),{to:[String,Object],duration:{type:Number,default:3e3},keepAliveOnHover:Boolean,max:Number,placement:{type:String,default:"top"},closable:Boolean,containerStyle:[String,Object]}),Qt=k({name:"MessageProvider",props:Xt,setup(e){const{mergedClsPrefixRef:o}=X(e),t=j([]),r=j({}),n={create(i,a){return l(i,Object.assign({type:"default"},a))},info(i,a){return l(i,Object.assign(Object.assign({},a),{type:"info"}))},success(i,a){return l(i,Object.assign(Object.assign({},a),{type:"success"}))},warning(i,a){return l(i,Object.assign(Object.assign({},a),{type:"warning"}))},error(i,a){return l(i,Object.assign(Object.assign({},a),{type:"error"}))},loading(i,a){return l(i,Object.assign(Object.assign({},a),{type:"loading"}))},destroyAll:c};V(Xe,{props:e,mergedClsPrefixRef:o}),V(qo,n);function l(i,a){const p=Uo(),g=go(Object.assign(Object.assign({},a),{content:i,key:p,destroy:()=>{var H;(H=r.value[p])===null||H===void 0||H.hide()}})),{max:f}=e;return f&&t.value.length>=f&&t.value.shift(),t.value.push(g),g}function u(i){t.value.splice(t.value.findIndex(a=>a.key===i),1),delete r.value[i]}function c(){Object.values(r.value).forEach(i=>{i.hide()})}return Object.assign({mergedClsPrefix:o,messageRefs:r,messageList:t,handleAfterLeave:u},n)},render(){var e,o,t;return m(Ve,null,(o=(e=this.$slots).default)===null||o===void 0?void 0:o.call(e),this.messageList.length?m(ho,{to:(t=this.to)!==null&&t!==void 0?t:"body"},m("div",{class:[`${this.mergedClsPrefix}-message-container`,`${this.mergedClsPrefix}-message-container--${this.placement}`],key:"message-container",style:this.containerStyle},this.messageList.map(r=>m(Yt,Object.assign({ref:n=>{n&&(this.messageRefs[r.key]=n)},internalKey:r.key,onInternalAfterLeave:this.handleAfterLeave},Wo(r,["destroy"],void 0),{duration:r.duration===void 0?this.duration:r.duration,keepAliveOnHover:r.keepAliveOnHover===void 0?this.keepAliveOnHover:r.keepAliveOnHover,closable:r.closable===void 0?this.closable:r.closable}))))):null)}}),Jt={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},Zt=Ge("path",{d:"M352 48H160a48 48 0 0 0-48 48v368l144-128l144 128V96a48 48 0 0 0-48-48z",fill:"none",stroke:"currentColor","stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"32"},null,-1),er=[Zt],or=k({name:"BookmarkOutline",render:function(o,t){return xe(),Ke("svg",Jt,er)}}),tr={xmlns:"http://www.w3.org/2000/svg","xmlns:xlink":"http://www.w3.org/1999/xlink",viewBox:"0 0 512 512"},rr=Ge("path",{d:"M98 190.06l139.78 163.12a24 24 0 0 0 36.44 0L414 190.06c13.34-15.57 2.28-39.62-18.22-39.62h-279.6c-20.5 0-31.56 24.05-18.18 39.62z",fill:"currentColor"},null,-1),nr=[rr],ir=k({name:"CaretDownOutline",render:function(o,t){return xe(),Ke("svg",tr,nr)}});const lr={__name:"index",setup(e){let o=bo();xo();let t=j(!1),r=j([]);const n=j([]);let l=g=>{o.push({name:g})},u=()=>{localStorage.removeItem("jwt"),localStorage.removeItem("author"),window.location.href="/"};const c={common:{primaryColor:"#3a94f1"}};let i=g=>"href"in g?m("a",{href:g.href,target:"_blank"},g.label):g.label,a=g=>g.key==="sheep-man"?!0:g.key==="food"?null:m(je,null,{default:()=>m(or)}),p=()=>m(je,null,{default:()=>m(ir)});return be(()=>{let g=o.getRoutes().filter(f=>{if(f.name=="admin")return f});r.value=g[0].children;for(let f of r.value)f.mate.isM&&n.value.push({label:f.mate.name,key:f.mate.key,name:f.name})}),(g,f)=>{const H=Co("router-view");return xe(),yo(T(st),{"theme-overrides":c,style:{height:"100%",position:"relative"}},{default:M(()=>[E(T(Qt),null,{default:M(()=>[E(T(ge),{position:"absolute"},{default:M(()=>[E(T(At),{class:"admin-nav",style:{height:"50px",padding:"15px"},bordered:""},{default:M(()=>[E(T(vt),{"x-gap":"12",cols:3},{default:M(()=>[E(T(Ee),{span:2},{default:M(()=>[E(T(fe),{text:"",onClick:f[0]||(f[0]=d=>ne(t)?t.value=!T(t):t=!T(t)),color:"#ffffff"},{default:M(()=>[de(" 内容管理系统 ")]),_:1}),E(T(fe),{text:"",onClick:f[1]||(f[1]=d=>ne(t)?t.value=!T(t):t=!T(t)),color:"#ffffff",style:{"margin-left":"15px"}},{default:M(()=>[de(Io(T(t)?"展开":"关闭"),1)]),_:1})]),_:1}),E(T(Ee),{style:{"text-align":"right"}},{default:M(()=>[E(T(fe),{text:"",onClick:T(u),color:"#ffffff"},{default:M(()=>[de("退出")]),_:1},8,["onClick"])]),_:1})]),_:1})]),_:1}),E(T(ge),{"has-sider":"",position:"absolute",style:{top:"50px"}},{default:M(()=>[E(T(Tt),{bordered:"","collapse-mode":"width","collapsed-width":54,width:180,collapsed:T(t),"show-trigger":"",onCollapse:f[2]||(f[2]=d=>ne(t)?t.value=!0:t=!0),onExpand:f[3]||(f[3]=d=>ne(t)?t.value=!1:t=!1)},{default:M(()=>[E(T(Kt),{"onUpdate:value":T(l),collapsed:T(t),"collapsed-width":50,"collapsed-icon-size":22,options:n.value,"render-label":T(i),"render-icon":T(a),"expand-icon":T(p)},null,8,["onUpdate:value","collapsed","options","render-label","render-icon","expand-icon"])]),_:1},8,["collapsed"]),E(T(ge),{"content-style":"padding: 10px;"},{default:M(()=>[E(H)]),_:1})]),_:1})]),_:1})]),_:1})]),_:1})}}},vr=po(lr,[["__scopeId","data-v-82e5a10b"]]);export{vr as default};
