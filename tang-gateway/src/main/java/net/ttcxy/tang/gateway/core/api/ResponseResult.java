package net.ttcxy.tang.gateway.core.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

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
     */
    public static <T> ResponseResult<String> success() {
        return success("执行成功");
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(data,HttpStatus.OK);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseResult<String> failed() {
        return failed("执行失败");
    }

    /**
     * 失败返回结果
     * 500 Internal Server Error
     * @param data 错误码
     */
    public static <T> ResponseResult<T> failed(T data) {
        return new ResponseResult<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 参数验证失败返回结果
     * 404 Not Found.
     */
    public static <T> ResponseResult<T> validateFailed(T data) {
        return new ResponseResult<>(data, HttpStatus.NOT_FOUND);
    }

    /**
     * 未登录返回结果
     * 401 Unauthorized
     */
    public static <T> ResponseResult<T> unauthorized(T data) {
        return new ResponseResult<>(data,HttpStatus.UNAUTHORIZED);
    }

    /**
     * 未授权返回结果
     * 403 Forbidden
     */
    public static <T> ResponseResult<T> forbidden(T data) {
        return new ResponseResult<>(data,HttpStatus.FORBIDDEN);
    }


    public static void main(String[] args) {
    }
}
