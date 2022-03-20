import { createApp } from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import './index.scss'
import './permission.js'
import "highlight.js/styles/github.css"
import "element-plus/dist/index.css"
import ranking from './components/ranking.vue'
import info from './components/info.vue'
import notice from './components/notice.vue'
import NPlayer from "@nplayer/vue"
import ElementPlus from 'element-plus'

router.beforeEach((to, from) => {
    document.documentElement.scrollTop = 0;
})

const app = createApp(App)
app.use(NPlayer)
app.use(ElementPlus)
app.use(router)
app.use(store)
app.use(ranking)
app.use(info)
app.use(notice)
app.mount('#app')

