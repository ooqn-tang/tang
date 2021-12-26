package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsArticleSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsArticle;

import java.util.List;

public interface DtsArticleSubjectDao {

    DtsArticleSubjectDto selectSubjectById(String subjectId);

    List<DtsArticle> selectSubjectArticleListById(String articleSubjectId);

    List<DtsArticleSubjectDto> selectSubjectList();

    List<DtsArticleSubjectDto> selectSubjectListByUsername(String username);

    List<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name);

    String selectSubjectIdByArticleId(String articleId);
}
