import{s as _}from"./request-55ac77c7.js";import{b as j,j as p,B,C as o,I as E,O as L,F as m,D as a,L as I,J as N,o as s,v as T,E as v,H as l,G as i,d as $,K as V,r as D}from"./github-6eaaf46c.js";const S={class:"list-group article-list"},A=["textContent"],F={class:"article-synopsis"},G={class:"tag"},U={key:0,class:"tag"},q={key:1,class:"tag"},w={class:"btn-group float-end"},H=["onClick"],J={class:"list-group-item"},K={__name:"article",setup(M){let h=I(),d=N(),g=d.params.username==h.state.username,r=p([]),c=p({number:0}),k=p([]);function b(n){_({url:`/api/article/list/${d.params.username}`,method:"get",params:{page:n}}).then(t=>{c.value=t.data,r.value=r.value.concat(t.data.content)})}function y(){_({url:`/api/subject/username/${d.params.username}`,method:"GET"}).then(n=>{k.value=n.data})}function C(n,t){_({url:`/api/article/${n}`,method:"DELETE"}).then(u=>{u.status==200&&r.value.splice(t,1)})}function x(){c.value.number+1<c.value.totalPages&&b(c.value.number+1)}return B(()=>{b(0),y()}),(n,t)=>{const u=D("router-link");return s(),o("ul",S,[(s(!0),o(E,null,L(m(r),(e,f)=>(s(),o("li",{class:"list-group-item",key:f},[T(u,{to:{name:"article_post",params:{id:e.articleId}},class:"article-title"},{default:v(()=>[a("strong",null,[a("p",{textContent:l(e.title)},null,8,A)])]),_:2},1032,["to"]),a("div",F,l(e.synopsis),1),a("span",G,l(e.createTime),1),e.subject!=null?(s(),o("span",U,l(e.subject.subjectName),1)):i("",!0),e.category!=null?(s(),o("span",q,l(e.category.name),1)):i("",!0),a("div",w,[m(g)?(s(),o("button",{key:0,class:"btn btn-outline-danger float-end blog-btn",onClick:O=>C(e.articleId,f)}," 删除 ",8,H)):i("",!0),m(g)?(s(),$(u,{key:1,class:"btn btn-outline-danger float-end blog-btn",target:"_blank",to:{name:"article-editor-md",query:{article:e.articleId}}},{default:v(()=>[V(" 修改 ")]),_:2},1032,["to"])):i("",!0)])]))),128)),a("li",J,[a("a",{onClick:t[0]||(t[0]=e=>x())},"获取")])])}}},z=j(K,[["__scopeId","data-v-1ee73ae1"]]);export{z as default};
