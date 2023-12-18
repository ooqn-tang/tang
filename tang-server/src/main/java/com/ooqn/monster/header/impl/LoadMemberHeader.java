package com.ooqn.monster.header.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.monster.RequestMessage;
import com.ooqn.monster.ResponseMessage;
import com.ooqn.monster.header.MessageHeader;
import com.ooqn.service.UtsAuthorService;


@Service("1003")
public class LoadMemberHeader implements MessageHeader{

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
