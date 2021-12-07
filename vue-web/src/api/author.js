import request from '../utils/request'

// 获取作者信息
export function selectAuthor(username) {
    return request({
        url: '/api/author/' + username,
        method: 'GET'
    })
}

export function authorListBlogCount(page){
    return request({
        url: '/api/author/authorListBlogCount',
        method: 'GET'
    })
}


export function updateAuthor(data) {
    return request({
        url: '/api/author',
        method: 'PUT',
        data
    })
}