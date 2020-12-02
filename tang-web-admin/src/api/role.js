import request from '@/utils/request'

export function roleList() {
  return request({
    url: '/role/list',
    method: 'post'
  })
}

export function insertRolePost(data) {
  return request({
    url: '/role/insert',
    method: 'post',
    data: data
  })
}

export function updateRolePost(data) {
  return request({
    url: '/role/update',
    method: 'post',
    data: data
  })
}

export function deleteRolePost(id) {
  return request({
    url: '/role/delete/' + id,
    method: 'post'
  })
}

