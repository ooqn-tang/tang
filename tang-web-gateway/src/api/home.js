import request from '../utils/request'

export function login(data) {
    return request({
        url: '/json_demo.json',
        method: 'get',
        data
    })
}