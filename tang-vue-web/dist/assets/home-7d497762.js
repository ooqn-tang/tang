import{s as y}from"./request-55ac77c7.js";import{j as w,h,B as x,C as s,D as e,v as a,E as o,F as n,G as d,H as A,I as D,J as C,K as E,L as T,r as f,o as l,M as i}from"./github-3fa84727.js";const B={class:"navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2",id:"top"},L={class:"container-fluid"},N=e("a",{class:"navbar-brand pc",href:"/",style:{"margin-right":"0px"}},"ooqn.com",-1),V=e("a",{class:"navbar-brand yd",href:"/",style:{"margin-right":"0px"}},"🙃",-1),j=e("button",{class:"navbar-toggler",type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarTogglerDemo02","aria-controls":"navbarTogglerDemo02","aria-expanded":"false","aria-label":"Toggle navigation"},[e("span",{class:"navbar-toggler-icon"})],-1),I={class:"collapse navbar-collapse",id:"navbarTogglerDemo02"},R={class:"navbar-nav me-auto mb-lg-0 pc"},S=e("li",{class:"nav-item"},[e("a",{class:"nav-link active",href:"/article"},"📰文章")],-1),F={class:"nav-item"},M={class:"nav-item"},O={class:"nav-item"},$={class:"nav-item"},q={key:0,class:"nav-item"},G=e("a",{class:"nav-link active",href:"/admin.html"},"🧙‍♂️管理",-1),H=[G],J={class:"navbar-nav me-auto mb-lg-0 yd"},K={class:"nav-item dropdown float-start"},P={class:"nav-link active dropdown-toggle",href:"#","data-bs-toggle":"dropdown"},z={class:"dropdown-menu"},Q=e("li",null,[e("a",{class:"dropdown-item",href:"/article"},"📰文章")],-1),U=e("li",null,[e("a",{class:"dropdown-item",href:"/essay"},"📝随笔")],-1),W=e("li",null,[e("a",{class:"dropdown-item",href:"/author"},"👨‍🎓作者")],-1),X=e("li",null,[e("a",{class:"dropdown-item",href:"/subject"},"📒专题")],-1),Y={key:0,class:"dropdown-item",href:"/dynamic"},Z={class:"nav-item float-start"},ee={class:"d-flex d-md-inline"},te={class:"navbar-nav me-auto"},ae={key:0,class:"nav-item"},se={key:1,class:"nav-item"},oe={key:2,class:"nav-item"},ne={key:3,class:"nav-item"},le=["href"],ie={class:"container-fluid"},ue={__name:"home",setup(re){const _=C(),p=E(),m=T();let u=w("菜单"),b=h(()=>{let r=!1;return _.state.author.roleList!=null&&_.state.author.roleList.forEach(c=>{c.roleValue=="ROLE_ADMIN"&&(r=!0)}),r}),v=h(()=>_.state.username!=null&&_.state.username!=""&&_.state.username!=null);x(()=>{m.name=="article"?u.value="文章":m.name=="subject_index"?u.value="专辑":m.name=="author_list"?u.value="作者":u.value="菜单"});function g(){y({url:"/api/article",method:"POST"}).then(r=>{let c=p.resolve({name:"article-editor-md",params:{id:r.data}}),t=document.createElement("a");t.setAttribute("href",c.href),t.setAttribute("target","_blank"),t.setAttribute("id",id),document.getElementById(id)||document.body.appendChild(t),t.click()})}return(r,c)=>{const t=f("router-link"),k=f("router-view");return l(),s(D,null,[e("nav",B,[e("div",L,[N,V,j,e("div",I,[e("ul",R,[S,e("li",F,[a(t,{class:"nav-link active",to:"/essay"},{default:o(()=>[i("📝随笔")]),_:1})]),e("li",M,[a(t,{class:"nav-link active",to:"/author"},{default:o(()=>[i("👨‍🎓作者")]),_:1})]),e("li",O,[a(t,{class:"nav-link active",to:"/subject"},{default:o(()=>[i("📒专题")]),_:1})]),e("li",$,[a(t,{class:"nav-link active",to:"/search"},{default:o(()=>[i("🔍搜索")]),_:1})]),n(b)?(l(),s("li",q,H)):d("",!0)]),e("ul",J,[e("li",K,[e("a",P,A(n(u)),1),e("ul",z,[Q,U,W,X,e("li",null,[n(v)?(l(),s("a",Y,"📒动态")):d("",!0)])])]),e("li",Z,[a(t,{class:"nav-link active",to:"/search"},{default:o(()=>[i("🔍搜索")]),_:1})])]),e("form",ee,[e("ul",te,[n(v)?d("",!0):(l(),s("li",ae,[a(t,{class:"nav-link active",to:"/login"},{default:o(()=>[i("登录")]),_:1})])),n(v)?(l(),s("li",se,[a(t,{class:"nav-link active",to:"/message"},{default:o(()=>[i("消息")]),_:1})])):d("",!0),n(v)?(l(),s("li",oe,[e("span",{class:"nav-link active",onClick:c[0]||(c[0]=ce=>g())},"投稿")])):d("",!0),n(v)?(l(),s("li",ne,[e("a",{class:"nav-link active",href:"/author/"+r.$store.state.username},"我的",8,le)])):d("",!0)])])])])]),e("div",ie,[a(k)])],64)}}};export{ue as default};
