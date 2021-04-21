package net.ttcxy.tang.gateway.core.verify;

import cn.hutool.json.JSONObject;
import net.ttcxy.tang.gateway.core.exception.IErrorCode;

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
    public long getCode() {
        return 410L;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
