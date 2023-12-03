import{s as Z}from"./request-90d4e0a2.js";import{l as ze,u as Se}from"./role-20ef7d22.js";import{y as X,q as $e,n as Ce,p as ke,l as xe,F as Be,s as Re,L as Ee,z as Te,h as _}from"./Dropdown-42d3e011.js";import{g as Fe,h as Ie,u as Q,c as n,a as N,j as w,k as x,o as D,l as ee,t as V,n as Me,v as Oe}from"./admin-4b1ed10e.js";import{s as Pe,d as Ae,l as te,m as De,u as q,c as P}from"./Scrollbar-501e05a5.js";import{N as He}from"./Close-b15c4fe9.js";import{e as Y,d as v,i as oe,b as E,w as _e,g as je,j as Le,p as U,k as W,v as K,h as i,Z as re,m as Ue,W as G,J as Ne,x as We,y as Xe,l as z,D as S,C as $,F as Ye,H as j}from"./router-2d2d1606.js";import{u as Ve,a as qe}from"./use-is-composing-bafc20b6.js";import{e as Ke,a as L,b as J}from"./Space-5790d1da.js";import"./notice-4adee1b0.js";const Ge=e=>{const{modalColor:t,textColor1:o,textColor2:u,boxShadow3:l,lineHeight:h,fontWeightStrong:d,dividerColor:f,closeColorHover:b,closeColorPressed:g,closeIconColor:m,closeIconColorHover:B,closeIconColorPressed:T,borderRadius:F,primaryColorHover:I}=e;return{bodyPadding:"16px 24px",headerPadding:"16px 24px",footerPadding:"16px 24px",color:t,textColor:u,titleTextColor:o,titleFontSize:"18px",titleFontWeight:d,boxShadow:l,lineHeight:h,headerBorderBottom:`1px solid ${f}`,footerBorderTop:`1px solid ${f}`,closeIconColor:m,closeIconColorHover:B,closeIconColorPressed:T,closeSize:"22px",closeIconSize:"18px",closeColorHover:b,closeColorPressed:g,closeBorderRadius:F,resizableTriggerColorHover:I}},Je=Fe({name:"Drawer",common:Ie,peers:{Scrollbar:Pe},self:Ge}),Ze=Je,Qe=Y({name:"NDrawerContent",inheritAttrs:!1,props:{blockScroll:Boolean,show:{type:Boolean,default:void 0},displayDirective:{type:String,required:!0},placement:{type:String,required:!0},contentStyle:[Object,String],nativeScrollbar:{type:Boolean,required:!0},scrollbarProps:Object,trapFocus:{type:Boolean,default:!0},autoFocus:{type:Boolean,default:!0},showMask:{type:[Boolean,String],required:!0},resizable:Boolean,onClickoutside:Function,onAfterLeave:Function,onAfterEnter:Function,onEsc:Function},setup(e){const t=v(!!e.show),o=v(null),u=oe(X);let l=0,h="",d=null;const f=v(!1),b=v(!1),g=E(()=>e.placement==="top"||e.placement==="bottom"),{mergedClsPrefixRef:m,mergedRtlRef:B}=Q(e),T=Ae("Drawer",B,m),F=r=>{b.value=!0,l=g.value?r.clientY:r.clientX,h=document.body.style.cursor,document.body.style.cursor=g.value?"ns-resize":"ew-resize",document.body.addEventListener("mousemove",A),document.body.addEventListener("mouseleave",k),document.body.addEventListener("mouseup",R)},I=()=>{d!==null&&(window.clearTimeout(d),d=null),b.value?f.value=!0:d=window.setTimeout(()=>{f.value=!0},300)},c=()=>{d!==null&&(window.clearTimeout(d),d=null),f.value=!1},{doUpdateHeight:p,doUpdateWidth:C}=u,A=r=>{var y,H;if(b.value)if(g.value){let M=((y=o.value)===null||y===void 0?void 0:y.offsetHeight)||0;const O=l-r.clientY;M+=e.placement==="bottom"?O:-O,p(M),l=r.clientY}else{let M=((H=o.value)===null||H===void 0?void 0:H.offsetWidth)||0;const O=l-r.clientX;M+=e.placement==="right"?O:-O,C(M),l=r.clientX}},R=()=>{b.value&&(l=0,b.value=!1,document.body.style.cursor=h,document.body.removeEventListener("mousemove",A),document.body.removeEventListener("mouseup",R),document.body.removeEventListener("mouseleave",k))},k=R;_e(()=>{e.show&&(t.value=!0)}),je(()=>e.show,r=>{r||R()}),Le(()=>{R()});const a=E(()=>{const{show:r}=e,y=[[K,r]];return e.showMask||y.push([$e,e.onClickoutside,void 0,{capture:!0}]),y});function s(){var r;t.value=!1,(r=e.onAfterLeave)===null||r===void 0||r.call(e)}return Ve(E(()=>e.blockScroll&&t.value)),U(Ce,o),U(ke,null),U(xe,null),{bodyRef:o,rtlEnabled:T,mergedClsPrefix:u.mergedClsPrefixRef,isMounted:u.isMountedRef,mergedTheme:u.mergedThemeRef,displayed:t,transitionName:E(()=>({right:"slide-in-from-right-transition",left:"slide-in-from-left-transition",top:"slide-in-from-top-transition",bottom:"slide-in-from-bottom-transition"})[e.placement]),handleAfterLeave:s,bodyDirectives:a,handleMousedownResizeTrigger:F,handleMouseenterResizeTrigger:I,handleMouseleaveResizeTrigger:c,isDragging:b,isHoverOnResizeTrigger:f}},render(){const{$slots:e,mergedClsPrefix:t}=this;return this.displayDirective==="show"||this.displayed||this.show?W(i("div",{role:"none"},i(Be,{disabled:!this.showMask||!this.trapFocus,active:this.show,autoFocus:this.autoFocus,onEsc:this.onEsc},{default:()=>i(re,{name:this.transitionName,appear:this.isMounted,onAfterEnter:this.onAfterEnter,onAfterLeave:this.handleAfterLeave},{default:()=>W(i("div",Ue(this.$attrs,{role:"dialog",ref:"bodyRef","aria-modal":"true",class:[`${t}-drawer`,this.rtlEnabled&&`${t}-drawer--rtl`,`${t}-drawer--${this.placement}-placement`,this.isDragging&&`${t}-drawer--unselectable`,this.nativeScrollbar&&`${t}-drawer--native-scrollbar`]}),[this.resizable?i("div",{class:[`${t}-drawer__resize-trigger`,(this.isDragging||this.isHoverOnResizeTrigger)&&`${t}-drawer__resize-trigger--hover`],onMouseenter:this.handleMouseenterResizeTrigger,onMouseleave:this.handleMouseleaveResizeTrigger,onMousedown:this.handleMousedownResizeTrigger}):null,this.nativeScrollbar?i("div",{class:`${t}-drawer-content-wrapper`,style:this.contentStyle,role:"none"},e):i(te,Object.assign({},this.scrollbarProps,{contentStyle:this.contentStyle,contentClass:`${t}-drawer-content-wrapper`,theme:this.mergedTheme.peers.Scrollbar,themeOverrides:this.mergedTheme.peerOverrides.Scrollbar}),e)]),this.bodyDirectives)})})),[[K,this.displayDirective==="if"||this.displayed||this.show]]):null}}),{cubicBezierEaseIn:et,cubicBezierEaseOut:tt}=N;function ot({duration:e="0.3s",leaveDuration:t="0.2s",name:o="slide-in-from-right"}={}){return[n(`&.${o}-transition-leave-active`,{transition:`transform ${t} ${et}`}),n(`&.${o}-transition-enter-active`,{transition:`transform ${e} ${tt}`}),n(`&.${o}-transition-enter-to`,{transform:"translateX(0)"}),n(`&.${o}-transition-enter-from`,{transform:"translateX(100%)"}),n(`&.${o}-transition-leave-from`,{transform:"translateX(0)"}),n(`&.${o}-transition-leave-to`,{transform:"translateX(100%)"})]}const{cubicBezierEaseIn:rt,cubicBezierEaseOut:nt}=N;function at({duration:e="0.3s",leaveDuration:t="0.2s",name:o="slide-in-from-left"}={}){return[n(`&.${o}-transition-leave-active`,{transition:`transform ${t} ${rt}`}),n(`&.${o}-transition-enter-active`,{transition:`transform ${e} ${nt}`}),n(`&.${o}-transition-enter-to`,{transform:"translateX(0)"}),n(`&.${o}-transition-enter-from`,{transform:"translateX(-100%)"}),n(`&.${o}-transition-leave-from`,{transform:"translateX(0)"}),n(`&.${o}-transition-leave-to`,{transform:"translateX(-100%)"})]}const{cubicBezierEaseIn:it,cubicBezierEaseOut:st}=N;function lt({duration:e="0.3s",leaveDuration:t="0.2s",name:o="slide-in-from-top"}={}){return[n(`&.${o}-transition-leave-active`,{transition:`transform ${t} ${it}`}),n(`&.${o}-transition-enter-active`,{transition:`transform ${e} ${st}`}),n(`&.${o}-transition-enter-to`,{transform:"translateY(0)"}),n(`&.${o}-transition-enter-from`,{transform:"translateY(-100%)"}),n(`&.${o}-transition-leave-from`,{transform:"translateY(0)"}),n(`&.${o}-transition-leave-to`,{transform:"translateY(-100%)"})]}const{cubicBezierEaseIn:dt,cubicBezierEaseOut:ct}=N;function ut({duration:e="0.3s",leaveDuration:t="0.2s",name:o="slide-in-from-bottom"}={}){return[n(`&.${o}-transition-leave-active`,{transition:`transform ${t} ${dt}`}),n(`&.${o}-transition-enter-active`,{transition:`transform ${e} ${ct}`}),n(`&.${o}-transition-enter-to`,{transform:"translateY(0)"}),n(`&.${o}-transition-enter-from`,{transform:"translateY(100%)"}),n(`&.${o}-transition-leave-from`,{transform:"translateY(0)"}),n(`&.${o}-transition-leave-to`,{transform:"translateY(100%)"})]}const ht=n([w("drawer",`
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
 `,[ot(),at(),lt(),ut(),x("unselectable",`
 user-select: none; 
 -webkit-user-select: none;
 `),x("native-scrollbar",[w("drawer-content-wrapper",`
 overflow: auto;
 height: 100%;
 `)]),D("resize-trigger",`
 position: absolute;
 background-color: #0000;
 transition: background-color .3s var(--n-bezier);
 `,[x("hover",`
 background-color: var(--n-resize-trigger-color-hover);
 `)]),w("drawer-content-wrapper",`
 box-sizing: border-box;
 `),w("drawer-content",`
 height: 100%;
 display: flex;
 flex-direction: column;
 `,[x("native-scrollbar",[w("drawer-body-content-wrapper",`
 height: 100%;
 overflow: auto;
 `)]),w("drawer-body",`
 flex: 1 0 0;
 overflow: hidden;
 `),w("drawer-body-content-wrapper",`
 box-sizing: border-box;
 padding: var(--n-body-padding);
 `),w("drawer-header",`
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
 `,[D("close",`
 margin-left: 6px;
 transition:
 background-color .3s var(--n-bezier),
 color .3s var(--n-bezier);
 `)]),w("drawer-footer",`
 display: flex;
 justify-content: flex-end;
 border-top: var(--n-footer-border-top);
 transition: border .3s var(--n-bezier);
 padding: var(--n-footer-padding);
 `)]),x("right-placement",`
 top: 0;
 bottom: 0;
 right: 0;
 `,[D("resize-trigger",`
 width: 3px;
 height: 100%;
 top: 0;
 left: 0;
 transform: translateX(-1.5px);
 cursor: ew-resize;
 `)]),x("left-placement",`
 top: 0;
 bottom: 0;
 left: 0;
 `,[D("resize-trigger",`
 width: 3px;
 height: 100%;
 top: 0;
 right: 0;
 transform: translateX(1.5px);
 cursor: ew-resize;
 `)]),x("top-placement",`
 top: 0;
 left: 0;
 right: 0;
 `,[D("resize-trigger",`
 width: 100%;
 height: 3px;
 bottom: 0;
 left: 0;
 transform: translateY(1.5px);
 cursor: ns-resize;
 `)]),x("bottom-placement",`
 left: 0;
 bottom: 0;
 right: 0;
 `,[D("resize-trigger",`
 width: 100%;
 height: 3px;
 top: 0;
 left: 0;
 transform: translateY(-1.5px);
 cursor: ns-resize;
 `)])]),n("body",[n(">",[w("drawer-container",{position:"fixed"})])]),w("drawer-container",`
 position: relative;
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 pointer-events: none;
 `,[n("> *",{pointerEvents:"all"})]),w("drawer-mask",`
 background-color: rgba(0, 0, 0, .3);
 position: absolute;
 left: 0;
 right: 0;
 top: 0;
 bottom: 0;
 `,[x("invisible",`
 background-color: rgba(0, 0, 0, 0)
 `),De({enterDuration:"0.2s",leaveDuration:"0.2s",enterCubicBezier:"var(--n-bezier-in)",leaveCubicBezier:"var(--n-bezier-out)"})])]),ft=Object.assign(Object.assign({},ee.props),{show:Boolean,width:[Number,String],height:[Number,String],placement:{type:String,default:"right"},maskClosable:{type:Boolean,default:!0},showMask:{type:[Boolean,String],default:!0},to:[String,Object],displayDirective:{type:String,default:"if"},nativeScrollbar:{type:Boolean,default:!0},zIndex:Number,onMaskClick:Function,scrollbarProps:Object,contentStyle:[Object,String],trapFocus:{type:Boolean,default:!0},onEsc:Function,autoFocus:{type:Boolean,default:!0},closeOnEsc:{type:Boolean,default:!0},blockScroll:{type:Boolean,default:!0},resizable:Boolean,defaultWidth:{type:[Number,String],default:251},defaultHeight:{type:[Number,String],default:251},onUpdateWidth:[Function,Array],onUpdateHeight:[Function,Array],"onUpdate:width":[Function,Array],"onUpdate:height":[Function,Array],"onUpdate:show":[Function,Array],onUpdateShow:[Function,Array],onAfterEnter:Function,onAfterLeave:Function,drawerStyle:[String,Object],drawerClass:String,target:null,onShow:Function,onHide:Function}),mt=Y({name:"Drawer",inheritAttrs:!1,props:ft,setup(e){const{mergedClsPrefixRef:t,namespaceRef:o,inlineThemeDisabled:u}=Q(e),l=Re(),h=ee("Drawer","-drawer",ht,Ze,e,t),d=v(e.defaultWidth),f=v(e.defaultHeight),b=q(G(e,"width"),d),g=q(G(e,"height"),f),m=E(()=>{const{placement:a}=e;return a==="top"||a==="bottom"?"":V(b.value)}),B=E(()=>{const{placement:a}=e;return a==="left"||a==="right"?"":V(g.value)}),T=a=>{const{onUpdateWidth:s,"onUpdate:width":r}=e;s&&P(s,a),r&&P(r,a),d.value=a},F=a=>{const{onUpdateHeight:s,"onUpdate:width":r}=e;s&&P(s,a),r&&P(r,a),f.value=a},I=E(()=>[{width:m.value,height:B.value},e.drawerStyle||""]);function c(a){const{onMaskClick:s,maskClosable:r}=e;r&&A(!1),s&&s(a)}const p=qe();function C(a){var s;(s=e.onEsc)===null||s===void 0||s.call(e),e.show&&e.closeOnEsc&&Ke(a)&&!p.value&&A(!1)}function A(a){const{onHide:s,onUpdateShow:r,"onUpdate:show":y}=e;r&&P(r,a),y&&P(y,a),s&&!a&&P(s,a)}U(X,{isMountedRef:l,mergedThemeRef:h,mergedClsPrefixRef:t,doUpdateShow:A,doUpdateHeight:F,doUpdateWidth:T});const R=E(()=>{const{common:{cubicBezierEaseInOut:a,cubicBezierEaseIn:s,cubicBezierEaseOut:r},self:{color:y,textColor:H,boxShadow:M,lineHeight:O,headerPadding:ne,footerPadding:ae,bodyPadding:ie,titleFontSize:se,titleTextColor:le,titleFontWeight:de,headerBorderBottom:ce,footerBorderTop:ue,closeIconColor:he,closeIconColorHover:fe,closeIconColorPressed:me,closeColorHover:be,closeColorPressed:ve,closeIconSize:ge,closeSize:pe,closeBorderRadius:we,resizableTriggerColorHover:ye}}=h.value;return{"--n-line-height":O,"--n-color":y,"--n-text-color":H,"--n-box-shadow":M,"--n-bezier":a,"--n-bezier-out":r,"--n-bezier-in":s,"--n-header-padding":ne,"--n-body-padding":ie,"--n-footer-padding":ae,"--n-title-text-color":le,"--n-title-font-size":se,"--n-title-font-weight":de,"--n-header-border-bottom":ce,"--n-footer-border-top":ue,"--n-close-icon-color":he,"--n-close-icon-color-hover":fe,"--n-close-icon-color-pressed":me,"--n-close-size":pe,"--n-close-color-hover":be,"--n-close-color-pressed":ve,"--n-close-icon-size":ge,"--n-close-border-radius":we,"--n-resize-trigger-color-hover":ye}}),k=u?Me("drawer",void 0,R,e):void 0;return{mergedClsPrefix:t,namespace:o,mergedBodyStyle:I,handleMaskClick:c,handleEsc:C,mergedTheme:h,cssVars:u?void 0:R,themeClass:k==null?void 0:k.themeClass,onRender:k==null?void 0:k.onRender,isMounted:l}},render(){const{mergedClsPrefix:e}=this;return i(Ee,{to:this.to,show:this.show},{default:()=>{var t;return(t=this.onRender)===null||t===void 0||t.call(this),W(i("div",{class:[`${e}-drawer-container`,this.namespace,this.themeClass],style:this.cssVars,role:"none"},this.showMask?i(re,{name:"fade-in-transition",appear:this.isMounted},{default:()=>this.show?i("div",{"aria-hidden":!0,class:[`${e}-drawer-mask`,this.showMask==="transparent"&&`${e}-drawer-mask--invisible`],onClick:this.handleMaskClick}):null}):null,i(Qe,Object.assign({},this.$attrs,{class:[this.drawerClass,this.$attrs.class],style:[this.mergedBodyStyle,this.$attrs.style],blockScroll:this.blockScroll,contentStyle:this.contentStyle,placement:this.placement,scrollbarProps:this.scrollbarProps,show:this.show,displayDirective:this.displayDirective,nativeScrollbar:this.nativeScrollbar,onAfterEnter:this.onAfterEnter,onAfterLeave:this.onAfterLeave,trapFocus:this.trapFocus,autoFocus:this.autoFocus,resizable:this.resizable,showMask:this.showMask,onEsc:this.handleEsc,onClickoutside:this.handleMaskClick}),this.$slots)),[[Te,{zIndex:this.zIndex,enabled:this.show}]])}})}}),bt={title:{type:String},headerStyle:[Object,String],footerStyle:[Object,String],bodyStyle:[Object,String],bodyContentStyle:[Object,String],nativeScrollbar:{type:Boolean,default:!0},scrollbarProps:Object,closable:Boolean},vt=Y({name:"DrawerContent",props:bt,setup(){const e=oe(X,null);e||Oe("drawer-content","`n-drawer-content` must be placed inside `n-drawer`.");const{doUpdateShow:t}=e;function o(){t(!1)}return{handleCloseClick:o,mergedTheme:e.mergedThemeRef,mergedClsPrefix:e.mergedClsPrefixRef}},render(){const{title:e,mergedClsPrefix:t,nativeScrollbar:o,mergedTheme:u,bodyStyle:l,bodyContentStyle:h,headerStyle:d,footerStyle:f,scrollbarProps:b,closable:g,$slots:m}=this;return i("div",{role:"none",class:[`${t}-drawer-content`,o&&`${t}-drawer-content--native-scrollbar`]},m.header||e||g?i("div",{class:`${t}-drawer-header`,style:d,role:"none"},i("div",{class:`${t}-drawer-header__main`,role:"heading","aria-level":"1"},m.header!==void 0?m.header():e),g&&i(He,{onClick:this.handleCloseClick,clsPrefix:t,class:`${t}-drawer-header__close`,absolute:!0})):null,o?i("div",{class:`${t}-drawer-body`,style:l,role:"none"},i("div",{class:`${t}-drawer-body-content-wrapper`,style:h,role:"none"},m)):i(te,Object.assign({themeOverrides:u.peerOverrides.Scrollbar,theme:u.peers.Scrollbar},b,{class:`${t}-drawer-body`,contentClass:`${t}-drawer-body-content-wrapper`,contentStyle:h}),m),m.footer?i("div",{class:`${t}-drawer-footer`,style:f,role:"none"},m.footer()):null)}});function gt(e){return Z({url:`api/admin/role/author/${e}`,method:"get"})}function pt(e){return Z({url:"/api/admin/author",method:"GET",params:e})}const Et={__name:"author",setup(e){const t=v(!1),o=v([]),u=v([]),l=v([]),h=v([]),d=v({}),f=v({}),b=[{title:"用户名",key:"username"},{title:"昵称",key:"nickname"},{title:"邮箱",key:"mail"},{title:"操作",key:"actions",width:"250",render(c){return i(L,[i(_,{size:"small",onClick:async()=>{h.value=[],gt(c.authorId).then(p=>{for(let C of p.data)h.value.push(C.roleId)}),f.value=c,t.value=!0}},{default:()=>"角色"}),i(_,{size:"small",onClick:()=>sendMail(c)},{default:()=>"编辑"})])}}],g=[{type:"selection"},{title:"名称",key:"roleName"},{title:"值",key:"roleValue"}],m=c=>c.roleId,B=()=>{pt(d.value).then(c=>{o.value=c.data})},T=()=>{ze().then(c=>{u.value=c.data})},F=c=>{l.value=c},I=()=>{Se(f.value.authorId,l.value)};return Ne(async()=>{B(),T()}),(c,p)=>(We(),Xe(Ye,null,[z($(L),{vertical:""},{default:S(()=>[z($(L),null,{default:S(()=>[z($(_),{type:"primary",onClick:B},{default:S(()=>[j("查询")]),_:1})]),_:1}),z($(J),{columns:b,data:o.value,bordered:!0},null,8,["data"])]),_:1}),z($(mt),{show:t.value,"onUpdate:show":p[2]||(p[2]=C=>t.value=C),width:600},{default:S(()=>[z($(vt),null,{header:S(()=>[j(" 角色管理 ")]),footer:S(()=>[z($(L),null,{default:S(()=>[z($(_),{onClick:p[0]||(p[0]=C=>I())},{default:S(()=>[j("保存")]),_:1}),z($(_),{onClick:p[1]||(p[1]=C=>t.value=!1)},{default:S(()=>[j("取消")]),_:1})]),_:1})]),default:S(()=>[z($(J),{columns:g,data:u.value,"row-key":m,"default-checked-row-keys":h.value,"onUpdate:checkedRowKeys":F},null,8,["data","default-checked-row-keys"])]),_:1})]),_:1},8,["show"])],64))}};export{Et as default};
