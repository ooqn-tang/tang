import{_ as m,r as h,l as p,d as v,e,f as o,g as t,F as b,m as f,i as x,h as a,s as g,w as k,t as r,p as y,q as w}from"./index.5db2cb1e.js";const C={class:"row"},L={class:"col-md-9 mb-2"},B={class:"row"},A={class:"card move-b-lr-0"},E={class:"card-body"},F={class:"card-text text-truncate"},N=["textContent"],V={class:"card-text text-truncate"},$={class:"col-md-3 mb-2 move-p-lr-0"},q={class:"list-group mb-2 move-b-lr-0"},D={class:"card mb-2 move-b-lr-0"},G={setup(I){let c=h([]);function _(){g({url:"/api/author/selectAuthor",method:"GET"}).then(n=>{c.value=n.data.content})}return p(()=>{_()}),(n,M)=>{const l=v("router-link"),d=y,i=w;return e(),o("div",C,[t("div",L,[t("div",B,[(e(!0),o(b,null,f(x(c),(s,u)=>(e(),o("div",{class:"col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0",key:u},[t("div",A,[t("div",E,[t("p",F,[a(l,{target:"_blank",to:{name:"author_article",params:{username:s.username}}},{default:k(()=>[t("strong",{textContent:r(s.nickname)},null,8,N)]),_:2},1032,["to"])]),t("p",V,"\u7B80\u4ECB\uFF1A"+r(s.signature),1)])])]))),128))])]),t("div",$,[t("div",q,[a(d)]),t("div",D,[a(i)])])])}}},T=m(G,[["__scopeId","data-v-e2356cb0"]]);export{T as default};