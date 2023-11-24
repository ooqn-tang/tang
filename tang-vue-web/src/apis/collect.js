import request from '@common/request';

export function collectListApi(params) {
    return request({
        url: `/api/collect/list`,
        method: 'GET',
        params: params
    })
}

export function insertCollectApi(data) {
    return request({
        url: `/api/collect`,
        method: "POST",
        data: data
    });
}

export function deleteCollectApi(params) {
    return request({
        url: `/api/collect`,
        method: "DELETE",
        params: params
    })
}

export function isCollectApi(params) {
    return request({
        url: `/api/collect`,
        method: "GET",
        params: params
    })
}