import{h as m,B as n,C as t,v as a,D as s,E as i,F as c,G as g,r as h,o as l,H as o,I as p}from"./github-2cfdd9fa.js";const b={class:"navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2",id:"top"},k={class:"container-fluid"},y=t("a",{class:"navbar-brand pc",href:"/",style:{"margin-right":"0px"}},"ooqn.com",-1),w=t("a",{class:"navbar-brand yd",href:"/",style:{"margin-right":"0px"}},"🙃",-1),x=t("button",{class:"navbar-toggler",type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarTogglerDemo02","aria-controls":"navbarTogglerDemo02","aria-expanded":"false","aria-label":"Toggle navigation"},[t("span",{class:"navbar-toggler-icon"})],-1),V={class:"collapse navbar-collapse",id:"navbarTogglerDemo02"},D={class:"navbar-nav me-auto mb-lg-0 pc"},N={class:"nav-item"},T={class:"nav-item"},B={class:"nav-item"},C={class:"nav-item"},E={class:"nav-item"},L={key:0,class:"nav-item"},j=t("a",{class:"nav-link active",href:"/admin.html"},"🧙‍♂️管理",-1),A=[j],F={class:"navbar-nav me-auto mb-lg-0 yd"},I={class:"nav-item dropdown float-start"},q=t("a",{class:"nav-link active dropdown-toggle",href:"#","data-bs-toggle":"dropdown"},"菜单",-1),G={class:"dropdown-menu"},H={key:0},M=t("a",{class:"dropdown-item",href:"/admin.html"},"🧙‍♂️管理",-1),O=[M],R={class:"nav-item float-start"},S={class:"d-flex d-md-inline"},$={class:"navbar-nav me-auto"},z={key:0,class:"nav-item"},J={key:1,class:"nav-item"},K={key:2,class:"nav-item"},P=t("a",{class:"nav-link active",href:"/article-editor-md",target:"_blank"},"投稿",-1),Q=[P],U={key:3,class:"nav-item"},W={class:"container-fluid"},Z={__name:"home",setup(X){const r=p();let v=m(()=>{let _=!1;return r.state.author.roleList!=null&&r.state.author.roleList.forEach(u=>{(u.roleValue=="ROLE_ADMIN"||u.roleValue=="role_admin")&&(_=!0)}),_}),d=m(()=>r.state.username!=null&&r.state.username!=""&&r.state.username!=null);return(_,u)=>{const e=h("router-link"),f=h("router-view");return l(),n(g,null,[t("nav",b,[t("div",k,[y,w,x,t("div",V,[t("ul",D,[t("li",N,[a(e,{class:"nav-link active",to:"/article"},{default:s(()=>[o("📰文章")]),_:1})]),t("li",T,[a(e,{class:"nav-link active",to:"/essay"},{default:s(()=>[o("📝随笔")]),_:1})]),t("li",B,[a(e,{class:"nav-link active",to:"/author"},{default:s(()=>[o("👨‍🎓作者")]),_:1})]),t("li",C,[a(e,{class:"nav-link active",to:"/subject"},{default:s(()=>[o("📒专题")]),_:1})]),t("li",E,[a(e,{class:"nav-link active",to:"/search"},{default:s(()=>[o("🔍搜索")]),_:1})]),i(v)?(l(),n("li",L,A)):c("",!0)]),t("ul",F,[t("li",I,[q,t("ul",G,[t("li",null,[a(e,{class:"dropdown-item",to:"/article"},{default:s(()=>[o("📰文章")]),_:1})]),t("li",null,[a(e,{class:"dropdown-item",to:"/essay"},{default:s(()=>[o("📝随笔")]),_:1})]),t("li",null,[a(e,{class:"dropdown-item",to:"/author"},{default:s(()=>[o("👨‍🎓作者")]),_:1})]),t("li",null,[a(e,{class:"dropdown-item",to:"/subject"},{default:s(()=>[o("📒专题")]),_:1})]),t("li",null,[a(e,{class:"dropdown-item",to:"/search"},{default:s(()=>[o("🔍搜索")]),_:1})]),i(v)?(l(),n("li",H,O)):c("",!0)])]),t("li",R,[a(e,{class:"nav-link active",to:"/search"},{default:s(()=>[o("🔍搜索")]),_:1})])]),t("form",S,[t("ul",$,[i(d)?c("",!0):(l(),n("li",z,[a(e,{class:"nav-link active",to:"/login"},{default:s(()=>[o("登录")]),_:1})])),i(d)?(l(),n("li",J,[a(e,{class:"nav-link active",to:"/message"},{default:s(()=>[o("消息")]),_:1})])):c("",!0),i(d)?(l(),n("li",K,Q)):c("",!0),i(d)?(l(),n("li",U,[a(e,{class:"nav-link active",to:"/author/"+_.$store.state.username},{default:s(()=>[o("我的")]),_:1},8,["to"])])):c("",!0)])])])])]),t("div",W,[a(f)])],64)}}};export{Z as default};
