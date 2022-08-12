package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsCommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论
 */
public interface DtsCommentDao {

    List<DtsCommentDto> select(String dataId);

    List<DtsCommentDto> selectLower(String commentId);

    List<DtsCommentDto> selectAll(String state);

}
