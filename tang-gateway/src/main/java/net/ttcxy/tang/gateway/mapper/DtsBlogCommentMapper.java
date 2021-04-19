package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.DtsBlogComment;
import net.ttcxy.tang.gateway.model.DtsBlogCommentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogCommentMapper {
    long countByExample(DtsBlogCommentExample example);

    int deleteByExample(DtsBlogCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(DtsBlogComment record);

    int insertSelective(DtsBlogComment record);

    List<DtsBlogComment> selectByExample(DtsBlogCommentExample example);

    DtsBlogComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DtsBlogComment record, @Param("example") DtsBlogCommentExample example);

    int updateByExample(@Param("record") DtsBlogComment record, @Param("example") DtsBlogCommentExample example);

    int updateByPrimaryKeySelective(DtsBlogComment record);

    int updateByPrimaryKey(DtsBlogComment record);
}