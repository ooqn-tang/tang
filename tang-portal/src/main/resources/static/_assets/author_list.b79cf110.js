let t=document.createElement("style");t.innerHTML="body{overflow-y:scroll}",document.head.appendChild(t);import{a}from"./author.cecec28a.js";import{o as e,c as s,b as o,F as r,g as l,f as c,r as n,i as d,t as i}from"./index.b78c9def.js";var m={name:"author_list",data:()=>({authorList:[]}),methods:{authorListBlogCount(){a().then((t=>{this.authorList=t.data.list}))}},mounted(){this.authorListBlogCount()}};const u={class:"row"},b={class:"col-md-9 mb-2"},p={class:"row"},h={class:"card move-b-lr-0"},v={class:"card-body"},f={class:"card-text text-truncate"},g={class:"card-text text-truncate"},x={class:"card-text text-truncate"},y={class:"col-md-3 mb-2 move-p-lr-0"},k={class:"list-group mb-2 move-b-lr-0"},_=c('<div class="card mb-2 move-b-lr-0"><div class="card-body"><p><a href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e" target="_blank">关于</a></p><p><a href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd" target="_blank">友情链接</a></p><p><a href="http://beian.miit.gov.cn" target="_blank">湘ICP备20009234号</a></p><a href="/map" class="hidden">地图</a></div></div>',1);m.render=function(t,a,c,m,C,L){const w=n("router-link"),j=n("notice");return e(),s("div",u,[o("div",b,[o("div",p,[(e(!0),s(r,null,l(C.authorList,((t,a)=>(e(),s("div",{class:"col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0",key:a},[o("div",h,[o("div",v,[o("p",f,[o(w,{target:"_blank",to:{name:"author_blog",params:{username:t.username}}},{default:d((()=>[o("strong",{textContent:i(t.nickname)},null,8,["textContent"])])),_:2},1032,["to"])]),o("p",g,"简介："+i(t.signature),1),o("p",x,"文章数："+i(t.count),1)])])])))),128))])]),o("div",y,[o("div",k,[o(j)]),_])])};export default m;
