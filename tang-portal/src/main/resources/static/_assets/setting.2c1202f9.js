let a=document.createElement("style");a.innerHTML="body{overflow-y:scroll}",document.head.appendChild(a);import{u as o,s as l}from"./author.d4831b9c.js";import{o as t,c as e,b as s,h as r,j as n}from"./index.a3a8cc74.js";var c={name:"author_setting",data:()=>({author:{username:"",nickname:"",mail:""}}),components:{},methods:{logout(){localStorage.removeItem("token"),localStorage.removeItem("author"),this.$store.state.username="",window.location.href="/"},save(){o(this.author).then((a=>{this.selectAuthorLoad()}))},selectAuthorLoad(){l(this.$route.params.username).then((a=>{this.author=a.data}))}},mounted(){this.selectAuthorLoad()}};const m={style:{margin:"10px"}},u={class:"row mb-3"},i=s("label",{class:"col-sm-2 col-form-label"},"用户名",-1),d={class:"col-sm-10"},h={class:"row mb-3"},b=s("label",{class:"col-sm-2 col-form-label",disabled:""},"邮箱",-1),p={class:"col-sm-10"},v={class:"row mb-3"},f=s("label",{class:"col-sm-2 col-form-label"},"昵称",-1),g={class:"col-sm-10"},w={class:"row mb-3"},y=s("label",{class:"col-sm-2 col-form-label"},"签名",-1),k={class:"col-sm-10"};c.render=function(a,o,l,c,x,L){return t(),e("div",m,[s("div",u,[i,s("div",d,[r(s("input",{class:"form-control ",disabled:"","onUpdate:modelValue":o[1]||(o[1]=a=>x.author.username=a)},null,512),[[n,x.author.username]])])]),s("div",h,[b,s("div",p,[r(s("input",{type:"text",class:"form-control",disabled:"","onUpdate:modelValue":o[2]||(o[2]=a=>x.author.mail=a)},null,512),[[n,x.author.mail]])])]),s("div",v,[f,s("div",g,[r(s("input",{type:"text",class:"form-control","onUpdate:modelValue":o[3]||(o[3]=a=>x.author.nickname=a)},null,512),[[n,x.author.nickname]])])]),s("div",w,[y,s("div",k,[r(s("input",{class:"form-control",id:"inputPassword3","onUpdate:modelValue":o[4]||(o[4]=a=>x.author.signature=a)},null,512),[[n,x.author.signature]])])]),s("div",null,[s("button",{class:"btn btn-primary",onClick:o[5]||(o[5]=(...a)=>L.save&&L.save(...a))},"保存信息"),s("button",{class:"btn btn-primary float-end",onClick:o[6]||(o[6]=(...a)=>L.logout&&L.logout(...a))},"退出登录")])])};export default c;