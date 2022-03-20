package cn.ttcxy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.model.DtsComment;
import cn.ttcxy.mapper.DtsCommentMapper;
import cn.ttcxy.mapper.dao.DtsCommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsCommentService {

    @Autowired
    private DtsCommentMapper commentMapper;

    @Autowired
    private DtsCommentDao commentDao;

    public int insert(DtsComment comment) {
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
