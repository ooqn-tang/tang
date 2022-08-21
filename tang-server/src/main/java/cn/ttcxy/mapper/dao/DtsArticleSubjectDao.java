package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;

/**
 * 文章专辑
 */
public interface DtsArticleSubjectDao {

    DtsArticleSubjectDto selectSubjectById(String subjectId);

    List<DtsArticleSubjectDto> selectSubjectList();

    List<DtsArticleSubjectDto> selectSubjectListByUsername( String username);

    List<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name);

}
