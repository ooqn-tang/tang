import{s as c}from"./request-55ac77c7.js";import{K as p,r as m,L as f,x as r,F as g,z as h,B as k,y as n,G as l,n as v,C,H as u,E as b}from"./github-f7596896.js";const x={class:"list-group article-list"},y=["textContent"],E=["onClick"],L={class:"article-synopsis"},B={__name:"subscribe",setup(F){let a=m([]);function _(){c({url:"/api/fans/list",method:"get"}).then(e=>{a.value=e.data.content})}function d(e,s){c({url:`/api/fans/${e}`,method:"DELETE"}).then(o=>{o.data>0&&a.value.splice(s,1)})}return f(()=>{_()}),(e,s)=>{const o=b("router-link");return l(),r("ul",x,[(l(!0),r(g,null,h(k(a),(t,i)=>(l(),r("li",{class:"list-group-item",key:i},[v(o,{target:"_blank",to:{name:"author_article",params:{username:t.username}}},{default:C(()=>[n("strong",{textContent:u(t.nickname)},null,8,y)]),_:2},1032,["to"]),n("span",{class:"float-end",onClick:$=>d(t.username,i)},"取消关注",8,E),n("div",L,u(t.signature),1)]))),128)),n("li",{class:"list-group-item",onClick:s[0]||(s[0]=t=>e.loadArticle())}," 获取 ")])}}},N=p(B,[["__scopeId","data-v-46091080"]]);export{N as default};
