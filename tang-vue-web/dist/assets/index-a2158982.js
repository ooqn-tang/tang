import{s as h}from"./request-5c6f490a.js";import{I as N,Q as V,L as j,u as B,e as c,g as D,J as R,t as y,x as p,y as f,z as t,H as b,C as e,l as a,D as r,K as u,E as g,G as _,O as T,P as z}from"./router-5601b984.js";import{_ as A,i as L}from"./notice-16fe471c.js";const O=d=>(T("data-v-35418bd3"),d=d(),z(),d),P={class:"row clearfix"},U={class:"col-md-4 col-md-push-8 small-col"},F={class:"card mb-2"},G={class:"card-body"},H=["textContent"],J=O(()=>t("hr",null,null,-1)),K={class:"d-md-inline d-none"},M={class:"col-md-8 col-md-pull-4 mb-2 small-col"},Q={class:"card"},q={class:"card-header p-0"},W={class:"nav justify-content-center"},X={class:"nav-item"},Y={class:"nav-item"},Z={key:0,class:"nav-item"},ee={key:1,class:"nav-item"},te={key:2,class:"nav-item"},se={class:"card-body",style:{padding:"0px"}},ae={__name:"index",setup(d){let C=V(),x=j(),w=B(),n=c(x.name),m=c({nickname:"∷∷∷∷∷∷∷∷",signature:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"}),o=c(""),k=w.username;c({page:1});let l=c(1);function S(s){l.value==2?h({url:`/api/fans/${s}`,method:"POST"}).then(v=>{l.value=1}):h({url:`/api/fans/${s}`,method:"DELETE"}).then(v=>{l.value=2})}D(()=>x.name,s=>{n.value=s});function $(){h({url:`/api/fans/username/${o}`,method:"get"}).then(s=>{s.data>0?l.value=1:l.value=2})}function E(){h({url:`/api/author/username/${o}`,method:"get"}).then(s=>{s.status==200&&(m.value=s.data)})}return R(()=>{o=C.currentRoute.value.params.username,E(),$()}),(s,v)=>{const i=y("router-link"),I=y("router-view");return p(),f("div",P,[t("div",U,[t("div",F,[t("div",G,[t("strong",null,b(e(m).nickname),1),t("button",{class:"btn btn-outline-warning float-end fans-but",onClick:v[0]||(v[0]=ne=>S(e(m).username)),textContent:b(e(l)==2?"订阅":"取消订阅")},null,8,H),J,t("div",null,"简介："+b(e(m).signature),1)])]),t("div",K,[a(A),a(L)])]),t("div",M,[t("div",Q,[t("div",q,[t("ul",W,[t("li",X,[a(i,{class:u(["nav-link",e(n)=="author_article"?"nav-link-active":""]),to:{name:"author_article"}},{default:r(()=>[_("文章")]),_:1},8,["class"])]),t("li",Y,[a(i,{class:u(["nav-link",e(n)=="author_subject"?"nav-link-active":""]),to:{name:"author_subject"}},{default:r(()=>[_("专栏")]),_:1},8,["class"])]),e(o)==e(k)?(p(),f("li",Z,[a(i,{class:u(["nav-link",e(n)=="author_subscribe"?"nav-link-active":""]),to:{name:"author_subscribe"}},{default:r(()=>[_("订阅")]),_:1},8,["class"])])):g("",!0),e(o)==e(k)?(p(),f("li",ee,[a(i,{class:u(["nav-link",e(n)=="author_collect"?"nav-link-active":""]),to:{name:"author_collect"}},{default:r(()=>[_("收藏")]),_:1},8,["class"])])):g("",!0),e(o)==e(k)?(p(),f("li",te,[a(i,{class:u(["nav-link",e(n)=="author_setting"?"nav-link-active":""]),to:{name:"author_setting"}},{default:r(()=>[_("设置")]),_:1},8,["class"])])):g("",!0)])]),t("div",se,[a(I)])])])])}}},ce=N(ae,[["__scopeId","data-v-35418bd3"]]);export{ce as default};
