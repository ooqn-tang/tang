package com.ooqn.chat;

import java.util.LinkedHashMap;

public class ResponseMessage extends LinkedHashMap<String,Object>{

    public ResponseMessage() {
        super();
        put("status", "200");
        put("message", "successful");
    }

    public void setMessageId(String messageId) {
        put("messageId", messageId);
    }

    public void setStatus(String status) {
        put("status", status);
    }

    public void setItem(String key,Object value){
        put(key, value);
    }

    public void setMessage(String message) {
        put("message", message);
    }

}
