import{u as p,d as b,J as f,x as h,y as v,z as s,k as a,P as n,C as l}from"./router-7246853f.js";import{s as c}from"./request-5c6f490a.js";const k={class:"m-3"},w={class:"row mb-3"},g=s("label",{class:"col-sm-2 col-form-label"},"用户名",-1),x={class:"col-sm-10"},y={class:"row mb-3"},V=s("label",{class:"col-sm-2 col-form-label",disabled:""},"邮箱",-1),U={class:"col-sm-10"},B={class:"row mb-3"},C=s("label",{class:"col-sm-2 col-form-label"},"昵称",-1),A={class:"col-sm-10"},M={class:"row mb-3"},P=s("label",{class:"col-sm-2 col-form-label"},"签名",-1),S={class:"col-sm-10"},J={__name:"setting",setup(z){let r=p(),o=b({username:"************",nickname:"********",mail:"****************"}),d=r.username;function m(){c({url:`/api/author/username/${d}`,method:"get"}).then(i=>{o.value=i.data})}function u(){c({url:"/api/author",method:"put",data:o.value}).then(i=>{alert("保存成功")})}function _(){r.logout(),window.location.href="/"}return f(()=>{m()}),(i,t)=>(h(),v("div",k,[s("div",w,[g,s("div",x,[a(s("input",{class:"form-control",disabled:"","onUpdate:modelValue":t[0]||(t[0]=e=>l(o).username=e)},null,512),[[n,l(o).username]])])]),s("div",y,[V,s("div",U,[a(s("input",{type:"text",class:"form-control",disabled:"","onUpdate:modelValue":t[1]||(t[1]=e=>l(o).mail=e)},null,512),[[n,l(o).mail]])])]),s("div",B,[C,s("div",A,[a(s("input",{type:"text",class:"form-control","onUpdate:modelValue":t[2]||(t[2]=e=>l(o).nickname=e)},null,512),[[n,l(o).nickname]])])]),s("div",M,[P,s("div",S,[a(s("input",{class:"form-control",id:"inputPassword3","onUpdate:modelValue":t[3]||(t[3]=e=>l(o).signature=e)},null,512),[[n,l(o).signature]])])]),s("div",null,[s("button",{class:"btn btn-primary",onClick:u},"保存信息"),s("button",{class:"btn btn-primary float-end",onClick:_},"退出登录")])]))}};export{J as default};