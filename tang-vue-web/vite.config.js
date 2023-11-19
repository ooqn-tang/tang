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
      "@utils": path.resolve('src/utils'),
      "@admin/views": path.resolve('src/module/admin/views'),
      "@gateway/views": path.resolve('src/module/gateway/views'),
      "@apis": path.resolve('src/apis'),
      "@components": path.resolve('src/components'),
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