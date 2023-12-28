import request from '@common/request';

export function insertArticleApi(data) {
    return request({
        url: `/api/article`,
        method: "POST",
        data: data
    });
}