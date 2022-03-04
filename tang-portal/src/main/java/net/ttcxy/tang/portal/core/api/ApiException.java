package net.ttcxy.tang.portal.core.api;

import org.springframework.http.HttpStatus;

/**
 * 自定义API异常
 * @author LYJ
 */
public class ApiException extends RuntimeException {

    private int status;
    private String message;

    public ApiException() {
        this.status = ResponseCode.FAILED.getStatus();
    }
    public ApiException(ResponseCode responseCode) {
        this.status = responseCode.getStatus();
        this.message = responseCode.getMessage();
    }

    public ApiException(int errorCode, String message) {
        this.status = errorCode;
        this.message = message;
    }

    public ApiException(org.springframework.http.HttpStatus status) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
    }

    public ApiException(org.springframework.http.HttpStatus status,String message) {
        this.status = status.value();
        this.message = message;
    }

    public ApiException(String message) {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
