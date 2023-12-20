import request from "@common/request";

export function articleSubjectArticleListApi(articleId) {
    return request({
        url: `/api/subject/article/${articleId}`,
        method: 'GET'
    })
}