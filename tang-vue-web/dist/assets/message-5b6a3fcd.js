import{s as i}from"./request-55ac77c7.js";import{a as m,_ as p}from"./notice-580ba3c6.js";import{b as u,j as v,N as h,C as o,D as s,I as f,P as b,F as g,v as l,o as c,H as t,M as y,Q as x,R as k}from"./github-1ff0047c.js";const I=a=>(x("data-v-4bfda86e"),a=a(),k(),a),D={class:"row"},N={class:"col-md-9 mb-2 move-p-lr-0"},S={class:"card move-b-lr-0"},w={class:"card-body",style:{padding:"0"}},B={class:"list-group article-list"},V={class:"row"},E={class:"col"},F=["href"],L={class:"float-end"},M=I(()=>s("br",null,null,-1)),T={class:"col-md-3 mb-2 move-p-lr-0"},$={class:"list-group mb-2 move-b-lr-0"},j={class:"card mb-2 move-b-lr-0"},C={__name:"message",setup(a){let _=v([{}]);function r(){i({url:"/api/message",method:"GET"}).then(d=>{_.value=d.data})}return h(()=>{r()}),(d,G)=>(c(),o("div",D,[s("div",N,[s("div",S,[s("div",w,[s("ul",B,[(c(!0),o(f,null,b(g(_),(e,n)=>(c(),o("li",{class:"list-group-item",key:n},[s("div",V,[s("div",E,[s("a",{target:"_blank",href:e.url},t(e.nickname)+t(e.title),9,F),s("span",L,t(e.createDate),1),M,y(" "+t(e.text),1)])])]))),128))])])])]),s("div",T,[s("div",$,[l(m)]),s("div",j,[l(p)])])]))}},R=u(C,[["__scopeId","data-v-4bfda86e"]]);export{R as default};