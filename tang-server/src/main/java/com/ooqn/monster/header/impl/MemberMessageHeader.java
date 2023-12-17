package com.ooqn.monster.header.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.monster.RequestMessage;
import com.ooqn.monster.ResponseMessage;
import com.ooqn.monster.header.MessageHeader;

@Service("2001")
public class MemberMessageHeader implements MessageHeader {

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {
        ResponseMessage responseMessage = requestMessage.getResponseMessage();
        String text = requestMessage.getParam("text");
        responseMessage.setItem("text", "收到了你的消息：" + text);
        return responseMessage;
    }
    
}
