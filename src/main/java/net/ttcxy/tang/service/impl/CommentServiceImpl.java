package net.ttcxy.tang.service.impl;

import net.ttcxy.tang.db.dao.CommentDao;
import net.ttcxy.tang.entity.dto.CommentDto;
import net.ttcxy.tang.entity.model.BlogComment;
import net.ttcxy.tang.entity.model.BlogCommentExample;
import net.ttcxy.tang.service.AuthDetailsService;
import net.ttcxy.tang.db.mapper.BlogCommentMapper;
import net.ttcxy.tang.service.CommentService;
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
