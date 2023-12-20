import{e as U,d as R,i as q,b as z,w as fe,g as me,j as ge,p as P,k as j,v as L,h as a,$ as V,m as be,X as _}from"./router-b176819d.js";import{s as ve,a4 as A,z as pe,W as we,R as ye,S as Se,Q as $e,U as ze,N as K,X as xe,Z as Ce,h as X,_ as Be,j as C,a0 as ke,D as Re}from"./Dropdown-8b114269.js";import{h as Ee,g as Te,u as Q,c as n,a as I,k as v,l as $,p as k,n as Z,q as Y,o as He,x as Fe}from"./admin-b42e2869.js";import{u as Me,a as Oe}from"./use-is-composing-717b95a5.js";import{e as Pe}from"./Space-4eaafb5f.js";const Ie=e=>{const{modalColor:t,textColor1:r,textColor2:m,boxShadow3:u,lineHeight:p,fontWeightStrong:d,dividerColor:g,closeColorHover:b,closeColorPressed:y,closeIconColor:h,closeIconColorHover:E,closeIconColorPressed:T,borderRadius:H,primaryColorHover:F}=e;return{bodyPadding:"16px 24px",headerPadding:"16px 24px",footerPadding:"16px 24px",color:t,textColor:m,titleTextColor:r,titleFontSize:"18px",titleFontWeight:d,boxShadow:u,lineHeight:p,headerBorderBottom:`1px solid ${g}`,footerBorderTop:`1px solid ${g}`,closeIconColor:h,closeIconColorHover:E,closeIconColorPressed:T,closeSize:"22px",closeIconSize:"18px",closeColorHover:b,closeColorPressed:y,closeBorderRadius:H,resizableTriggerColorHover:F}},De=Ee({name:"Drawer",common:Te,peers:{Scrollbar:ve},self:Ie}),We=De,Ne=U({name:"NDrawerContent",inheritAttrs:!1,props:{blockScroll:Boolean,show:{type:Boolean,default:void 0},displayDirective:{type:String,required:!0},placement:{type:String,required:!0},contentStyle:[Object,String],nativeScrollbar:{type:Boolean,required:!0},scrollbarProps:Object,trapFocus:{type:Boolean,default:!0},autoFocus:{type:Boolean,default:!0},showMask:{type:[Boolean,String],required:!0},maxWidth:Number,maxHeight:Number,minWidth:Number,minHeight:Number,resizable:Boolean,onClickoutside:Function,onAfterLeave:Function,onAfterEnter:Function,onEsc:Function},setup(e){const t=R(!!e.show),r=R(null),m=q(A);let u=0,p="",d=null;const g=R(!1),b=R(!1),y=z(()=>e.placement==="top"||e.placement==="bottom"),{mergedClsPrefixRef:h,mergedRtlRef:E}=Q(e),T=pe("Drawer",E,h),H=i=>{b.value=!0,u=y.value?i.clientY:i.clientX,p=document.body.style.cursor,document.body.style.cursor=y.value?"ns-resize":"ew-resize",document.body.addEventListener("mousemove",S),document.body.addEventListener("mouseleave",s),document.body.addEventListener("mouseup",o)},F=()=>{d!==null&&(window.clearTimeout(d),d=null),b.value?g.value=!0:d=window.setTimeout(()=>{g.value=!0},300)},D=()=>{d!==null&&(window.clearTimeout(d),d=null),g.value=!1},{doUpdateHeight:W,doUpdateWidth:N}=m,M=i=>{const{maxWidth:l}=e;if(l&&i>l)return l;const{minWidth:f}=e;return f&&i<f?f:i},O=i=>{const{maxHeight:l}=e;if(l&&i>l)return l;const{minHeight:f}=e;return f&&i<f?f:i},S=i=>{var l,f;if(b.value)if(y.value){let w=((l=r.value)===null||l===void 0?void 0:l.offsetHeight)||0;const x=u-i.clientY;w+=e.placement==="bottom"?x:-x,w=O(w),W(w),u=i.clientY}else{let w=((f=r.value)===null||f===void 0?void 0:f.offsetWidth)||0;const x=u-i.clientX;w+=e.placement==="right"?x:-x,w=M(w),N(w),u=i.clientX}},o=()=>{b.value&&(u=0,b.value=!1,document.body.style.cursor=p,document.body.removeEventListener("mousemove",S),document.body.removeEventListener("mouseup",o),document.body.removeEventListener("mouseleave",s))},s=o;fe(()=>{e.show&&(t.value=!0)}),me(()=>e.show,i=>{i||o()}),ge(()=>{o()});const c=z(()=>{const{show:i}=e,l=[[L,i]];return e.showMask||l.push([we,e.onClickoutside,void 0,{capture:!0}]),l});function B(){var i;t.value=!1,(i=e.onAfterLeave)===null||i===void 0||i.call(e)}return Me(z(()=>e.blockScroll&&t.value)),P(ye,r),P(Se,null),P($e,null),{bodyRef:r,rtlEnabled:T,mergedClsPrefix:m.mergedClsPrefixRef,isMounted:m.isMountedRef,mergedTheme:m.mergedThemeRef,displayed:t,transitionName:z(()=>({right:"slide-in-from-right-transition",left:"slide-in-from-left-transition",top:"slide-in-from-top-transition",bottom:"slide-in-from-bottom-transition"})[e.placement]),handleAfterLeave:B,bodyDirectives:c,handleMousedownResizeTrigger:H,handleMouseenterResizeTrigger:F,handleMouseleaveResizeTrigger:D,isDragging:b,isHoverOnResizeTrigger:g}},render(){const{$slots:e,mergedClsPrefix:t}=this;return this.displayDirective==="show"||this.displayed||this.show?j(a("div",{role:"none"},a(ze,{disabled:!this.showMask||!this.trapFocus,active:this.show,autoFocus:this.autoFocus,onEsc:this.onEsc},{default:()=>a(V,{name:this.transitionName,appear:this.isMounted,onAfterEnter:this.onAfterEnter,onAfterLeave:this.handleAfterLeave},{default:()=>j(a("div",be(this.$attrs,{role:"dialog",ref:"bodyRef","aria-modal":"true",class:[`${t}-drawer`,this.rtlEnabled&&`${t}-drawer--rtl`,`${t}-drawer--${this.placement}-placement`,this.isDragging&&`${t}-drawer--unselectable`,this.nativeScrollbar&&`${t}-drawer--native-scrollbar`]}),[this.resizable?a("div",{class:[`${t}-drawer__resize-trigger`,(this.isDragging||this.isHoverOnResizeTrigger)&&`${t}-drawer__resize-trigger--hover`],onMouseenter:this.handleMouseenterResizeTrigger,onMouseleave:this.handleMouseleaveResizeTrigger,onMousedown:this.handleMousedownResizeTrigger}):null,this.nativeScrollbar?a("div",{class:`${t}-drawer-content-wrapper`,style:this.contentStyle,role:"none"},e):a(K,Object.assign({},this.scrollbarProps,{contentStyle:this.contentStyle,contentClass:`${t}-drawer-content-wrapper`,theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar}),e)]),this.bodyDirectives)})})),[[L,this.displayDirective==="if"||this.displayed||this.show]]):null}}),{cubicBezierEaseIn:je,cubicBezierEaseOut:Ue}=I;function Ae({duration:e="0.3s",leaveDuration:t="0.2s",name:r="slide-in-from-right"}={}){return[n(`&.${r}-transition-leave-active`,{transition:`transform ${t} ${je}`}),n(`&.${r}-transition-enter-active`,{transition:`transform ${e} ${Ue}`}),n(`&.${r}-transition-enter-to`,{transform:"translateX(0)"}),n(`&.${r}-transition-enter-from`,{transform:"translateX(100%)"}),n(`&.${r}-transition-leave-from`,{transform:"translateX(0)"}),n(`&.${r}-transition-leave-to`,{transform:"translateX(100%)"})]}const{cubicBezierEaseIn:Le,cubicBezierEaseOut:_e}=I;function Xe({duration:e="0.3s",leaveDuration:t="0.2s",name:r="slide-in-from-left"}={}){return[n(`&.${r}-transition-leave-active`,{transition:`transform ${t} ${Le}`}),n(`&.${r}-transition-enter-active`,{transition:`transform ${e} ${_e}`}),n(`&.${r}-transition-enter-to`,{transform:"translateX(0)"}),n(`&.${r}-transition-enter-from`,{transform:"translateX(-100%)"}),n(`&.${r}-transition-leave-from`,{transform:"translateX(0)"}),n(`&.${r}-transition-leave-to`,{transform:"translateX(-100%)"})]}const{cubicBezierEaseIn:Ye,cubicBezierEaseOut:qe}=I;function Ve({duration:e="0.3s",leaveDuration:t="0.2s",name:r="slide-in-from-top"}={}){return[n(`&.${r}-transition-leave-active`,{transition:`transform ${t} ${Ye}`}),n(`&.${r}-transition-enter-active`,{transition:`transform ${e} ${qe}`}),n(`&.${r}-transition-enter-to`,{transform:"translateY(0)"}),n(`&.${r}-transition-enter-from`,{transform:"translateY(-100%)"}),n(`&.${r}-transition-leave-from`,{transform:"translateY(0)"}),n(`&.${r}-transition-leave-to`,{transform:"translateY(-100%)"})]}const{cubicBezierEaseIn:Ke,cubicBezierEaseOut:Qe}=I;function Ze({duration:e="0.3s",leaveDuration:t="0.2s",name:r="slide-in-from-bottom"}={}){return[n(`&.${r}-transition-leave-active`,{transition:`transform ${t} ${Ke}`}),n(`&.${r}-transition-enter-active`,{transition:`transform ${e} ${Qe}`}),n(`&.${r}-transition-enter-to`,{transform:"translateY(0)"}),n(`&.${r}-transition-enter-from`,{transform:"translateY(100%)"}),n(`&.${r}-transition-leave-from`,{transform:"translateY(0)"}),n(`&.${r}-transition-leave-to`,{transform:"translateY(100%)"})]}const Ge=n([v("drawer",`
 word-break: break-word;
 line-height: var(--n-line-height);
 position: absolute;
 pointer-events: all;
 box-shadow: var(--n-box-shadow);
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
 background-color: var(--n-color);
 color: var(--n-text-color);
 box-sizing: border-box;
 `,[Ae(),Xe(),Ve(),Ze(),$("unselectable",`
 user-select: none; 
 -webkit-user-select: none;
 `),$("native-scrollbar",[v("drawer-content-wrapper",`
 overflow: auto;
 height: 100%;
 `)]),k("resize-trigger",`
 position: absolute;
 background-color: #0000;
 transition: background-color .3s var(--n-bezier);
 `,[$("hover",`
 background-color: var(--n-resize-trigger-color-hover);
 `)]),v("drawer-content-wrapper",`
 box-sizing: border-box;
 `),v("drawer-content",`
 height: 100%;
 display: flex;
 flex-direction: column;
 `,[$("native-scrollbar",[v("drawer-body-content-wrapper",`
 height: 100%;
 overflow: auto;
 `)]),v("drawer-body",`
 flex: 1 0 0;
 overflow: hidden;
 `),v("drawer-body-content-wrapper",`
 box-sizing: border-box;
 padding: var(--n-body-padding);
 `),v("drawer-header",`
 font-weight: var(--n-title-font-weight);
 line-height: 1;
 font-size: var(--n-title-font-size);
 color: var(--n-title-text-color);
 padding: var(--n-header-padding);
 transition: border .3s var(--n-bezier);
 border-bottom: 1px solid var(--n-divider-color);
 border-bottom: var(--n-header-border-bottom);
 display: flex;
 justify-content: space-between;
 align-items: center;
 `,[k("close",`
 margin-left: 6px;
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
 `)]),v("drawer-footer",`
 display: flex;
 justify-content: flex-end;
 border-top: var(--n-footer-border-top);
 transition: border .3s var(--n-bezier);
 padding: var(--n-footer-padding);
 `)]),$("right-placement",`
 top: 0;
 bottom: 0;
 right: 0;
 `,[k("resize-trigger",`
 width: 3px;
 height: 100%;
 top: 0;
 left: 0;
 transform: translateX(-1.5px);
 cursor: ew-resize;
 `)]),$("left-placement",`
 top: 0;
 bottom: 0;
 left: 0;
 `,[k("resize-trigger",`
 width: 3px;
 height: 100%;
 top: 0;
 right: 0;
 transform: translateX(1.5px);
 cursor: ew-resize;
 `)]),$("top-placement",`
 top: 0;
 left: 0;
 right: 0;
 `,[k("resize-trigger",`
 width: 100%;
 height: 3px;
 bottom: 0;
 left: 0;
 transform: translateY(1.5px);
 cursor: ns-resize;
 `)]),$("bottom-placement",`
 left: 0;
 bottom: 0;
 right: 0;
 `,[k("resize-trigger",`
 width: 100%;
 height: 3px;
 top: 0;
 left: 0;
 transform: translateY(-1.5px);
 cursor: ns-resize;
 `)])]),n("body",[n(">",[v("drawer-container",{position:"fixed"})])]),v("drawer-container",`
 position: relative;
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 pointer-events: none;
 `,[n("> *",{pointerEvents:"all"})]),v("drawer-mask",`
 background-color: rgba(0, 0, 0, .3);
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `,[$("invisible",`
 background-color: rgba(0, 0, 0, 0)
 `),xe({enterDuration:"0.2s",leaveDuration:"0.2s",enterCubicBezier:"var(--n-bezier-in)",leaveCubicBezier:"var(--n-bezier-out)"})])]),Je=Object.assign(Object.assign({},Z.props),{show:Boolean,width:[Number,String],height:[Number,String],placement:{type:String,default:"right"},maskClosable:{type:Boolean,default:!0},showMask:{type:[Boolean,String],default:!0},to:[String,Object],displayDirective:{type:String,default:"if"},nativeScrollbar:{type:Boolean,default:!0},zIndex:Number,onMaskClick:Function,scrollbarProps:Object,contentStyle:[Object,String],trapFocus:{type:Boolean,default:!0},onEsc:Function,autoFocus:{type:Boolean,default:!0},closeOnEsc:{type:Boolean,default:!0},blockScroll:{type:Boolean,default:!0},maxWidth:Number,maxHeight:Number,minWidth:Number,minHeight:Number,resizable:Boolean,defaultWidth:{type:[Number,String],default:251},defaultHeight:{type:[Number,String],default:251},onUpdateWidth:[Function,Array],onUpdateHeight:[Function,Array],"onUpdate:width":[Function,Array],"onUpdate:height":[Function,Array],"onUpdate:show":[Function,Array],onUpdateShow:[Function,Array],onAfterEnter:Function,onAfterLeave:Function,drawerStyle:[String,Object],drawerClass:String,target:null,onShow:Function,onHide:Function}),st=U({name:"Drawer",inheritAttrs:!1,props:Je,setup(e){const{mergedClsPrefixRef:t,namespaceRef:r,inlineThemeDisabled:m}=Q(e),u=Ce(),p=Z("Drawer","-drawer",Ge,We,e,t),d=R(e.defaultWidth),g=R(e.defaultHeight),b=X(_(e,"width"),d),y=X(_(e,"height"),g),h=z(()=>{const{placement:o}=e;return o==="top"||o==="bottom"?"":Y(b.value)}),E=z(()=>{const{placement:o}=e;return o==="left"||o==="right"?"":Y(y.value)}),T=o=>{const{onUpdateWidth:s,"onUpdate:width":c}=e;s&&C(s,o),c&&C(c,o),d.value=o},H=o=>{const{onUpdateHeight:s,"onUpdate:width":c}=e;s&&C(s,o),c&&C(c,o),g.value=o},F=z(()=>[{width:h.value,height:E.value},e.drawerStyle||""]);function D(o){const{onMaskClick:s,maskClosable:c}=e;c&&M(!1),s&&s(o)}const W=Oe();function N(o){var s;(s=e.onEsc)===null||s===void 0||s.call(e),e.show&&e.closeOnEsc&&Pe(o)&&!W.value&&M(!1)}function M(o){const{onHide:s,onUpdateShow:c,"onUpdate:show":B}=e;c&&C(c,o),B&&C(B,o),s&&!o&&C(s,o)}P(A,{isMountedRef:u,mergedThemeRef:p,mergedClsPrefixRef:t,doUpdateShow:M,doUpdateHeight:H,doUpdateWidth:T});const O=z(()=>{const{common:{cubicBezierEaseInOut:o,cubicBezierEaseIn:s,cubicBezierEaseOut:c},self:{color:B,textColor:i,boxShadow:l,lineHeight:f,headerPadding:w,footerPadding:x,bodyPadding:G,titleFontSize:J,titleTextColor:ee,titleFontWeight:te,headerBorderBottom:re,footerBorderTop:oe,closeIconColor:ne,closeIconColorHover:ie,closeIconColorPressed:se,closeColorHover:ae,closeColorPressed:le,closeIconSize:de,closeSize:ce,closeBorderRadius:ue,resizableTriggerColorHover:he}}=p.value;return{"--n-line-height":f,"--n-color":B,"--n-text-color":i,"--n-box-shadow":l,"--n-bezier":o,"--n-bezier-out":c,"--n-bezier-in":s,"--n-header-padding":w,"--n-body-padding":G,"--n-footer-padding":x,"--n-title-text-color":ee,"--n-title-font-size":J,"--n-title-font-weight":te,"--n-header-border-bottom":re,"--n-footer-border-top":oe,"--n-close-icon-color":ne,"--n-close-icon-color-hover":ie,"--n-close-icon-color-pressed":se,"--n-close-size":ce,"--n-close-color-hover":ae,"--n-close-color-pressed":le,"--n-close-icon-size":de,"--n-close-border-radius":ue,"--n-resize-trigger-color-hover":he}}),S=m?He("drawer",void 0,O,e):void 0;return{mergedClsPrefix:t,namespace:r,mergedBodyStyle:F,handleMaskClick:D,handleEsc:N,mergedTheme:p,cssVars:m?void 0:O,themeClass:S==null?void 0:S.themeClass,onRender:S==null?void 0:S.onRender,isMounted:u}},render(){const{mergedClsPrefix:e}=this;return a(Be,{to:this.to,show:this.show},{default:()=>{var t;return(t=this.onRender)===null||t===void 0||t.call(this),j(a("div",{class:[`${e}-drawer-container`,this.namespace,this.themeClass],style:this.cssVars,role:"none"},this.showMask?a(V,{name:"fade-in-transition",appear:this.isMounted},{default:()=>this.show?a("div",{"aria-hidden":!0,class:[`${e}-drawer-mask`,this.showMask==="transparent"&&`${e}-drawer-mask--invisible`],onClick:this.handleMaskClick}):null}):null,a(Ne,Object.assign({},this.$attrs,{class:[this.drawerClass,this.$attrs.class],style:[this.mergedBodyStyle,this.$attrs.style],blockScroll:this.blockScroll,contentStyle:this.contentStyle,placement:this.placement,scrollbarProps:this.scrollbarProps,show:this.show,displayDirective:this.displayDirective,nativeScrollbar:this.nativeScrollbar,onAfterEnter:this.onAfterEnter,onAfterLeave:this.onAfterLeave,trapFocus:this.trapFocus,autoFocus:this.autoFocus,resizable:this.resizable,maxHeight:this.maxHeight,minHeight:this.minHeight,maxWidth:this.maxWidth,minWidth:this.minWidth,showMask:this.showMask,onEsc:this.handleEsc,onClickoutside:this.handleMaskClick}),this.$slots)),[[ke,{zIndex:this.zIndex,enabled:this.show}]])}})}}),et={title:{type:String},headerStyle:[Object,String],footerStyle:[Object,String],bodyStyle:[Object,String],bodyContentStyle:[Object,String],nativeScrollbar:{type:Boolean,default:!0},scrollbarProps:Object,closable:Boolean},at=U({name:"DrawerContent",props:et,setup(){const e=q(A,null);e||Fe("drawer-content","`n-drawer-content` must be placed inside `n-drawer`.");const{doUpdateShow:t}=e;function r(){t(!1)}return{handleCloseClick:r,mergedTheme:e.mergedThemeRef,mergedClsPrefix:e.mergedClsPrefixRef}},render(){const{title:e,mergedClsPrefix:t,nativeScrollbar:r,mergedTheme:m,bodyStyle:u,bodyContentStyle:p,headerStyle:d,footerStyle:g,scrollbarProps:b,closable:y,$slots:h}=this;return a("div",{role:"none",class:[`${t}-drawer-content`,r&&`${t}-drawer-content--native-scrollbar`]},h.header||e||y?a("div",{class:`${t}-drawer-header`,style:d,role:"none"},a("div",{class:`${t}-drawer-header__main`,role:"heading","aria-level":"1"},h.header!==void 0?h.header():e),y&&a(Re,{onClick:this.handleCloseClick,clsPrefix:t,class:`${t}-drawer-header__close`,absolute:!0})):null,r?a("div",{class:`${t}-drawer-body`,style:u,role:"none"},a("div",{class:`${t}-drawer-body-content-wrapper`,style:p,role:"none"},h)):a(K,Object.assign({themeOverrides:m.peerOverrides.Scrollbar,theme:m.peers.Scrollbar},b,{class:`${t}-drawer-body`,contentClass:`${t}-drawer-body-content-wrapper`,contentStyle:p}),h),h.footer?a("div",{class:`${t}-drawer-footer`,style:g,role:"none"},h.footer()):null)}});export{at as N,st as a};
