package net.ttcxy.tang.gateway.dao;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogSubjectDto;

import java.util.List;

public interface DtsBlogSubjectDao {
    DtsBlogSubjectDto selectSubjectBlogListById(String blogSubjectId);

    List<DtsBlogSubjectDto> selectSubjectList();
}
