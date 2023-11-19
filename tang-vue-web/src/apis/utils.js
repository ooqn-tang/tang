import request from '@utils/request'

// 导出一个刷新函数
export function refresh(data) {
    // 调用request函数，发送post请求，请求地址为/api/refresh
    return request({
        url: `/api/refresh`,
        method: 'POST',
        // 发送的数据为传入的data
        data:data
    })
}   