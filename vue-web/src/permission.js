import router from './router'
import store from './store'
import {isLogin} from './api/author'

// 路由守卫
router.beforeEach((to, from, next) => {
    next()
});
router.afterEach((to, from, next) => {
    // console.log('路由跳转后')
    store.state.user = JSON.parse(localStorage.getItem("user"))
})