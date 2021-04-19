import axios from 'axios'

const service = axios.create({
    baseURL: 'http://localhost:80/',
    timeout: 30000
});

//请求前拦截
service.interceptors.request.use(
    config => {
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
            return Promise.reject(new Error(res.message || "Error"));
        } else {
            return res;
        }
    },
    error => {
        return Promise.reject(error);
    }
);

export default service