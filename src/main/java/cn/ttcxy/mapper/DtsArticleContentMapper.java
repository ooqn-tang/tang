package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsArticleContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleContentMapper {
    long countByExample(DtsArticleContentExample example);

    int deleteByExample(DtsArticleContentExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(DtsArticleContent row);

    int insertSelective(DtsArticleContent row);

    List<DtsArticleContent> selectByExampleWithBLOBs(DtsArticleContentExample example);

    List<DtsArticleContent> selectByExample(DtsArticleContentExample example);

    DtsArticleContent selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("row") DtsArticleContent row, @Param("example") DtsArticleContentExample example);

    int updateByExampleWithBLOBs(@Param("row") DtsArticleContent row, @Param("example") DtsArticleContentExample example);

    int updateByExample(@Param("row") DtsArticleContent row, @Param("example") DtsArticleContentExample example);

    int updateByPrimaryKeySelective(DtsArticleContent row);

    int updateByPrimaryKeyWithBLOBs(DtsArticleContent row);
}