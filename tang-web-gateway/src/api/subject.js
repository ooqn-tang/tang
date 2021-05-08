import request from '../utils/request'

// 获取专题列表
export function selectSubjectListByUsername(username) {
    return request({
        url: '/subject/username',
        method: 'GET',
        params:{"username":username}
    })
}
