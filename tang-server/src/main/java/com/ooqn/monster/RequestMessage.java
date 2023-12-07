package com.ooqn.monster;

import java.util.Map;

public class RequestMessage {

    private String messageId;

    private String code;

    private Map<String,String> params;

    public ResponseMessage getResponseMessage(){
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageId(messageId);
        return responseMessage;
    }

    public String getParam(String key){
        return params.get(key);
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    
}
