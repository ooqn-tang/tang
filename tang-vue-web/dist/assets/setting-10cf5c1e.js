import{I as v,r as b,J as h,x as g,y as s,l as n,R as i,B as e,H as w,E as k,P as x,Q as y}from"./github-1130d390.js";import{s as m,r as I}from"./request-55ac77c7.js";const c=a=>(x("data-v-5da0f840"),a=a(),y(),a),U={class:"m-3"},V={class:"row mb-3"},B=c(()=>s("label",{class:"col-sm-2 col-form-label"},"用户名",-1)),S={class:"col-sm-10"},C={class:"row mb-3"},E=c(()=>s("label",{class:"col-sm-2 col-form-label",disabled:""},"邮箱",-1)),M={class:"col-sm-10"},P={class:"row mb-3"},T=c(()=>s("label",{class:"col-sm-2 col-form-label"},"昵称",-1)),A={class:"col-sm-10"},D={class:"row mb-3"},H=c(()=>s("label",{class:"col-sm-2 col-form-label"},"签名",-1)),J={class:"col-sm-10"},N={__name:"setting",setup(a){let r=w(),t=b({username:"",nickname:"",mail:"",headUrl:"https://avatars.githubusercontent.com/u/15867678?v=4"}),u=r.state.username;function _(){m({url:`/api/author/${u}`,method:"get"}).then(d=>{t.value=d.data})}function p(){m({url:"/api/author",method:"put",data:t.value}).then(d=>{alert("保存成功")})}function f(){I(r),window.location.href="/"}return h(()=>{_()}),(d,o)=>(k(),g("div",U,[s("div",V,[B,s("div",S,[n(s("input",{class:"form-control",disabled:"","onUpdate:modelValue":o[0]||(o[0]=l=>e(t).username=l)},null,512),[[i,e(t).username]])])]),s("div",C,[E,s("div",M,[n(s("input",{type:"text",class:"form-control",disabled:"","onUpdate:modelValue":o[1]||(o[1]=l=>e(t).mail=l)},null,512),[[i,e(t).mail]])])]),s("div",P,[T,s("div",A,[n(s("input",{type:"text",class:"form-control","onUpdate:modelValue":o[2]||(o[2]=l=>e(t).nickname=l)},null,512),[[i,e(t).nickname]])])]),s("div",D,[H,s("div",J,[n(s("input",{class:"form-control",id:"inputPassword3","onUpdate:modelValue":o[3]||(o[3]=l=>e(t).signature=l)},null,512),[[i,e(t).signature]])])]),s("div",null,[s("button",{class:"btn btn-primary",onClick:p},"保存信息"),s("button",{class:"btn btn-primary float-end",onClick:f},"退出登录")])]))}},$=v(N,[["__scopeId","data-v-5da0f840"]]);export{$ as default};