import{s as c}from"./request-596b05ba.js";import{a as r,H as _,q as k,L as h,A as t,z as e,j as a,C as u,P as v}from"./preload-helper-b3ec2021.js";import{G as i}from"./Dropdown-5ec2749a.js";import{a as p,b as C}from"./Space-bd56af07.js";import"./admin-11bb90a5.js";const L={__name:"resource",setup(N){let o=r(!1),n=r([]);r({});let d=r(""),f=[{title:"资源名称",key:"name"},{title:"资源路径",key:"path"},{title:"请求类型",key:"type"}];function y(){c({url:"/api/admin/resource/refresh",method:"GET"}).then(l=>{s()})}function s(){c({url:"/api/admin/resource",method:"GET",params:{query:d.value}}).then(l=>{n.value=l.data})}return _(()=>{s()}),(l,m)=>(k(),h(e(p),{vertical:""},{default:t(()=>[a(e(p),null,{default:t(()=>[a(e(i),{type:"primary",onClick:s},{default:t(()=>[u("搜索")]),_:1}),a(e(i),{type:"primary",onClick:m[0]||(m[0]=b=>v(o)?o.value=!0:o=!0)},{default:t(()=>[u("添加资源")]),_:1}),a(e(i),{type:"primary",onClick:y},{default:t(()=>[u("刷新请求状态")]),_:1})]),_:1}),a(e(C),{columns:e(f),data:e(n),bordered:!0},null,8,["columns","data"])]),_:1}))}};export{L as default};