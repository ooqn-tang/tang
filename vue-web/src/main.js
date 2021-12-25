import {createApp} from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import './index.scss'
import './permission'
import notice from './components/notice.vue'
import "highlight.js/styles/github.css"

const Vue = createApp(App)

function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}

Vue.component("notice", notice);//全局自定义组件
Vue.use(router).use(store).mount('#app')
