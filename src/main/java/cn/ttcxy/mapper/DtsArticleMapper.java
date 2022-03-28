package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleMapper {
    long countByExample(DtsArticleExample example);

    int deleteByExample(DtsArticleExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(DtsArticle row);

    int insertSelective(DtsArticle row);

    List<DtsArticle> selectByExample(DtsArticleExample example);

    DtsArticle selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("row") DtsArticle row, @Param("example") DtsArticleExample example);

    int updateByExample(@Param("row") DtsArticle row, @Param("example") DtsArticleExample example);

    int updateByPrimaryKeySelective(DtsArticle row);

    int updateByPrimaryKey(DtsArticle row);
}