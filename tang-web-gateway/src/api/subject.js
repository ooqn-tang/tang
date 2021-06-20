import request from '../utils/request'

// 获取专题列表
export function selectSubjectListByUsername(username) {
    return request({
        url: '/api/subject/username',
        method: 'GET',
        params:{"username":username}
    })
}

// 添加博客到专辑
export function insertBlogToSubject(blogId,subjectId) {
    return request({
        url: '/api/subject/blog',
        method: 'POST',
        params:{"blogId":blogId,"subjectId":subjectId}
    })
}

// 更新博客到专辑
export function updateBlogToSubject(blogId,subjectId) {
    return request({
        url: '/api/subject/blog',
        method: 'PUT',
        params:{"blogId":blogId,"subjectId":subjectId}
    })
}

// 博客ID查询专辑列表
export function selectSubjectBlogList(blogId) {
    return request({
        url: '/api/subject/blog',
        method: 'GET',
        params:{"blogId":blogId}
    })
}

// 添加专辑
export function insertSubject(data) {
    return request({
        url: '/api/subject',
        method: 'POST',
        data
    })
}

// 更新专辑
export function updateSubject(data) {
    return request({
        url: '/api/subject',
        method: 'PUT',
        data
    })
}

export function loadSubjectById(id){
    return request({
        url: '/api/subject/subjectId',
        method: 'GET',
        params: {
            "subjectId":id
        }
    })
}