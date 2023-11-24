import { createApp } from 'vue'
import routeData from './router-data'
import App from '@src/App.vue'
import '@src/index.scss'
import "highlight.js/styles/github.css";
import info from '@components/info.vue'
import notice from '@components/notice.vue'
import { NIcon } from "naive-ui";

import contextmenu from "v-contextmenu";
import "v-contextmenu/dist/themes/default.css";
import { createPinia } from 'pinia'

import router from '@utils/router'

const app = createApp(App)

app.use(info)
app.use(notice)
app.use(contextmenu)
app.use(NIcon)
app.use(createPinia())
app.use(router(routeData, true))
app.mount('#app')
