package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.BlogComment;
import net.ttcxy.tang.entity.model.BlogCommentExample;
import org.apache.ibatis.annotations.Param;

public interface BlogCommentMapper {
    long countByExample(BlogCommentExample example);

    int deleteByExample(BlogCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    List<BlogComment> selectByExample(BlogCommentExample example);

    BlogComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByExample(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);
}