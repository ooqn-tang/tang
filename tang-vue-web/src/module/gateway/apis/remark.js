import request from "@common/request";

export function insertRemarkApi(data) {
    return request({
        url: `/api/remark`,
        method: 'post',
        data: data
    })
}

export function deleteRemarkApi(dataId) {
    return request({
        url: `/api/remark/${dataId}`,
        method: 'delete'
    })
}

export function selectRemarkApi(dataId, pageNum) {
    return request({
        url: `/api/remark/${dataId}/list`,
        method: 'get',
        params: {
            pageNum: pageNum
        }
    })
}
