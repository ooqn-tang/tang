import{G as z,J as O,u as U,a as i,H as J,e as N,l as K,q as o,t as l,x as t,z as e,D as c,C as T,B as p,g as Q,K as W,F as y,y as g,j as R,I as B,L as X,A as Y,M as Z,N as tt,n as et}from"./preload-helper-2ca1440d.js";import{s as h}from"./request-596b05ba.js";import{_ as st,i as at}from"./info-86cfaa29.js";import{d as ot,i as lt,a as nt}from"./collect-78643e43.js";import{a as it}from"./subject-00162416.js";function rt(d){return h({url:"/api/remark",method:"post",data:d})}function ct(d,b){return h({url:`/api/remark/${d}/list`,method:"get",params:{pageNum:b}})}const m=d=>(Z("data-v-233e98ca"),d=d(),tt(),d),dt={class:"row"},ut={class:"col-md-9 col-lg-9"},mt={class:"row"},_t={class:"col-lg-12 small-col"},ht={class:"card mb-2 article-body"},pt={key:0,class:"card-body"},bt={id:"title"},ft={class:"time-font"},vt=m(()=>t("hr",null,null,-1)),kt=["innerHTML"],yt={key:1,class:"card-body"},gt={class:"card mb-2"},xt={class:"card-body"},wt=m(()=>t("label",{for:"exampleFormControlTextarea1",class:"form-label"},"评论",-1)),Tt={class:"mb-2"},Ct=m(()=>t("button",{class:"btn btn-outline-secondary btn-sm",type:"button"},"表情🙂",-1)),It={class:"card mb-2"},At={class:"card-body"},Lt={style:{color:"rgb(0, 89, 255)"}},St={class:"col-md-3 col-lg-3 d-md-inline small-col"},Et={key:0,class:"list-group mb-2"},$t=m(()=>t("a",{class:"list-group-item active"},"专题",-1)),jt={class:"list-group mb-2"},Nt=m(()=>t("a",{class:"list-group-item active"},[T("推荐"),t("span",{class:"float-end"},"🎇")],-1)),Rt=["href"],Bt={class:"list-group mb-2",style:{position:"sticky",top:"10px"}},Mt=m(()=>t("a",{class:"list-group-item active"},[T("目录"),t("span",{class:"float-end"},"🎇")],-1)),Vt=["id","href"],qt={class:"navbar fixed-bottom navbar-light bg-light foot-navbar p-0"},Dt={class:"container-fluid"},Ft={class:"row"},Pt={class:"col-md-12 col-lg-12 small-col",style:{"padding-top":"3px","padding-bottom":"5px"}},Gt=m(()=>t("a",{class:"btn btn-outline-primary btn-sm ssm me-1",disabled:""},"举报",-1)),Ht=["href"],zt=["href"],Ot=m(()=>t("a",{class:"btn btn-outline-primary btn-sm ssm me-1",onclick:"document.body.scrollTop = document.documentElement.scrollTop = 0"},"⬆TOP",-1)),Ut={__name:"article-post",setup(d){const b=O(),C=U();let _=i(1),u=i(b.query.value),I=i(!1),A=i([]),n=i({author:{}}),x=i([{remarkId:"1",text:"alksdjfkajsdf"},{remarkId:"1",text:"alksdjfkajsdf"}]),L=i(!1),w=i([]),f=i(0),M=i("加载中..."),S=i([]),v=i({});function E(s){_.value==2?h({url:`/api/fans/${s}`,method:"POST"}).then(r=>{_.value=1}):h({url:`/api/fans/${s}`,method:"DELETE"}).then(r=>{_.value=2})}function V(){v.value.dataId=u,rt(v.value).then(s=>{x.value.unshift(s.data),v.value.text=""})}function $(){ct(u,0).then(s=>{x.value=s.data.content})}function q(){h({url:`/api/fans/username/${n.value.author.username}`,method:"get"}).then(s=>{s.data==1?_.value=1:_.value=2})}function D(){f.value>=1?ot({url:window.location.href}).then(s=>{f.value=0}):lt({dataId:u,url:window.location.href,title:n.value.title,synopsis:n.value.synopsis}).then(s=>{f.value=1})}function F(){nt({url:window.location.href}).then(s=>{f.value=s.data})}function P(){h({url:`/api/article/load/${u}`,method:"GET"}).then(s=>{n.value=s.data,L.value=C.author.username==n.value.author.username,q()})}function G(){it(u).then(s=>{w.value=s.data.dataArray})}function H(){h({url:"/api/article/recommend",method:"GET"}).then(s=>{A.value=s.data})}function j(){u=b.params.id,C.username!=""&&F(),G(),P()}return J(()=>{j(),H(),$()}),N(()=>b.params.id,()=>{j(),$(),document.body.scrollTop=document.documentElement.scrollTop=0}),N(()=>n.value.text,async()=>{await et();let s=document.querySelectorAll(".markdown-body h1,.markdown-body h2,.markdown-body h3,.markdown-body h4,.markdown-body h5,.markdown-body h6"),r=[];for(let k=0;k<s.length;k++){let a=s[k];r.push({id:a.id,text:a.innerText})}S.value=r}),(s,r)=>{const k=K("router-link");return o(),l(y,null,[t("div",dt,[t("div",ut,[t("div",mt,[t("div",_t,[t("div",ht,[e(I)?p("",!0):(o(),l("div",pt,[t("h3",bt,[t("strong",null,c(e(n).title),1)]),t("div",null,[t("strong",null,c(e(n).author.nickname),1),T(" . "),t("span",ft,c(e(n).createTime),1),e(_)==2?(o(),l("button",{key:0,class:"btn btn-outline-warning float-end btn-sm ssm",onClick:r[0]||(r[0]=a=>E(e(n).author.username))}," 订阅 ")):p("",!0),e(_)==1?(o(),l("button",{key:1,class:"btn btn-outline-warning float-end btn-sm ssm",onClick:r[1]||(r[1]=a=>E(e(n).author.username))}," 取消订阅 ")):p("",!0),vt]),t("div",{class:"markdown-body",innerHTML:e(n).text},null,8,kt)])),e(I)?(o(),l("div",yt,c(e(M)),1)):p("",!0)]),t("div",gt,[t("div",xt,[wt,t("div",Tt,[Q(t("textarea",{class:"form-control",rows:"3",placeholder:"输入的内容不包含标签的内容会在最后追加标签中的内容。","onUpdate:modelValue":r[2]||(r[2]=a=>e(v).text=a)},null,512),[[W,e(v).text]])]),Ct,t("button",{class:"btn btn-outline-secondary btn-sm float-end",type:"button",onClick:V},"发送")])]),(o(!0),l(y,null,g(e(x),a=>(o(),l("div",It,[t("div",At,[t("p",Lt,c(a.author!=null?a.author.nickname:"未知"),1),t("p",null,c(a.text),1)])]))),256))])])]),t("div",St,[e(w).length>0?(o(),l("div",Et,[$t,(o(!0),l(y,null,g(e(w),a=>(o(),X(k,{class:B(["list-group-item",a.articleId==e(n).articleId?"active2":""]),to:"/article/"+a.articleId},{default:Y(()=>[t("div",null,c(a.title),1)]),_:2},1032,["class","to"]))),256))])):p("",!0),t("div",jt,[Nt,(o(!0),l(y,null,g(e(A),a=>(o(),l("a",{class:"list-group-item",href:"/article/"+a.articleId},c(a.title),9,Rt))),256))]),R(st),R(at),t("div",Bt,[Mt,(o(!0),l(y,null,g(e(S),a=>(o(),l("a",{class:"list-group-item",id:a.id,href:"#"+a.id},c(a.text),9,Vt))),256))])])]),t("nav",qt,[t("div",Dt,[t("div",Ft,[t("div",Pt,[t("a",{class:B([e(f)==1?"btn-outline-danger":"btn-outline-primary","btn btn-sm ssm m-l-0 me-1"]),onClick:D},"收藏",2),Gt,t("a",{class:"btn btn-outline-primary btn-sm ssm me-1",href:"https://www.ooqn.com/article/"+e(u),target:"_blank"},"阅读模式",8,Ht),e(L)?(o(),l("a",{key:0,class:"btn btn-outline-primary btn-sm ssm me-1",target:"_blank",href:"/article-editor-md?article="+e(u)},"修改",8,zt)):p("",!0),Ot])])])])],64)}}},Yt=z(Ut,[["__scopeId","data-v-233e98ca"]]);export{Yt as default};
