import{s as a}from"./index.16955009.js";function r(r){return a({url:"/api/blog/list",method:"get",params:r})}function t(r,t){return a({url:"/api/blog/list/"+r,method:"get",params:t})}function o(r){return a({url:"/api/blog/load/all",method:"GET",params:{blogId:r}})}function n(r){return a({url:"/api/blog/load",method:"GET",params:r})}function u(){return a({url:"/api/blog",method:"POST"})}function e(r){return a({url:"/api/blog",method:"PUT",data:r})}function l(r){return a({url:"/api/blog/"+r,method:"DELETE"})}function i(r){return a({url:"/api/subject/username",method:"GET",params:{username:r}})}function s(){return a({url:"/api/tag/allTag",method:"GET"})}function m(){return a({url:"/api/blog/recommend",method:"GET"})}export{m as a,r as b,u as c,l as d,o as e,i as f,s as g,t as l,n as p,e as s};