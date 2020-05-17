package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.CommentDto;
import net.ttcxy.tangtang.dao.CommentDao;
import net.ttcxy.tangtang.mapper.BlogCommentMapper;
import net.ttcxy.tangtang.model.Blog;
import net.ttcxy.tangtang.model.BlogComment;
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

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Autowired
    private AuthDetailsImpl authDetailsImpl;

    @Override
    public int insertComment(BlogComment blogComment) {
        return blogCommentMapper.insertSelective(blogComment);
    }



    @Override
    public int deleteComment(String commentId) {

        String userId = authDetailsImpl.getUserId();

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
