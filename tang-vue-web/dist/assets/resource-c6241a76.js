import{s as m}from"./request-55ac77c7.js";import{j as o,N as k,d as h,E as a,F as e,r as v,o as N,v as t,M as l,A as g}from"./github-3fa84727.js";import{N as C,a as d,b}from"./Space-8ada6f7b.js";import{m as n}from"./Dropdown-77abfe22.js";import"./admin-012b45fb.js";import"./notice-7aa0c2eb.js";const G={__name:"resource",setup(T){let s=o(!1),u=o([]);o({});let c=o(""),f=[{title:"资源名称",key:"name"},{title:"资源路径",key:"path"},{title:"请求类型",key:"type"}],_=()=>{m({url:"/api/admin/resource/refresh",method:"GET"}).then(r=>{i()})},i=()=>{m({url:"/api/admin/resource",method:"GET",params:{query:c.value}}).then(r=>{u.value=r.data})};return k(()=>{i()}),(r,p)=>{const y=v("n-input-group");return N(),h(e(d),{vertical:""},{default:a(()=>[t(e(d),null,{default:a(()=>[t(y,null,{default:a(()=>[t(e(C),{style:{width:"50%"}}),t(e(n),{type:"primary",ghost:""},{default:a(()=>[l("搜索")]),_:1})]),_:1}),t(e(n),{type:"primary",onClick:e(i)},{default:a(()=>[l("搜索")]),_:1},8,["onClick"]),t(e(n),{type:"primary",onClick:p[0]||(p[0]=x=>g(s)?s.value=!0:s=!0)},{default:a(()=>[l("添加资源")]),_:1}),t(e(n),{type:"primary",onClick:e(_)},{default:a(()=>[l("刷新请求状态")]),_:1},8,["onClick"])]),_:1}),t(e(b),{columns:e(f),data:e(u),pagination:r.pagination,bordered:!0},null,8,["columns","data","pagination"])]),_:1})}}};export{G as default};
