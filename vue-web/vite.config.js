import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from "path";
import components from 'unplugin-vue-components/vite'
import { VarletUIResolver,ElementPlusResolver } from 'unplugin-vue-components/resolvers'

// https://vitejs.dev/config/
export default defineConfig({
    resolve:{
        alias: {
            "src": path.resolve(__dirname, "src")
            //"components": path.resolve(__dirname, "src/components"),
            //"styles": path.resolve(__dirname, "src/styles"),
            //"plugins": path.resolve(__dirname, "src/plugins"),
            //"views": path.resolve(__dirname, "src/views"),
            //"layouts": path.resolve(__dirname, "src/layouts"),
            //"utils": path.resolve(__dirname, "src/utils"),
           // "apis": path.resolve(__dirname, "src/apis"),
            //"dirs": path.resolve(__dirname, "src/directives"),
        }
    },
  plugins: [
    vue(),
    components({
      resolvers: [VarletUIResolver(),ElementPlusResolver()]
    })
  ],
  server: {
    host: 'localhost',
    open: '/',
    port: 8080
  }
})
