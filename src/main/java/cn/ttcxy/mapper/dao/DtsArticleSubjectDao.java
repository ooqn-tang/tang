package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsArticleSubjectDao {

    DtsArticleSubjectDto selectSubjectById(@Param("subjectId") String subjectId);

    List<DtsArticle> selectSubjectArticleListById(@Param("subjectId") String subjectId);

    List<DtsArticleSubjectDto> selectSubjectList();

    List<DtsArticleSubjectDto> selectSubjectListByUsername(@Param("username") String username);

    List<DtsArticleSubjectDto> selectSubjectListBySubjectName(@Param("name") String name);

    String selectSubjectIdByArticleId(@Param("articleId") String articleId);

}
