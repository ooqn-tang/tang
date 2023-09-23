import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";
import store from 'src/store'


const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('views/home/home.vue'),
        children: [
            {
                path: '/',
                name: 'main',
                component: () => import('views/article/article-list.vue')
            },
            {
                path: '/article',
                name: 'article',
                component: () => import('views/article/article-list.vue')
            },
            {
                path: '/article/:id',
                name: 'article_post',
                component: () => import('views/article/article-post.vue')
            },
            {
                path: 'message',
                name: 'message',
                component: () => import('views/home/message.vue')
            },
            {
                path: 'essay',
                name: 'essay_index',
                component: () => import('views/essay/index.vue'),
                children:[
                    {
                        path: '',
                        name: 'essay_message',
                        component: () => import('views/essay/message.vue')
                    },
                    {
                        path: 'my',
                        name: 'essay_my',
                        component: () => import('views/essay/my.vue')
                    }
                ]
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
                path: '/subject',
                name: 'subject',
                component: () => import('views/subject/subject.vue')
            },
            {
                path: '/author',
                name: 'author',
                component: () => import('views/author/author-list.vue')
            },
            {
                path: '/subject/:subject_id',
                name: 'subject_post',
                component: () => import('views/subject/subject-post.vue')
            },
            {
                path: '/search',
                name: 'search_index',
                component: () => import('views/home/search.vue')
            }
        ]
    },
    {
        path: '/chat',
        name: 'chat',
        component: () => import('views/chat/index.vue'),
        children:[
            {
                path:"",
                name:"chat_no",
                component: () => import('views/chat/no.vue')
            },
            {
                path:"message/:id",
                name:"chat_message",
                component: () => import('views/chat/message.vue')
            }
        ]
    },
    {
        path: '/article-editor-md',
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
        component: () => import('views/home/404.vue'),
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