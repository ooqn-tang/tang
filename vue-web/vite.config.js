import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from "path";
import components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

export default defineConfig({
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "src"),
      "apis": path.resolve(__dirname, "src/apis"),
      "comps": path.resolve(__dirname, "src/components"),
      "views": path.resolve(__dirname, "src/views"),
      "utils": path.resolve(__dirname, "src/utils")
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
  }
})
