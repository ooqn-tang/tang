import{K as v,r as f,L as h,x as w,y as s,l as n,R as c,B as e,J as g,G as k,P as x,Q as y}from"./github-e5e29926.js";import{s as m,r as V}from"./request-de408a29.js";const i=a=>(x("data-v-c1637669"),a=a(),y(),a),B={class:"m-3"},I={class:"row mb-3"},S=i(()=>s("label",{class:"col-sm-2 col-form-label"},"用户名",-1)),U={class:"col-sm-10"},C={class:"row mb-3"},M=i(()=>s("label",{class:"col-sm-2 col-form-label",disabled:""},"邮箱",-1)),P={class:"col-sm-10"},T={class:"row mb-3"},A=i(()=>s("label",{class:"col-sm-2 col-form-label"},"昵称",-1)),D={class:"col-sm-10"},E={class:"row mb-3"},G=i(()=>s("label",{class:"col-sm-2 col-form-label"},"签名",-1)),J={class:"col-sm-10"},K={__name:"setting",setup(a){let d=g(),o=f({username:"************",nickname:"********",mail:"****************"}),u=d.state.username;function _(){m({url:`/api/author/${u}`,method:"get"}).then(r=>{o.value=r.data})}function p(){m({url:"/api/author",method:"put",data:o.value}).then(r=>{alert("保存成功")})}function b(){V(d),window.location.href="/"}return h(()=>{_()}),(r,t)=>(k(),w("div",B,[s("div",I,[S,s("div",U,[n(s("input",{class:"form-control",disabled:"","onUpdate:modelValue":t[0]||(t[0]=l=>e(o).username=l)},null,512),[[c,e(o).username]])])]),s("div",C,[M,s("div",P,[n(s("input",{type:"text",class:"form-control",disabled:"","onUpdate:modelValue":t[1]||(t[1]=l=>e(o).mail=l)},null,512),[[c,e(o).mail]])])]),s("div",T,[A,s("div",D,[n(s("input",{type:"text",class:"form-control","onUpdate:modelValue":t[2]||(t[2]=l=>e(o).nickname=l)},null,512),[[c,e(o).nickname]])])]),s("div",E,[G,s("div",J,[n(s("input",{class:"form-control",id:"inputPassword3","onUpdate:modelValue":t[3]||(t[3]=l=>e(o).signature=l)},null,512),[[c,e(o).signature]])])]),s("div",null,[s("button",{class:"btn btn-primary",onClick:p},"保存信息"),s("button",{class:"btn btn-primary float-end",onClick:b},"退出登录")])]))}},Q=v(K,[["__scopeId","data-v-c1637669"]]);export{Q as default};