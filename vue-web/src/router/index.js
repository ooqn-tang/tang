import {
    createRouter,
    createWebHistory,
    createWebHashHistory
} from "vue-router";

const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('../views/home/index.vue'),
        children: [
            {
                path: '/',
                name: 'main',
                component: () => import('../views/article/index.vue')
            },
            {
                path: '/article',
                name: 'article',
                component: () => import('../views/article/index.vue')
            },
            {
                path: '/author/:username',
                name:'author_index',
                component: () => import('../views/author/index.vue'),
                children:[
                    {
                        path: '',
                        name: 'author_article',
                        component: () => import('../views/author/article.vue')
                    },
                    {
                        path: 'setting',
                        name: 'author_setting',
                        component: () => import('../views/author/setting.vue')
                    },
                    {
                        path: 'subject',
                        name: 'author_subject',
                        component: () => import('../views/author/subject.vue')
                    }
                    ,
                    {
                        path: 'subscribe',
                        name: 'author_subscribe',
                        component: () => import('../views/author/subscribe.vue')
                    }
                    ,
                    {
                        path: 'like',
                        name: 'author_like',
                        component: () => import('../views/author/like.vue')
                    }
                ]
            },
            {
                path: '/article/:id',
                name: 'article_info',
                component: () => import('../views/article/article.vue')
            },
            {
                path: '/subject',
                name: 'subject_index',
                component: () => import('../views/subject/index.vue')
            },
            {
                path: '/authors',
                name: 'author_list',
                component: () => import('../views/author/author_list.vue')
            },
            {
                path: '/subject/:subject_id',
                name: 'subject_info',
                component: () => import('../views/subject/post.vue')
            },
            {
                path: '/search',
                name: 'search_index',
                component: () => import('../views/search/index.vue')
            }
        ]
    },
    {
        path: '/admin',
        name: 'admin',
        component: () => import('../views/admin/index.vue'),
        children:[
            {
                path:"",
                name:"admin_article",
                component: () => import('../views/admin/article.vue')
            },{
                path:"author",
                name:"admin_author",
                component: () => import('../views/admin/author.vue')
            },{
                path:"role",
                name:"admin_role",
                component: () => import('../views/admin/role.vue')
            },{
                path:"resource",
                name:"admin_resource",
                component: () => import('../views/admin/resource.vue')
            }
        ]
    },
    {
        path: '/article-editor/:id',
        name: 'article-editor',
        component: () => import('../views/article/article-editor.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('../views/login/index.vue')
    },
    {
        path: '/:catchAll(.*)',
        component: () => import('../views/404.vue'),
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