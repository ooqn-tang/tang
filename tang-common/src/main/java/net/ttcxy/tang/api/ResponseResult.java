package net.ttcxy.tang.api;

import cn.hutool.json.JSONUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回对象
 * @author huanglei
 */
public class ResponseResult<T> extends ResponseEntity<T> {

    private ResponseResult(HttpStatus status) {
        super(status);
    }

    private ResponseResult(T body, HttpStatus status) {
        super(body, status);
    }

    private ResponseResult(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    private ResponseResult(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    @Override
    public HttpHeaders getHeaders() {
        return super.getHeaders();
    }

    @Override
    public T getBody() {
        return super.getBody();
    }

    @Override
    public boolean hasBody() {
        return super.hasBody();
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     */
    public static <T> ResponseResult<?> success(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map,HttpStatus.OK);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseResult<?> failed() {
        return failed("执行失败");
    }

    /**
     * 失败返回结果
     * 500 Internal Server Error
     * @param data 错误码
     */
    public static <T> ResponseResult<?> failed(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 参数验证失败返回结果
     * 404 Not Found.
     */
    public static <T> ResponseResult<?> validateFailed(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map, HttpStatus.NOT_FOUND);
    }

    /**
     * 未登录返回结果
     * 401 Unauthorized
     */
    public static <T> ResponseResult<?> unauthorized(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map,HttpStatus.UNAUTHORIZED);
    }

    /**
     * 未授权返回结果
     * 403 Forbidden
     */
    public static <T> ResponseResult<?> forbidden(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map,HttpStatus.FORBIDDEN);
    }


    public static void main(String[] args) {
    }
}
