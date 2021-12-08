package net.ttcxy.tang.portal.dao;

import net.ttcxy.tang.portal.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsBlog;

import java.util.List;

public interface DtsBlogSubjectDao {

    DtsBlogSubjectDto selectSubjectById(String subjectId);

    List<DtsBlog> selectSubjectBlogListById(String blogSubjectId);

    List<DtsBlogSubjectDto> selectSubjectList();

    List<DtsBlogSubjectDto> selectSubjectListByUsername(String username);

    List<DtsBlogSubjectDto> selectSubjectListBySubjectName(String name);

    String selectSubjectIdByBlogId(String blogId);
}
