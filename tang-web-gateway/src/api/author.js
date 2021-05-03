import request from '../utils/request'

// 获取作者信息
export function selectAuthor(username) {
    return request({
        url: '/author/' + username,
        method: 'GET'
    })
}

export function updateAuthor(data) {
    return request({
        url: '/author',
        method: 'PUT',
        data
    })
}