package net.ttcxy.tang.portal.core.exception;

import cn.hutool.json.JSONObject;

public class VerifyException extends RuntimeException implements IErrorCode{

    private JSONObject data;

    public VerifyException(String message, JSONObject data) {
        super(message);
        this.data = data;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public int getCode() {
        return 410;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
