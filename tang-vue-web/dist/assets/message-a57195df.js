import{s as t}from"./request-5c6f490a.js";import{_ as l,i as d}from"./notice-16fe471c.js";import{e as i,J as r,x as m,y as n,z as s,l as e}from"./router-5601b984.js";const _={class:"row"},f=s("div",{class:"col-md-9 small-col"},[s("div",{class:"card"},[s("div",{class:"card-body"})])],-1),p={class:"col-md-3 mb-2 small-col"},B={__name:"message",setup(u){let o=i([{}]);function c(){t({url:"/api/message",method:"GET"}).then(a=>{o.value=a.data})}return r(()=>{c()}),(a,v)=>(m(),n("div",_,[f,s("div",p,[e(l),e(d)])]))}};export{B as default};
