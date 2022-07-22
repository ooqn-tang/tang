package cn.ttcxy.service;

import cn.hutool.core.util.StrUtil;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.model.DtsComment;
import cn.ttcxy.mapper.DtsCommentMapper;
import cn.ttcxy.mapper.dao.DtsCommentDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsCommentService {

    @Autowired
    private DtsCommentMapper commentMapper;

    @Autowired
    private DtsCommentDao commentDao;

    @Autowired
    private DtsVideoService videoService;

    @Autowired
    private DtsMessageService messageService;

    public int insert(DtsComment comment) {
        String dataId = comment.getDataId();
        DtsVideoDto dtsVideoDto = videoService.selectById(dataId);
        String url = comment.getType()+"/"+dataId+"?commentId="+comment.getCommentId();
        String parentCommentId = comment.getParentCommentId();
        String title = "";
        String beAuthorId = "";
        if (StrUtil.isNotBlank(parentCommentId)){
            List<DtsCommentDto> select = commentDao.selectLower(parentCommentId);
            if (select.size() > 0){
                title = " 回复了你的评论 " + select.get(0).getText();
                beAuthorId = select.get(0).getAuthorId();
            }
        }else{
            title = " 评论了你的作品 "+dtsVideoDto.getTitle();
            beAuthorId = dtsVideoDto.getAuthorId();
        }
        messageService.insertMessage(dataId,title,comment.getText(),url,comment.getAuthorId(),beAuthorId,"one");
        return commentMapper.insertSelective(comment);
    }

    public int delete(String commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    public PageInfo<DtsCommentDto> select(String dataId, Integer page) {
        PageHelper.startPage(page, 30);
        List<DtsCommentDto> commentDtoList = commentDao.select(dataId);
        return new PageInfo<>(commentDtoList);
    }

    public PageInfo<DtsCommentDto> selectLower(String commentId, Integer page) {
        PageHelper.startPage(page, 30);
        List<DtsCommentDto> commentDtoList = commentDao.selectLower(commentId);
        return new PageInfo<>(commentDtoList);
    }

    public PageInfo<DtsCommentDto> selectAll(String state ,Integer page) {
        PageHelper.startPage(page, 15);
        List<DtsCommentDto> commentDtoList = commentDao.selectAll(state);
        return new PageInfo<>(commentDtoList);
    }

    public Integer updateState(String commentId,Integer state){
        DtsComment comment = new DtsComment();
        comment.setCommentId(commentId);
        comment.setState(state);
        return commentMapper.updateByPrimaryKeySelective(comment);
    }
}
