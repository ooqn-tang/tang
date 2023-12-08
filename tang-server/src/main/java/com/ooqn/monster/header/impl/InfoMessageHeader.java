package com.ooqn.monster.header.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.core.security.JwtProvider;
import com.ooqn.monster.RequestMessage;
import com.ooqn.monster.ResponseMessage;
import com.ooqn.monster.header.MessageHeader;
import com.ooqn.service.UtsUserDetailsService;

@Service("1000")
public class InfoMessageHeader implements MessageHeader {

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
