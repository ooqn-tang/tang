import { createStore } from 'vuex'

export default createStore({
    /*
    * 存储
    */
    state: {
        username: ""
    },

    /*
    * 获取
    */
    getters: {
        username(state) {
            return state.username
        }
    },

    /*
    * 1、通过提交commit改变数据
    * 2、只是一个单纯的函数
    * 3、不要使用异步操作，异步操作会导致变量不能追踪
    */
    mutations: {
        setUsername(state, username) {
            state.username = username
        }
    },

    /*
    * 1、用于通过提交mutation改变数据
    * 2、会默认将自身封装为一个Promise
    * 3、可以包含任意的异步操作
    */
    actions: {
        //setName(state, author) {
        //    alert(author)
        //    // state.name = name
        //}
    }
})