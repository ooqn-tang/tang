import {createApp} from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import './index.scss'
import './permission'
import notice from './components/notice.vue'
import "highlight.js/styles/github.css"
import naive from 'naive-ui'
  

const app = createApp(App)

function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}

app.component("notice", notice);//全局自定义组件
app.use(naive)
app.use(router).use(store).mount('#app')
