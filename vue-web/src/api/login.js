import request from '../utils/request'

export function login(data) {
    return request({
        url: '/api/authenticate',
        method: 'post',
        data:data
    })
}

export function sendMailVerify(mail) {
    return request({
        url: '/api/mail-verify',
        method: 'post',
        params:{mail:mail}
    })
}

export function register(data) {
    return request({
        url: '/api/register',
        method: 'post',
        data:data
    })
}

