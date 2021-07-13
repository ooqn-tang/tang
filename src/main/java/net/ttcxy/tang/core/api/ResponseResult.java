package net.ttcxy.tang.core.api;

/**
 * 通用返回对象
 * @author huanglei
 */
public class ResponseResult<T> {

    /**
     * 状态码
     */
    private int code;


    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    protected ResponseResult(String message,Integer code, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    protected ResponseResult(ResponseCode response, T data) {
        this(response.getMessage(),response.getCode(),data);
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResponseCode.SUCCESS, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<T>(message,ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseResult<T> failed(String message) {
        return new ResponseResult<T>(message,ResponseCode.FAILED.getCode(), null);
    }

    public static <T> ResponseResult<T> failed(ResponseCode responseCode,T data) {
        return new ResponseResult<T>(responseCode, data);
    }

    public static ResponseResult<String> success() {
        return new ResponseResult<>(ResponseCode.SUCCESS,"执行成功");
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
