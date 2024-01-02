import '@src/index.scss';
import "highlight.js/styles/github.css";
import Engine from '@src/module/engine';
import router from '@common/router';
import { MonsterSocket } from "@common/monster";
import routerData from './router-data';

let monsterUrl = import.meta.env.VITE_BASE_API_WS + "_monster";
let monsterSocket = new MonsterSocket(monsterUrl);

if (localStorage.getItem('jwt')) {
    monsterSocket.login(() => {
        console.log('monsterSocket login');
    })
}
const routers = router(routerData, false);
let engine = new Engine(routers);
engine.provide('$ms', monsterSocket);
engine.mount('#app');

