package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.dao.DtsBlogSubjectDao;
import net.ttcxy.tang.portal.dao.mapper.DtsBlogMapper;
import net.ttcxy.tang.portal.dao.mapper.DtsBlogSubjectMapper;
import net.ttcxy.tang.portal.dao.mapper.DtsBlogSubjectRelationMapper;
import net.ttcxy.tang.portal.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsBlog;
import net.ttcxy.tang.portal.entity.model.DtsBlogSubject;
import net.ttcxy.tang.portal.entity.model.DtsBlogSubjectRelation;
import net.ttcxy.tang.portal.entity.model.DtsBlogSubjectRelationExample;
import net.ttcxy.tang.portal.service.DtsBlogSubjectService;
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
        subject.setBlogSubjectId(IdUtil.objectId());
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

        if (StrUtil.equals(blog.getAuthorId(),blogSubject.getAuthorId()) &&
                StrUtil.equals(blog.getAuthorId(), CurrentUtil.id())){
            DtsBlogSubjectRelation blogSubjectRelation = new DtsBlogSubjectRelation();
            blogSubjectRelation.setBlogSubjectRelationId(IdUtil.objectId());
            blogSubjectRelation.setBlogId(blogId);
            blogSubjectRelation.setBlogSubjectId(subjectId);
            blogSubjectRelation.setCreateDate(DateUtil.date());
            return blogSubjectRelationMapper.insert(blogSubjectRelation);
        }else{
            throw new ApiException("权限不足");
        }
    }

    @Override
    public Integer updateBlogToSubject(String blogId, String subjectId) {
        DtsBlogSubject blogSubject = blogSubjectMapper.selectByPrimaryKey(subjectId);
        DtsBlog blog = blogMapper.selectByPrimaryKey(blogId);

        if (StrUtil.equals(blog.getAuthorId(),blogSubject.getAuthorId()) &&
                StrUtil.equals(blog.getAuthorId(),CurrentUtil.id())){
            DtsBlogSubjectRelation blogSubjectRelation = new DtsBlogSubjectRelation();
            blogSubjectRelation.setBlogId(blogId);
            blogSubjectRelation.setBlogSubjectId(subjectId);
            blogSubjectRelation.setCreateDate(DateUtil.date());
            DtsBlogSubjectRelationExample dtsBlogSubjectRelationExample = new DtsBlogSubjectRelationExample();
            dtsBlogSubjectRelationExample.createCriteria().andBlogIdEqualTo(blogId);
            return blogSubjectRelationMapper.updateByExampleSelective(blogSubjectRelation,dtsBlogSubjectRelationExample);
        }else{
            throw new ApiException("权限不足");
        }
    }

    @Override
    public PageInfo<DtsBlogSubjectDto> selectSubjectListBySubjectName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogSubjectDao.selectSubjectListBySubjectName(name));
    }

    @Override
    public String selectSubjectIdByBlogId(String blogId) {
        return blogSubjectDao.selectSubjectIdByBlogId(blogId);
    }
}
