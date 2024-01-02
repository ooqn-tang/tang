import{_ as e,r as _,E as i}from"./preload-helper-3003bc42.js";class r{constructor(t){this.messageFunctionList={},this.messageHeader={},this.socket=new WebSocket(t),this.messageQueue=[],this.socket.onopen=o=>{console.log(o),this.sendAll()},this.socket.onmessage=o=>{let s=JSON.parse(o.data);s.code!=null?this.messageHeader[s.code](s):this.messageFunctionList[s.messageId](s)},this.socket.onclose=o=>{},this.socket.onerror=o=>{}}setHeader(t,o){this.messageHeader[t]=o}send(t,o){t.messageId=Math.random(),this.messageFunctionList[t.messageId]=o,this.messageQueue.push(t),this.sendAll()}sendAll(){for(;this.messageQueue.length>0&&this.socket.readyState===1;){let t=this.messageQueue.shift();this.socket.send(JSON.stringify(t))}}getUserInfo(t){this.send({code:1e3},t)}login(t){this.send({code:"Login",params:{jwt:localStorage.getItem("jwt")}},t)}sendMessage(t,o,s){this.send({code:"SendMessage",params:{username:o,content:t}},s)}watchList(t){this.send({code:"WatchList"},t)}messageList(t,o){this.send({code:"MessageList",params:{memberName:t}},o)}}const m=[{path:"/",name:"home",component:()=>e(()=>import("./index-5e39adfb.js"),["assets/index-5e39adfb.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/index-5243a2f2.css"]),children:[{path:"/",name:"home",component:()=>e(()=>import("./article-list-007138df.js"),["assets/article-list-007138df.js","assets/request-651d32a9.js","assets/info-e0b80c69.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/article-list-32f1d2a7.css"])},{path:"/article",name:"article",component:()=>e(()=>import("./article-list-007138df.js"),["assets/article-list-007138df.js","assets/request-651d32a9.js","assets/info-e0b80c69.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/article-list-32f1d2a7.css"])},{path:"/article/:id",name:"article_post",component:()=>e(()=>import("./article-post-211a67fd.js"),["assets/article-post-211a67fd.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js","assets/info-e0b80c69.js","assets/collect-b665d4b5.js","assets/subject-eedf1819.js","assets/article-post-9d0184e6.css"])},{path:"message",name:"message",component:()=>e(()=>import("./message-d8b1e06a.js"),["assets/message-d8b1e06a.js","assets/request-651d32a9.js","assets/info-e0b80c69.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css"])},{path:"/author/:username",name:"author_index",component:()=>e(()=>import("./index-acb510a5.js"),["assets/index-acb510a5.js","assets/request-651d32a9.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/info-e0b80c69.js","assets/index-a5a00085.css"]),children:[{path:"",name:"author_article",component:()=>e(()=>import("./article-e3812624.js"),["assets/article-e3812624.js","assets/request-651d32a9.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css"])},{path:"setting",name:"author_setting",component:()=>e(()=>import("./setting-ccc87809.js"),["assets/setting-ccc87809.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js"])},{path:"subject",name:"author_subject",component:()=>e(()=>import("./subject-c43279b2.js"),["assets/subject-c43279b2.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js"])},{path:"subscribe",name:"author_subscribe",component:()=>e(()=>import("./subscribe-d5669f3e.js"),["assets/subscribe-d5669f3e.js","assets/request-651d32a9.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/subscribe-3ddb1f59.css"])},{path:"collect",name:"author_collect",component:()=>e(()=>import("./collect-56a4d1d4.js"),["assets/collect-56a4d1d4.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/collect-b665d4b5.js","assets/request-651d32a9.js"])}]},{path:"/subject",name:"subject",component:()=>e(()=>import("./subject-82612159.js"),["assets/subject-82612159.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/info-e0b80c69.js","assets/request-651d32a9.js"])},{path:"/author",name:"author",component:()=>e(()=>import("./author-list-63a446ca.js"),["assets/author-list-63a446ca.js","assets/request-651d32a9.js","assets/info-e0b80c69.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css"])},{path:"/subject/:subject_id",name:"subject_post",component:()=>e(()=>import("./subject-post-ce549620.js"),["assets/subject-post-ce549620.js","assets/request-651d32a9.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/info-e0b80c69.js","assets/subject-post-91a43c77.css"])},{path:"/search",name:"search",component:()=>e(()=>import("./index-3667f91d.js"),["assets/index-3667f91d.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js","assets/info-e0b80c69.js","assets/index-94db8e82.css"])},{path:"/chat",name:"chat",component:()=>e(()=>import("./index-9c946202.js"),["assets/index-9c946202.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js","assets/index-a33b5db9.css"])}]},{path:"/article-editor-md",name:"article-editor-md",component:()=>e(()=>import("./article-editor-md-59f49e17.js"),["assets/article-editor-md-59f49e17.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/_commonjsHelpers-725317a4.js","assets/request-651d32a9.js","assets/subject-eedf1819.js","assets/article-editor-md-ba05413d.css"])},{path:"/login",name:"login",component:()=>e(()=>import("./login-cac23f3c.js"),["assets/login-cac23f3c.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js","assets/login-7cc867ed.css"])},{path:"/register",name:"register",component:()=>e(()=>import("./register-b94e39b2.js"),["assets/register-b94e39b2.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css","assets/request-651d32a9.js","assets/register-e03b21be.css"])},{path:"/:catchAll(.*)",component:()=>e(()=>import("./404-dc8ceb31.js"),["assets/404-dc8ceb31.js","assets/preload-helper-3003bc42.js","assets/preload-helper-13bb1186.css"]),hidden:!0}];let c="wss://www.ooqn.com/_monster",n=new r(c);localStorage.getItem("jwt")&&n.login(()=>{console.log("monsterSocket login")});const p=_(m,!1);let a=new i(p);a.provide("$ms",n);a.mount("#app");
