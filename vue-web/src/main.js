import {createApp} from 'vue'
import router from './router'
import store from './store'
import App from './App.vue'
import './index.scss'
import './permission'
import notice from './components/notice.vue'
import "highlight.js/styles/github.css"
import VLoading from "element-plus/es/components/loading/index"


router.beforeEach((to,from)=>{
    document.documentElement.scrollTop=0;
})

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

import NPlayer from "@nplayer/vue";
app.use(VLoading)
app.use(NPlayer);
app.component("notice", notice);//全局自定义组件
app.use(router).use(store).mount('#app')
