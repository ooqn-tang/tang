import{u as C,a as d,i as L,q as c,t as b,x as e,F as x,y as _,z as n,I as m,P as r,D as g,g as f,K as S,Q as D,v as M}from"./preload-helper-bcb988a1.js";import"./request-596b05ba.js";const $={class:"row h-100"},N={class:"h-100",style:{display:"flex","flex-direction":"column",height:"100%",padding:"0px"}},T=D('<div class="input-group" style="margin-bottom:1px;"><input type="text" class="form-control" aria-label="Text input with segmented dropdown button"><button type="button" class="btn btn-outline-secondary">搜索</button><button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false"><span class="visually-hidden">Toggle Dropdown</span></button><ul class="dropdown-menu dropdown-menu-end"><li><a class="dropdown-item" href="#">增加好友</a></li><li><a class="dropdown-item" href="#">增加群</a></li><li><a class="dropdown-item" href="#">创建群</a></li></ul></div>',1),B={class:"box",style:{height:"100%","flex-grow":"1","overflow-y":"auto",padding:"5px",border:"1px solid #dee2e6",margin:"5px 0px 0px 0px"}},R={class:"box-list",style:{height:"0"}},V=["onClick"],z={style:{color:"#bbbbbb"}},F={class:"btn-group",role:"group","aria-label":"Basic outlined example",style:{margin:"5px 0px 0 0"}},H={class:"h-100",style:{display:"flex","flex-direction":"column",height:"100%",padding:"0px"}},P={class:"card",style:{border:"1px solid rgb(222, 226, 230)"}},U={class:"card-body",style:{padding:"6px 10px","vertical-align":"top",display:"inline-block"}},j={class:"align-middle"},q={class:"box",style:{height:"100%","flex-grow":"1","overflow-y":"auto",padding:"5px",border:"1px solid #dee2e6",margin:"5px 0px"}},A={class:"box-list",style:{height:"0"}},E={style:{"border-bottom":"0"}},I={style:{color:"rgb(8, 78, 184)","font-weight":"bold"}},K={style:{border:"1px solid black","border-radius":"5px",padding:"5px"}},Q={class:"input-group"},X={__name:"index",setup(G){let h=C(),o=d(new URLSearchParams(window.location.search).get("type"));o.value==null&&(o.value="message");let l=d("left"),i=d(""),u=d([]),v=d({}),p=L("$ms");p.setHeader("Message",a=>{u.value.push(a.data),console.log(a)}),p.setHeader("MessageList",a=>{u.value.push(a.data),console.log(a.data)});function w(){let a={acceptName:v.value.username,sendName:h.author.username,content:i.value,createTime:new Date,updateTime:new Date};u.value.push(a),p.sendMessage(i.value,v.value.username,t=>{t.status==200&&console.log(t.message)}),i.value=""}function k(a){v.value=a,p.messageList(a.username,t=>{t.status==200&&(u.value=t.data)})}let y=d([]);return p.watchList(a=>{a.status==200&&(y.value=a.data)}),(a,t)=>(c(),b("div",$,[e("div",{class:m(["col-md-4 h-100 pb-2",n(l)=="left"?"":"m-h"])},[e("div",N,[T,e("div",B,[e("div",R,[(c(!0),b(x,null,_(n(y),s=>f((c(),b("div",{onClick:J=>{k(s),r(l)?l.value="right":l="right"}},[e("p",null,g(s.nickname),1),e("p",z,g(s.signature)+" ",1)],8,V)),[[M,s.username!=n(h).author.username]])),256))])]),e("div",F,[e("button",{type:"button",class:m(["btn",n(o)=="message"?"btn-primary":"btn-outline-primary"]),onClick:t[0]||(t[0]=s=>r(o)?o.value="message":o="message")},"消息",2),e("button",{type:"button",class:m(["btn",n(o)=="contacts"?"btn-primary":"btn-outline-primary"]),onClick:t[1]||(t[1]=s=>r(o)?o.value="contacts":o="contacts")},"通讯录",2),e("button",{type:"button",class:m(["btn",n(o)=="me"?"btn-primary":"btn-outline-primary"]),onClick:t[2]||(t[2]=s=>r(o)?o.value="me":o="me")},"我的",2)])])],2),e("div",{class:m(["col-md-8 h-100 pb-2",n(l)=="right"?"":"m-h"])},[e("div",H,[e("div",P,[e("div",U,[e("span",j,g(n(v).nickname),1),e("span",{style:{float:"right"},onClick:t[3]||(t[3]=s=>r(l)?l.value="left":l="left")}," ✖️ ")])]),e("div",q,[e("div",A,[(c(!0),b(x,null,_(n(u),s=>(c(),b("div",E,[e("p",I,g(s.sendName),1),e("p",K,g(s.content)+" ",1)]))),256))])]),e("div",Q,[f(e("input",{"onUpdate:modelValue":t[4]||(t[4]=s=>r(i)?i.value=s:i=s),type:"text",class:"form-control",placeholder:"Recipient's username","aria-label":"Recipient's username","aria-describedby":"button-addon2"},null,512),[[S,n(i)]]),e("button",{class:"btn btn-outline-secondary",type:"button",id:"button-addon2",onClick:t[5]||(t[5]=s=>w())},"发送")])])],2)]))}};export{X as default};
