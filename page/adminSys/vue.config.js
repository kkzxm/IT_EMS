module.exports = {
    css: {
        loaderOptions: {
            sass: {
                additionalData: `
          @import "@/assets/scss/variable.scss";
          @import "@/assets/scss/mixin.scss";
        `
            }
        }
    },
    devServer: {
        open: process.platform === 'darwin',
        host: '127.0.0.1',
        port: 8001,
        https: false,
        hotOnly: false,
        proxy: null, // 设置代理
    },
}
