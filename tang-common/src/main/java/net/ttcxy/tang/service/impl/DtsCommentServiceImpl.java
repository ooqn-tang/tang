package net.ttcxy.tang.service.impl;

import net.ttcxy.tang.db.dao.DtsCommentDao;
import net.ttcxy.tang.entity.dto.DtsCommentDto;
import net.ttcxy.tang.service.CurrentAuthorService;
import net.ttcxy.tang.service.DtsCommentService;
import net.ttcxy.tang.db.mapper.DtsBlogCommentMapper;
import net.ttcxy.tang.entity.model.DtsBlogComment;
import net.ttcxy.tang.entity.model.DtsBlogCommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论服务
 * @author huanglei
 */
@Service
public class DtsCommentServiceImpl implements DtsCommentService {

    @Autowired
    private DtsCommentDao dtsCommentDao;

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
    public List<DtsCommentDto> selectComments(String blogId) {
        return dtsCommentDao.selectComments(blogId);
    }

    @Override
    public DtsCommentDto selectComment(String commentId) {
        return dtsCommentDao.selectComment(commentId);
    }
}
