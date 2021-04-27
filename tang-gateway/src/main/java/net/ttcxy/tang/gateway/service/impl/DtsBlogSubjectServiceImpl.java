package net.ttcxy.tang.gateway.service.impl;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.DtsBlogSubjectDao;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogSubjectMapper;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.gateway.service.DtsBlogSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsBlogSubjectServiceImpl implements DtsBlogSubjectService {

    @Autowired
    private DtsBlogSubjectDao blogSubjectDao;

    @Autowired
    private DtsBlogSubjectMapper blogSubjectMapper;

    @Override
    public DtsBlogSubjectDto selectSubjectInfo(String subjectId) {

        return null;
    }

    @Override
    public DtsBlogSubjectDto selectSubjectAllInfo(String subjectId) {
        return null;
    }

    @Override
    public PageInfo<DtsBlogSubjectDto> selectSubjectList(Integer page, Integer size, String name) {
        return null;
    }

    @Override
    public Integer insertSubject(DtsBlogSubjectDto subjectDto) {
        return null;
    }

    @Override
    public Integer deleteSubject(String subjectId) {
        return null;
    }

    @Override
    public Integer updateSubject(DtsBlogSubjectDto subjectDto) {
        return blogSubjectMapper.updateByPrimaryKey(subjectDto);
    }
}
