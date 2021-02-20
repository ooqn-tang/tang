package net.ttcxy.tang.admin.service.impl;

import net.ttcxy.tang.admin.service.CurrentMemberService;
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
