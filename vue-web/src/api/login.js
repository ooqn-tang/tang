import request from '../utils/request'

export function login(data) {
    return request({
        url: '/api/authenticate',
        method: 'post',
        data:data
    })
}

export function logout() {
    return request({
        url: '/api/logout',
        method: 'get'
    })
}

