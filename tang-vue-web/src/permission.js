import router from './router'
import store from './store'

// 路由守卫
router.beforeEach((to, from, next) => {
    try{
        // 获取本地存储中的author
        let author = JSON.parse(localStorage.getItem("author"))
        if (author != null) {
            store.state.username = author.sub
            store.state.author = author.author
        } else {
            store.state.username = ""
            store.state.author = {}
        }
    }catch(e){
        store.state.username = ""
        store.state.author = {}
        localStorage.removeItem("jwt")
        localStorage.removeItem("author")
    }
    // 跳转到下一个路由
    next()
});
// 路由守卫后
router.afterEach((to, from, next) => {
    // 打印路由跳转后
    console.log('路由跳转后')
})