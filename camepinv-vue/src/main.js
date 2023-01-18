import { createApp } from 'vue'
import App from './App.vue'
import "./assets/css/bootstrap.css"
import './assets/main.css'
import router from "@/router";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from "axios";
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const  app =createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus)
app.use(router)

app.mount('#app')
