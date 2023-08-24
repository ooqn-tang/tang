import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";
import store from 'src/store'

const routes = [
    {
        path: '/',
        name: 'admin',
        component: () => import('admin/views/index.vue'),
        redirect:"/article",
        children:[
            {
                path:"article",
                name:"admin_article",
                component: () => import('admin/views/article.vue'),
                mate:{
                    isM:true,
                    name:'文章管理'
                }
            },{
                path:"recommend",
                name:"admin_recommend",
                component: () => import('admin/views/recommend.vue'),
                mate:{
                    isM:true,
                    name:'推荐管理'
                }
            },{
                path:"author",
                name:"admin_author",
                component: () => import('admin/views/author.vue'),
                mate:{
                    isM:true,
                    name:'用户管理'
                }
            },{
                path:"role",
                name:"admin_role",
                component: () => import('admin/views/role.vue'),
                mate:{
                    isM:true,
                    name:'角色管理'
                }
            },{
                path:"resource",
                name:"admin_resource",
                component: () => import('admin/views/resource.vue'),
                mate:{
                    isM:true,
                    name:'资源管理'
                }
            },{
                path:"resource",
                name:"admin_resource",
                mate:{
                    isM:true,
                    name:'资源管理',
                    isLink:true,
                    openUrl:"http://baidu.com"
                }
            },{
                path:"template",
                name:"admin_template",
                component: () => import('admin/views/template.vue'),
                mate:{
                    isM:true,
                    name:'模板管理'
                }
            }
        ]
    }
]
/*
createWebHistory   History 模式
createWebHashHistory    hash 模式
*/
const router = createRouter({
    history: createWebHashHistory(),
    routes
});

// 路由守卫
router.beforeEach((to, from, next) => {
    try{
        // 获取本地存储中的author
        let author = JSON.parse(localStorage.getItem("author"))
        if (author != null) {
            store.state.username = author.sub
            store.state.author = author.author
        } else {
            store.state.username = ""
            store.state.author = {}
        }
    }catch(e){
        store.state.username = ""
        store.state.author = {}
        localStorage.removeItem("jwt")
        localStorage.removeItem("author")
    }
    // 跳转到下一个路由
    next()
});
// 路由守卫后
router.afterEach((to, from, next) => {
    // 打印路由跳转后
    console.log('路由跳转后')
})


export default router