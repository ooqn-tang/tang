import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";

import { useAuthorStore } from '@common/user'

import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

//全局进度条的配置
NProgress.configure({
    easing: 'ease', // 动画方式
    speed: 1000, // 递增进度条的速度
    showSpinner: false, // 是否显示加载ico
    trickleSpeed: 200, // 自动递增间隔
    minimum: 0.3, // 更改启动时使用的最小百分比
    parent: 'body', //指定进度条的父容器
  })
  

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
        NProgress.start();
        document.documentElement.scrollTop = 0;
        let authorStore = useAuthorStore()
        let author = localStorage.getItem("author")
        let roles = localStorage.getItem("roles")
        if (author != null && roles != null) {
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
        NProgress.done();
    })

    return router
} 