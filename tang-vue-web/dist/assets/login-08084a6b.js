import{G as g,a as v,O as b,l as y,q as w,t as x,x as t,C as i,D as S,z as a,g as u,K as p,j as _,A as m,M as I,N}from"./preload-helper-b3ec2021.js";import{s as d}from"./request-596b05ba.js";async function k(o){return d({url:"/api/authenticate",method:"post",data:o})}function V(){return d({url:"/api/author/role/list",method:"get"})}function A(){return d({url:"/api/author",method:"get"})}const c=o=>(I("data-v-61797b61"),o=o(),N(),o),C={class:"modal",style:{display:"inline"}},D={id:"loginModal",class:"modal-dialog"},M={class:"modal-content"},R=c(()=>t("div",{class:"modal-header"},[t("h4",{class:"modal-title text-center"},"登录")],-1)),B={id:"model-body",class:"modal-body"},O=c(()=>t("label",null,"邮箱/用户名：",-1)),j={class:"form-group"},J=c(()=>t("label",null,"密码：",-1)),T={class:"form-group"},U={class:"modal-footer"},q={class:"btn-group w-100"},z={class:"btn-group w-100"},E={class:"btn-group w-100"},G={__name:"login",setup(o){let s=v({rememberMe:!0}),h=b();async function f(){let r=await k(s.value);if(r.status===200){localStorage.setItem("jwt",r.data);let e=await A(),l=await V();localStorage.setItem("author",JSON.stringify(e.data)),localStorage.setItem("roles",JSON.stringify(l.data)),h.push({path:"/author/"+e.data.username})}}return(r,e)=>{const l=y("router-link");return w(),x("div",C,[t("div",D,[t("div",M,[R,t("div",B,[i(S(a(s).value)+" ",1),O,t("div",j,[u(t("input",{type:"text","onUpdate:modelValue":e[0]||(e[0]=n=>a(s).username=n),placeholder:"邮箱/用户名",autocomplete:"off",class:"form-control"},null,512),[[p,a(s).username]])]),J,t("div",T,[u(t("input",{type:"password","onUpdate:modelValue":e[1]||(e[1]=n=>a(s).password=n),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[p,a(s).password]])])]),t("div",U,[t("div",q,[t("button",{type:"button",class:"btn btn-primary",onClick:e[2]||(e[2]=n=>f())},"登录")]),t("div",z,[_(l,{to:"/register",type:"button",class:"btn btn-outline-secondary"},{default:m(()=>[i("注册")]),_:1})]),t("div",E,[_(l,{to:"/",type:"button",class:"btn btn-outline-secondary"},{default:m(()=>[i("返回首页")]),_:1})])])])])])}}},F=g(G,[["__scopeId","data-v-61797b61"]]);export{F as default};