import App from '@src/App.vue';
import { createPinia } from 'pinia';
import { createApp,reactive } from 'vue';

export default class Engine{

    constructor(router){
        this.app = createApp(App);
        this.app.use(createPinia());
        this.app.use(router);
    }

    provide(key, value){
        this.app.provide(key, reactive(value));
        return this;
    }

    use(plugin){
        this.app.use(plugin);
        return this;
    }

    mount(id){
        this.app.mount(id);
        return this;
    }

}