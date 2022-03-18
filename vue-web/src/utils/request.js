import axios from 'axios'
import {refresh} from 'src/api/test'
import {setToken} from 'src/utils/token'

axios.defaults.withCredentials = true;

// 是否正在刷新的标记
let isRefreshing = false
//重试队列
let requests = []

const service = axios.create({
    baseURL: import.meta.env.VITE_BASE_API,
    timeout: 30000
});

//请求前拦截
service.interceptors.request.use(
    config => {
        if('/api/authenticate' == config.url){
            return config;
        }
        config.headers.Authorization = localStorage.getItem("jwt")
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

//请求后拦截
service.interceptors.response.use(
    response => {
        return response;
    },
    error => {
        if (error.response.status === 401) {
            location.href = '/login'
            return Promise.reject(error);
        }
        if (error.response.status === 403) {
            alert("无权限")
            return Promise.reject(error);
        }
        if (error.response.status === 404) {
            alert("资源不存在")
            return Promise.reject(error);
        }
        if (error.response.status === 500) {
            return Promise.reject(error.response);
        }
        // 重新获取新TOKEN
        if (error.response.status === 666) {
            if (!isRefreshing){
                isRefreshing = true
                //调用刷新token的接口
                return refresh({'jwt':localStorage.getItem("jwt")}).then(res => {
                    setToken(res.jwt)
                    error.response.headers.Authorization = res.jwt
                    requests.forEach((cb) => cb(res.jwt))
                    return service(error.response.config)
                }).catch(err => {
                    //跳到登录页
                    localStorage.removeItem("jwt")
                    localStorage.removeItem("authorData")
                    this.$store.state.username = ""
                    window.location.href = "/"
                    return Promise.reject(err)
                }).finally(() => {
                    isRefreshing = false
                })
            } else {
                // 返回未执行 resolve 的 Promise
                return new Promise(resolve => {
                  // 用函数形式将 resolve 存入，等待刷新后再执行
                  requests.push(jwt => {
                    error.response.headers.Authorization = jwt
                    resolve(service(error.response.config))
                  })
                })
              }
        }
        return Promise.reject(error.response);
    }
);

export default service