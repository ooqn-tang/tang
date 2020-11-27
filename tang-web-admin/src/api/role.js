import request from '@/utils/request'

export function roleList() {
  return request({
    url: '/role/list',
    method: 'post'
  })
}
