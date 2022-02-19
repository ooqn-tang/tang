package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsCommentDao {
    List<DtsCommentDto> select(@Param("dataId") String dataId);

    List<DtsCommentDto> selectLower(@Param("commentId") String commentId);
}
