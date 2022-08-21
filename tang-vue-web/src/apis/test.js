import request from '../utils/request'

export function refresh(data) {
    return request({
        url: '/api/refresh',
        method: 'POST',
        data:data
    })
}