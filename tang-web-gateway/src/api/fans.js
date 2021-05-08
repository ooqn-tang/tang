import request from '../utils/request'

// 获取作者信息
export function insertFans(username) {
    return request({
        url: '/fans/' + username,
        method: 'POST'
    })
}

export function deleteFans(username) {
    return request({
        url: '/fans/' + username,
        method: 'DELETE'
    })
}

export function fansList(data) {
    return request({
        url: '/fans/list',
        method: 'get'
    })
}

export function isFans(username) {
    return request({
        url: '/fans/is',
        method: 'get',
        params:{
            username:username
        }
    })
}