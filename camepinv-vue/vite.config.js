import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'


export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    open: true, //是否自动弹出浏览器页面
    https: false,
    hotOnly: false,
    proxy: {
      '/api': {
        target: 'http://localhost:8080/login/teacher',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, '')
      },
      "/student":{
        target: 'http://localhost:8080/login/studentlogin',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/student/, '')
      },
      "/home":{
        target: 'http://localhost:8080/home/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/home/, '')
      },
      "/analysis":{
        target: 'http://localhost:8080/analysis/',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/analysis/, '')
      },


    }
  },

})


