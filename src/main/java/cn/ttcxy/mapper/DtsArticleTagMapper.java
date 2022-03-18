package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsArticleTag;
import cn.ttcxy.entity.model.DtsArticleTagExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleTagMapper {
    long countByExample(DtsArticleTagExample example);

    int deleteByExample(DtsArticleTagExample example);

    int deleteByPrimaryKey(String articleTagId);

    int insert(DtsArticleTag record);

    int insertSelective(DtsArticleTag record);

    List<DtsArticleTag> selectByExample(DtsArticleTagExample example);

    DtsArticleTag selectByPrimaryKey(String articleTagId);

    int updateByExampleSelective(@Param("record") DtsArticleTag record, @Param("example") DtsArticleTagExample example);

    int updateByExample(@Param("record") DtsArticleTag record, @Param("example") DtsArticleTagExample example);

    int updateByPrimaryKeySelective(DtsArticleTag record);

    int updateByPrimaryKey(DtsArticleTag record);
}