import request from '@/utils/request'

export function resourceList() {
  return request({
    url: '/resource/list',
    method: 'post'
  })
}
