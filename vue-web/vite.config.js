const path = require('path')
// vite.config.js # or vite.config.ts

module.exports = {
    alias: { // 配置 /@/为src 键必须以斜线开始和结束
        '/@/': path.resolve(__dirname, './src')
    },
    hostname: 'localhost', // 默认是 localhost
    port: 8080, // 默认是 3000 端口
    open: true, // 是否自动在浏览器打开
    https: false, // 是否开启 https
    ssr: false, // 服务端渲染
    base: './', // 生产环境下的公共路径
    outDir: 'dist', // 打包构建输出路径，默认 dist ，如果路径存在，构建之前会被删除
    proxy: { // 反向代理
        '/api': {
            target: 'http://localhost',
            changeOrigin: true,
            rewrite: path => path.replace(/^\/api/, '')
        }
    }
}