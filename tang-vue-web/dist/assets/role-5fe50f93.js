import{s as f}from"./request-02cf91c6.js";import{l as k}from"./role-25989725.js";import{d as l,H as _,x as y,N as C,J as t,C as e,l as o,K as r}from"./router-f99ea542.js";import{G as s}from"./Dropdown-7dbd4cfb.js";import{a as i,b as h}from"./Space-3b70ee3a.js";import"./admin-6c3842a9.js";import"./notice-369b78c3.js";const G={__name:"role",setup(N){l();let n=l(!1),u=l([]),d=l(null);l(""),l(-1);let c=[{title:"角色名",key:"roleName"},{title:"角色值",key:"roleValue"}],m=()=>{n.value=!0,k().then(a=>{n.value=!1,u.value=a.data})};function p(){f({url:"/api/admin/resource",method:"GET"}).then(a=>{d.value=a.data})}return _(()=>{m(),p()}),(a,v)=>(y(),C(e(i),{vertical:""},{default:t(()=>[o(e(i),null,{default:t(()=>[o(e(s),{type:"primary",onClick:a.handleCreate},{default:t(()=>[r("添加")]),_:1},8,["onClick"]),o(e(s),{type:"primary",onClick:a.handleUpdate},{default:t(()=>[r("保存")]),_:1},8,["onClick"]),o(e(s),{type:"primary",onClick:a.handleQuery},{default:t(()=>[r("查询")]),_:1},8,["onClick"])]),_:1}),o(e(h),{columns:e(c),data:e(u),bordered:!0},null,8,["columns","data"])]),_:1}))}};export{G as default};
