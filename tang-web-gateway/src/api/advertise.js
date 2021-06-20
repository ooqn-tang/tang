import request from '../utils/request'

export function loadAdvertise() {
    return request({
        url: '/api/advertise/list',
        method: 'GET'
    })
}