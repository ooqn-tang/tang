package cn.ttcxy.service;

import cn.ttcxy.entity.dto.DtsMessageDto;
import cn.ttcxy.mapper.dsl.DtsMessageDsl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
