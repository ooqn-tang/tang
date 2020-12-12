package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.entity.dto.DtsCommentDto;
import net.ttcxy.tang.model.DtsBlogComment;
import net.ttcxy.tang.model.DtsBlogCommentExample;
import net.ttcxy.tang.gateway.dao.DtsCommentDao;
import net.ttcxy.tang.gateway.service.CurrentMemberService;
import net.ttcxy.tang.gateway.service.DtsCommentService;
import net.ttcxy.tang.mapper.DtsBlogCommentMapper;
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
    private CurrentMemberService currentMemberServiceImpl;

    @Override
    public int insertComment(DtsBlogComment blogComment) {
        return blogCommentMapper.insertSelective(blogComment);
    }

    @Override
    public int deleteComment(String commentId) {
        String userId = currentMemberServiceImpl.getMemberId();
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
