import{K as D,r as n,L as F,x as l,y as t,B as e,F as g,z as E,D as u,H as m,I as y,n as L,M as $,N as H,C as O,O as j,E as z,G as o,P as R,Q as J,J as K}from"./github-f7596896.js";import{s as _}from"./request-55ac77c7.js";import{_ as Q,i as U}from"./notice-74d52136.js";import{d as W,i as X,a as Y}from"./collect-0e162f1e.js";const b=p=>(R("data-v-94b7c24e"),p=p(),J(),p),Z={class:"row"},tt={class:"col-md-3 col-lg-3 d-md-inline d-none"},et={key:0,class:"list-group mb-2"},st=b(()=>t("a",{class:"list-group-item active"},"专题",-1)),at=["href"],ot={class:"list-group mb-2"},lt=b(()=>t("a",{class:"list-group-item active"},[y("推荐"),t("span",{class:"float-end"},"🎇")],-1)),nt=["href"],it={class:"col-md-9 col-lg-9 pb-5"},ct={class:"row"},rt={class:"col-lg-8"},dt={class:"card mb-2 article-body"},ut={key:0,class:"card-body"},mt={class:"time-font"},_t=["innerHTML"],ht={key:1,class:"card-body"},pt={class:"col-md-4 mb-2"},bt={class:"navbar fixed-bottom navbar-light bg-light foot-navbar"},ft={class:"container-fluid"},vt={class:"col-md-12 col-lg-12"},gt=b(()=>t("a",{class:"btn btn-outline-primary btn-sm mini-but",disabled:""},"举报",-1)),yt=["href"],kt=b(()=>t("a",{class:"btn btn-outline-primary btn-sm mini-but",onclick:"document.body.scrollTop = document.documentElement.scrollTop = 0"},"⬆TOP",-1)),Ct={__name:"article-post",setup(p){const k=j(),C=K();let c=n(1),r=n(k.query.value),T=n(!1),w=n([]),a=n({article:{},author:{}}),I=n(!1),f=n([]),h=n(0),S=n("加载中...");function x(s){c.value==2?_({url:`/api/fans/${s}`,method:"POST"}).then(d=>{c.value=1}):_({url:`/api/fans/${s}`,method:"DELETE"}).then(d=>{c.value=2})}function A(){_({url:`/api/fans/username/${a.value.author.username}`,method:"get"}).then(s=>{s.data==1?c.value=1:c.value=2})}function B(){h.value>=1?W({url:window.location.href}).then(s=>{h.value=0}):X({dataId:r,url:window.location.href,title:a.value.title,synopsis:a.value.synopsis}).then(s=>{h.value=1})}function N(){Y({url:window.location.href}).then(s=>{h.value=s.data})}function P(){_({url:`/api/article/load/${r}`,method:"GET"}).then(s=>{a.value=s.data,I.value=C.state.username==a.value.author.username,A()})}function G(){_({url:`/api/subject/article/${r}`,method:"GET"}).then(s=>{f=s.data})}function M(){_({url:"/api/article/recommend",method:"GET"}).then(s=>{w.value=s.data})}function V(){r=k.params.id,C.state.username!=""&&N(),G(),P()}return F(()=>{V(),M()}),(s,d)=>{const q=z("router-link");return o(),l(g,null,[t("div",Z,[t("div",tt,[e(f).length>0?(o(),l("div",et,[st,(o(!0),l(g,null,E(e(f),(i,v)=>(o(),l("a",{class:$(["list-group-item",i.articleId==e(a).articleId?"active2":""]),key:v,href:"/article/"+i.articleId},m(i.title),11,at))),128))])):u("",!0),t("div",ot,[lt,(o(!0),l(g,null,E(e(w),(i,v)=>(o(),l("a",{class:"list-group-item",key:v,href:"/article/"+i.articleId},m(i.title),9,nt))),128))])]),t("div",it,[t("div",ct,[t("div",rt,[t("div",dt,[e(T)?u("",!0):(o(),l("div",ut,[t("div",null,[t("strong",null,m(e(a).author.nickname),1),y(" . "),t("span",mt,m(e(a).createTime),1),e(c)==2?(o(),l("button",{key:0,class:"btn btn-outline-warning float-end t-b-m-1",onClick:d[0]||(d[0]=i=>x(e(a).author.username))}," 订阅 ")):u("",!0),e(c)==1?(o(),l("button",{key:1,class:"btn btn-outline-warning float-end t-b-m-1",onClick:d[1]||(d[1]=i=>x(e(a).author.username))}," 取消订阅 ")):u("",!0)]),t("h3",null,[t("strong",null,m(e(a).title),1)]),t("div",{class:"markdown-body",innerHTML:e(a).text},null,8,_t)])),e(T)?(o(),l("div",ht,m(e(S)),1)):u("",!0)])]),t("div",pt,[L(Q),L(U)])])])]),t("nav",bt,[t("div",ft,[t("div",vt,[t("a",{class:$([e(h)==1?"btn-outline-danger":"btn-outline-primary","btn btn-sm mini-but m-l-0"]),onClick:B},"收藏",2),gt,t("a",{class:"btn btn-outline-primary btn-sm mini-but",href:"https://api.ooqn.com/article/"+e(r),target:"_blank"},"阅读模式",8,yt),e(I)?(o(),H(q,{key:0,class:"btn btn-outline-primary btn-sm mini-but",target:"_blank",to:{name:"article-editor-md",query:{article:e(r)}}},{default:O(()=>[y("修改")]),_:1},8,["to"])):u("",!0),kt])])])],64)}}},Et=D(Ct,[["__scopeId","data-v-94b7c24e"]]);export{Et as default};
