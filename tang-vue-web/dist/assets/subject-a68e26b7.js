import{u,R as m,d as p,J as h,t as b,x as e,y as o,z as s,F as f,B as v,C as x,l as c,D as j,G as a}from"./router-7246853f.js";import{_ as k,i as g}from"./notice-7b947d3f.js";import{s as y}from"./request-5c6f490a.js";const B={class:"row clearfix"},S={class:"col-md-9 small-col"},w={class:"row"},C={class:"card"},L={class:"card-body"},N={class:"card-text text-truncate"},D={class:"card-text text-truncate"},E={class:"card-text text-truncate"},F={class:"col-md-3 mb-2 small-col"},G={class:"list-group mb-2"},R={class:"card mb-2"},M={__name:"subject",setup(V){const l=u();m();let r=p([]);l.username,h(()=>{d()});function d(){y({url:"/api/subject/list",method:"GET"}).then(n=>{r.value=n.data.content})}return(n,z)=>{const i=b("router-link");return e(),o("div",B,[s("div",S,[s("div",w,[(e(!0),o(f,null,v(x(r),(t,_)=>(e(),o("div",{class:"col-xl-3 col-lg-4 col-md-4 col-12 mb-2",key:_},[s("div",C,[s("div",L,[s("p",N,[c(i,{to:{name:"subject_post",params:{subject_id:t.subjectId}}},{default:j(()=>[s("strong",null,a(t.subjectName),1)]),_:2},1032,["to"])]),s("p",D,"作者："+a(t.author.nickname),1),s("p",E,"专辑描述："+a(t.synopsis),1)])])]))),128))])]),s("div",F,[s("div",G,[c(k)]),s("div",R,[c(g)])])])}}};export{M as default};
