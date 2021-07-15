package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.dao.DtsCommentDao;
import net.ttcxy.tang.portal.dao.mapper.DtsBlogCommentMapper;
import net.ttcxy.tang.portal.entity.dto.DtsBlogCommentDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogComment;
import net.ttcxy.tang.portal.entity.model.DtsBlogCommentExample;
import net.ttcxy.tang.portal.service.CurrentAuthorService;
import net.ttcxy.tang.portal.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 评论服务
 * @author huanglei
 */
@Service
public class DtsCommentServiceImpl implements DtsCommentService {

    @Autowired
    private DtsCommentDao commentDao;

    @Autowired
    private DtsBlogCommentMapper blogCommentMapper;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Override
    public int insertComment(DtsBlogComment blogComment) {
        String commentId = IdUtil.objectId();
        blogComment.setBlogCommentId(commentId);
        blogComment.setCreateDate(new Date());
        blogComment.setStatus(1);
        return blogCommentMapper.insertSelective(blogComment);
    }

    @Override
    public int deleteComment(String commentId) {
        DtsBlogCommentExample blogCommentExample = new DtsBlogCommentExample();
        blogCommentExample.createCriteria()
                .andBlogCommentIdEqualTo(commentId);
        return blogCommentMapper.deleteByExample(blogCommentExample);
    }

    @Override
    public PageInfo<DtsBlogCommentDto> selectComments(String blogId, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<DtsBlogCommentDto> commentDtoList = commentDao.selectComments(blogId);
        return new PageInfo<>(commentDtoList);
    }

    @Override
    public DtsBlogComment selectCommentById(String commentId) {
        return blogCommentMapper.selectByPrimaryKey(commentId);
    }
}
