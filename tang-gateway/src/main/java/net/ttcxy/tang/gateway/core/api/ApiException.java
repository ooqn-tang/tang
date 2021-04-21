package net.ttcxy.tang.gateway.core.api;

import net.ttcxy.tang.gateway.core.exception.IErrorCode;

/**
 * 自定义API异常
 * @author huanglei
 */
public class ApiException extends RuntimeException implements IErrorCode {

    private long errorCode;

    public ApiException(long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public long getCode() {
        return errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
