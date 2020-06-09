package net.ttcxy.service.impl;

import net.ttcxy.entity.CommentDto;
import net.ttcxy.model.BlogComment;
import net.ttcxy.model.BlogCommentExample;
import net.ttcxy.service.AuthDetailsService;
import net.ttcxy.dao.CommentDao;
import net.ttcxy.mapper.BlogCommentMapper;
import net.ttcxy.service.CommentService;
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

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Autowired
    private AuthDetailsService authDetailsServiceImpl;

    @Override
    public int insertComment(BlogComment blogComment) {
        return blogCommentMapper.insertSelective(blogComment);
    }



    @Override
    public int deleteComment(String commentId) {

        String userId = authDetailsServiceImpl.getUserId();

        BlogCommentExample blogCommentExample = new BlogCommentExample();
        blogCommentExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andIdEqualTo(commentId);

        return blogCommentMapper.deleteByExample(blogCommentExample);
    }

    @Override
    public List<CommentDto> selectComment(String blogId) {
        return commentDao.selectComment(blogId);
    }
}
