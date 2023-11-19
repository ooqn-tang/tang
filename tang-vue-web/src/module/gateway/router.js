import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('@gateway/views/home/home.vue'),
        children: [
            {
                path: '/',
                name: 'main',
                component: () => import('@gateway/views/article/article-list.vue')
            },
            {
                path: '/article',
                name: 'article',
                component: () => import('@gateway/views/article/article-list.vue')
            },
            {
                path: '/article/:id',
                name: 'article_post',
                component: () => import('@gateway/views/article/article-post.vue')
            },
            {
                path: 'message',
                name: 'message',
                component: () => import('@gateway/views/home/message.vue')
            },
            {
                path: 'essay',
                name: 'essay_index',
                component: () => import('@gateway/views/essay/index.vue')
            },
            {
                path: '/author/:username',
                name:'author_index',
                component: () => import('@gateway/views/author/index.vue'),
                children:[
                    {
                        path: '',
                        name: 'author_article',
                        component: () => import('@gateway/views/author/article.vue')
                    },
                    {
                        path: 'setting',
                        name: 'author_setting',
                        component: () => import('@gateway/views/author/setting.vue')
                    },
                    {
                        path: 'subject',
                        name: 'author_subject',
                        component: () => import('@gateway/views/author/subject.vue')
                    }
                    ,
                    {
                        path: 'subscribe',
                        name: 'author_subscribe',
                        component: () => import('@gateway/views/author/subscribe.vue')
                    }
                    ,
                    {
                        path: 'collect',
                        name: 'author_collect',
                        component: () => import('@gateway/views/author/collect.vue')
                    }
                ]
            },
            {
                path: '/subject',
                name: 'subject',
                component: () => import('@gateway/views/subject/subject.vue')
            },
            {
                path: '/author',
                name: 'author',
                component: () => import('@gateway/views/author/author-list.vue')
            },
            {
                path: '/subject/:subject_id',
                name: 'subject_post',
                component: () => import('@gateway/views/subject/subject-post.vue')
            },
            {
                path: '/search',
                name: 'search',
                component: () => import('@gateway/views/home/search.vue')
            }
        ]
    },
    {
        path: '/chat',
        name: 'chat',
        component: () => import('@gateway/views/chat/index.vue'),
        children:[
            {
                path:"",
                name:"chat_no",
                component: () => import('@gateway/views/chat/no.vue')
            },
            {
                path:"message/:id",
                name:"chat_message",
                component: () => import('@gateway/views/chat/message.vue')
            }
        ]
    },
    {
        path: '/article-editor-md',
        name: 'article-editor-md',
        component: () => import('@gateway/views/article/article-editor-md.vue')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('@gateway/views/home/login.vue')
    },
    {
        path: '/register',
        name: 'register',
        component: () => import('@gateway/views/home/register.vue')
    },
    {
        path: '/:catchAll(.*)',
        component: () => import('@gateway/views/home/404.vue'),
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