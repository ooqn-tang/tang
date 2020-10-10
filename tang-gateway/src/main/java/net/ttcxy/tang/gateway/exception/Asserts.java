package net.ttcxy.tang.gateway.exception;

import net.ttcxy.tang.gateway.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * created by huanglei on 2020/10/10
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
