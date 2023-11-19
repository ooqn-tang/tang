import request from "@utils/request";

export function getRoles() {
    request({
        url: `/api/admin/role`,
        method: "GET"
    });
}