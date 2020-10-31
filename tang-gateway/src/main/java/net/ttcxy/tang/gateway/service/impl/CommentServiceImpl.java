package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.dao.CommentDao;
import net.ttcxy.tang.mapper.BlogCommentMapper;
import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import net.ttcxy.tang.model.BlogComment;
import net.ttcxy.tang.model.BlogCommentExample;
import net.ttcxy.tang.gateway.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论服务
 * @author huanglei
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Override
    public int insertComment(BlogComment blogComment) {
        return blogCommentMapper.insertSelective(blogComment);
    }

    @Override
    public int deleteComment(String commentId) {
        String userId = currentAuthorServiceImpl.getUserId();
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
