package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsLikeBlog;
import net.ttcxy.tang.portal.entity.model.DtsLikeBlogExample;
import org.apache.ibatis.annotations.Param;

public interface DtsLikeBlogMapper {
    long countByExample(DtsLikeBlogExample example);

    int deleteByExample(DtsLikeBlogExample example);

    int deleteByPrimaryKey(String likeBlogId);

    int insert(DtsLikeBlog record);

    int insertSelective(DtsLikeBlog record);

    DtsLikeBlog selectByPrimaryKey(String likeBlogId);

    int updateByExampleSelective(@Param("record") DtsLikeBlog record, @Param("example") DtsLikeBlogExample example);

    int updateByExample(@Param("record") DtsLikeBlog record, @Param("example") DtsLikeBlogExample example);

    int updateByPrimaryKeySelective(DtsLikeBlog record);

    int updateByPrimaryKey(DtsLikeBlog record);
}