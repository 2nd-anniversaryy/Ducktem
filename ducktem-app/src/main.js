import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store.js';

const app = createApp(App);

app.use(router).use(store);

app.mount('#app');
