package net.ttcxy.tang.portal.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.mapper.DtsArticleMapper;
import net.ttcxy.tang.portal.mapper.DtsArticleSubjectMapper;
import net.ttcxy.tang.portal.mapper.DtsArticleSubjectRelationMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsArticleSubjectDao;
import net.ttcxy.tang.portal.entity.dto.DtsArticleSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsArticle;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubject;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubjectRelation;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubjectRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsArticleSubjectService {

    @Autowired
    private DtsArticleSubjectDao articleSubjectDao;

    @Autowired
    private DtsArticleSubjectRelationMapper articleSubjectRelationMapper;

    @Autowired
    private DtsArticleSubjectMapper articleSubjectMapper;

    @Autowired
    private DtsArticleMapper articleMapper;

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
        subject.setArticleSubjectId(IdUtil.objectId());
        DateTime date = DateUtil.date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        return articleSubjectMapper.insertSelective(subject);
    }

    
    public Integer updateSubject(DtsArticleSubject subject) {
        subject.setUpdateDate(DateUtil.date());
        return articleSubjectMapper.updateByPrimaryKeySelective(subject);
    }

    
    public Integer insertArticleToSubject(String articleId, String subjectId) {
        DtsArticleSubject articleSubject = articleSubjectMapper.selectByPrimaryKey(subjectId);
        DtsArticle article = articleMapper.selectByPrimaryKey(articleId);

        if (StrUtil.equals(article.getAuthorId(),articleSubject.getAuthorId()) &&
                StrUtil.equals(article.getAuthorId(), CurrentUtil.id())){
            DtsArticleSubjectRelation articleSubjectRelation = new DtsArticleSubjectRelation();
            articleSubjectRelation.setArticleSubjectRelationId(IdUtil.objectId());
            articleSubjectRelation.setArticleId(articleId);
            articleSubjectRelation.setArticleSubjectId(subjectId);
            articleSubjectRelation.setCreateDate(DateUtil.date());
            return articleSubjectRelationMapper.insert(articleSubjectRelation);
        }else{
            throw new ApiException("权限不足");
        }
    }

    
    public Integer updateArticleToSubject(String articleId, String subjectId) {
        DtsArticleSubject articleSubject = articleSubjectMapper.selectByPrimaryKey(subjectId);
        DtsArticle article = articleMapper.selectByPrimaryKey(articleId);

        if (StrUtil.equals(article.getAuthorId(),articleSubject.getAuthorId()) &&
                StrUtil.equals(article.getAuthorId(),CurrentUtil.id())){
            DtsArticleSubjectRelation articleSubjectRelation = new DtsArticleSubjectRelation();
            articleSubjectRelation.setArticleId(articleId);
            articleSubjectRelation.setArticleSubjectId(subjectId);
            articleSubjectRelation.setCreateDate(DateUtil.date());
            DtsArticleSubjectRelationExample dtsArticleSubjectRelationExample = new DtsArticleSubjectRelationExample();
            dtsArticleSubjectRelationExample.createCriteria().andArticleIdEqualTo(articleId);
            return articleSubjectRelationMapper.updateByExampleSelective(articleSubjectRelation,dtsArticleSubjectRelationExample);
        }else{
            throw new ApiException("权限不足");
        }
    }

    
    public PageInfo<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDao.selectSubjectListBySubjectName(name));
    }

    
    public String selectSubjectIdByArticleId(String articleId) {
        return articleSubjectDao.selectSubjectIdByArticleId(articleId);
    }

    
    public boolean deleteArticleSubjectArticleId(String articleId) {
        DtsArticleSubjectRelationExample articleSubjectRelationExample = new DtsArticleSubjectRelationExample();
        articleSubjectRelationExample.createCriteria().andArticleIdEqualTo(articleId);
        return articleSubjectRelationMapper.deleteByExample(articleSubjectRelationExample) > 0;
    }
}
