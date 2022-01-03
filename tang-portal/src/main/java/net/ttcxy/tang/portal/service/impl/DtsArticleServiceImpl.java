package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.mapper.DtsArticleMapper;
import net.ttcxy.tang.portal.mapper.DtsArticleTagRelationMapper;
import net.ttcxy.tang.portal.mapper.DtsArticleLikeMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsArticleDao;
import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.model.*;
import net.ttcxy.tang.portal.service.DtsArticleService;
import net.ttcxy.tang.portal.service.DtsArticleSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * 博客服务
 * @author huanglei
 */
@Service
public class DtsArticleServiceImpl implements DtsArticleService {

    private static final ExecutorService executorService = ThreadUtil.newExecutor(50);

    private static List<DtsArticleDto> cache = new ArrayList<>();

    @Autowired
    private DtsArticleDao articleDao;

    @Autowired
    private DtsArticleMapper articleMapper;

    @Autowired
    private DtsArticleTagRelationMapper articleTagRelationMapper;

    @Autowired
    private DtsArticleLikeMapper likeMapper;

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @Override
    public PageInfo<DtsArticleDto> selectArticleList(String tagName, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(articleDao.selectArticleList(tagName));
    }

    @Override
    public PageInfo<DtsArticleDto> search(String title, Integer page , Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(articleDao.search(title));
    }

    @Override
    public PageInfo<DtsArticleDto> selectArticleByAuthorName(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleDao.selectArticleListByUsername(username));
    }

    @Override
    public int insertArticle(DtsArticle article) {
        return articleMapper.insertSelective(article);
    }

    @Override
    public int updateArticle(DtsArticle article, String subjectId, List<String> tagIdList) {
        DtsArticleTagRelation articleTagRelation = new DtsArticleTagRelation();
        int i = articleMapper.updateByPrimaryKeySelective(article);

        DtsArticleTagRelationExample articleTagRelationExample = new DtsArticleTagRelationExample();
        articleTagRelationExample.createCriteria().andArticleIdEqualTo(article.getArticleId());

        articleTagRelationMapper.deleteByExample(articleTagRelationExample);

        for (String tagId : tagIdList) {
            articleTagRelation.setArticleTagRelationId(IdUtil.objectId());
            articleTagRelation.setArticleId(article.getArticleId());
            articleTagRelation.setArticleTagId(tagId);
            articleTagRelationMapper.insert(articleTagRelation);
        }

        articleSubjectService.deleteArticleSubjectArticleId(article.getArticleId());

        if (i > 0 && StrUtil.isNotBlank(subjectId)){
            articleSubjectService.insertArticleToSubject(article.getArticleId(), subjectId);
        }

        return i;
    }

    @Override
    public int deleteArticle(String id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int like(String authorId, String articleId) {
        try{
            DtsArticleLikeExample likeDataExample = new DtsArticleLikeExample();
            likeDataExample.createCriteria().andArticleIdEqualTo(articleId).andAuthorIdEqualTo(authorId);
            DtsArticleLike dtsArticleLike = new DtsArticleLike();
            String id = IdUtil.objectId();
            dtsArticleLike.setAuthorId(authorId);
            dtsArticleLike.setArticleId(articleId);
            dtsArticleLike.setLikeArticleId(id);
            dtsArticleLike.setCreateDate(DateUtil.date());
            return likeMapper.insert(dtsArticleLike);
        }catch (DuplicateKeyException e){
            throw new ApiException("重复插入");
        }
    }

    @Override
    public int unlike(String authorId, String articleId) {
        DtsArticleLikeExample likeDataExample = new DtsArticleLikeExample();
        likeDataExample.createCriteria().andArticleIdEqualTo(articleId).andAuthorIdEqualTo(authorId);
        return likeMapper.deleteByExample(likeDataExample);
    }

    @Override
    public DtsArticleDto selectArticleById(String id) {
        return articleDao.selectArticleById(id);
    }

    @Override
    public DtsArticleDto selectArticleAllById(String id) {
        return articleDao.selectArticleAllById(id);
    }



    @Override
    public DtsArticle selectArticleInfoById(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public DtsArticle selectByPrimaryId(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public long selectLike(String authorId, String articleId) {
        DtsArticleLikeExample likeExample = new DtsArticleLikeExample();
        likeExample.createCriteria().andArticleIdEqualTo(articleId).andAuthorIdEqualTo(authorId);
        return likeMapper.countByExample(likeExample);
    }

    @Override
    public PageInfo<DtsArticleDto> selectLikeArticleList(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleDao.selectLikeArticles(username));
    }

    @Override
    public List<DtsArticleDto> selectArticleListRandom() {
        List<DtsArticleDto> set = new ArrayList<>();
        cache = articleDao.selectArticleList1000();
        while(set.size() <= 10){
            Random random = new Random();
            int n = random.nextInt(cache.size());
            DtsArticleDto dtsArticleDto = cache.get(n);
            set.add(dtsArticleDto);
        }
       return set;
    }
}
