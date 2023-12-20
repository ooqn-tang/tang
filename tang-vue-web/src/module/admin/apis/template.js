import request from "@common/request";

export function selectTemplateApi() {
    return request({
        url: `/api/admin/template`,
        method: "GET"
    });
}

export function insertTemplateApi(data) {
    return request({
        url: `/api/admin/template`,
        method: "post",
        data: data
    });
}

export function updateTemplateApi(data) {
    return request({
        url: `/api/admin/template`,
        method: "put",
        data: data
    });
}


export function deleteTemplateApi(id) {
    return request({
        url: `/api/admin/template/${id}`,
        method: "delete"
    });
}
