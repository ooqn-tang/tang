let a=document.createElement("style");a.innerHTML=".m-r-5-px[data-v-3b7c8340]{margin-right:5px}.date-color[data-v-3b7c8340]{color:#00285a}p[data-v-3b7c8340]{margin:0}body[data-v-3b7c8340]{overflow-y:scroll}",document.head.appendChild(a);import{c as e}from"./blog.dc5ee4a9.js";import{p as t,a as l,o as s,c as n,b as r,t as o,d as i,F as d,w as c,e as v,f as b,r as m}from"./index.b78c9def.js";var u={name:"home",data:()=>({title:"菜单"}),computed:{name(){}},created(){},methods:{createBlog(){e().then((a=>{let e=this.$router.resolve({name:"blog-editor",params:{id:a.data}});window.open(e.href,"_blank"),this.$refs.close.click()}))}},mounted(){"blog"==this.$route.name?this.title="文章":"subject_index"==this.$route.name?this.title="专辑":"author_list"==this.$route.name?this.title="作者":this.title="菜单"}};const g=c("data-v-3b7c8340");t("data-v-3b7c8340");const p={class:"navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2",id:"top"},h={class:"container-fluid"},f=r("a",{class:"navbar-brand pc",href:"/",style:{"margin-right":"0px"}},"🙃堂堂程序员",-1),k=r("a",{class:"navbar-brand yd",href:"/",style:{"margin-right":"0px"}},"🙃",-1),w=r("button",{class:"navbar-toggler",type:"button","data-bs-toggle":"collapse","data-bs-target":"#navbarTogglerDemo02","aria-controls":"navbarTogglerDemo02","aria-expanded":"false","aria-label":"Toggle navigation"},[r("span",{class:"navbar-toggler-icon"})],-1),x={class:"collapse navbar-collapse",id:"navbarTogglerDemo02"},y={class:"navbar-nav me-auto mb-lg-0 pc"},_=r("li",{class:"nav-item"},[r("a",{class:"nav-link",href:"/"},"🏠主页")],-1),$=r("li",{class:"nav-item"},[r("a",{class:"nav-link",href:"/blog"},"📰文章")],-1),j={class:"nav-item"},T=v("👨‍🎓作者"),D={class:"nav-item"},B=v("📒专题"),C={class:"nav-item"},E=v("🔍搜索"),F={class:"navbar-nav me-auto mb-lg-0 yd"},H={class:"nav-item dropdown float-start"},I={class:"nav-link dropdown-toggle",href:"#",id:"dropdown03","data-bs-toggle":"dropdown","aria-expanded":"false"},L=b('<ul class="dropdown-menu" aria-labelledby="dropdown03" data-v-3b7c8340><li data-v-3b7c8340><a class="dropdown-item" href="/" data-v-3b7c8340>🏠主页</a></li><li data-v-3b7c8340><a class="dropdown-item" href="/blog" data-v-3b7c8340>📰文章</a></li><li data-v-3b7c8340><a class="dropdown-item" href="/authors" data-v-3b7c8340>👨‍🎓作者</a></li><li data-v-3b7c8340><a class="dropdown-item" href="/subject" data-v-3b7c8340>📒专题</a></li></ul>',1),M={class:"nav-item float-start"},q=v("🔍搜索"),z={class:"d-flex d-md-inline"},A={class:"navbar-nav me-auto"},G={key:0,class:"nav-item"},J=v("登录"),K={key:1,class:"nav-item dropdown"},N={key:2,class:"nav-item"},O={class:"container-fluid"};l();const P=g(((a,e,t,l,c,v)=>{const b=m("router-link"),u=m("router-view");return s(),n(d,null,[r("nav",p,[r("div",h,[f,k,w,r("div",x,[r("ul",y,[_,$,r("li",j,[r(b,{class:"nav-link",to:"/authors"},{default:g((()=>[T])),_:1})]),r("li",D,[r(b,{class:"nav-link",to:"/subject"},{default:g((()=>[B])),_:1})]),r("li",C,[r(b,{class:"nav-link",to:"/search"},{default:g((()=>[E])),_:1})])]),r("ul",F,[r("li",H,[r("a",I,o(c.title),1),L]),r("li",M,[r(b,{class:"nav-link",to:"/search"},{default:g((()=>[q])),_:1})])]),r("form",z,[r("ul",A,[""==a.$store.state.username?(s(),n("li",G,[r(b,{class:"nav-link",to:"/login"},{default:g((()=>[J])),_:1})])):i("",!0),""!=a.$store.state.username?(s(),n("li",K,[r("a",{class:"nav-link",onClick:e[1]||(e[1]=a=>v.createBlog())},"投稿")])):i("",!0),""!=a.$store.state.username?(s(),n("li",N,[r("a",{class:"nav-link",href:"/author/"+a.$store.state.username},"我的",8,["href"])])):i("",!0)])])])])]),r("div",O,[r(u)])],64)}));u.render=P,u.__scopeId="data-v-3b7c8340";export default u;
