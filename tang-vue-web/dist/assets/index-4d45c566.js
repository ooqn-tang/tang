import{K as z,r,L as S,x as l,y as t,l as x,R as b,B as i,F as u,z as _,S as f,G as c,I as w,H as d,P as B,Q as M}from"./github-f7596896.js";import{s as y}from"./request-55ac77c7.js";function T(e){return y({url:"/api/essay",method:"post",data:e})}function E(e){return y({url:"/api/essay",method:"get",params:e})}const C=e=>(B("data-v-9ce68860"),e=e(),M(),e),I={class:"row"},V={class:"col-md-6 mb-2"},A={class:"mb-2"},D=f('<datalist id="datalistOptions" data-v-9ce68860><option value="San Francisco" data-v-9ce68860></option><option value="New York" data-v-9ce68860></option><option value="Seattle" data-v-9ce68860></option><option value="Los Angeles" data-v-9ce68860></option><option value="Chicago" data-v-9ce68860></option></datalist>',1),F={class:"mb-2"},Z={class:"card"},O={class:"card-body"},P={class:"input-group"},U={class:"card"},$={class:"card-body"},j={class:"float-end"},G={class:"badge text-bg-primary"},H=f('<div class="row" data-v-9ce68860><div class="col-4" data-v-9ce68860><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chat-dots tag" viewBox="0 0 16 16" data-v-9ce68860><path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z" data-v-9ce68860></path><path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z" data-v-9ce68860></path></svg></div><div class="col-4" style="text-align:center;" data-v-9ce68860><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-balloon-heart tag" viewBox="0 0 16 16" data-v-9ce68860><path fill-rule="evenodd" d="m8 2.42-.717-.737c-1.13-1.161-3.243-.777-4.01.72-.35.685-.451 1.707.236 3.062C4.16 6.753 5.52 8.32 8 10.042c2.479-1.723 3.839-3.29 4.491-4.577.687-1.355.587-2.377.236-3.061-.767-1.498-2.88-1.882-4.01-.721L8 2.42Zm-.49 8.5c-10.78-7.44-3-13.155.359-10.063.045.041.089.084.132.129.043-.045.087-.088.132-.129 3.36-3.092 11.137 2.624.357 10.063l.235.468a.25.25 0 1 1-.448.224l-.008-.017c.008.11.02.202.037.29.054.27.161.488.419 1.003.288.578.235 1.15.076 1.629-.157.469-.422.867-.588 1.115l-.004.007a.25.25 0 1 1-.416-.278c.168-.252.4-.6.533-1.003.133-.396.163-.824-.049-1.246l-.013-.028c-.24-.48-.38-.758-.448-1.102a3.177 3.177 0 0 1-.052-.45l-.04.08a.25.25 0 1 1-.447-.224l.235-.468ZM6.013 2.06c-.649-.18-1.483.083-1.85.798-.131.258-.245.689-.08 1.335.063.244.414.198.487-.043.21-.697.627-1.447 1.359-1.692.217-.073.304-.337.084-.398Z" data-v-9ce68860></path></svg></div><div class="col-4" style="text-align:right;" data-v-9ce68860><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cursor tag" viewBox="0 0 16 16" data-v-9ce68860><path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103zM2.25 8.184l3.897 1.67a.5.5 0 0 1 .262.263l1.67 3.897L12.743 3.52 2.25 8.184z" data-v-9ce68860></path></svg></div></div>',1),J={class:"col-md-3 mb-2"},K={class:"list-group"},Q=C(()=>t("li",{class:"list-group-item active"},"推荐标签",-1)),R=["onClick"],Y={class:"col-md-3 mb-2"},q={class:"list-group"},W=C(()=>t("li",{class:"list-group-item active"},"最近使用",-1)),X=["onClick"],tt={__name:"index",setup(e){let h=r({number:0}),v=r([]),s=r({text:"",tagName:""});s.value.text="";let g=r([{text:"Test1"},{text:"Test2"},{text:"Java"},{text:"C#"},{text:"Python"}]);function k(){E({page:h.number}).then(o=>{h=o.data;for(const n of o.data.content)v.value.push(n)})}function L(){T(s.value).then(o=>{s.value.text="",v.value.unshift(o.data)})}function m(o){s.value.tagName=o.text}return S(()=>{k()}),(o,n)=>(c(),l("div",I,[t("div",V,[t("div",A,[x(t("input",{class:"form-control",list:"datalistOptions",id:"exampleDataList","onUpdate:modelValue":n[0]||(n[0]=a=>i(s).tagName=a),placeholder:"输入标签"},null,512),[[b,i(s).tagName]]),D]),t("div",F,[t("div",Z,[t("div",O,[t("div",P,[x(t("textarea",{"onUpdate:modelValue":n[1]||(n[1]=a=>i(s).text=a),class:"form-control",rows:"3",placeholder:"输入的内容不包含标签的内容会在最后追加标签中的内容。",id:"textarea"},null,512),[[b,i(s).text]]),t("button",{class:"btn btn-outline-secondary",type:"button",id:"button-addon2",onClick:L},"发送")])])])]),(c(!0),l(u,null,_(i(v),(a,p)=>(c(),l("div",{class:"mb-2",key:p},[t("div",U,[t("div",$,[t("p",null,[w(d(a.author.nickname)+" ",1),t("span",j,d(a.createTime),1)]),t("div",null,[w(d(a.text)+" ",1),t("span",G,"#"+d(a.tagName),1)]),H])])]))),128))]),t("div",J,[t("ul",K,[Q,(c(!0),l(u,null,_(i(g),(a,p)=>(c(),l("li",{class:"list-group-item",onClick:N=>m(a)},d(a.text),9,R))),256))])]),t("div",Y,[t("ul",q,[W,(c(!0),l(u,null,_(i(g),(a,p)=>(c(),l("li",{class:"list-group-item",onClick:N=>m(a)},d(a.text),9,X))),256))])])]))}},st=z(tt,[["__scopeId","data-v-9ce68860"]]);export{st as default};