package net.ttcxy.tang.api;

import org.springframework.http.HttpEntity;
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
public class ResponseResult<T> extends HttpEntity<T> {

    private ResponseResult() {
        super();
    }

    private ResponseResult(T body) {
        super(body);
    }

    private ResponseResult(MultiValueMap<String, String> headers) {
        super(headers);
    }

    private ResponseResult(T body, MultiValueMap<String, String> headers) {
        super(body, headers);
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
        return new ResponseResult<>(map);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseResult<?> failed() {
        return failed("执行失败");
    }

    /**
     * 失败返回结果
     * @param data 错误码
     */
    public static <T> ResponseResult<?> failed(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map);
    }


    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseResult<?> validateFailed(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseResult<?> unauthorized(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseResult<?> forbidden(T data) {
        Map<String,T> map = new HashMap<>();
        map.put("data",data);
        return new ResponseResult<>(map);
    }

}
