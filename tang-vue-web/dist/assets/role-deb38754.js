import{s as f}from"./request-596b05ba.js";import{l as k}from"./role-72a181a8.js";import{a as l,H as _,q as y,L as C,A as t,z as e,j as o,C as r}from"./preload-helper-b3ec2021.js";import{G as s}from"./Dropdown-5ec2749a.js";import{a as i,b as h}from"./Space-bd56af07.js";import"./admin-11bb90a5.js";const V={__name:"role",setup(v){l();let n=l(!1),u=l([]),c=l(null);l(""),l(-1);let d=[{title:"角色名",key:"roleName"},{title:"角色值",key:"roleValue"}],m=()=>{n.value=!0,k().then(a=>{n.value=!1,u.value=a.data})};function p(){f({url:"/api/admin/resource",method:"GET"}).then(a=>{c.value=a.data})}return _(()=>{m(),p()}),(a,N)=>(y(),C(e(i),{vertical:""},{default:t(()=>[o(e(i),null,{default:t(()=>[o(e(s),{type:"primary",onClick:a.handleCreate},{default:t(()=>[r("添加")]),_:1},8,["onClick"]),o(e(s),{type:"primary",onClick:a.handleUpdate},{default:t(()=>[r("保存")]),_:1},8,["onClick"]),o(e(s),{type:"primary",onClick:a.handleQuery},{default:t(()=>[r("查询")]),_:1},8,["onClick"])]),_:1}),o(e(h),{columns:e(d),data:e(u),bordered:!0},null,8,["columns","data"])]),_:1}))}};export{V as default};