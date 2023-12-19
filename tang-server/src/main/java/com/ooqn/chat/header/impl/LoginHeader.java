package com.ooqn.chat.header.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.chat.RequestMessage;
import com.ooqn.chat.ResponseMessage;
import com.ooqn.chat.header.MsgHeader;
import com.ooqn.core.security.JwtProvider;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.service.UtsUserDetailsService;

import cn.hutool.json.JSONObject;

@Service("Login")
public class LoginHeader implements MsgHeader {

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
        responseMessage.setMessage("登录成功");
        responseMessage.setStatus("200");

        List<WebSocketSession> list = nameMap.get(author.getUsername());
        if (list == null) {
            list = new ArrayList<>();
            nameMap.put(username, list);
        }
        list.add(session);
        
        return responseMessage;

    }

}
