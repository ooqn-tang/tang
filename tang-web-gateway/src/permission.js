import router from './router'
import store from './store'
import Cookies from 'js-cookie'
import {isLogin} from './api/author'

// 路由守卫
router.beforeEach((to, from, next) => {
    next()
});
router.afterEach((to, from, next) => {
    // console.log('路由跳转后')
    store.state.username =  Cookies.get("username")
    isLogin().then((response) => {
        if(!response.data){
            Cookies.set("username","")
            store.state.username =  Cookies.get("username")
        }
    })
    
})