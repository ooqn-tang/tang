package net.ttcxy.tang.portal.core.exception;

/**
 * 封装API的错误码
 * @author huanglei
 */
public interface IErrorCode {
    /**
     * 错误码
     * @return 错误码数值
     */
    int getCode();

    /**
     * 消息
     * @return 错误消息
     */
    String getMessage();

}
