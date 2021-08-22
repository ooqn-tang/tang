import request from '../utils/request'

export function upload(data) {
    return request({
        url: '/api/file/upload',
        method: 'POST',
        headers:{post:{ 'Content-Type': 'multipart/form-data' }},
        data:data
    })
}