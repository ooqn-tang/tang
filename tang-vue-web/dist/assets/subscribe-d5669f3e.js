import{s as l}from"./request-651d32a9.js";import{G as d,a as p,H as f,q as m,s as r,t as i,F as b,y as g,z as h,x as n,j as v,A as k,D as c}from"./preload-helper-3003bc42.js";const x={class:"list-group article-list"},C={class:"list-group-item"},y=["textContent"],E=["onClick"],F={class:"article-synopsis"},L={__name:"subscribe",setup(B){let a=p([]);function u(){l({url:"/api/fans/list",method:"get"}).then(t=>{a.value=t.data.content})}function _(t,s){l({url:`/api/fans/${t}`,method:"DELETE"}).then(o=>{o.data>0&&a.value.splice(s,1)})}return f(()=>{u()}),(t,s)=>{const o=m("router-link");return r(),i("ul",x,[(r(!0),i(b,null,g(h(a),e=>(r(),i("li",C,[v(o,{target:"_blank",to:{name:"author_article",params:{username:e.username}}},{default:k(()=>[n("strong",{textContent:c(e.nickname)},null,8,y)]),_:2},1032,["to"]),n("button",{class:"btn btn-outline-danger float-end fans-but",onClick:D=>_(e.username,t.index)},"取消关注",8,E),n("div",F,c(e.signature),1)]))),256)),n("li",{class:"list-group-item",onClick:s[0]||(s[0]=e=>t.loadArticle())}," 获取 ")])}}},M=d(L,[["__scopeId","data-v-d5532728"]]);export{M as default};
