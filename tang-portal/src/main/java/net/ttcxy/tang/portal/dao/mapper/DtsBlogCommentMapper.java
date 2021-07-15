package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlogComment;
import net.ttcxy.tang.portal.entity.model.DtsBlogCommentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogCommentMapper {
    long countByExample(DtsBlogCommentExample example);

    int deleteByExample(DtsBlogCommentExample example);

    int deleteByPrimaryKey(String blogCommentId);

    int insert(DtsBlogComment record);

    int insertSelective(DtsBlogComment record);

    DtsBlogComment selectByPrimaryKey(String blogCommentId);

    int updateByExampleSelective(@Param("record") DtsBlogComment record, @Param("example") DtsBlogCommentExample example);

    int updateByExample(@Param("record") DtsBlogComment record, @Param("example") DtsBlogCommentExample example);

    int updateByPrimaryKeySelective(DtsBlogComment record);

    int updateByPrimaryKey(DtsBlogComment record);
}