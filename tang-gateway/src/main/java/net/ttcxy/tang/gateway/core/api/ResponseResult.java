package net.ttcxy.tang.gateway.core.api;

import net.ttcxy.tang.gateway.core.exception.IErrorCode;

/**
 * 通用返回对象
 * @author huanglei
 */
public class ResponseResult<T> {


    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    protected ResponseResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResponseCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<T>(message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResponseResult<T> failed(IErrorCode errorCode) {
        return new ResponseResult<T>(errorCode.getMessage(), null);
    }

    public static <T> ResponseResult<T> failed(String message,T data) {
        return new ResponseResult<T>(message, data);
    }

    public static <T> ResponseResult<T> failed(ResponseCode responseCode,T data) {
        return new ResponseResult<T>(responseCode.getMessage(), data);
    }

    public static ResponseResult<?> success() {
        return new ResponseResult<>(ResponseCode.SUCCESS.getMessage(),null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
