import router from './router'
import store from './store'

// 路由守卫
router.beforeEach((to, from, next) => {
    try{
        // 获取本地存储中的authorData
        let authorData = JSON.parse(localStorage.getItem("authorData"))
        if (authorData != null) {
            // 如果authorData不为空
            if (authorData!= null) {
                // 将authorData的sub属性赋值给store.state.username
                store.state.username = authorData.sub
                // 将authorData的roles属性赋值给store.state.roles
                store.state.roles = authorData.roles.split(',')
                // 将authorData的author属性赋值给store.state.author
                store.state.author = authorData.author.author
            } else {
                // 如果authorData为空，将store.state.username赋值为空字符串
                store.state.username = ""
                // 将store.state.roles赋值为空数组
                store.state.roles = []
                // 将store.state.author赋值为空对象
                store.state.author = {}
            }
        }
    }catch(e){
        // 如果出现异常，将store.state.username赋值为空字符串
        store.state.username = ""
        // 将store.state.roles赋值为空数组
        store.state.roles = []
        // 将store.state.author赋值为空对象
        store.state.author = {}
        // 将jwt和authorData中的jwt和authorData中的authorData分别存入localStorage中
        localStorage.removeItem("jwt")
        localStorage.removeItem("authorData")
    }
    // 跳转到下一个路由
    next()
});
// 路由守卫后
router.afterEach((to, from, next) => {
    // 打印路由跳转后
    console.log('路由跳转后')
})