package net.ttcxy.tang.portal.service;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.mapper.DtsArticleMapper;
import net.ttcxy.tang.portal.mapper.DtsArticleTagRelationMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsArticleDao;
import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * 博客服务
 *
 * @author LYJ
 */
@Service
public class DtsArticleService {

    private static final ExecutorService executorService = ThreadUtil.newExecutor(50);

    private static List<DtsArticleDto> cache = new ArrayList<>();

    @Autowired
    private DtsArticleDao articleDao;

    @Autowired
    private DtsArticleMapper articleMapper;

    @Autowired
    private DtsArticleTagRelationMapper articleTagRelationMapper;


    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    public PageInfo<DtsArticleDto> selectArticleList(String tagName, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDao.selectArticleList(tagName));
    }

    public PageInfo<DtsArticleDto> search(String title, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(articleDao.search(title));
    }

    public PageInfo<DtsArticleDto> selectArticleByAuthorName(String username, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDao.selectArticleListByUsername(username));
    }

    public int insertArticle(DtsArticle article) {
        return articleMapper.insertSelective(article);
    }

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

        if (i > 0 && StrUtil.isNotBlank(subjectId)) {
            articleSubjectService.insertArticleToSubject(article.getArticleId(), subjectId);
        }

        return i;
    }

    public int deleteArticle(String id) {
        return articleMapper.deleteByPrimaryKey(id);
    }


    public DtsArticleDto selectArticleById(String id) {
        return articleDao.selectArticleById(id);
    }

    public DtsArticleDto selectArticleAllById(String id) {
        return articleDao.selectArticleAllById(id);
    }

    public DtsArticle selectArticleInfoById(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public DtsArticle selectByPrimaryId(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }


    public List<DtsArticleDto> selectArticleListRandom() {
        List<DtsArticleDto> set = new ArrayList<>();
        DtsArticleService.cache = articleDao.selectArticleList1000();
        while (set.size() <= 10) {
            Random random = new Random();
            int n = random.nextInt(DtsArticleService.cache.size());
            DtsArticleDto dtsArticleDto = DtsArticleService.cache.get(n);
            set.add(dtsArticleDto);
        }
        return set;
    }
}
