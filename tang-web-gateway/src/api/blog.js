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
        method: 'GET',
        params:data
    })
}

export function insertBlog(data) {
    return request({
        url: '/blog',
        method: 'POST',
        data
    })
}

export function deleteBlog(data) {
    return request({
        url: '/blog',
        method: 'DELETE',
        params:data
    })
}

export function putBlog(data) {
    return request({
        url: '/blog',
        method: 'PUT',
        data
    })
}

export function loadSubjectList(data) {
    return request({
        url: '/subject/search',
        method: 'GET',
        params:data
    })
}

export function loadTagList(data) {
    return request({
        url: '/tag/search',
        method: 'GET',
        params:data
    })
}

export function loadAuthorAllTagList() {
    return request({
        url: '/tag/allTag',
        method: 'GET'
    })
}

export function insertAuthorTag(data) {
    return request({
        url: '/tag/author',
        method: 'POST',
        params:data
    })
}

export function insertTag(data) {
    return request({
        url: '/tag',
        method: 'POST',
        data:data
    })
}