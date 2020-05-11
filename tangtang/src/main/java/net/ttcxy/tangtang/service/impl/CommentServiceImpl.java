package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.CommentDto;
import net.ttcxy.tangtang.dao.CommentDao;
import net.ttcxy.tangtang.mapper.BlogCommentMapper;
import net.ttcxy.tangtang.model.BlogCommentExample;
import net.ttcxy.tangtang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2020/4/18 0018 18:18
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean insertComment(CommentDto commentDto) {
        int code = commentDao.insertComment(commentDto);
        if (code==1){
            return true;
        }
        return false;
    }
    @Autowired
    private AuthDetailsImpl authDetailsImpl;

    private BlogCommentMapper blogCommentMapper;

    @Override
    public int deleteComment(String id) {

        BlogCommentExample blogCommentExample = new BlogCommentExample();
        blogCommentExample.createCriteria()
                .andUserIdEqualTo(authDetailsImpl.getUserId())
                .andIdEqualTo(id);

        return blogCommentMapper.deleteByExample(blogCommentExample);
    }

    @Override
    public List<CommentDto> selectComment(String blogId) {

        return commentDao.selectComment(blogId);
    }
}
