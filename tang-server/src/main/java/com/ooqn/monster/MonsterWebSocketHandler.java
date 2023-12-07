package com.ooqn.monster;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooqn.monster.header.MessageHeader;
import com.ooqn.monster.header.impl.JwtLoginMessageHeader;

import cn.hutool.json.JSONObject;

@Component
public class MonsterWebSocketHandler implements WebSocketHandler {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Map<String,MessageHeader> messageHeaderMap = new HashMap<String,MessageHeader>();

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String payload = message.getPayload().toString();
        RequestMessage requestMessage = objectMapper.readValue(payload, RequestMessage.class);
        String code = requestMessage.getCode();
        MessageHeader messageHeader = messageHeaderMap.get(code);
        
        ResponseMessage responseMessage = null;
        if (messageHeader != null) {
            responseMessage = messageHeader.run(session, requestMessage);
        }else{
            responseMessage = requestMessage.getResponseMessage();
            responseMessage.setBody("没有处理器");
            responseMessage.setStatus("500");
            System.out.println("没有处理器！");
        }
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(responseMessage)));
        System.out.println("处理消息");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("处理传输错误");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接创建成功");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
       System.out.println("连接关闭");
    }
}
