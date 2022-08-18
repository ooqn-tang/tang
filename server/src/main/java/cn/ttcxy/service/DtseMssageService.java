package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ttcxy.entity.dto.DtsMessageDto;
import cn.ttcxy.mapper.dao.DtsMessageDao;

/**
 * 用户的动态包括关注的作者，自己的内容等
 */
@Service
public class DtseMssageService {

    @Autowired
    private DtsMessageDao messageDao;

    public List<DtsMessageDto> authorMessageList(String authorId) {
        return messageDao.selectAuthorMessage(authorId);
    }
}
