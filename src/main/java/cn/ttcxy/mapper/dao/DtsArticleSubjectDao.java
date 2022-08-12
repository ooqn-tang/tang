package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章专辑
 */
public interface DtsArticleSubjectDao {

    DtsArticleSubjectDto selectSubjectById(String subjectId);

    List<DtsArticle> selectSubjectArticleListById(String subjectId);

    List<DtsArticleSubjectDto> selectSubjectList();

    List<DtsArticleSubjectDto> selectSubjectListByUsername( String username);

    List<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name);

    String selectSubjectIdByArticleId(String articleId);

}
