import request from '../utils/request'

export function login(data) {
    return request({
        url: '/api/authenticate',
        method: 'post',
        data:data
    })
}
