package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsArticleSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubject;

public interface DtsArticleSubjectService {

    /**
     * 通过ID查询当前专题，以及博客列表
     * @param subjectId 专题ID
     * @return 当前专题的博客列表
     */
    DtsArticleSubjectDto selectSubjectArticleListById(String subjectId);

    PageInfo<DtsArticleSubjectDto> selectSubjectList(Integer page, Integer pageSize);

    Integer insertSubject(DtsArticleSubject subjectDto);

    Integer updateSubject(DtsArticleSubject subject);

    Integer insertArticleToSubject(String articleId, String subjectId);

    Integer updateArticleToSubject(String articleId, String subjectId);

    PageInfo<DtsArticleSubjectDto> selectSubjectListByUsername(String name, Integer page, Integer pageSize);

    String selectSubjectIdByArticleId(String articleId);

    /**
     * 通过专辑名查询
     */
    PageInfo<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name, int page, int pageSize);

    boolean deleteArticleSubjectArticleId(String articleId);
}
