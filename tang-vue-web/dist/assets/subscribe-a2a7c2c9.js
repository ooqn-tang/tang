import{s as c}from"./request-5c6f490a.js";import{d as _,J as m,t as f,x as r,y as l,F as h,B as k,C as g,z as n,l as C,D as v,G as u}from"./router-7246853f.js";const x={class:"list-group article-list"},y=["textContent"],B=["onClick"],E={class:"article-synopsis"},$={__name:"subscribe",setup(F){let a=_([]);function d(){c({url:"/api/fans/list",method:"get"}).then(t=>{a.value=t.data.content})}function p(t,s){c({url:`/api/fans/${t}`,method:"DELETE"}).then(o=>{o.data>0&&a.value.splice(s,1)})}return m(()=>{d()}),(t,s)=>{const o=f("router-link");return r(),l("ul",x,[(r(!0),l(h,null,k(g(a),(e,i)=>(r(),l("li",{class:"list-group-item",key:i},[C(o,{target:"_blank",to:{name:"author_article",params:{username:e.username}}},{default:v(()=>[n("strong",{textContent:u(e.nickname)},null,8,y)]),_:2},1032,["to"]),n("span",{class:"float-end",onClick:L=>p(e.username,i)},"取消关注",8,B),n("div",E,u(e.signature),1)]))),128)),n("li",{class:"list-group-item",onClick:s[0]||(s[0]=e=>t.loadArticle())}," 获取 ")])}}};export{$ as default};
