import { createApp } from 'vue'
import router from './router'
import store from 'src/store'
import App from 'src/App.vue'
import 'src/index.scss'
import "highlight.js/styles/github.css";
import info from 'components/info.vue'
import notice from 'components/notice.vue'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import { NIcon  } from "naive-ui";

import contextmenu from "v-contextmenu";
import "v-contextmenu/dist/themes/default.css";


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
app.use(contextmenu)
app.use(NIcon)
app.mount('#app')
