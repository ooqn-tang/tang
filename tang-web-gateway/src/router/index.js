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
                path: 'blog',
                name: 'blog',
                component: () => import('../views/blog/index.vue')
            },
            {
                path: 'author/:username',
                name: 'author',
                component: () => import('../views/author/index.vue')
            },
            {
                path: 'post/:blogId',
                name: 'post',
                component: () => import('../views/blog/post.vue')
            }
        ]
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