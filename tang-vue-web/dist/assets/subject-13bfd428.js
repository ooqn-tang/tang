import{b as u,j as m,J as p,B as e,C as s,G as b,L as h,E as v,v as o,I as f,o as c,D as x,M as a,S as j,r as g}from"./github-2cfdd9fa.js";import{_ as y,i as k}from"./notice-8b177a27.js";import{s as B}from"./request-55ac77c7.js";const L={class:"row clearfix"},S={class:"col-md-9"},w={class:"row"},C={class:"card"},E={class:"card-body",style:{}},I={class:"card-text text-truncate"},N={class:"card-text text-truncate"},D={class:"card-text text-truncate"},G={class:"col-md-3 mb-2"},M={class:"list-group mb-2"},V={class:"card mb-2"},F={__name:"subject",setup(J){const _=f();j();let n=m([]);_.getters.username,p(()=>{d()});function d(){B({url:"/api/subject/list",method:"GET"}).then(r=>{n.value=r.data.content})}return(r,R)=>{const l=g("router-link");return c(),e("div",L,[s("div",S,[s("div",w,[(c(!0),e(b,null,h(v(n),(t,i)=>(c(),e("div",{class:"col-xl-3 col-lg-4 col-md-4 col-12 mb-2",key:i},[s("div",C,[s("div",E,[s("p",I,[o(l,{to:{name:"subject_post",params:{subject_id:t.subjectId}}},{default:x(()=>[s("strong",null,a(t.subjectName),1)]),_:2},1032,["to"])]),s("p",N,"作者："+a(t.author.nickname),1),s("p",D,"专辑描述："+a(t.synopsis),1)])])]))),128))])]),s("div",G,[s("div",M,[o(y)]),s("div",V,[o(k)])])])}}},z=u(F,[["__scopeId","data-v-e8993bed"]]);export{z as default};
