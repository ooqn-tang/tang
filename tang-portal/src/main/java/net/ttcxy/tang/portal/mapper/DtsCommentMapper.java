package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsComment;
import net.ttcxy.tang.portal.entity.model.DtsCommentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsCommentMapper {
    long countByExample(DtsCommentExample example);

    int deleteByExample(DtsCommentExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(DtsComment record);

    int insertSelective(DtsComment record);

    List<DtsComment> selectByExample(DtsCommentExample example);

    DtsComment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") DtsComment record, @Param("example") DtsCommentExample example);

    int updateByExample(@Param("record") DtsComment record, @Param("example") DtsCommentExample example);

    int updateByPrimaryKeySelective(DtsComment record);

    int updateByPrimaryKey(DtsComment record);
}