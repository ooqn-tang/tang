package com.ooqn.chat.header.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.chat.RequestMessage;
import com.ooqn.chat.ResponseMessage;
import com.ooqn.chat.header.MsgHeader;
import com.ooqn.entity.model.CtsMessage;
import com.ooqn.repository.CtsMessageRepository;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@Service("MessageList")
public class MessageListHeader implements MsgHeader {

    @Autowired
    private CtsMessageRepository messageRepository;

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {
        ResponseMessage responseMessage = requestMessage.getResponseMessage();
        JSONObject object = (JSONObject) session.getAttributes().get("author");
        String username = object.getStr("username");
        String memberName = requestMessage.getParam("memberName");
        List<CtsMessage> messageList = messageRepository.findBySendNameAndAcceptName(username, memberName);
        responseMessage.setItem("data", messageList);

        Iterator<WebSocketSession> iterator = nameMap.get(username).iterator();

        while (iterator.hasNext()) {
            WebSocketSession next = iterator.next();
            if (next.isOpen()) {
                ResponseMessage responseMessage2 = new ResponseMessage();
                responseMessage2.setItem("code", "MessageList");
                responseMessage2.setItem("data", messageList);
                String jsonStr = JSONUtil.toJsonStr(responseMessage2);
                try {
                    next.sendMessage(new TextMessage(jsonStr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                continue;
            }
            iterator.remove();
        }

        return responseMessage;
    }

}
