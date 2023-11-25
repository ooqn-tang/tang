import request from "@common/request";

export function updateAuthorApi(data) {
  return request({
    url: `/api/admin/author`,
    method: "PUT",
    data: data,
  })
}

export function loadRoleByAuthorIdApi(authorId) {
  return request({
    url: `api/admin/role/author/${authorId}`,
    method: "get"
  })
}

export function loadAuthorApi(params) {
  return request({
    url: `/api/admin/author`,
    method: "GET",
    params: params
  })
}