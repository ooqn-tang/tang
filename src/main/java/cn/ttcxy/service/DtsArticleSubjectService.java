package cn.ttcxy.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.mapper.DtsArticleMapper;
import cn.ttcxy.mapper.DtsArticleSubjectMapper;
import cn.ttcxy.mapper.dao.DtsArticleSubjectDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsArticleSubjectService {

    @Autowired
    private DtsArticleSubjectDao articleSubjectDao;

    @Autowired
    private DtsArticleSubjectMapper articleSubjectMapper;

    @Autowired
    private DtsArticleMapper articleMapper;

    @Autowired
    private DtsArticleService articleService;

    public DtsArticleSubjectDto selectSubjectArticleListById(String subjectId) {
        DtsArticleSubjectDto dtsArticleSubjectDto = articleSubjectDao.selectSubjectById(subjectId);
        List<DtsArticle> dtsArticles = articleSubjectDao.selectSubjectArticleListById(subjectId);
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
        return articleSubjectDao.selectSubjectIdByArticleId(articleId);
    }

    public DtsArticleSubject subjectById(String subjectId) {
        return articleSubjectMapper.selectByPrimaryKey(subjectId);
    }

}
