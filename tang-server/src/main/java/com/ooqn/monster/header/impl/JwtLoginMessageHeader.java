package com.ooqn.monster.header.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.core.propertie.JwtProperties;
import com.ooqn.core.security.JwtProvider;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.monster.RequestMessage;
import com.ooqn.monster.ResponseMessage;
import com.ooqn.monster.header.MessageHeader;
import com.ooqn.service.UtsUserDetailsService;

import cn.hutool.json.JSONObject;

@Service("9000")
public class JwtLoginMessageHeader implements MessageHeader {

    @Autowired
    private UtsUserDetailsService userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {
        String jwt = requestMessage.getParam("jwt");
        jwtProvider.validateJwt(jwt);
        String username = jwtProvider.getAuthentication(jwt);
        UtsAuthor author = userDetailsService.loadUserByUsername(username);
        JSONObject authorObject = new JSONObject();
        authorObject.set("username", author.getUsername());
        authorObject.set("signature", author.getSignature());
        authorObject.set("nickname", author.getNickname());

        Map<String, Object> attributes = session.getAttributes();
        attributes.put("author", authorObject);

        ResponseMessage responseMessage = requestMessage.getResponseMessage();
        responseMessage.setBody("登录成功");
        responseMessage.setStatus("200");
        
        return responseMessage;

    }

}
