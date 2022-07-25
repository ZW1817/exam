import { createApp, reactive, ref } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-plus'
import 'element-plus/dist/index.css'
import elementIcon from "./plugins/icons"
import axios from 'axios'
const app = createApp(App)

app.config.globalProperties.$axios = axios
app.use(router);
app.use(ElementUI);
app.use(elementIcon);
app.mount('#app')