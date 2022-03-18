package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;

import java.util.List;

public interface DtsArticleSubjectDao {

    DtsArticleSubjectDto selectSubjectById(String subjectId);

    List<DtsArticle> selectSubjectArticleListById(String articleSubjectId);

    List<DtsArticleSubjectDto> selectSubjectList();

    List<DtsArticleSubjectDto> selectSubjectListByUsername(String username);

    List<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name);

    String selectSubjectIdByArticleId(String articleId);
}
