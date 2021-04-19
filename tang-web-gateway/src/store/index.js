import {createStore} from 'vuex'

export default createStore({
    /*
    * 存储
    */
    state: {
        name: '',
        isLogin: true
    },

    /*
    * 获取
    */
    getters: {
        name(state) {
            return state.name
        }
    },

    /*
    * 1、通过提交commit改变数据
    * 2、只是一个单纯的函数
    * 3、不要使用异步操作，异步操作会导致变量不能追踪
    */
    mutations: {
        setName(state, name) {
            state.name = name
        }
    },

    /*
    * 1、用于通过提交mutation改变数据
    * 2、会默认将自身封装为一个Promise
    * 3、可以包含任意的异步操作
    */
    actions: {
        setName(state, name) {
            // state.name = name
            setTimeout(() => {
                state.commit('setName', name)
            }, 500)
        }
    }
})