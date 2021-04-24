import request from '../utils/request'

export function blogList(data) {
    return request({
        url: '/blog/list',
        method: 'get',
        params:data
    })
}

export function postBlog(data) {
    return request({
        url: '/blog/load',
        method: 'get',
        params:data
    })
}