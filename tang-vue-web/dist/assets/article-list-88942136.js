import{s as C}from"./request-5c6f490a.js";import{_ as N,i as B}from"./notice-16fe471c.js";import{I as V,e as d,J as $,t as D,x as a,y as s,z as e,K as I,C as r,F as y,B as g,E as f,l as p,H as n,D as b,G as L}from"./router-5601b984.js";const E={class:"row"},F={class:"col-md-9 mb-2 small-col"},T={class:"card mb-2"},A={class:"card-body p-0",style:{padding:"0px !important"}},G={class:"nav"},H=["onClick"],J={class:"list-group",style:{}},K={class:"list-group-item"},M=["textContent"],S={class:"article-synopsis",style:{color:"#5f5a5a","white-space":"nowrap",overflow:"hidden","text-overflow":"ellipsis"}},j={class:"date-color",style:{"font-size":"16px"}},q={key:0,class:"date-color",style:{"font-size":"16px"}},O={style:{"font-size":"16px",color:"#dc3545"}},P={class:"list-group-item"},Q={key:1},R={class:"col-md-3 mb-2 small-col"},U={__name:"article-list",setup(W){let u=d(0),c=d({number:0}),_=d([]),m=d(!0),h=d([]);$(()=>{v({categoryId:0}),w()});function k(o){u=o.categoryId,c.value.number=0,_.value=[],v(o)}function w(){C({url:"/api/category/list",method:"get",params:{type:"1"}}).then(o=>{o.data.length>0&&(h.value=o.data)})}function v(o){C({url:"/api/article/list",method:"get",params:{page:c.value.number,categoryId:o.categoryId}}).then(l=>{m.value=!1,c.value=l.data,l.data.content=l.data.content.filter(t=>t.author!=null),_.value=_.value.concat(l.data.content)})}function z(){c.last||(c.value.number+=1,v({categoryId:u.value}))}return(o,i)=>{const l=D("router-link");return a(),s("div",E,[e("div",F,[e("div",T,[e("div",A,[e("nav",G,[e("a",{class:I(["nav-link item-p-link",r(u)=="0"?"nav-link-active":""]),onClick:i[0]||(i[0]=t=>k({categoryId:0}))},"全部",2),(a(!0),s(y,null,g(r(h),t=>(a(),s("a",{class:I([r(u)==t.categoryId?"nav-link-active":"","nav-link item-p-link"]),onClick:x=>k(t)},n(t.name),11,H))),256))])])]),e("ul",J,[(a(!0),s(y,null,g(r(_),t=>(a(),s("li",K,[p(l,{to:{name:"article_post",params:{id:t.articleId}},class:"article-title"},{default:b(()=>[e("strong",null,[e("p",{textContent:n(t.title)},null,8,M)])]),_:2},1032,["to"]),e("div",S,n(t.synopsis),1),e("div",null,[e("span",j,n(t.createTime),1),t.category!=null?(a(),s("span",q," . "+n(t.category.name),1)):f("",!0),(a(!0),s(y,null,g(t.tagList,x=>(a(),s("span",null,[L(" . "),e("span",O,n(x.tagName),1)]))),256)),p(l,{to:{name:"author_article",params:{username:t.author.username}},class:"float-end"},{default:b(()=>[L(n(t.author.nickname),1)]),_:2},1032,["to"])])]))),256)),e("li",P,[r(m)?f("",!0):(a(),s("a",{key:0,onClick:i[1]||(i[1]=t=>z())},"获取")),r(m)?(a(),s("a",Q,"加载中...")):f("",!0)])])]),e("div",R,[p(N),p(B)])])}}},tt=V(U,[["__scopeId","data-v-de96fb24"]]);export{tt as default};
