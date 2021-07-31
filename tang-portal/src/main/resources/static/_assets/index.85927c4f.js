let t=document.createElement("style");t.innerHTML=".W33{width:33%}.W34{width:34%}.W100{width:100%}.mb10px{margin-bottom:10px}body,html{overflow:hidden}",document.head.appendChild(t);import{s as o,o as e,c as a,b as l,h as n,j as r,i as s,d,F as i,r as c,e as p}from"./index.a3a8cc74.js";function u(t){this.message=t}u.prototype=new Error,u.prototype.name="InvalidCharacterError";var m="undefined"!=typeof window&&window.atob&&window.atob.bind(window)||function(t){var o=String(t).replace(/=+$/,"");if(o.length%4==1)throw new u("'atob' failed: The string to be decoded is not correctly encoded.");for(var e,a,l=0,n=0,r="";a=o.charAt(n++);~a&&(e=l%4?64*e+a:a,l++%4)?r+=String.fromCharCode(255&e>>(-2*l&6)):0)a="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".indexOf(a);return r};function b(t){this.message=t}function g(t,o){if("string"!=typeof t)throw new b("Invalid token specified");var e=!0===(o=o||{}).header?0:1;try{return JSON.parse(function(t){var o=t.replace(/-/g,"+").replace(/_/g,"/");switch(o.length%4){case 0:break;case 2:o+="==";break;case 3:o+="=";break;default:throw"Illegal base64url string!"}try{return decodeURIComponent(m(o).replace(/(.)/g,(function(t,o){var e=o.charCodeAt(0).toString(16).toUpperCase();return e.length<2&&(e="0"+e),"%"+e})))}catch(t){return m(o)}}(t.split(".")[e]))}catch(t){throw new b("Invalid token specified: "+t.message)}}b.prototype=new Error,b.prototype.name="InvalidTokenError";var f={name:"login",data:()=>({type:"dl",loginData:{username:"",password:"",rememberMe:!0}}),components:{},methods:{login(){var t;(t=this.loginData,o({url:"/api/authenticate",method:"post",data:t})).then((t=>{if(200===t.code){let o=g(t.jwt_token);localStorage.setItem("token",t.jwt_token),localStorage.setItem("author",JSON.stringify(o.author)),this.$router.go(-1)}}))}},mounted(){localStorage.removeItem("token"),localStorage.removeItem("author")}};const h={key:0,id:"loginModal",class:"modal-dialog"},y={class:"modal-content"},v=l("div",{class:"modal-header"},[l("h4",{class:"modal-title text-center"},"登录")],-1),w={id:"model-body",class:"modal-body"},k=l("label",null,"邮箱：",-1),W={class:"form-group"},x=l("label",null,"密码：",-1),D={class:"form-group"},C={class:"modal-footer"},I={class:"btn-group W100 mb10px"},S={class:"btn-group W100 mb10px"},U={class:"btn-group W100"},V=p("返回首页"),E={key:1,class:"modal-dialog"},j={class:"modal-content"},_=l("div",{class:"modal-header"},[l("h4",{class:"modal-title text-center"},"注册")],-1),M={id:"model-body",class:"modal-body"},O=l("label",null,"邮箱：",-1),T={class:"input-group"},z=l("button",{class:"btn btn-outline-secondary",type:"button",id:"button-addon2"},"发送验证码",-1),A=l("label",null,"验证码：",-1),J={class:"form-group"},N=l("label",null,"密码：",-1),F={class:"form-group"},H=l("label",null,"确认密码：",-1),L={class:"form-group"},R={class:"modal-footer"},$={class:"btn-group W100 mb10px"},q={class:"btn-group W100 mb10px"},B={class:"btn-group W100"},G=p("返回首页");f.render=function(t,o,p,u,m,b){const g=c("router-link");return e(),a(i,null,["dl"==m.type?(e(),a("div",h,[l("div",y,[v,l("div",w,[k,l("div",W,[n(l("input",{type:"text","onUpdate:modelValue":o[1]||(o[1]=t=>m.loginData.username=t),placeholder:"用户名",autocomplete:"off",class:"form-control"},null,512),[[r,m.loginData.username]])]),x,l("div",D,[n(l("input",{type:"password","onUpdate:modelValue":o[2]||(o[2]=t=>m.loginData.password=t),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[r,m.loginData.password]])])]),l("div",C,[l("div",I,[l("button",{type:"button",class:"btn btn-primary W100",onClick:o[3]||(o[3]=t=>b.login())},"登录")]),l("div",S,[l("button",{type:"button",class:"btn btn-primary W100",onClick:o[4]||(o[4]=t=>m.type="zc")},"注册")]),l("div",U,[l(g,{to:"/",type:"button",class:"btn btn-default W100"},{default:s((()=>[V])),_:1})])])])])):d("",!0),"zc"==m.type?(e(),a("div",E,[l("div",j,[_,l("div",M,[O,l("div",T,[n(l("input",{type:"text","onUpdate:modelValue":o[5]||(o[5]=t=>m.loginData.username=t),placeholder:"用户名",autocomplete:"off",class:"form-control"},null,512),[[r,m.loginData.username]]),z]),A,l("div",J,[n(l("input",{type:"text","onUpdate:modelValue":o[6]||(o[6]=t=>m.loginData.code=t),placeholder:"验证码",autocomplete:"off",class:"form-control"},null,512),[[r,m.loginData.code]])]),N,l("div",F,[n(l("input",{type:"password","onUpdate:modelValue":o[7]||(o[7]=t=>m.loginData.password=t),placeholder:"密码",autocomplete:"off",class:"form-control"},null,512),[[r,m.loginData.password]])]),H,l("div",L,[n(l("input",{type:"password","onUpdate:modelValue":o[8]||(o[8]=t=>m.loginData.password1=t),placeholder:"确认密码",autocomplete:"off",class:"form-control"},null,512),[[r,m.loginData.password1]])])]),l("div",R,[l("div",$,[l("button",{type:"button",class:"btn btn-primary W100",onClick:o[9]||(o[9]=t=>b.login())},"注册")]),l("div",q,[l("button",{type:"button",class:"btn btn-primary W100",onClick:o[10]||(o[10]=t=>m.type="dl")},"登录")]),l("div",B,[l(g,{to:"/",type:"button",class:"btn btn-default W100"},{default:s((()=>[G])),_:1})])])])])):d("",!0)],64)};export default f;
