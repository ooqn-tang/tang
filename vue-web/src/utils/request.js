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
        config.headers.Authorization = 'Bearer ' + localStorage.getItem("token")
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

//请求后拦截
service.interceptors.response.use(
    response => {
        const res = response.data;
        res.code = 200
        if (res.code !== 200) {
            alert(res.message)
            return Promise.reject(new Error(res.message || "Error"));
        } else {
            return res;
        }
    },
    error => {
        if (error.response.status === 401) {
            alert("需要登录")
            return Promise.reject(error);
        }
        if (error.response.status === 404) {
            alert(error.response.data.message)
            return Promise.reject(error);
        }
        if (error.response.status === 666) {
            if (!isRefreshing){
                isRefreshing = true
                //调用刷新token的接口
                return refresh({'jwt':localStorage.getItem("token")}).then(res => {
                    setToken(res.jwt_token)
                    error.response.headers.Authorization = 'Bearer ' + res.jwt_token
                    requests.forEach((cb) => cb(res.jwt_token))
                    return service(error.response.config)
                }).catch(err => {
                    //跳到登录页
                    localStorage.removeItem("token")
                    localStorage.removeItem("author")
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
                  requests.push(token => {
                    error.response.headers.Authorization = 'Bearer ' + token
                    resolve(service(error.response.config))
                  })
                })
              }
        }

    }
);

export default service