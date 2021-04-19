package net.ttcxy.tang.gateway.core.api;

/**
 * 封装API的错误码
 * @author huanglei
 */
public interface IErrorCode {
    /**
     * 错误码
     * @return 错误码数值
     */
     long getCode();

    /**
     * 消息
     * @return 错误消息
     */
    String getMessage();
}
