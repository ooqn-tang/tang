import router from './router'
import store from './store'

// 路由守卫
router.beforeEach((to, from, next) => {
    // console.log('路由跳转前')
    // if (store.state.author == null && to.path !== '/') {
    //     next('/')
    // } else {
    //     next()
    // }
    store.state.username = localStorage.getItem("username")
    next()
});
router.afterEach((to, from, next) => {
    // console.log('路由跳转后')
})