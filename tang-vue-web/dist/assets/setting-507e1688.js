import{b as v,j as h,N as f,C as g,D as s,u as n,S as c,F as e,J as w,o as k,Q as x,R as y}from"./github-3fa84727.js";import{s as u,r as S}from"./request-55ac77c7.js";const i=a=>(x("data-v-e4b110c9"),a=a(),y(),a),U={class:"m-3"},V={class:"row mb-3"},I=i(()=>s("label",{class:"col-sm-2 col-form-label"},"用户名",-1)),B={class:"col-sm-10"},C={class:"row mb-3"},D=i(()=>s("label",{class:"col-sm-2 col-form-label",disabled:""},"邮箱",-1)),M={class:"col-sm-10"},N={class:"row mb-3"},T=i(()=>s("label",{class:"col-sm-2 col-form-label"},"昵称",-1)),j={class:"col-sm-10"},A={class:"row mb-3"},E=i(()=>s("label",{class:"col-sm-2 col-form-label"},"签名",-1)),F={class:"col-sm-10"},J={__name:"setting",setup(a){let d=w(),o=h({username:"",nickname:"",mail:"",headUrl:"https://avatars.githubusercontent.com/u/15867678?v=4"}),m=d.state.username;function _(){u({url:`/api/author/${m}`,method:"get"}).then(r=>{o.value=r.data})}function p(){u({url:"/api/author",method:"put",data:o.value}).then(r=>{alert("保存成功")})}function b(){S(d),window.location.href="/"}return f(()=>{_()}),(r,t)=>(k(),g("div",U,[s("div",V,[I,s("div",B,[n(s("input",{class:"form-control",disabled:"","onUpdate:modelValue":t[0]||(t[0]=l=>e(o).username=l)},null,512),[[c,e(o).username]])])]),s("div",C,[D,s("div",M,[n(s("input",{type:"text",class:"form-control",disabled:"","onUpdate:modelValue":t[1]||(t[1]=l=>e(o).mail=l)},null,512),[[c,e(o).mail]])])]),s("div",N,[T,s("div",j,[n(s("input",{type:"text",class:"form-control","onUpdate:modelValue":t[2]||(t[2]=l=>e(o).nickname=l)},null,512),[[c,e(o).nickname]])])]),s("div",A,[E,s("div",F,[n(s("input",{class:"form-control",id:"inputPassword3","onUpdate:modelValue":t[3]||(t[3]=l=>e(o).signature=l)},null,512),[[c,e(o).signature]])])]),s("div",null,[s("button",{class:"btn btn-primary",onClick:p},"保存信息"),s("button",{class:"btn btn-primary float-end",onClick:b},"退出登录")])]))}},R=v(J,[["__scopeId","data-v-e4b110c9"]]);export{R as default};
