import{s as d}from"./request-55ac77c7.js";import{a as u,_ as m}from"./notice-580ba3c6.js";import{b as h,j as p,N as v,C as e,D as t,I as f,P as x,F as b,v as o,r as g,o as a,E as k,H as n}from"./github-1ff0047c.js";const y={class:"row"},C={class:"col-md-9 mb-2"},L={class:"row"},w={class:"card move-b-lr-0"},B={class:"card-body"},E={class:"card-text text-truncate"},N=["textContent"],A={class:"card-text text-truncate"},D={class:"col-md-3 mb-2 move-p-lr-0"},F={class:"list-group mb-2 move-b-lr-0"},I={class:"card mb-2 move-b-lr-0"},V={__name:"author-list",setup($){let c=p([]);function _(){d({url:"/api/author/selectAuthor",method:"GET"}).then(r=>{c.value=r.data.content})}return v(()=>{_()}),(r,j)=>{const l=g("router-link");return a(),e("div",y,[t("div",C,[t("div",L,[(a(!0),e(f,null,x(b(c),(s,i)=>(a(),e("div",{class:"col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0",key:i},[t("div",w,[t("div",B,[t("p",E,[o(l,{target:"_blank",to:{name:"author_article",params:{username:s.username}}},{default:k(()=>[t("strong",{textContent:n(s.nickname)},null,8,N)]),_:2},1032,["to"])]),t("p",A,"简介："+n(s.signature),1)])])]))),128))])]),t("div",D,[t("div",F,[o(u)]),t("div",I,[o(m)])])])}}},P=h(V,[["__scopeId","data-v-1c09e6f9"]]);export{P as default};