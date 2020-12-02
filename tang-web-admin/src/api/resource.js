import request from '@/utils/request'

export function resourceList() {
  return request({
    url: '/resource/list',
    method: 'post'
  })
}

export function insertResourcePost(data) {
  return request({
    url: '/resource/insert',
    method: 'post',
    data: data
  })
}
export function updateResourcePost(data) {
  return request({
    url: '/resource/update',
    method: 'post',
    data: data
  })
}
export function deleteResourcePost(id) {
  return request({
    url: '/resource/delete/' + id,
    method: 'post'
  })
}
