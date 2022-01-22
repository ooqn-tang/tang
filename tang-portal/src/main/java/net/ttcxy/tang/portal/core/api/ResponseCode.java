package net.ttcxy.tang.portal.core.api;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResponseCode {
    /**
     * 执行成功
     */
    SUCCESS(200, "执行成功"),
    /**
     * 服务器异常
     */
    FAILED(500, "执行失败"),
    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 没有相关权限
     */
    FORBIDDEN(403, "没有相关权限"),
    /**
     * 请刷新JWT
     */
    REFRESH(666, "请刷新JWT");
    private final int status;
    private final String message;

    ResponseCode(int status, String message) {

        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
