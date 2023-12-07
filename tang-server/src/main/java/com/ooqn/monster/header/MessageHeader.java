package com.ooqn.monster.header;

import org.springframework.web.socket.WebSocketSession;

import com.ooqn.monster.RequestMessage;
import com.ooqn.monster.ResponseMessage;

public interface MessageHeader {
    ResponseMessage run(WebSocketSession session,RequestMessage requestMessage);
}
