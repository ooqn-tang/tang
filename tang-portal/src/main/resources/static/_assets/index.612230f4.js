let e=document.createElement("style");e.innerHTML="body{overflow-y:scroll}",document.head.appendChild(e);import{s as a}from"./author.126194e0.js";import{i as s,d as t,a as n}from"./fans.0c954413.js";import{o as i,c as l,b as r,t as o,d as c,e as u,r as m}from"./index.7f4a8142.js";var h={name:"author_index",data(){return{routeName:this.$route.name,author:{},thisUsername:"",loginUsername:this.$store.state.username,from:{page:1},fans:1}},components:{},methods:{fansClick(e){2==this.fans?s(e).then((e=>{this.fans=1})):t(e).then((e=>{this.fans=2}))},isFans(){n(this.thisUsername).then((e=>{1==e.data?this.fans=1:this.fans=2}))},selectTypeClick(e){this.routeName=e,this.$router.push({name:e})},selectAuthor(e){a(e).then((e=>{this.author=e.data}))}},created(){this.selectAuthor(this.$route.params.username)},mounted(){this.thisUsername=this.$route.params.username,""!=this.$store.state.username&&this.isFans()}};const d={class:"row clearfix"},k={class:"col-md-4 col-md-push-8"},p={class:"card mb-2"},v={class:"card-body "},f=r("hr",null,null,-1),b=u("简介："),y={class:"list-group mb-2  d-md-inline d-none"},C={class:"col-md-8 col-md-pull-4 mb-2"},g={class:"card"},x={class:"card-header"},_={class:"nav justify-content-center"},U={class:"nav-item"},N={class:"nav-item"},T={key:0,class:"nav-item"},j={key:1,class:"nav-item"},$={key:2,class:"nav-item"},w={class:"card-body p-0"};h.render=function(e,a,s,t,n,u){const h=m("notice"),z=m("router-view");return i(),l("div",d,[r("div",k,[r("div",p,[r("div",v,[r("strong",null,o(n.author.nickname),1),2==n.fans?(i(),l("button",{key:0,class:"btn btn-outline-warning float-end",style:{padding:"0px 5px 0px 3px","font-size":"13px"},onClick:a[1]||(a[1]=e=>u.fansClick(n.author.username))},"订阅")):c("",!0),1==n.fans?(i(),l("button",{key:1,class:"btn btn-outline-warning float-end",style:{padding:"0px 5px 0px 3px","font-size":"13px"},onClick:a[2]||(a[2]=e=>u.fansClick(n.author.username))},"取消订阅")):c("",!0),f,r("div",null,[b,r("span",null,o(n.author.signature),1)])])]),r("div",y,[r(h)])]),r("div",C,[r("div",g,[r("div",x,[r("ul",_,[r("li",U,[r("a",{class:["nav-link","author_blog"==n.routeName?"nav-link-active":""],onClick:a[3]||(a[3]=e=>u.selectTypeClick("author_blog"))},"博客",2)]),r("li",N,[r("a",{class:["nav-link","author_subject"==n.routeName?"nav-link-active":""],onClick:a[4]||(a[4]=e=>u.selectTypeClick("author_subject"))},"专栏",2)]),n.thisUsername==n.loginUsername?(i(),l("li",T,[r("a",{class:["nav-link","author_subscribe"==n.routeName?"nav-link-active":""],onClick:a[5]||(a[5]=e=>u.selectTypeClick("author_subscribe"))},"订阅",2)])):c("",!0),n.thisUsername==n.loginUsername?(i(),l("li",j,[r("a",{class:["nav-link","author_like"==n.routeName?"nav-link-active":""],onClick:a[6]||(a[6]=e=>u.selectTypeClick("author_like"))},"喜欢",2)])):c("",!0),n.thisUsername==n.loginUsername?(i(),l("li",$,[r("a",{class:["nav-link","author_setting"==n.routeName?"nav-link-active":""],onClick:a[7]||(a[7]=e=>u.selectTypeClick("author_setting"))},"设置",2)])):c("",!0)])]),r("div",w,[r(z)])])])])};export default h;
