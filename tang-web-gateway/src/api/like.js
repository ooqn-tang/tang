import request from '../utils/request'

// 获取作者信息
export function isLike(blogId) {
    return request({
        url: '/blog/like',
        method: 'GET',
        params:{"blogId":blogId}
    })
}

export function likeList(data) {
    return request({
        url: '/blog/like/list',
        method: 'GET',
        params:data
    })
}

export function like(blogId) {
    return request({
        url: '/blog/like',
        method: 'POST',
        params:{blogId:blogId}
    })
}

export function unlike(blogId) {
    return request({
        url: '/blog/like',
        method: 'DELETE',
        params:{blogId:blogId}
    })
}
