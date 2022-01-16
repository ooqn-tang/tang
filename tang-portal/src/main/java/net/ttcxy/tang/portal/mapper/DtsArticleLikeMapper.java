package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsArticleLike;
import net.ttcxy.tang.portal.entity.model.DtsArticleLikeExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleLikeMapper {
    long countByExample(DtsArticleLikeExample example);

    int deleteByExample(DtsArticleLikeExample example);

    int deleteByPrimaryKey(String likeArticleId);

    int insert(DtsArticleLike record);

    int insertSelective(DtsArticleLike record);

    List<DtsArticleLike> selectByExample(DtsArticleLikeExample example);

    DtsArticleLike selectByPrimaryKey(String likeArticleId);

    int updateByExampleSelective(@Param("record") DtsArticleLike record, @Param("example") DtsArticleLikeExample example);

    int updateByExample(@Param("record") DtsArticleLike record, @Param("example") DtsArticleLikeExample example);

    int updateByPrimaryKeySelective(DtsArticleLike record);

    int updateByPrimaryKey(DtsArticleLike record);
}