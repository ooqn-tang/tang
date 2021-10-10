import request from '../utils/request'

// 发送信息
export function sendLaoke(id, laoke) {
    return request({
        url: '/api/laoke',
        method: 'POST',
        params: { id: id, laoke: laoke }
    })
}

// 发送评论
export function sendMsg(id, message) {
    return request({
        url: '/api/laoke/msg',
        method: 'POST',
        params: { id: id, message: message }
    })
}

// 加载消息
export function loadLaoke(page, loadTime) {
    return request({
        url: '/api/blog',
        method: 'GET',
        params: { page: page, loadTime: loadTime }
    })
}

// 加载评论
export function loadMsg(page, loadTime) {
    return request({
        url: '/api/laoke/message',
        method: 'GET',
        params: { page: page, loadTime: loadTime }
    })
}

// 删除消息
export function deleteLaoke(id) {
    return request({
        url: '/api/laoke',
        method: 'DELETE',
        params: { id: id }
    })
}


// 删除评论
export function deleteMsg(id) {
    return request({
        url: '/api/laoke/message',
        method: 'DELETE',
        params: { id: id }
    })
}

