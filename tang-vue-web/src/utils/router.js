import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";

import { useAuthorStore } from '@utils/user'

export default function router(routes, hash) {
    /*
    createWebHistory   History 模式
    createWebHashHistory    hash 模式
    */
    let history;
    if (hash) {
        history = createWebHashHistory()
    } else {
        history = createWebHistory()
    }

    const router = createRouter({
        history: history,
        routes
    });

    // 路由守卫
    router.beforeEach((to, from, next) => {
        document.documentElement.scrollTop = 0;
        let authorStore = useAuthorStore()
        let author = localStorage.getItem("author")
        let roles = localStorage.getItem("roles")
        if(author != null){
            authorStore.setAuthor(JSON.parse(author))
            authorStore.setRoles(JSON.parse(roles))
        }
        // 跳转到下一个路由
        next()
    });

    // 路由守卫后
    router.afterEach((to, from, next) => {
        // 打印路由跳转后
        console.log('路由跳转后')
    })

    return router
} 