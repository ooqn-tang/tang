package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsArticleContentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleContentMapper {
    long countByExample(DtsArticleContentExample example);

    int deleteByExample(DtsArticleContentExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(DtsArticleContent record);

    int insertSelective(DtsArticleContent record);

    List<DtsArticleContent> selectByExampleWithBLOBs(DtsArticleContentExample example);

    List<DtsArticleContent> selectByExample(DtsArticleContentExample example);

    DtsArticleContent selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") DtsArticleContent record, @Param("example") DtsArticleContentExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsArticleContent record, @Param("example") DtsArticleContentExample example);

    int updateByExample(@Param("record") DtsArticleContent record, @Param("example") DtsArticleContentExample example);

    int updateByPrimaryKeySelective(DtsArticleContent record);

    int updateByPrimaryKeyWithBLOBs(DtsArticleContent record);
}