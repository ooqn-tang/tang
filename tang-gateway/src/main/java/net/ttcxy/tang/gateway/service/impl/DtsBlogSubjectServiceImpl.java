package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.dao.DtsBlogSubjectDao;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogMapper;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogSubjectMapper;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogSubjectRelationMapper;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.DtsBlogSubject;
import net.ttcxy.tang.gateway.entity.model.DtsBlogSubjectRelation;
import net.ttcxy.tang.gateway.service.DtsBlogSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsBlogSubjectServiceImpl implements DtsBlogSubjectService {

    @Autowired
    private DtsBlogSubjectDao blogSubjectDao;

    @Autowired
    private DtsBlogSubjectRelationMapper blogSubjectRelationMapper;

    @Autowired
    private DtsBlogSubjectMapper blogSubjectMapper;

    @Autowired
    private DtsBlogMapper blogMapper;

    @Override
    public DtsBlogSubjectDto selectSubjectBlogListById(String subjectId) {
        return blogSubjectDao.selectSubjectBlogListById(subjectId);
    }

    @Override
    public PageInfo<DtsBlogSubjectDto> selectSubjectList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogSubjectDao.selectSubjectList());
    }

    @Override
    public PageInfo<DtsBlogSubjectDto> selectSubjectListByUsername(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogSubjectDao.selectSubjectListByUsername(username));
    }

    @Override
    public Integer insertSubject(DtsBlogSubject subject) {
        subject.setBlogSubjectId(IdUtil.fastSimpleUUID());
        DateTime date = DateUtil.date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        return blogSubjectMapper.insertSelective(subject);
    }

    @Override
    public Integer updateSubject(DtsBlogSubject subject) {
        subject.setUpdateDate(DateUtil.date());
        return blogSubjectMapper.updateByPrimaryKeySelective(subject);
    }

    @Override
    public Integer insertBlogToSubject(String blogId, String subjectId) {
        DtsBlogSubject blogSubject = blogSubjectMapper.selectByPrimaryKey(subjectId);
        DtsBlog blog = blogMapper.selectByPrimaryKey(blogId);

        if (blog != null && blogSubject != null){
            if(StrUtil.equals(blog.getAuthorId(),blogSubject.getAuthorId())){
                DtsBlogSubjectRelation blogSubjectRelation = new DtsBlogSubjectRelation();
                blogSubjectRelation.setBlogSubjectRelationId(IdUtil.fastSimpleUUID());
                blogSubjectRelation.setBlogId(blogId);
                blogSubjectRelation.setBlogSubjectId(subjectId);
                blogSubjectRelation.setCreateDate(DateUtil.date());
                return blogSubjectRelationMapper.insert(blogSubjectRelation);
            }
        }
        throw new ApiException("是失败");
    }


    @Override
    public String selectSubjectIdByBlogId(String blogId) {
        return blogSubjectDao.selectSubjectIdByBlogId(blogId);
    }
}
