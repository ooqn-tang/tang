package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleExample;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.mapper.DtsArticleMapper;
import cn.ttcxy.mapper.DtsArticleSubjectMapper;
import cn.ttcxy.mapper.dao.DtsArticleSubjectDao;

@Service
public class DtsArticleSubjectService {

    @Autowired
    private DtsArticleSubjectDao articleSubjectDao;

    @Autowired
    private DtsArticleSubjectMapper articleSubjectMapper;

    @Autowired
    private DtsArticleMapper articleMapper;

    public DtsArticleSubjectDto selectSubjectArticleListById(String subjectId) {
        DtsArticleSubjectDto dtsArticleSubjectDto = articleSubjectDao.selectSubjectById(subjectId);

        DtsArticleExample articleExample = new DtsArticleExample();
        articleExample.createCriteria().andSubjectIdEqualTo(subjectId);
        List<DtsArticle> dtsArticles = articleMapper.selectByExample(articleExample);

        if (dtsArticleSubjectDto == null){
            return null;
        }
        dtsArticleSubjectDto.setArticleList(dtsArticles);
        return dtsArticleSubjectDto;
    }

    public PageInfo<DtsArticleSubjectDto> selectSubjectList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDao.selectSubjectList());
    }

    public PageInfo<DtsArticleSubjectDto> selectSubjectListByUsername(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDao.selectSubjectListByUsername(username));
    }

    public Integer insertSubject(DtsArticleSubject subject) {
        subject.setSubjectId(IdUtil.objectId());
        DateTime date = DateUtil.date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        return articleSubjectMapper.insertSelective(subject);
    }

    public Integer updateSubject(DtsArticleSubject subject) {
        subject.setUpdateDate(DateUtil.date());
        return articleSubjectMapper.updateByPrimaryKeySelective(subject);
    }

    public PageInfo<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDao.selectSubjectListBySubjectName(name));
    }

    public String selectSubjectIdByArticleId(String articleId) {
        return articleMapper.selectByPrimaryKey(articleId).getSubjectId();
    }

    public DtsArticleSubject subjectById(String subjectId) {
        return articleSubjectMapper.selectByPrimaryKey(subjectId);
    }

}
