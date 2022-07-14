package cn.ttcxy.service;

import cn.ttcxy.entity.dto.DtsMessageDto;
import cn.ttcxy.entity.model.DtsMessage;
import cn.ttcxy.mapper.dao.DtsMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
