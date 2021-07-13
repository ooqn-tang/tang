package net.ttcxy.tang.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.entity.model.DtsBlogSubject;

public interface DtsBlogSubjectService {

    /**
     * 通过ID查询当前专题，以及博客列表
     * @param subjectId 专题ID
     * @return 当前专题的博客列表
     */
    DtsBlogSubjectDto selectSubjectBlogListById(String subjectId);

    PageInfo<DtsBlogSubjectDto> selectSubjectList(Integer page, Integer pageSize);

    Integer insertSubject(DtsBlogSubject subjectDto);

    Integer updateSubject(DtsBlogSubject subject);

    Integer insertBlogToSubject(String blogId, String subjectId);

    Integer updateBlogToSubject(String blogId, String subjectId);

    PageInfo<DtsBlogSubjectDto> selectSubjectListByUsername(String name, Integer page, Integer pageSize);

    String selectSubjectIdByBlogId(String blogId);

    /**
     * 通过专辑名查询
     */
    PageInfo<DtsBlogSubjectDto> selectSubjectListBySubjectName(String name, int page, int pageSize);
}
