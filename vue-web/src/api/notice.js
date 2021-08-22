import request from '../utils/request'

export function loadNotice() {
    return request({
        url: '/api/notice/list',
        method: 'GET'
    })
}