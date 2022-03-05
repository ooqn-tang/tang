import { createStore } from 'vuex'

export default createStore({
    /*
    * 存储
    */
    state: {
        username: "",
        roles:[]
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