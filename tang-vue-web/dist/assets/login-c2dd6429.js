import{b as v,j as b,N as f,C as g,D as t,M as d,H as y,F as a,u as c,S as u,v as p,E as _,K as x,r as S,o as w,Q as I,R as k}from"./github-3fa84727.js";import{s as M,o as N}from"./request-55ac77c7.js";const r=l=>(I("data-v-19896e1a"),l=l(),k(),l),V={class:"modal",style:{display:"inline"}},C={id:"loginModal",class:"modal-dialog"},D={class:"modal-content"},B=r(()=>t("div",{class:"modal-header"},[t("h4",{class:"modal-title text-center"},"登录")],-1)),W={id:"model-body",class:"modal-body"},j=r(()=>t("label",null,"邮箱/用户名：",-1)),E={class:"form-group"},R=r(()=>t("label",null,"密码：",-1)),T={class:"form-group"},U={class:"modal-footer"},F={class:"btn-group W100"},H={class:"btn-group W100"},J={class:"btn-group W100"},K={__name:"login",setup(l){let e=b({rememberMe:!0}),m=x();function h(){M({url:"/api/authenticate",method:"post",data:e.value}).then(s=>{if(s.status===200){debugger;let o=N(s.data);localStorage.setItem("jwt",s.data),localStorage.setItem("author",JSON.stringify(o)),m.push({path:"/author/"+o.sub})}}).catch(s=>{alert(s.data)})}return f(()=>{}),(s,o)=>{const i=S("router-link");return w(),g("div",V,[t("div",C,[t("div",D,[B,t("div",W,[d(y(a(e).value)+" ",1),j,t("div",E,[c(t("input",{type:"text","onUpdate:modelValue":o[0]||(o[0]=n=>a(e).username=n),placeholder:"邮箱/用户名",autocomplete:"off",class:"form-control"},null,512),[[u,a(e).username]])]),R,t("div",T,[c(t("input",{type:"password","onUpdate:modelValue":o[1]||(o[1]=n=>a(e).password=n),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[u,a(e).password]])])]),t("div",U,[t("div",F,[t("button",{type:"button",class:"btn btn-primary",onClick:o[2]||(o[2]=n=>h())},"登录")]),t("div",H,[p(i,{to:"/register",type:"button",class:"btn btn-outline-secondary"},{default:_(()=>[d("注册")]),_:1})]),t("div",J,[p(i,{to:"/",type:"button",class:"btn btn-outline-secondary"},{default:_(()=>[d("返回首页")]),_:1})])])])])])}}},$=v(K,[["__scopeId","data-v-19896e1a"]]);export{$ as default};