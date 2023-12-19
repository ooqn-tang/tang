package com.ooqn.chat.header.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.chat.RequestMessage;
import com.ooqn.chat.ResponseMessage;
import com.ooqn.chat.header.MsgHeader;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.service.UtsAuthorService;


@Service("WatchList")
public class WatchListHeader implements MsgHeader{

    @Autowired
    private UtsAuthorService authorService;

    @Override
    public ResponseMessage run(WebSocketSession session, RequestMessage requestMessage) {
        Pageable pageable = PageRequest.of(0, 15);
        Page<UtsAuthor> selectAuthor = authorService.selectAuthor(pageable);
        ResponseMessage responseMessage = requestMessage.getResponseMessage();
        responseMessage.setItem("data", selectAuthor.getContent());
        return responseMessage;
    }
    
}
