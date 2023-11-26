import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import path from "path";

export default defineConfig({
  pages: {
    index: {
      entry: '/src/module/index/index.js',
      template: 'index.html',
      filename: 'index.html',
      title: 'ooqn.com'
    },
    admin: {
      entry: '/src/module/admin/index.js',
      template: 'admin.html',
      filename: 'admin.html',
      title: 'admin.ooqn.com'
    }
  },
  resolve: {
    alias: {
      "@src": path.resolve('src'),
      "@common": path.resolve('src/common'),
      "@components": path.resolve('src/components'),
      "@admin/views": path.resolve('src/module/admin/views'),
      "@admin/apis": path.resolve('src/module/admin/apis'),
      "@gateway/views": path.resolve('src/module/gateway/views'),
      "@gateway/apis": path.resolve('src/module/gateway/apis'),
    },
  },
  plugins: [
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
  , server: {
    port: 8000
  }
})