import{s as v}from"./request-651d32a9.js";import{G as j,O as B,J as E,u as V,a as c,e as A,H as D,q as y,s as f,t as p,x as t,D as k,z as e,j as a,A as r,I as u,B as g,C as _,M as R,N as T}from"./preload-helper-3003bc42.js";import{_ as z,i as M}from"./info-e0b80c69.js";const O=d=>(R("data-v-a4f1bbb1"),d=d(),T(),d),U={class:"row clearfix"},q={class:"col-md-4 col-md-push-8 small-col"},F={class:"card mb-2"},G={class:"card-body"},H=["textContent"],J=O(()=>t("hr",null,null,-1)),L={class:"d-md-inline d-none"},P={class:"col-md-8 col-md-pull-4 mb-2 small-col"},K={class:"card"},Q={class:"card-header p-0"},W={class:"nav justify-content-center"},X={class:"nav-item"},Y={class:"nav-item"},Z={key:0,class:"nav-item"},ee={key:1,class:"nav-item"},te={key:2,class:"nav-item"},se={class:"card-body",style:{padding:"0px"}},ae={__name:"index",setup(d){let C=B(),x=E(),w=V(),n=c(x.name),m=c({nickname:"∷∷∷∷∷∷∷∷",signature:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"}),o=c(""),b=w.author.username;c({page:1});let l=c(1);function S(s){l.value==2?v({url:`/api/fans/${s}`,method:"POST"}).then(h=>{l.value=1}):v({url:`/api/fans/${s}`,method:"DELETE"}).then(h=>{l.value=2})}A(()=>x.name,s=>{n.value=s});function N(){v({url:`/api/fans/username/${o}`,method:"get"}).then(s=>{s.data>0?l.value=1:l.value=2})}function $(){v({url:`/api/author/username/${o}`,method:"get"}).then(s=>{s.status==200&&(m.value=s.data)})}return D(()=>{o=C.currentRoute.value.params.username,$(),N()}),(s,h)=>{const i=y("router-link"),I=y("router-view");return f(),p("div",U,[t("div",q,[t("div",F,[t("div",G,[t("strong",null,k(e(m).nickname),1),t("button",{class:"btn btn-outline-warning float-end fans-but",onClick:h[0]||(h[0]=ne=>S(e(m).username)),textContent:k(e(l)==2?"订阅":"取消订阅")},null,8,H),J,t("div",null,"简介："+k(e(m).signature),1)])]),t("div",L,[a(z),a(M)])]),t("div",P,[t("div",K,[t("div",Q,[t("ul",W,[t("li",X,[a(i,{class:u(["nav-link",e(n)=="author_article"?"nav-link-active":""]),to:{name:"author_article"}},{default:r(()=>[_("文章")]),_:1},8,["class"])]),t("li",Y,[a(i,{class:u(["nav-link",e(n)=="author_subject"?"nav-link-active":""]),to:{name:"author_subject"}},{default:r(()=>[_("专栏")]),_:1},8,["class"])]),e(o)==e(b)?(f(),p("li",Z,[a(i,{class:u(["nav-link",e(n)=="author_subscribe"?"nav-link-active":""]),to:{name:"author_subscribe"}},{default:r(()=>[_("订阅")]),_:1},8,["class"])])):g("",!0),e(o)==e(b)?(f(),p("li",ee,[a(i,{class:u(["nav-link",e(n)=="author_collect"?"nav-link-active":""]),to:{name:"author_collect"}},{default:r(()=>[_("收藏")]),_:1},8,["class"])])):g("",!0),e(o)==e(b)?(f(),p("li",te,[a(i,{class:u(["nav-link",e(n)=="author_setting"?"nav-link-active":""]),to:{name:"author_setting"}},{default:r(()=>[_("设置")]),_:1},8,["class"])])):g("",!0)])]),t("div",se,[a(I)])])])])}}},ce=j(ae,[["__scopeId","data-v-a4f1bbb1"]]);export{ce as default};
