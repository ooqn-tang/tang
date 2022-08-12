import router from './router'
import store from './store'

// 路由守卫
router.beforeEach((to, from, next) => {
    let authorData = JSON.parse(localStorage.getItem("authorData"))
    if (authorData != null) {
        store.state.username = authorData.sub
        store.state.roles = authorData.roles.split(',')
        store.state.author = authorData.author.author
    } else {
        store.state.username = ""
        store.state.roles = []
        store.state.author = {}
    }
    next()
});
router.afterEach((to, from, next) => {
    console.log('路由跳转后')
})