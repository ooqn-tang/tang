import request from '../utils/request'

export function blogList(data) {
    return request({
        url: '/api/blog/list',
        method: 'get',
        params:data
    })
}

export function loadBlogByUsername(username,data) {
    return request({
        url: '/api/blog/list/' + username,
        method: 'get',
        params:data
    })
}

export function loadBlogAllInfo(blogId) {
    return request({
        url: '/api/blog/load/all',
        method: 'GET',
        params: {"blogId":blogId}
    })
}

export function postBlog(data) {
    return request({
        url: '/api/blog/load',
        method: 'GET',
        params:data
    })
}

export function createBlog() {
    return request({
        url: '/api/blog',
        method: 'POST'
    })
}

export function saveBlog(data) {
    return request({
        url: '/api/blog',
        method: 'PUT',
        data
    })
}

export function deleteBlog(blogId) {
    return request({
        url: '/api/blog/' + blogId,
        method: 'DELETE'
    })
}

export function loadSubjectList(username) {
    return request({
        url: '/api/subject/username',
        method: 'GET',
        params:{"username":username}
    })
}

export function loadTagList(data) {
    return request({
        url: '/api/tag/search',
        method: 'GET',
        params:data
    })
}

export function loadAuthorAllTagList() {
    return request({
        url: '/api/tag/allTag',
        method: 'GET'
    })
}

export function insertAuthorTag(data) {
    return request({
        url: '/api/tag/author',
        method: 'POST',
        params:data
    })
}

export function insertTag(data) {
    return request({
        url: '/api/tag',
        method: 'POST',
        data:data
    })
}

export function loadRecommend() {
    return request({
        url: '/api/blog/recommend',
        method: 'GET'
    })
}