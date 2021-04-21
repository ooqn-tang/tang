package net.ttcxy.tang.gateway.core.api;

/**
 * 枚举了一些常用API操作码
 * @author huanglei
 */
public enum ResultCode {
    /**
     *
     */
    SUCCESS(200, "操作成功"),
    /**
     *
     */
    FAILED(500, "操作失败"),
    /**
     *
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     *
     */
    UNAUTHORIZED(401, "未登陆"),
    /**
     *
     */
    FORBIDDEN(403, "没有相关权限");

    private long code;

    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
