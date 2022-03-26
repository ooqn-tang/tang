package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsComment;
import cn.ttcxy.entity.model.DtsCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsCommentMapper {
    long countByExample(DtsCommentExample example);

    int deleteByExample(DtsCommentExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(DtsComment row);

    int insertSelective(DtsComment row);

    List<DtsComment> selectByExample(DtsCommentExample example);

    DtsComment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("row") DtsComment row, @Param("example") DtsCommentExample example);

    int updateByExample(@Param("row") DtsComment row, @Param("example") DtsCommentExample example);

    int updateByPrimaryKeySelective(DtsComment row);

    int updateByPrimaryKey(DtsComment row);
}