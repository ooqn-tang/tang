import { createApp } from 'vue'
import routerData from './router-data'

import App from '@src/App.vue'
import { createPinia } from 'pinia'
import '@src/index.scss'
import "highlight.js/styles/github.css";

import router from '@common/router'


const app = createApp(App)
app.use(createPinia())
app.use(router(routerData, false))
app.mount('#app')


