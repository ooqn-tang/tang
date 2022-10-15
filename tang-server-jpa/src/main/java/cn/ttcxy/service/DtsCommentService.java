package cn.ttcxy.service;

import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.model.DtsComment;
import cn.ttcxy.mapper.dsl.DtsCommentDsl;
import cn.ttcxy.mapper.repository.DtsCommentRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsCommentService {

    @Autowired
    private DtsCommentRepository commentRepository;

    @Autowired
    private DtsCommentDsl commentDsl;

    public DtsComment insert(DtsComment comment) {
        return commentRepository.save(comment);
    }

    public void delete(String commentId) {
        commentRepository.deleteById(commentId);
    }

    public PageInfo<DtsCommentDto> select(String dataId, Integer page) {
        PageHelper.startPage(page, 30);
        List<DtsCommentDto> commentDtoList = commentDsl.select(dataId);
        return new PageInfo<>(commentDtoList);
    }

    public PageInfo<DtsCommentDto> selectLower(String commentId, Integer page) {
        PageHelper.startPage(page, 30);
        List<DtsCommentDto> commentDtoList = commentDsl.selectLower(commentId);
        return new PageInfo<>(commentDtoList);
    }

    public PageInfo<DtsCommentDto> selectAll(String state ,Integer page) {
        PageHelper.startPage(page, 15);
        List<DtsCommentDto> commentDtoList = commentDsl.selectAll(Integer.valueOf(state));
        return new PageInfo<>(commentDtoList);
    }

    public DtsComment updateState(String commentId,Integer state){
        DtsComment comment = new DtsComment();
        comment.setCommentId(commentId);
        comment.setState(state);
        return commentRepository.save(comment);
    }
}
