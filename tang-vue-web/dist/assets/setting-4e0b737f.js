import{u as p,a as b,H as h,q as f,t as v,x as o,g as a,K as n,z as l}from"./preload-helper-2ca1440d.js";import{s as c}from"./request-596b05ba.js";const g={class:"list-group article-list"},w={class:"list-group-item"},k={class:"row mb-3"},x=o("label",{class:"col-2 col-form-label"},"用户名",-1),V={class:"col-10"},y={class:"row mb-3"},U=o("label",{class:"col-2 col-form-label",disabled:""},"邮箱",-1),B={class:"col-10"},A={class:"row mb-3"},C=o("label",{class:"col-2 col-form-label"},"昵称",-1),M={class:"col-10"},S={class:"row mb-3"},q=o("label",{class:"col-2 col-form-label"},"签名",-1),z={class:"col-10"},K={__name:"setting",setup(D){let r=p(),t=b({username:"************",nickname:"********",mail:"****************"}),u=r.author.username;function d(){c({url:`/api/author/username/${u}`,method:"get"}).then(i=>{t.value=i.data})}function m(){c({url:"/api/author",method:"put",data:t.value}).then(i=>{alert("保存成功")})}function _(){r.logout(),window.location.href="/"}return h(()=>{d()}),(i,s)=>(f(),v("ul",g,[o("li",w,[o("div",k,[x,o("div",V,[a(o("input",{class:"form-control",disabled:"","onUpdate:modelValue":s[0]||(s[0]=e=>l(t).username=e)},null,512),[[n,l(t).username]])])]),o("div",y,[U,o("div",B,[a(o("input",{type:"text",class:"form-control",disabled:"","onUpdate:modelValue":s[1]||(s[1]=e=>l(t).mail=e)},null,512),[[n,l(t).mail]])])]),o("div",A,[C,o("div",M,[a(o("input",{type:"text",class:"form-control","onUpdate:modelValue":s[2]||(s[2]=e=>l(t).nickname=e)},null,512),[[n,l(t).nickname]])])]),o("div",S,[q,o("div",z,[a(o("input",{class:"form-control",id:"inputPassword3","onUpdate:modelValue":s[3]||(s[3]=e=>l(t).signature=e)},null,512),[[n,l(t).signature]])])]),o("div",null,[o("button",{class:"btn btn-primary",onClick:m},"保存信息"),o("button",{class:"btn btn-primary float-end",onClick:_},"退出登录")])])]))}};export{K as default};
