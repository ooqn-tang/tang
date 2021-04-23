package net.ttcxy.tang.gateway.dao.mapper;

import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.entity.model.UtsAuthorExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorMapper {
    long countByExample(UtsAuthorExample example);

    int deleteByExample(UtsAuthorExample example);

    int deleteByPrimaryKey(String authorId);

    int insert(UtsAuthor record);

    int insertSelective(UtsAuthor record);

    UtsAuthor selectByPrimaryKey(String authorId);

    int updateByExampleSelective(@Param("record") UtsAuthor record, @Param("example") UtsAuthorExample example);

    int updateByExample(@Param("record") UtsAuthor record, @Param("example") UtsAuthorExample example);

    int updateByPrimaryKeySelective(UtsAuthor record);

    int updateByPrimaryKey(UtsAuthor record);
}