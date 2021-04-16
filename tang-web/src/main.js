import {createApp} from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import api from './api/index.js'
import './index.scss'
import './permission'

const Vue = createApp(App)

Vue.config.globalProperties.$api = api

Vue.use(router).use(store).mount('#app')
