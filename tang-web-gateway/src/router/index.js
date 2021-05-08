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
                path: '/post/:id',
                name: 'post',
                component: () => import('../views/blog/post.vue')
            },
        ]
    },
    {
        path: '/editor',
        name: 'editor',
        component: () => import('../views/blog/editor.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('../views/login/index.vue')
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