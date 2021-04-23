package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.DtsCommentDao;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogCommentDto;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogCommentMapper;
import net.ttcxy.tang.gateway.entity.model.DtsBlogComment;
import net.ttcxy.tang.gateway.entity.model.DtsBlogCommentExample;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsCommentService;
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
        String commentId = IdUtil.fastSimpleUUID();
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
