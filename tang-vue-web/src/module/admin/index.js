import '@src/index.scss';
import "highlight.js/styles/github.css";
import Engine from '@src/module/engine';
import router from '@common/router';
import routerData from './router-data';
import { NIcon } from "naive-ui";
import contextmenu from "v-contextmenu";
import "v-contextmenu/dist/themes/default.css";



const routers = router(routerData, true);
let engine = new Engine(routers);
engine.use(contextmenu)
engine.use(NIcon)
engine.mount('#app');