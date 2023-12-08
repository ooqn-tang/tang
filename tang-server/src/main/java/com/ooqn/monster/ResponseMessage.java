package com.ooqn.monster;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {

    private String messageId;

    private String status;

    private String message;

    private Map<String,Object> body = new HashMap<String,Object>();

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setItem(String key,Object value){
        body.put(key, value);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

}
