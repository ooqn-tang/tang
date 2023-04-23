import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import {resolve} from "path";
import components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

export default defineConfig({
  resolve: {
    alias: {
      "@": resolve("./src"),
      "apis": resolve("./src/apis"),
      "comps": resolve("./src/components"),
      "views": resolve("./src/views"),
      "utils": resolve("./src/utils")
    }
  },
  plugins: [
    vue(),
    components({
      resolvers: [ElementPlusResolver()]
    })
  ],
  server: {
    host: 'localhost',
    open: '/',
    port: 8080
  },
  dev:{
    sourcemap:true
  }
})
