import request from '../utils/request'

// 获取作者信息
export function selectAuthor(username) {
    return request({
        url: '/api/author/' + username,
        method: 'GET'
    })
}

export function isLogin(){
    return request({
        url: '/api/author/isLogin',
        method: 'GET'
    })
}

export function updateAuthor(data) {
    return request({
        url: '/api/author',
        method: 'PUT',
        data
    })
}