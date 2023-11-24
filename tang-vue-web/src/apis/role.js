import request from "@common/request";

export function getRoles() {
    return request({
        url: `/api/admin/role`,
        method: "GET"
    });
}