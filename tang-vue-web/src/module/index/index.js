import { createApp } from 'vue'
import router from './router.js'
import App from './App.vue'
import store from 'src/store'
import 'src/index.scss'
import "highlight.js/styles/github.css";

router.beforeEach((to, from) => {
    document.documentElement.scrollTop = 0;
})

const app = createApp(App)
app.use(router)
app.use(store)
app.mount('#app')


