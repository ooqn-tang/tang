import{_ as p,a as f,b as m,u as g,r as u,l as h,d as k,e as o,f as r,F as b,m as v,i as C,g as l,s as c,h as x,w as y,t as E}from"./index.5db2cb1e.js";const F={class:"list-group article-list"},L=["textContent"],B=["onClick"],$={setup(w){f(),m(),g(),u({number:0});let a=u([]);function _(){c({url:"/api/fans/list",method:"get"}).then(e=>{a.value=e.data.content})}function d(e,t){c({url:`/api/fans/${e}`,method:"DELETE"}).then(n=>{n.data>0&&a.value.splice(t,1)})}return h(()=>{_()}),(e,t)=>{const n=k("router-link");return o(),r("ul",F,[(o(!0),r(b,null,v(C(a),(s,i)=>(o(),r("li",{class:"list-group-item",key:i},[x(n,{target:"_blank",to:{name:"author_article",params:{username:s.username}}},{default:y(()=>[l("strong",{textContent:E(s.nickname)},null,8,L)]),_:2},1032,["to"]),l("span",{class:"float-end",onClick:D=>d(s.username,i)},"\u53D6\u6D88\u5173\u6CE8",8,B)]))),128)),l("li",{class:"list-group-item",onClick:t[0]||(t[0]=s=>e.loadArticle())}," \u83B7\u53D6 ")])}}},N=p($,[["__scopeId","data-v-d4fd5bec"]]);export{N as default};