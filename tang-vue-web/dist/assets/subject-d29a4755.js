import{u as I,L,d as i,H as E,t as S,x as d,y as r,z as e,F as v,B as U,C as l,R as f,D as h,k as y,M as j,l as B,J as V,E as x}from"./router-b176819d.js";import{s as m}from"./request-02cf91c6.js";const $={class:"list-group article-list"},D={class:"list-group-item"},w=["textContent"],R={class:"btn-group float-end"},J=["onClick"],O=["onClick"],P={key:0,class:"list-group-item"},z={class:"modal fade",id:"exampleModal",tabindex:"-1","aria-labelledby":"exampleModalLabel","aria-hidden":"true"},A={class:"modal-dialog"},G={class:"modal-content"},H=e("div",{class:"modal-header"},[e("h5",{class:"modal-title",id:"exampleModalLabel"},"专辑"),e("button",{type:"button",class:"btn-close","data-bs-dismiss":"modal","aria-label":"Close"})],-1),q={class:"modal-body"},K={class:"mb-3"},Q=e("label",{for:"exampleFormControlInput1",class:"form-label"},"专辑名",-1),W={class:"mb-3"},X=e("label",{for:"exampleFormControlTextarea1",class:"form-label"},"描述",-1),Y={class:"modal-footer"},se={__name:"subject",setup(Z){let g=I(),C=L(),b=i(null),p=i(!1),u=i([]),t=i({subjectId:"",subjectName:"",synopsis:""}),n=i("update"),_=C.params.username;function k(o){m({url:`/api/subject/username/${o}`,method:"GET"}).then(s=>{u.value=s.data})}function N(){n.value=="insert"?m({url:"/api/subject",method:"POST",data:t.value}).then(o=>{u.value.unshift(o.data),b.value.click()}):m({url:"/api/subject",method:"PUT",data:t.value}).then(o=>{alert(JSON.stringify(o.data)),b.value.click()})}function T(o,s,c){t.value.subjectId=o,t.value.subjectName=s,t.value.synopsis=c,n.value="update"}function M(o,s){confirm("确认删除吗？")&&m({url:`/api/subject/${o}`,method:"DELETE"}).then(c=>{u.value.splice(s,1)})}return E(()=>{k(_),p.value=_==g.username}),(o,s)=>{const c=S("router-link");return d(),r(v,null,[e("ul",$,[(d(!0),r(v,null,U(l(u),a=>(d(),r("li",D,[B(c,{to:{name:"subject_post",params:{subject_id:a.subjectId}}},{default:V(()=>[e("strong",{textContent:x(a.subjectName)},null,8,w)]),_:2},1032,["to"]),e("div",R,[e("button",{class:"btn btn-outline-danger float-end blog-btn",onClick:F=>M(a.subjectId,o.index)},"删除",8,J),l(p)?(d(),r("button",{key:0,class:"btn btn-outline-danger float-end blog-btn","data-bs-toggle":"modal","data-bs-target":"#exampleModal",onClick:F=>T(a.subjectId,a.subjectName,a.synopsis)},"修改",8,O)):h("",!0)]),e("div",null,x(a.synopsis),1)]))),256)),l(p)?(d(),r("li",P,[e("a",{"data-bs-toggle":"modal","data-bs-target":"#exampleModal",onClick:s[0]||(s[0]=a=>(f(t)?t.value={}:t={},f(n)?n.value="insert":n="insert"))},"创建专辑")])):h("",!0)]),e("div",z,[e("div",A,[e("div",G,[H,e("div",q,[e("div",K,[Q,y(e("input",{class:"form-control",id:"exampleFormControlInput1","onUpdate:modelValue":s[1]||(s[1]=a=>l(t).subjectName=a)},null,512),[[j,l(t).subjectName]])]),e("div",W,[X,y(e("textarea",{class:"form-control",id:"exampleFormControlTextarea1",rows:"3","onUpdate:modelValue":s[2]||(s[2]=a=>l(t).synopsis=a)},null,512),[[j,l(t).synopsis]])])]),e("div",Y,[e("button",{type:"button",class:"btn btn-secondary","data-bs-dismiss":"modal",ref_key:"close",ref:b},"关闭",512),e("button",{type:"button",class:"btn btn-primary",onClick:N},"保存")])])])])],64)}}};export{se as default};
