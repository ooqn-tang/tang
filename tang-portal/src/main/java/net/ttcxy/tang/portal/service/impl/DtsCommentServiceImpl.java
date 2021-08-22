package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.dao.DtsCommentDao;
import net.ttcxy.tang.portal.dao.mapper.DtsCommentMapper;
import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import net.ttcxy.tang.portal.entity.model.DtsComment;
import net.ttcxy.tang.portal.entity.model.DtsCommentExample;
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
    private DtsCommentMapper blogCommentMapper;

    @Override
    public int insertComment(DtsComment blogComment) {
        String commentId = IdUtil.objectId();
        blogComment.setCommentId(commentId);
        blogComment.setCreateDate(new Date());
        blogComment.setStatus(1);
        return blogCommentMapper.insertSelective(blogComment);
    }

    @Override
    public int deleteComment(String commentId,String authorId) {
        DtsCommentExample blogCommentExample = new DtsCommentExample();
        blogCommentExample.createCriteria()
                .andAuthorIdEqualTo(authorId)
                .andCommentIdEqualTo(commentId);
        return blogCommentMapper.deleteByExample(blogCommentExample);
    }

    @Override
    public PageInfo<DtsCommentDto> selectComments(String blogId, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<DtsCommentDto> commentDtoList = commentDao.selectComments(blogId);
        return new PageInfo<>(commentDtoList);
    }

    @Override
    public DtsComment selectCommentById(String commentId) {
        return blogCommentMapper.selectByPrimaryKey(commentId);
    }
}
