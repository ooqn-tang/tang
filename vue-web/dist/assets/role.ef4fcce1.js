/* empty css             *//* empty css                   *//* empty css               *//* empty css                  *//* empty css                  */import{_ as k,s as u}from"./index.2f223259.js";import{J as R,B as C,L,O as v,I as y,R as T,S as E,o as a,d as _,w as t,m as e,f as b,e as I,n as h,t as V,q as j,j as r}from"./vendor.69c4f9d0.js";const N={name:"admin_role",data(){return{loading:!1,routeName:this.$route.name,formInline:{user:""},roleList:[],resourceList:null,resourceIdList:null,selectRoleId:"",resourceForm:[],editIndex:-1}},computed:{},watch:{resourceIdList:{handler(){this.$nextTick(()=>{for(let o in this.resourceList)this.resourceIdList.indexOf(this.resourceList[o].resourceId)>-1&&this.$refs.multipleTable.toggleRowSelection(this.resourceList[o])})}}},created(){},methods:{checkResource(o,n){this.resourceForm=o},saveResourceRole(){u({url:"/api/admin/role/resource/"+this.selectRoleId,method:"POST",data:this.resourceForm}).then(o=>{alert("\u6DFB\u52A0\u6210\u529F")})},rowRoleClick(o){this.selectRoleId=o.roleId,this.selectResource(o)},selectRole(){this.loading=!0,u({url:"/api/admin/role",method:"GET"}).then(o=>{this.loading=!1,this.roleList=o.data})},selectResource(o){u({url:"/api/admin/resource",async:!1,method:"GET"}).then(n=>{this.resourceList=n.data,this.selectResourceIdList(o.roleId)})},selectResourceIdList(o){u({url:"/api/admin/resource/role/"+o,method:"GET"}).then(n=>{this.resourceIdList=n.data})}},mounted(){this.selectRole()}},B={style:{margin:"10px"}},S=r("\u65B0\u589E\u89D2\u8272"),z=r("\u641C\u7D22"),$={key:0},F={key:1},G=r("\u7F16\u8F91"),O=r("\u4FDD\u5B58"),D=r("\u6743\u9650\u8D44\u6E90\u7F16\u8F91"),U=r("\u5220\u9664"),q={style:{margin:"10px"}},J=r("\u4FDD\u5B58\u89D2\u8272"),P=r("\u641C\u7D22");function A(o,n,H,K,s,m){const d=R,p=C,i=L,f=v,x=y,g=T,w=E;return a(),_(g,null,{default:t(()=>[e(x,{span:14},{default:t(()=>[b("div",B,[e(p,{placeholder:"\u540D\u79F0/\u89D2\u8272\u503C/\u8D44\u6E90\u540D/\u8D44\u6E90\u503C",class:"input-with-select",style:{"padding-bottom":"5px"}},{prepend:t(()=>[e(d,null,{default:t(()=>[S]),_:1})]),append:t(()=>[e(d,null,{default:t(()=>[z]),_:1})]),_:1}),e(f,{data:s.roleList,"highlight-current-row":"",border:"","max-height":"400",style:{width:"100%"}},{default:t(()=>[e(i,{label:"\u89D2\u8272\u540D"},{default:t(l=>[l.$index==s.editIndex?(a(),I("div",$,[e(p,{modelValue:l.row.roleName,"onUpdate:modelValue":c=>l.row.roleName=c,size:"small",placeholder:"\u8BF7\u8F93\u5165\u89D2\u8272\u540D"},null,8,["modelValue","onUpdate:modelValue"])])):h("",!0),l.$index!=s.editIndex?(a(),I("div",F,V(l.row.roleName),1)):h("",!0)]),_:1}),e(i,{prop:"roleValue",label:"\u89D2\u8272\u503C"}),e(i,{prop:"createTime",label:"\u521B\u5EFA\u65F6\u95F4"}),e(i,{label:"\u64CD\u4F5C",width:"250"},{default:t(l=>[s.editIndex!=l.$index?(a(),_(d,{key:0,size:"small",onClick:c=>s.editIndex=l.$index},{default:t(()=>[G]),_:2},1032,["onClick"])):h("",!0),s.editIndex==l.$index?(a(),_(d,{key:1,size:"small",onClick:n[0]||(n[0]=c=>s.editIndex=-1)},{default:t(()=>[O]),_:1})):h("",!0),e(d,{size:"small",onClick:c=>(o.dialogVisible=!0,m.rowRoleClick(l.row))},{default:t(()=>[D]),_:2},1032,["onClick"]),e(d,{size:"small",type:"danger",onClick:c=>o.deleteResource(l.row.resourceId)},{default:t(()=>[U]),_:2},1032,["onClick"])]),_:1})]),_:1},8,["data"])])]),_:1}),e(x,{span:10},{default:t(()=>[b("div",q,[e(p,{placeholder:"",style:{"padding-bottom":"5px"},disabled:""},{prepend:t(()=>[e(d,{onClick:m.saveResourceRole},{default:t(()=>[J]),_:1},8,["onClick"])]),append:t(()=>[P]),_:1}),j((a(),_(f,{data:s.resourceList,ref:"multipleTable",onSelectionChange:m.checkResource,border:"","max-height":"800",style:{width:"100%"}},{default:t(()=>[e(i,{type:"selection",width:"40"}),e(i,{prop:"name",label:"\u540D\u79F0",width:"180"}),e(i,{prop:"path",label:"\u8DEF\u5F84",width:"180"}),e(i,{prop:"type",label:"\u7C7B\u578B"})]),_:1},8,["data","onSelectionChange"])),[[w,s.loading]])])]),_:1})]),_:1})}var te=k(N,[["render",A]]);export{te as default};
