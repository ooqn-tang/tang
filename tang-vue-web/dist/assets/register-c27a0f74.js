import{G as v,d as f,H as h,t as b,x as g,y,z as t,k as n,M as i,C as a,l as p,J as u,K as _,O as w,P as x}from"./router-f99ea542.js";import{s as k}from"./request-02cf91c6.js";const r=l=>(w("data-v-30691a04"),l=l(),x(),l),I={class:"modal",style:{display:"inline"}},V={class:"modal-dialog"},S={class:"modal-content"},C=r(()=>t("div",{class:"modal-header"},[t("h4",{class:"modal-title text-center"},"注册")],-1)),M={id:"model-body",class:"modal-body"},B=r(()=>t("label",null,"邮箱：",-1)),N={class:"input-group"},U=r(()=>t("label",null,"密码：",-1)),W={class:"form-group"},D=r(()=>t("label",null,"确认密码：",-1)),T={class:"form-group"},j={class:"modal-footer"},z={class:"btn-group w100"},E={class:"btn-group w100"},G={class:"btn-group w100"},H={__name:"register",setup(l){let o=f({username:"",password:"",mail:"",password1:"",rememberMe:!0});function m(){if(o.value.password!==o.value.password1){alert("两次密码不一致");return}k({url:"/api/register",method:"post",data:o.value}).then(d=>{alert(d.data)}).catch(d=>{alert(d.data)})}return h(()=>{localStorage.removeItem("jwt"),localStorage.removeItem("author")}),(d,e)=>{const c=b("router-link");return g(),y("div",I,[t("div",V,[t("div",S,[C,t("div",M,[B,t("div",N,[n(t("input",{type:"text","onUpdate:modelValue":e[0]||(e[0]=s=>a(o).mail=s),placeholder:"邮箱号",autocomplete:"off",class:"form-control"},null,512),[[i,a(o).mail]])]),U,t("div",W,[n(t("input",{type:"password","onUpdate:modelValue":e[1]||(e[1]=s=>a(o).password=s),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[i,a(o).password]])]),D,t("div",T,[n(t("input",{type:"password","onUpdate:modelValue":e[2]||(e[2]=s=>a(o).password1=s),placeholder:"确认密码",autocomplete:"off",class:"form-control"},null,512),[[i,a(o).password1]])])]),t("div",j,[t("div",z,[t("button",{type:"button",class:"btn btn-primary",onClick:e[3]||(e[3]=s=>m())},"注册")]),t("div",E,[p(c,{to:"/login",type:"button",class:"btn btn-outline-secondary"},{default:u(()=>[_("登录")]),_:1})]),t("div",G,[p(c,{to:"/",type:"button",class:"btn btn-outline-secondary"},{default:u(()=>[_("返回首页")]),_:1})])])])])])}}},O=v(H,[["__scopeId","data-v-30691a04"]]);export{O as default};
