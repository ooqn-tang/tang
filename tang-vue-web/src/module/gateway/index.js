import { createApp, reactive } from 'vue'
import routerData from './router-data'

import App from '@src/App.vue'
import { createPinia } from 'pinia'
import '@src/index.scss'
import "highlight.js/styles/github.css";

import router from '@common/router'


import { useAuthorStore } from "@common/user";
import { MonsterSocket } from "@common/monster"

let monsterUrl = import.meta.env.VITE_BASE_API_WS + "_monster";
let monsterSocket = new MonsterSocket(monsterUrl);

const ms = reactive(monsterSocket)

if(localStorage.getItem('jwt')){
    monsterSocket.login(() => {
        console.log('monsterSocket login');
    })
}

const app = createApp(App)
app.use(createPinia())
app.use(router(routerData, false))
app.provide('$ms', ms)
app.mount('#app')


