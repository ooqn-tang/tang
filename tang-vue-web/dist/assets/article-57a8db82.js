import{s as _}from"./request-55ac77c7.js";import{b as j,j as p,N as E,C as o,I as L,P as N,F as m,D as a,J as B,L as I,r as T,o as s,v as $,E as v,H as l,G as u,d as V,M as D}from"./github-1ff0047c.js";const S={class:"list-group article-list"},A=["textContent"],F={class:"article-synopsis"},G={class:"tag"},M={key:0,class:"tag"},P={key:1,class:"tag"},U={class:"btn-group float-end"},w=["onClick"],H={class:"list-group-item"},J={__name:"article",setup(R){let h=B(),d=I(),b=d.params.username==h.state.username,r=p([]),c=p({number:0}),k=p([]);function g(n){_({url:`/api/article/list/${d.params.username}`,method:"get",params:{page:n}}).then(t=>{c.value=t.data,r.value=r.value.concat(t.data.content)})}function y(){_({url:`/api/subject/username/${d.params.username}`,method:"GET"}).then(n=>{k.value=n.data})}function C(n,t){_({url:`/api/article/${n}`,method:"DELETE"}).then(i=>{i.status==200&&r.value.splice(t,1)})}function x(){c.value.number+1<c.value.totalPages&&g(c.value.number+1)}return E(()=>{g(0),y()}),(n,t)=>{const i=T("router-link");return s(),o("ul",S,[(s(!0),o(L,null,N(m(r),(e,f)=>(s(),o("li",{class:"list-group-item",key:f},[$(i,{to:{name:"article_post",params:{id:e.articleId}},class:"article-title"},{default:v(()=>[a("strong",null,[a("p",{textContent:l(e.title)},null,8,A)])]),_:2},1032,["to"]),a("div",F,l(e.synopsis),1),a("span",G,l(e.createTime),1),e.subject!=null?(s(),o("span",M,l(e.subject.subjectName),1)):u("",!0),e.category!=null?(s(),o("span",P,l(e.category.name),1)):u("",!0),a("div",U,[m(b)?(s(),o("button",{key:0,class:"btn btn-outline-danger float-end blog-btn",onClick:q=>C(e.articleId,f)}," 删除 ",8,w)):u("",!0),m(b)?(s(),V(i,{key:1,class:"btn btn-outline-danger float-end blog-btn",target:"_blank",to:{name:"article-editor-md",params:{id:e.articleId}}},{default:v(()=>[D(" 修改 ")]),_:2},1032,["to"])):u("",!0)])]))),128)),a("li",H,[a("a",{onClick:t[0]||(t[0]=e=>x())},"获取")])])}}},O=j(J,[["__scopeId","data-v-87ba02f3"]]);export{O as default};