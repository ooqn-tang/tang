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

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@Service("SendMessage")
public class SendMessageHeader implements MsgHeader {

    @Autowired
    private CtsMessageRepository messageRepository;

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {
        ResponseMessage responseMessage = requestMessage.getResponseMessage();
        String content = requestMessage.getParam("content");
        String acceptName = requestMessage.getParam("username");
        JSONObject object = (JSONObject) session.getAttributes().get("author");
        String sendName = object.getStr("username");

        CtsMessage message = new CtsMessage();
        message.setId(IdUtil.objectId());
        message.setAcceptName(acceptName);
        message.setSendName(sendName);
        message.setContent(content);
        message.setCreateTime(DateUtil.date());
        message.setUpdateTime(DateUtil.date());
        messageRepository.save(message);

        List<WebSocketSession> list = nameMap.get(acceptName);
        if (list != null) {
            Iterator<WebSocketSession> iterator = list.iterator();
            while (iterator.hasNext()) {
                WebSocketSession next = iterator.next();
                if (next.isOpen()) {
                    try {
                        ResponseMessage responseMessage2 = new ResponseMessage();
                        responseMessage2.setItem("code", "Message");
                        responseMessage2.setItem("data", message);
                        next.sendMessage(new TextMessage(JSONUtil.toJsonStr(responseMessage2)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        

        responseMessage.setItem("text", "收到了你的消息：" + content);
        return responseMessage;
    }
    
}
