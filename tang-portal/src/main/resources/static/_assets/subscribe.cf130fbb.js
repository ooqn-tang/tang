let t=document.createElement("style");t.innerHTML="body{overflow-y:scroll}",document.head.appendChild(t);import{f as s,d as e}from"./fans.e27036d1.js";import{o as a,c as n,F as o,f as l,b as i,r,i as d,t as c}from"./index.a3a8cc74.js";var u={name:"author_subscribe",data:()=>({fansList:[]}),components:{},methods:{fansListMethod(){s().then((t=>{this.fansList=t.data.list}))},deleteFansMethod(t,s){e(t).then((t=>{200==t.code&&this.fansList.splice(s,1)}))}},mounted(){this.fansListMethod()}};const m={class:"list-group blog-list"},f={class:"list-group-item "};u.render=function(t,s,e,u,h,p){const g=r("router-link");return a(),n("ul",m,[(a(!0),n(o,null,l(h.fansList,((t,s)=>(a(),n("li",{class:"list-group-item",key:s},[i(g,{target:"_blank",to:{name:"author_blog",params:{username:t.username}}},{default:d((()=>[i("strong",{textContent:c(t.nickname)},null,8,["textContent"])])),_:2},1032,["to"]),i("span",{class:"float-end",onClick:e=>p.deleteFansMethod(t.username,s)},"取消关注",8,["onClick"])])))),128)),i("li",f,[i("a",{class:"",onClick:s[1]||(s[1]=s=>t.loadBlog())},"获取")])])};export default u;
