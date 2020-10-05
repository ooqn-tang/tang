package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.dao.CommentDao;
import net.ttcxy.tang.mapper.BlogCommentMapper;
import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import net.ttcxy.tang.model.BlogComment;
import net.ttcxy.tang.model.BlogCommentExample;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.service.CommentService;
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
    public List<CommentDto> selectComments(String blogId) {
        return commentDao.selectComments(blogId);
    }

    @Override
    public CommentDto selectComment(String commentId) {
        return commentDao.selectComment(commentId);
    }
}