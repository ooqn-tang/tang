import{s as p}from"./request-5c6f490a.js";import{d as r,J as _,x as h,M as k,D as t,C as e,l as a,H as u,n as v}from"./router-7246853f.js";import{h as i}from"./Dropdown-9296c3ac.js";import{a as c,b as x}from"./Space-ade002b2.js";import"./admin-3c01a676.js";import"./notice-7b947d3f.js";import"./Scrollbar-df727b44.js";import"./Close-a013adfa.js";const L={__name:"resource",setup(C){let o=r(!1),n=r([]);r({});let d=r(""),f=[{title:"资源名称",key:"name"},{title:"资源路径",key:"path"},{title:"请求类型",key:"type"}];function y(){p({url:"/api/admin/resource/refresh",method:"GET"}).then(s=>{l()})}function l(){p({url:"/api/admin/resource",method:"GET",params:{query:d.value}}).then(s=>{n.value=s.data})}return _(()=>{l()}),(s,m)=>(h(),k(e(c),{vertical:""},{default:t(()=>[a(e(c),null,{default:t(()=>[a(e(i),{type:"primary",onClick:l},{default:t(()=>[u("搜索")]),_:1}),a(e(i),{type:"primary",onClick:m[0]||(m[0]=N=>v(o)?o.value=!0:o=!0)},{default:t(()=>[u("添加资源")]),_:1}),a(e(i),{type:"primary",onClick:y},{default:t(()=>[u("刷新请求状态")]),_:1})]),_:1}),a(e(x),{columns:e(f),data:e(n),bordered:!0},null,8,["columns","data"])]),_:1}))}};export{L as default};