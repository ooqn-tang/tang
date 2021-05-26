import request from '../utils/request'

export function loadAdvertise() {
    return request({
        url: '/advertise/list',
        method: 'GET'
    })
}