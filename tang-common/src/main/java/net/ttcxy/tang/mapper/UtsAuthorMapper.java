package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsAuthorExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorMapper {
    long countByExample(UtsAuthorExample example);

    int deleteByExample(UtsAuthorExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsAuthor record);

    int insertSelective(UtsAuthor record);

    List<UtsAuthor> selectByExample(UtsAuthorExample example);

    UtsAuthor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsAuthor record, @Param("example") UtsAuthorExample example);

    int updateByExample(@Param("record") UtsAuthor record, @Param("example") UtsAuthorExample example);

    int updateByPrimaryKeySelective(UtsAuthor record);

    int updateByPrimaryKey(UtsAuthor record);
}