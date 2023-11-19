import { createApp } from 'vue'
import router from './router'
import store from '@utils/store'
import App from '@src/App.vue'
import '@src/index.scss'
import "highlight.js/styles/github.css";
import info from '@components/info.vue'
import notice from '@components/notice.vue'
import { NIcon  } from "naive-ui";

import contextmenu from "v-contextmenu";
import "v-contextmenu/dist/themes/default.css";

const app = createApp(App)

// 路由守卫
router.beforeEach((to, from, next) => {
  try{
      document.documentElement.scrollTop = 0;
      // 获取本地存储中的author
      let author = JSON.parse(localStorage.getItem("author"))
      if (author != null) {
          store.state.username = author.sub
          store.state.author = author.author
      } else {
          store.state.username = ""
          store.state.author = {}
      }
  }catch(e){
      store.state.username = ""
      store.state.author = {}
      localStorage.removeItem("jwt")
      localStorage.removeItem("author")
  }
  // 跳转到下一个路由
  next()
});
// 路由守卫后
router.afterEach((to, from, next) => {
  // 打印路由跳转后
  console.log('路由跳转后')
})

app.use(router)
app.use(store)
app.use(info)
app.use(notice)
app.use(contextmenu)
app.use(NIcon)
app.mount('#app')
