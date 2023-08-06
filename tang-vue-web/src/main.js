import { createApp } from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import './index.scss'
import './permission.js'
import "element-plus/dist/index.css"
import info from './components/info.vue'
import notice from './components/notice.vue'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

router.beforeEach((to, from) => {
    document.documentElement.scrollTop = 0;
})

const app = createApp(App)

import * as ElementPlusIconsVue from '@element-plus/icons-vue'

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(ElementPlus, { locale: zhCn })
app.use(router)
app.use(store)
app.use(info)
app.use(notice)
app.mount('#app')


