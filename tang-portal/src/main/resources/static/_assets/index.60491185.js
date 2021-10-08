let t=document.createElement("style");t.innerHTML=".W33{width:33%}.W34{width:34%}.W100{width:100%}.mb10px{margin-bottom:10px}body,html{overflow:hidden}",document.head.appendChild(t);import{s as a,o as e,c as o,b as l,h as r,j as n,i as s,d,F as i,r as p,e as c}from"./index.dc9d8f03.js";function u(t){this.message=t}u.prototype=new Error,u.prototype.name="InvalidCharacterError";var m="undefined"!=typeof window&&window.atob&&window.atob.bind(window)||function(t){var a=String(t).replace(/=+$/,"");if(a.length%4==1)throw new u("'atob' failed: The string to be decoded is not correctly encoded.");for(var e,o,l=0,r=0,n="";o=a.charAt(r++);~o&&(e=l%4?64*e+o:o,l++%4)?n+=String.fromCharCode(255&e>>(-2*l&6)):0)o="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(o);return n};function g(t){this.message=t}function b(t,a){if("string"!=typeof t)throw new g("Invalid token specified");var e=!0===(a=a||{}).header?0:1;try{return JSON.parse(function(t){var a=t.replace(/-/g,"+").replace(/_/g,"/");switch(a.length%4){case 0:break;case 2:a+="==";break;case 3:a+="=";break;default:throw"Illegal base64url string!"}try{return decodeURIComponent(m(a).replace(/(.)/g,(function(t,a){var e=a.charCodeAt(0).toString(16).toUpperCase();return e.length<2&&(e="0"+e),"%"+e})))}catch(t){return m(a)}}(t.split(".")[e]))}catch(t){throw new g("Invalid token specified: "+t.message)}}g.prototype=new Error,g.prototype.name="InvalidTokenError";var h={name:"login",data:()=>({type:"dl",loginData:{username:"",password:"",mail:"",password1:"",rememberMe:!0}}),components:{},methods:{login(){var t;(t=this.loginData,a({url:"/api/authenticate",method:"post",data:t})).then((t=>{if(200===t.code){let a=b(t.jwt_token);localStorage.setItem("token",t.jwt_token),localStorage.setItem("author",JSON.stringify(a.author)),this.$router.push({path:"/author/"+a.sub})}}))},sendMail(){var t;(t=this.loginData.username,a({url:"/api/mail-verify",method:"post",params:{mail:t}})).then((t=>{alert(t.message)}))},register(){var t;this.loginData.password===this.loginData.password1?(t=this.loginData,a({url:"/api/register",method:"post",data:t})).then((t=>{alert(t.data)})):alert("两次密码不一致")}},mounted(){localStorage.removeItem("token"),localStorage.removeItem("author")}};const f={key:0,id:"loginModal",class:"modal-dialog"},v={class:"modal-content"},y=l("div",{class:"modal-header"},[l("h4",{class:"modal-title text-center"},"登录")],-1),w={id:"model-body",class:"modal-body"},k=l("label",null,"邮箱/用户名：",-1),D={class:"form-group"},W=l("label",null,"密码：",-1),x={class:"form-group"},C={class:"modal-footer"},I={class:"btn-group W100 mb10px"},S={class:"btn-group W100 mb10px"},U={class:"btn-group W100"},E=c("返回首页"),V={key:1,class:"modal-dialog"},j={class:"modal-content"},M=l("div",{class:"modal-header"},[l("h4",{class:"modal-title text-center"},"注册")],-1),_={id:"model-body",class:"modal-body"},O=l("label",null,"邮箱：",-1),T={class:"input-group"},z=l("label",null,"密码：",-1),A={class:"form-group"},J=l("label",null,"确认密码：",-1),N={class:"form-group"},F={class:"modal-footer"},H={class:"btn-group W100 mb10px"},L={class:"btn-group W100 mb10px"},R={class:"btn-group W100"},$=c("返回首页");h.render=function(t,a,c,u,m,g){const b=p("router-link");return e(),o(i,null,["dl"==m.type?(e(),o("div",f,[l("div",v,[y,l("div",w,[k,l("div",D,[r(l("input",{type:"text","onUpdate:modelValue":a[1]||(a[1]=t=>m.loginData.username=t),placeholder:"邮箱/用户名",autocomplete:"off",class:"form-control"},null,512),[[n,m.loginData.username]])]),W,l("div",x,[r(l("input",{type:"password","onUpdate:modelValue":a[2]||(a[2]=t=>m.loginData.password=t),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[n,m.loginData.password]])])]),l("div",C,[l("div",I,[l("button",{type:"button",class:"btn btn-primary W100",onClick:a[3]||(a[3]=t=>g.login())},"登录")]),l("div",S,[l("button",{type:"button",class:"btn btn-primary W100",onClick:a[4]||(a[4]=t=>m.type="zc")},"注册")]),l("div",U,[l(b,{to:"/",type:"button",class:"btn btn-default W100"},{default:s((()=>[E])),_:1})])])])])):d("",!0),"zc"==m.type?(e(),o("div",V,[l("div",j,[M,l("div",_,[O,l("div",T,[r(l("input",{type:"text","onUpdate:modelValue":a[5]||(a[5]=t=>m.loginData.mail=t),placeholder:"邮箱号",autocomplete:"off",class:"form-control"},null,512),[[n,m.loginData.mail]])]),z,l("div",A,[r(l("input",{type:"password","onUpdate:modelValue":a[6]||(a[6]=t=>m.loginData.password=t),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[n,m.loginData.password]])]),J,l("div",N,[r(l("input",{type:"password","onUpdate:modelValue":a[7]||(a[7]=t=>m.loginData.password1=t),placeholder:"确认密码",autocomplete:"off",class:"form-control"},null,512),[[n,m.loginData.password1]])])]),l("div",F,[l("div",H,[l("button",{type:"button",class:"btn btn-primary W100",onClick:a[8]||(a[8]=t=>g.register())},"注册")]),l("div",L,[l("button",{type:"button",class:"btn btn-primary W100",onClick:a[9]||(a[9]=t=>m.type="dl")},"登录")]),l("div",R,[l(b,{to:"/",type:"button",class:"btn btn-default W100"},{default:s((()=>[$])),_:1})])])])])):d("",!0)],64)};export default h;
