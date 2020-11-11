package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.code.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.dao.CommentDao;
import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import net.ttcxy.tang.gateway.service.CommentService;
import net.ttcxy.tang.mapper.DtsBlogCommentMapper;
import net.ttcxy.tang.model.DtsBlogComment;
import net.ttcxy.tang.model.DtsBlogCommentExample;
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
    private DtsBlogCommentMapper blogCommentMapper;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Override
    public int insertComment(DtsBlogComment blogComment) {
        return blogCommentMapper.insertSelective(blogComment);
    }

    @Override
    public int deleteComment(String commentId) {
        String userId = currentAuthorServiceImpl.getAuthorId();
        DtsBlogCommentExample blogCommentExample = new DtsBlogCommentExample();
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
