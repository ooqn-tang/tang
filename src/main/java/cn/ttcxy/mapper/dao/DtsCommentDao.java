package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsCommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsCommentDao {

    List<DtsCommentDto> select(@Param("dataId") String dataId);

    List<DtsCommentDto> selectLower(@Param("commentId") String commentId);

    List<DtsCommentDto> selectAll(@Param("state") String state);

}
