import{s as l,o as e,c as a,b as o,F as t,g as s,f as r}from"./index.7f4a8142.js";var i={name:"search_index",data:()=>({videoTagList:[{},{},{},{},{},{},{},{},{},{}]}),computed:{},created(){},methods:{upfile(e){let a=e.target.files[0],o=new FormData;o.append("file",a),l({url:"/api/file/upload",method:"POST",headers:{post:{"Content-Type":"multipart/form-data"}},data:o}).then((l=>{alert(l.data)}))}},mounted(){}};const n={class:"row"},c={class:"col-lg-8"},m=r('<div class="mb-3"><label for="exampleFormControlInput1" class="form-label">标题</label><input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com"></div><div class="mb-3"><label for="exampleFormControlTextarea1" class="form-label">描述</label><textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea></div>',2),p={class:"mb-3"},d=o("label",{for:"formFileMultiple",class:"form-label"},"视频",-1),f={class:"mb-3"},u=o("label",{for:"formFileMultiple",class:"form-label"},"标签",-1),b=o("br",null,null,-1),v=r('<div class="mb-3"><label for="formFileMultiple" class="form-label">专辑</label><select class="form-select" aria-label="Default select example"><option selected>Open this select menu</option><option value="1">One</option><option value="2">Two</option><option value="3">Three</option></select></div><div class="mb-3"><button type="submit" class="btn btn-primary">Submit</button></div>',2),h=o("div",{class:"col-lg-4"},null,-1);i.render=function(l,r,i,x,F,T){return e(),a("div",n,[o("div",c,[m,o("div",p,[d,o("input",{class:"form-control",type:"file",id:"formFileMultiple",onChange:r[1]||(r[1]=l=>T.upfile(l)),ref:"inputer"},null,544)]),o("div",f,[u,b,(e(!0),a(t,null,s(F.videoTagList,((l,t)=>(e(),a("div",{class:"form-check form-check-inline",key:t},[o("input",{class:"form-check-input",type:"checkbox",id:t,value:"option1"},null,8,["id"]),o("label",{class:"form-check-label",for:t},"asdfasdf",8,["for"])])))),128))]),v]),h])};export default i;
