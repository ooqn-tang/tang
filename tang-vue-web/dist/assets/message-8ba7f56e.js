import{b as h,j as f,J as g,B as o,C as t,u as b,R as y,E as c,G as A,L as x,Q as k,o as n,H as B,M as d,O as S,P as w}from"./github-2cfdd9fa.js";import{s as m}from"./request-55ac77c7.js";const E=a=>(S("data-v-7c5f5ef2"),a=a(),w(),a),I={class:"row"},V={class:"col-md-8 mb-2"},L={class:"mb-2"},M={class:"card"},N={class:"card-body",style:{height:"6.5em"}},T={class:"input-group",style:{height:"100%"}},C={class:"card"},D={class:"card-body"},j={class:"float-end"},F=E(()=>t("div",{class:"btn-group btn-group-sm",role:"group","aria-label":"Basic outlined example",style:{width:"100%"}},[t("button",{type:"button",class:"btn btn-outline-secondary"},"评论"),t("button",{type:"button",class:"btn btn-outline-secondary"},"转发"),t("button",{type:"button",class:"btn btn-outline-secondary"},"喜欢"),t("button",{type:"button",class:"btn btn-outline-secondary"},"转发")],-1)),G=k('<div class="col-md-4 mb-2" data-v-7c5f5ef2><ul class="list-group" data-v-7c5f5ef2><li class="list-group-item" data-v-7c5f5ef2>An item</li><li class="list-group-item" data-v-7c5f5ef2>A second item</li><li class="list-group-item" data-v-7c5f5ef2>A third item</li><li class="list-group-item" data-v-7c5f5ef2>A fourth item</li><li class="list-group-item" data-v-7c5f5ef2>And a fifth one</li><li class="list-group-item" data-v-7c5f5ef2>An item</li><li class="list-group-item" data-v-7c5f5ef2>A second item</li><li class="list-group-item" data-v-7c5f5ef2>A third item</li><li class="list-group-item" data-v-7c5f5ef2>A fourth item</li><li class="list-group-item" data-v-7c5f5ef2>And a fifth one</li><li class="list-group-item" data-v-7c5f5ef2>An item</li><li class="list-group-item" data-v-7c5f5ef2>A second item</li><li class="list-group-item" data-v-7c5f5ef2>A third item</li><li class="list-group-item" data-v-7c5f5ef2>A fourth item</li><li class="list-group-item" data-v-7c5f5ef2>And a fifth one</li><li class="list-group-item" data-v-7c5f5ef2>An item</li><li class="list-group-item" data-v-7c5f5ef2>A second item</li></ul></div>',1),H={__name:"message",setup(a){let r=f({number:0}),i=f([]),l={text:""};function p(){m({url:"/api/essay",method:"get",params:{page:r.value.number}}).then(e=>{r.value=e.data,i.value=i.value.concat(e.data.content)})}function v(){m({url:"/api/essay",method:"post",data:l}).then(e=>{l={},i.value.unshift(e.data)})}return g(()=>{p()}),(e,u)=>(n(),o("div",I,[t("div",V,[t("div",L,[t("div",M,[t("div",N,[t("div",T,[b(t("textarea",{"onUpdate:modelValue":u[0]||(u[0]=s=>c(l).text=s),class:"form-control",id:"textarea",style:{height:"100%"}},null,512),[[y,c(l).text]]),t("button",{class:"btn btn-outline-secondary",type:"button",id:"button-addon2",onClick:v},"发送")])])])]),(n(!0),o(A,null,x(c(i),(s,_)=>(n(),o("div",{class:"mb-2",key:_},[t("div",C,[t("div",D,[t("p",null,[B(d(s.author.nickname)+" ",1),t("span",j,d(s.createTime),1)]),t("div",null,d(s.text),1),F])])]))),128))]),G]))}},P=h(H,[["__scopeId","data-v-7c5f5ef2"]]);export{P as default};
