import request from "@common/request";

export async function authenticateApi(data) {
    return request({
        url: `/api/authenticate`,
        method: 'post',
        data: data
    })
}

export function rolesApi() {
    return request({
        url: `/api/author/role/list`,
        method: 'get'
    })
}

export function authorApi() {
    return request({
        url: `/api/author`,
        method: 'get'
    })
}
