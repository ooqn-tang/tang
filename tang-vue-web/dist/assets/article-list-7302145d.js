import{s as x,f as B}from"./request-596b05ba.js";import{_ as V,i as $}from"./info-3da8b178.js";import{G as T,a as d,H as w,l as A,q as a,t as s,x as e,I,z as n,F as f,y as g,B as y,j as p,D as c,A as b,C as L}from"./preload-helper-b3ec2021.js";const D={class:"row"},F={class:"col-md-9 mb-2 small-col"},j={class:"card mb-2"},q={class:"card-body p-0",style:{padding:"0px !important"}},E={class:"nav"},G=["onClick"],H={class:"list-group",style:{}},M={class:"list-group-item"},S=["textContent"],J={class:"synopsis"},K={class:"date-color",style:{"font-size":"16px"}},O={key:0,class:"date-color",style:{"font-size":"16px"}},P={style:{"font-size":"16px",color:"#dc3545"}},Q={class:"list-group-item"},R={key:1},U={class:"col-md-3 mb-2 small-col"},W={__name:"article-list",setup(X){let u=d(0),r=d({number:0}),_=d([]),m=d(!0),h=d([]);w(()=>{v({categoryId:0}),z()});function k(o){u=o.categoryId,r.value.number=0,_.value=[],v(o)}function z(){x({url:"/api/category/list",method:"get",params:{type:"1"}}).then(o=>{o.data.length>0&&(h.value=o.data)})}function v(o){x({url:"/api/article/list",method:"get",params:{page:r.value.number,categoryId:o.categoryId}}).then(l=>{m.value=!1,r.value=l.data,l.data.content=l.data.content.filter(t=>t.author!=null),_.value=_.value.concat(l.data.content)})}function N(){r.last||(r.value.number+=1,v({categoryId:u.value}))}return(o,i)=>{const l=A("router-link");return a(),s("div",D,[e("div",F,[e("div",j,[e("div",q,[e("nav",E,[e("a",{class:I(["nav-link item-p-link",n(u)=="0"?"nav-link-active":""]),onClick:i[0]||(i[0]=t=>k({categoryId:0}))},"全部",2),(a(!0),s(f,null,g(n(h),t=>(a(),s("a",{class:I([n(u)==t.categoryId?"nav-link-active":"","nav-link item-p-link"]),onClick:C=>k(t)},c(t.name),11,G))),256))])])]),e("ul",H,[(a(!0),s(f,null,g(n(_),t=>(a(),s("li",M,[p(l,{to:{name:"article_post",params:{id:t.articleId}},class:"article-title"},{default:b(()=>[e("strong",null,[e("p",{textContent:c(t.title)},null,8,S)])]),_:2},1032,["to"]),e("div",J,c(t.synopsis),1),e("div",null,[e("span",K,c(n(B)(t.createTime)),1),t.category!=null?(a(),s("span",O," . "+c(t.category.name),1)):y("",!0),(a(!0),s(f,null,g(t.tagList,C=>(a(),s("span",null,[L(" . "),e("span",P,c(C.tagName),1)]))),256)),p(l,{to:{name:"author_article",params:{username:t.author.username}},class:"float-end"},{default:b(()=>[L(c(t.author.nickname),1)]),_:2},1032,["to"])])]))),256)),e("li",Q,[n(m)?y("",!0):(a(),s("a",{key:0,onClick:i[1]||(i[1]=t=>N())},"获取")),n(m)?(a(),s("a",R,"加载中...")):y("",!0)])])]),e("div",U,[p(V),p($)])])}}},et=T(W,[["__scopeId","data-v-fbf9dc84"]]);export{et as default};
