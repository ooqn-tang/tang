import{s as l}from"./request-02cf91c6.js";import{G as d,d as p,H as f,t as m,x as r,y as i,F as b,B as g,C as h,z as n,l as v,J as k,E as c}from"./router-b176819d.js";const C={class:"list-group article-list"},x={class:"list-group-item"},y=["textContent"],E=["onClick"],B={class:"article-synopsis"},F={__name:"subscribe",setup(L){let a=p([]);function u(){l({url:"/api/fans/list",method:"get"}).then(t=>{a.value=t.data.content})}function _(t,s){l({url:`/api/fans/${t}`,method:"DELETE"}).then(o=>{o.data>0&&a.value.splice(s,1)})}return f(()=>{u()}),(t,s)=>{const o=m("router-link");return r(),i("ul",C,[(r(!0),i(b,null,g(h(a),e=>(r(),i("li",x,[v(o,{target:"_blank",to:{name:"author_article",params:{username:e.username}}},{default:k(()=>[n("strong",{textContent:c(e.nickname)},null,8,y)]),_:2},1032,["to"]),n("button",{class:"btn btn-outline-danger float-end fans-but",onClick:$=>_(e.username,t.index)},"取消关注",8,E),n("div",B,c(e.signature),1)]))),256)),n("li",{class:"list-group-item",onClick:s[0]||(s[0]=e=>t.loadArticle())}," 获取 ")])}}},N=d(F,[["__scopeId","data-v-d5532728"]]);export{N as default};
