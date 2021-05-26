import {createApp} from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import api from './api/index.js'
import './index.scss'
import './permission'
import advertise from '/@/components/advertise.vue'




const Vue = createApp(App)

Vue.config.globalProperties.$api = api
Vue.component("advertise", advertise);//全局自定义组件
Vue.use(router).use(store).mount('#app')
