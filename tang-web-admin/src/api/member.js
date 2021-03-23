import request from '@/utils/request'

export function memberList() {
  return request({
    url: '/member/list',
    method: 'post'
  })
}
