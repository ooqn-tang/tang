import router from './router'
import store from './store'

// 路由守卫
router.beforeEach((to, from, next) => {
    if(localStorage.getItem("author") != null){
        store.state.username = JSON.parse(localStorage.getItem("author")).username
        let a = JSON.parse(localStorage.getItem("author"))
        if(a.authorities != null){
            let rs = []
            for(let r in a.authorities){
                rs.push(a.authorities[r]["authority"])
            }
            store.state.roles = rs
        }else{
            store.state.roles = []
        }
    }else{
        store.state.username = ""
        store.state.roles = []
    }
    next()
});
router.afterEach((to, from, next) => {
    // console.log('路由跳转后')
})