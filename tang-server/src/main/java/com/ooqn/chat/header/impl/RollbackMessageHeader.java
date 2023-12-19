package com.ooqn.chat.header.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.chat.RequestMessage;
import com.ooqn.chat.ResponseMessage;
import com.ooqn.chat.header.MsgHeader;

@Service("RollbackMessage")
public class RollbackMessageHeader implements MsgHeader{

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {
        return requestMessage.getResponseMessage();
    }
    
}
