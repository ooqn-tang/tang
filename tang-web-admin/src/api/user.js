import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/admin/token',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/admin/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/admin/logout',
    method: 'get'
  })
}
