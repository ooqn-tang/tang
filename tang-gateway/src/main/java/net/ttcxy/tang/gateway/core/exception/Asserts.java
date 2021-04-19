package net.ttcxy.tang.gateway.core.exception;

import net.ttcxy.tang.gateway.core.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * @author huanglei
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
