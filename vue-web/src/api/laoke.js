import request from '../utils/request'

// 发送信息
export function sendLaoke(data) {
    return request({
        url: '/api/laoke',
        method: 'POST',
        data: data
    })
}

// 加载信息
export function loadLaoke() {
    return request({
        url: '/api/laoke',
        method: 'GET'
    })
}

// 删除信息
export function deleteLaoke(id) {
    return request({
        url: '/api/laoke/'+id,
        method: 'DELETE'
    })
}