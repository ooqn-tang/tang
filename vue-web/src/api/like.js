import request from '../utils/request'

// 查看是否喜欢了当前博客
export function isLike(blogId) {
    return request({
        url: '/api/blog/like',
        method: 'GET',
        params:{"blogId":blogId}
    })
}

// 查询登录用户喜欢的博客列表
export function likeList(pageNum) {
    return request({
        url: '/api/blog/like/list',
        method: 'GET',
        params:{page:pageNum}
    })
}

export function like(blogId) {
    return request({
        url: '/api/blog/like',
        method: 'POST',
        params:{blogId:blogId}
    })
}

export function unlike(blogId) {
    return request({
        url: '/api/blog/like',
        method: 'DELETE',
        params:{blogId:blogId}
    })
}
