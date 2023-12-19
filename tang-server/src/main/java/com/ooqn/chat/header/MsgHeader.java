package com.ooqn.chat.header;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.WebSocketSession;

import com.ooqn.chat.RequestMessage;
import com.ooqn.chat.ResponseMessage;

public interface MsgHeader {
    
    public static final Map<String, List<WebSocketSession>> nameMap = new ConcurrentHashMap<>();

    ResponseMessage run(WebSocketSession session,RequestMessage requestMessage);
}
