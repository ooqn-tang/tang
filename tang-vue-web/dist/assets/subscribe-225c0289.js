import{s as c}from"./request-55ac77c7.js";import{b as p,j as m,N as f,C as r,I as v,P as b,F as g,D as n,r as h,o as l,v as k,E as C,H as u}from"./github-e9c6c174.js";const x={class:"list-group article-list"},y=["textContent"],E=["onClick"],F={class:"article-synopsis"},L={__name:"subscribe",setup(B){let a=m([]);function _(){c({url:"/api/fans/list",method:"get"}).then(e=>{a.value=e.data.content})}function d(e,s){c({url:`/api/fans/${e}`,method:"DELETE"}).then(o=>{o.data>0&&a.value.splice(s,1)})}return f(()=>{_()}),(e,s)=>{const o=h("router-link");return l(),r("ul",x,[(l(!0),r(v,null,b(g(a),(t,i)=>(l(),r("li",{class:"list-group-item",key:i},[k(o,{target:"_blank",to:{name:"author_article",params:{username:t.username}}},{default:C(()=>[n("strong",{textContent:u(t.nickname)},null,8,y)]),_:2},1032,["to"]),n("span",{class:"float-end",onClick:D=>d(t.username,i)},"取消关注",8,E),n("div",F,u(t.signature),1)]))),128)),n("li",{class:"list-group-item",onClick:s[0]||(s[0]=t=>e.loadArticle())}," 获取 ")])}}},I=p(L,[["__scopeId","data-v-db0e7593"]]);export{I as default};
