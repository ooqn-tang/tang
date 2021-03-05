package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.DtsVboComment;
import net.ttcxy.tang.model.DtsVboCommentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsVboCommentMapper {
    long countByExample(DtsVboCommentExample example);

    int deleteByExample(DtsVboCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(DtsVboComment record);

    int insertSelective(DtsVboComment record);

    List<DtsVboComment> selectByExample(DtsVboCommentExample example);

    DtsVboComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DtsVboComment record, @Param("example") DtsVboCommentExample example);

    int updateByExample(@Param("record") DtsVboComment record, @Param("example") DtsVboCommentExample example);

    int updateByPrimaryKeySelective(DtsVboComment record);

    int updateByPrimaryKey(DtsVboComment record);
}