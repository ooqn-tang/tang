package cn.ttcxy.service;

import cn.hutool.core.thread.ThreadUtil;
import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.*;
import cn.ttcxy.mapper.DtsArticleContentMapper;
import cn.ttcxy.mapper.DtsArticleMapper;
import cn.ttcxy.mapper.dao.DtsArticleDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * 博客服务
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
    private DtsMessageService messageService;

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @Autowired
    private DtsEssayService dynamicService;

    public PageInfo<DtsArticleDto> selectArticleList(String classId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDao.selectArticleList(classId));
    }

    public PageInfo<DtsArticleDto> selectArticleListSmall(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDao.selectArticleListSmall());
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

    public int updateArticle(DtsArticle article, DtsArticleContent articleContent) {
        int i = articleMapper.updateByPrimaryKeySelective(article);
        String articleId = article.getArticleId();
        int count = articleContentCount(articleId);
        if (count > 0){
            articleContentMapper.updateByPrimaryKeySelective(articleContent);
        }else{
            articleContentMapper.insert(articleContent);
        }
        DtsEssay dynamic = new DtsEssay();
        dynamic.setText(article.getTitle());
        dynamic.setAuthorId(article.getAuthorId());
        dynamic.setUrl("/article/"+article.getArticleId());
        dynamicService.insert(dynamic);
        return i;
    }

    @Autowired
    private DtsArticleContentMapper articleContentMapper;

    public int articleContentCount(String articleId){
        DtsArticleContent articleContent = articleContentMapper.selectByPrimaryKey(articleId);
        if (articleContent == null){
            return 0;
        }
        return 1;
    }

    public int deleteArticle(String articleId, String authorId) {
        DtsArticleExample articleExample = new DtsArticleExample();
        articleExample.createCriteria()
                .andArticleIdEqualTo(articleId)
                .andAuthorIdEqualTo(authorId);
        return articleMapper.deleteByExample(articleExample);
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

    public int updateSubject(String articleId, String subjectId) {
        DtsArticle article = new DtsArticle();
        article.setArticleId(articleId);
        article.setSubjectId(subjectId);
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    public String authorId(String articleId) {
        DtsArticle article = articleMapper.selectByPrimaryKey(articleId);
        if (article != null){
            return article.getAuthorId();
        }
        return null;
    }
}
