import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('views/home/index.vue'),
        children: [
            {
                path: '/',
                name: 'main',
                component: () => import('views/article/index.vue')
            },
            {
                path: 'message',
                name: 'message',
                component: () => import('views/home/message.vue')
            },
            {
                path: 'essay',
                name: 'essay',
                component: () => import('views/home/essay.vue')
            },
            {
                path: '/article',
                name: 'article',
                component: () => import('views/article/index.vue')
            },
            {
                path: '/author/:username',
                name:'author_index',
                component: () => import('views/author/index.vue'),
                children:[
                    {
                        path: '',
                        name: 'author_article',
                        component: () => import('views/author/article.vue')
                    },
                    {
                        path: 'setting',
                        name: 'author_setting',
                        component: () => import('views/author/setting.vue')
                    },
                    {
                        path: 'subject',
                        name: 'author_subject',
                        component: () => import('views/author/subject.vue')
                    }
                    ,
                    {
                        path: 'subscribe',
                        name: 'author_subscribe',
                        component: () => import('views/author/subscribe.vue')
                    }
                    ,
                    {
                        path: 'collect',
                        name: 'author_collect',
                        component: () => import('views/author/collect.vue')
                    }
                ]
            },
            {
                path: '/article/:id',
                name: 'article_info',
                component: () => import('views/article/article.vue')
            },
            {
                path: '/subject',
                name: 'subject_index',
                component: () => import('views/subject/index.vue')
            },
            {
                path: '/authors',
                name: 'authors',
                component: () => import('views/home/authors.vue')
            },
            {
                path: '/subject/:subject_id',
                name: 'subject_info',
                component: () => import('views/subject/post.vue')
            },
            {
                path: '/search',
                name: 'search_index',
                component: () => import('views/search/index.vue')
            }
        ]
    },
    {
        path: '/admin',
        name: 'admin',
        component: () => import('views/admin/index.vue'),
        redirect:"/admin/comment",
        children:[
            {
                path:"comment",
                name:"admin_comment",
                component: () => import('views/admin/comment.vue')
            },{
                path:"recommend",
                name:"admin_recommend",
                component: () => import('views/admin/recommend.vue')
            },{
                path:"author",
                name:"admin_author",
                component: () => import('views/admin/author.vue')
            },{
                path:"role",
                name:"admin_role",
                component: () => import('views/admin/role.vue')
            },{
                path:"resource",
                name:"admin_resource",
                component: () => import('views/admin/resource.vue')
            },{
                path:"class",
                name:"admin_class",
                component: () => import('views/admin/class.vue')
            },{
                path:"article",
                name:"admin_article",
                component: () => import('views/admin/article.vue')
            }
        ]
    },
    {
        path: '/article-editor-md/:id',
        name: 'article-editor-md',
        component: () => import('views/article/article-editor-md.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('views/home/login.vue')
    },
    {
        path: '/register',
        name: 'register',
        component: () => import('views/home/register.vue')
    },
    {
        path: '/:catchAll(.*)',
        component: () => import('views/404.vue'),
        hidden: true
    }
]
/*
createWebHistory   History 模式
createWebHashHistory    hash 模式
*/
const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router