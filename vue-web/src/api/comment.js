import request from '../utils/request'

export function insertComment(data) {
    return request({
        url: '/api/comment/insert',
        method: 'POST',
        data:data
    })
}

export function deleteComment(id) {
    return request({
        url: '/api/comment/' + id,
        method: 'DELETE'
    })
}

export function selectComment(dataId,page) {
    return request({
        url: '/api/comment',
        method: 'GET',
        params:{"dataId":dataId,"page":page}
    })
}