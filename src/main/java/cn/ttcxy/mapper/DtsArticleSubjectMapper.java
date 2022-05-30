package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.entity.model.DtsArticleSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleSubjectMapper {
    long countByExample(DtsArticleSubjectExample example);

    int deleteByExample(DtsArticleSubjectExample example);

    int deleteByPrimaryKey(String subjectId);

    int insert(DtsArticleSubject row);

    int insertSelective(DtsArticleSubject row);

    List<DtsArticleSubject> selectByExample(DtsArticleSubjectExample example);

    DtsArticleSubject selectByPrimaryKey(String subjectId);

    int updateByExampleSelective(@Param("row") DtsArticleSubject row, @Param("example") DtsArticleSubjectExample example);

    int updateByExample(@Param("row") DtsArticleSubject row, @Param("example") DtsArticleSubjectExample example);

    int updateByPrimaryKeySelective(DtsArticleSubject row);

    int updateByPrimaryKey(DtsArticleSubject row);
}