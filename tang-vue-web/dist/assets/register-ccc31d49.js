import{G as v,a as f,H as b,l as h,q as g,t as w,x as t,g as n,K as i,z as a,j as p,A as u,C as _,M as y,N as x}from"./preload-helper-b3ec2021.js";import{s as I}from"./request-596b05ba.js";const d=l=>(y("data-v-2b799c04"),l=l(),x(),l),V={class:"modal",style:{display:"inline"}},k={class:"modal-dialog"},S={class:"modal-content"},C=d(()=>t("div",{class:"modal-header"},[t("h4",{class:"modal-title text-center"},"注册")],-1)),M={id:"model-body",class:"modal-body"},N=d(()=>t("label",null,"邮箱：",-1)),B={class:"input-group"},U=d(()=>t("label",null,"密码：",-1)),j={class:"form-group"},D=d(()=>t("label",null,"确认密码：",-1)),T={class:"form-group"},q={class:"modal-footer"},z={class:"btn-group w-100"},A={class:"btn-group w-100"},E={class:"btn-group w-100"},G={__name:"register",setup(l){let o=f({username:"",password:"",mail:"",password1:"",rememberMe:!0});function m(){if(o.value.password!==o.value.password1){alert("两次密码不一致");return}I({url:"/api/register",method:"post",data:o.value}).then(r=>{alert(r.data)}).catch(r=>{alert(r.data)})}return b(()=>{localStorage.removeItem("jwt"),localStorage.removeItem("author")}),(r,e)=>{const c=h("router-link");return g(),w("div",V,[t("div",k,[t("div",S,[C,t("div",M,[N,t("div",B,[n(t("input",{type:"text","onUpdate:modelValue":e[0]||(e[0]=s=>a(o).mail=s),placeholder:"邮箱号",autocomplete:"off",class:"form-control"},null,512),[[i,a(o).mail]])]),U,t("div",j,[n(t("input",{type:"password","onUpdate:modelValue":e[1]||(e[1]=s=>a(o).password=s),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[i,a(o).password]])]),D,t("div",T,[n(t("input",{type:"password","onUpdate:modelValue":e[2]||(e[2]=s=>a(o).password1=s),placeholder:"确认密码",autocomplete:"off",class:"form-control"},null,512),[[i,a(o).password1]])])]),t("div",q,[t("div",z,[t("button",{type:"button",class:"btn btn-primary",onClick:e[3]||(e[3]=s=>m())},"注册")]),t("div",A,[p(c,{to:"/login",type:"button",class:"btn btn-outline-secondary"},{default:u(()=>[_("登录")]),_:1})]),t("div",E,[p(c,{to:"/",type:"button",class:"btn btn-outline-secondary"},{default:u(()=>[_("返回首页")]),_:1})])])])])])}}},$=v(G,[["__scopeId","data-v-2b799c04"]]);export{$ as default};