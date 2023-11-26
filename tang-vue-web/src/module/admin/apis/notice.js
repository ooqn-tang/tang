import request from "@common/request";

export function insertNoticeApi(data) {
    return request({
        url: `/api/admin/notice`,
        method: "POST",
        data: data,
    });
}

export function deleteNoticeApi(noticeId) {
    return request({
        url: `/api/admin/notice/${noticeId}`,
        method: "DELETE",
    })
}

export function updateOrderApi(data) {
    return request({
        url: `/api/admin/notice/order`,
        method: "PUT",
        data: data,
    })
}