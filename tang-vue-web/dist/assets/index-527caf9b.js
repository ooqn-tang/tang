import{x as t,y as e,z as d,F as o,B as v,k as r,M as c,S as n,E as l}from"./router-f99ea542.js";import"./request-02cf91c6.js";const b={class:"row H100"},p={class:"col-md-4 H100 pb-2"},f={class:"H100",style:{display:"flex","flex-direction":"column",height:"100%",padding:"0px"}},u=d("div",{class:"input-group"},[d("input",{type:"text",class:"form-control",placeholder:"Recipient's username","aria-label":"Recipient's username","aria-describedby":"button-addon2"}),d("button",{class:"btn btn-outline-secondary",type:"button",id:"button-addon2"},"搜索")],-1),m={class:"box",style:{height:"100%","flex-grow":"1","overflow-y":"auto",padding:"5px",border:"1px solid #dee2e6",margin:"5px 0px"}},y={class:"box-list"},g={style:{color:"#bbbbbb"}},_=d("div",{class:"btn-group btn-group-sm",role:"group","aria-label":"Basic radio toggle button group"},[d("button",{class:"btn btn-outline-primary"},"消息"),d("button",{class:"btn btn-outline-primary"},"好友"),d("button",{class:"btn btn-outline-primary"},"我的")],-1),x={class:"col-md-8 H100 pb-2 pc"},h={class:"H100",style:{display:"flex","flex-direction":"column",height:"100%",padding:"0px"}},w=n('<div class="card"><div class="card-body" style="padding:6px 10px;vertical-align:top;display:inline-block;"><span class="align-middle">这是文本</span><span style="float:right;"> ✖️ </span></div></div><div class="box" style="height:100%;flex-grow:1;overflow-y:auto;padding:5px;border:1px solid #dee2e6;margin:5px 0px;"><div class="box-list"><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div><div>asdf</div></div></div>',2),k={class:"input-group input-group-sm"},B=n('<div class="modal fade show modal-rgba modal-lg"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">聊天室</h5><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><form><div class="mb-3"><label for="recipient-name" class="col-form-label">用户地址:</label><input type="text" class="form-control" id="recipient-name" placeholder="账号地址 @bobcbui:ooqn.com"></div><div class="mb-3"><label for="recipient-name" class="col-form-label">邮箱/手机号：</label><input type="text" class="form-control" id="recipient-name"></div><div class="mb-3"><label for="message-text" class="col-form-label">密码：</label><input type="text" class="form-control" id="recipient-name"></div></form></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button><button type="button" class="btn btn-primary">登录</button></div></div></div></div>',1),L={__name:"index",setup(H){return(s,a)=>(t(),e(o,null,[d("div",b,[d("div",p,[d("div",f,[u,d("div",m,[d("div",y,[(t(!0),e(o,null,v(s.memeberList,i=>(t(),e("div",null,[d("p",null,l(i.nickname),1),d("p",g,l(i.signature),1)]))),256))])]),_])]),d("div",x,[d("div",h,[w,d("div",k,[r(d("input",{"onUpdate:modelValue":a[0]||(a[0]=i=>s.message=i),type:"text",class:"form-control",placeholder:"Recipient's username","aria-label":"Recipient's username","aria-describedby":"button-addon2"},null,512),[[c,s.message]]),d("button",{class:"btn btn-outline-secondary",type:"button",id:"button-addon2",onClick:a[1]||(a[1]=i=>s.sendMessage())},"发送")])])])]),B],64))}};export{L as default};
