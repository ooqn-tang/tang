import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import path from "path";

export default defineConfig({
  pages: {
    index: {
      entry: '/src/module/index/index.js',
      template: 'index.html',
      filename: 'index.html',
      title: 'Main App'
    },
    admin: {
      entry: '/src/module/admin/index.js',
      template: 'admin.html',
      filename: 'admin.html',
      title: 'Admin App'
    }
  },
resolve:{
    alias: {
      "@src": path.resolve('src'),
      "@utils": path.resolve('src/utils'),
      "@views": path.resolve('src/module/index/views'),
      "@admin/views": path.resolve('src/module/admin/views'),
      "@apis": path.resolve('src/apis'),
      "@components": path.resolve('src/components'),
    },
  },
  plugins:[
    vue()
  ],
  build: {
    rollupOptions: {
      input: {
        index: '/index.html',
        admin: '/admin.html'
      }
    }
  }
  // 配置 端口
  ,server:{
    port:8000
    }
})