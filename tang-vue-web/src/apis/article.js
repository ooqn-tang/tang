import request from "@utils/request";

export function deleteArticleApi(articleId) {
    return request({
        url: `/api/admin/article/${articleId}`,
        method: "DELETE",
    })
}

export function loadArticleApi() {
    return request({
        url: `/api/admin/article`,
        method: "GET",
    })
}