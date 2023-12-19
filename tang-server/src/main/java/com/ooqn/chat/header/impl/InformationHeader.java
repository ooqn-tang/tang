package com.ooqn.chat.header.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.chat.RequestMessage;
import com.ooqn.chat.ResponseMessage;
import com.ooqn.chat.header.MsgHeader;

@Service("Information")
public class InformationHeader implements MsgHeader {

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {

        Map<String, Object> attributes = session.getAttributes();
        Object author = attributes.get("author");
        
        ResponseMessage responseMessage = requestMessage.getResponseMessage();
        responseMessage.setMessage("获取信息成功!");
        responseMessage.setStatus("200");
        responseMessage.setItem("author", author);
        
        return responseMessage;

    }

}
