package net.ttcxy.tangtang.mapper;

import java.util.List;
import net.ttcxy.tangtang.model.BlogComment;
import net.ttcxy.tangtang.model.BlogCommentExample;
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