import {
    createRouter,
    createWebHistory,
    createWebHashHistory
} from "vue-router";

const routes = [
    {
        path: '/',
        name: 'home',
        redirect: '/blog',
        component: () => import('../views/home/index.vue'),
        children: [
            {
                path: '/blog',
                name: 'blog',
                component: () => import('../views/blog/index.vue')
            },
            {
                path: '/author/:username',
                name:'author_index',
                component: () => import('../views/author/index.vue'),
                children:[
                    {
                        path: '',
                        name: 'author_blog',
                        component: () => import('../views/author/blog.vue')
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
                path: '/blog/:id',
                name: 'blog_info',
                component: () => import('../views/blog/blog.vue')
            },
            {
                path: '/subject',
                name: 'subject',
                component: () => import('../views/subject/index.vue')
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
            },
        ]
    },
    {
        path: '/editor/:id',
        name: 'editor',
        component: () => import('../views/blog/editor.vue')
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