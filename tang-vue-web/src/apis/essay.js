import request from "@utils/request";

export function insertEssayApi(data){
    return request({
        url: `/api/essay`,
        method: "post",
        data: data
      });
}

export function loadEssayApi(params){
    return request({
        url: `/api/essay`,
        method: "get",
        params: params
      })
}