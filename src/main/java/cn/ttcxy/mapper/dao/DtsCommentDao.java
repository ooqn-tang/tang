package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.DtsCommentDto;

/**
 * 评论
 */
public interface DtsCommentDao {

    List<DtsCommentDto> select(String dataId);

    List<DtsCommentDto> selectLower(String commentId);

    List<DtsCommentDto> selectAll(String state);

}
