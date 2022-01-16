package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubject;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubjectExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleSubjectMapper {
    long countByExample(DtsArticleSubjectExample example);

    int deleteByExample(DtsArticleSubjectExample example);

    int deleteByPrimaryKey(String articleSubjectId);

    int insert(DtsArticleSubject record);

    int insertSelective(DtsArticleSubject record);

    List<DtsArticleSubject> selectByExample(DtsArticleSubjectExample example);

    DtsArticleSubject selectByPrimaryKey(String articleSubjectId);

    int updateByExampleSelective(@Param("record") DtsArticleSubject record, @Param("example") DtsArticleSubjectExample example);

    int updateByExample(@Param("record") DtsArticleSubject record, @Param("example") DtsArticleSubjectExample example);

    int updateByPrimaryKeySelective(DtsArticleSubject record);

    int updateByPrimaryKey(DtsArticleSubject record);
}