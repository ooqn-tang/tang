import{s as h}from"./request-90d4e0a2.js";import{I as f,L as v,d as b,J as y,t as j,x as n,y as r,z as s,G as e,C as a,l,D as _,F as x,B as g,H as k,N as I,O as N}from"./router-2d2d1606.js";import{_ as B,i as C}from"./notice-4adee1b0.js";const D=o=>(I("data-v-19777a2f"),o=o(),N(),o),S={class:"row clearfix"},w={class:"col-md-9 small-col"},T={class:"card mb-2"},V={class:"card-body"},A=D(()=>s("hr",null,null,-1)),E={class:"float-end"},F={class:"list-group mb-2"},G=["textContent"],L={class:"article-synopsis"},P={class:"date-color"},$={class:"col-md-3 mb-2 small-col"},z={class:"list-group mb-2"},H={class:"card mb-2"},J={__name:"subject-post",setup(o){let u=v(),t=b({subject:{subjectName:"∷∷∷∷∷∷∷∷∷",synopsis:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷",createDate:"∷∷∷∷∷∷∷"},author:{username:"∷∷∷∷∷∷∷∷∷",nickname:"∷∷∷∷∷∷∷∷∷"},dataArray:[]});function p(){h({url:`/api/subject/id/${u.params.subject_id}`,method:"GET"}).then(i=>{t.value=i.data})}return y(()=>{p()}),(i,M)=>{const d=j("router-link");return n(),r("div",S,[s("div",w,[s("div",T,[s("div",V,[s("h4",null,e(a(t).subjectName),1),s("span",null,e(a(t).synopsis),1),A,s("div",null,[l(d,{to:"/author/"+a(t).author.username},{default:_(()=>[k(e(a(t).author.nickname),1)]),_:1},8,["to"]),s("span",E,e(a(t).createTime),1)])])]),s("ul",F,[(n(!0),r(x,null,g(a(t).dataArray,(c,m)=>(n(),r("li",{class:"list-group-item",key:m},[l(d,{to:{name:"article_post",params:{id:c.articleId}},class:"article-title"},{default:_(()=>[s("strong",null,[s("p",{textContent:e(c.title)},null,8,G)])]),_:2},1032,["to"]),s("div",L,e(c.synopsis),1),s("div",null,[s("span",P,e(c.createDate),1)])]))),128))])]),s("div",$,[s("div",z,[l(B)]),s("div",H,[l(C)])])])}}},K=f(J,[["__scopeId","data-v-19777a2f"]]);export{K as default};
