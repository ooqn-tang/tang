package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsAuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorMapper {
    long countByExample(UtsAuthorExample example);

    int deleteByExample(UtsAuthorExample example);

    int deleteByPrimaryKey(String authorId);

    int insert(UtsAuthor row);

    int insertSelective(UtsAuthor row);

    List<UtsAuthor> selectByExample(UtsAuthorExample example);

    UtsAuthor selectByPrimaryKey(String authorId);

    int updateByExampleSelective(@Param("row") UtsAuthor row, @Param("example") UtsAuthorExample example);

    int updateByExample(@Param("row") UtsAuthor row, @Param("example") UtsAuthorExample example);

    int updateByPrimaryKeySelective(UtsAuthor row);

    int updateByPrimaryKey(UtsAuthor row);
}