package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ttcxy.dao.dsl.DtsMessageDsl;
import cn.ttcxy.entity.dto.DtsMessageDto;

/**
 * 用户的动态包括关注的作者，自己的内容等
 */
@Service
public class DtseMssageService {

    @Autowired
    private DtsMessageDsl messageDsl;

    public List<DtsMessageDto> authorMessageList(String authorId) {
        return messageDsl.selectAuthorMessage(authorId);
    }
}
