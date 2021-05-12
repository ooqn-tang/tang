import request from '../utils/request'

export function login(data) {
    return request({
        url: '/login',
        method: 'post',
        params:data
    })
}

export function logout() {
    return request({
        url: '/logout',
        method: 'get'
    })
}

