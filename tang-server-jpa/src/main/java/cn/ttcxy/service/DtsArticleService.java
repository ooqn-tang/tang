package cn.ttcxy.service;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.mapper.dsl.DtsArticleDsl;
import cn.ttcxy.mapper.repository.DtsArticleContentRepository;
import cn.ttcxy.mapper.repository.DtsArticleRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 博客服务
 */
@Service
public class DtsArticleService {

    private static List<DtsArticleDto> cache = new ArrayList<>();

    @Autowired
    private DtsArticleDsl articleDsl;

    @Autowired
    private DtsArticleRepository articleRepository;

    @Autowired
    private DtsEssayService dynamicService;

    public PageInfo<DtsArticleDto> selectArticleList(String classId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDsl.selectArticleList(classId));
    }

    public PageInfo<DtsArticleDto> selectArticleListSmall(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDsl.selectArticleListSmall());
    }

    public PageInfo<DtsArticleDto> search(String title, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(articleDsl.search(title));
    }

    public PageInfo<DtsArticleDto> selectArticleByAuthorName(String username, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(articleDsl.selectArticleListByUsername(username));
    }

    public DtsArticle insertArticle(DtsArticle article) {
        return articleRepository.save(article);
    }

    @Autowired
    DtsArticleContentRepository articleContentRepository;

    public DtsArticle updateArticle(DtsArticle article, DtsArticleContent articleContent) {
        DtsArticle saveArticle = articleRepository.save(article);

        String articleId = article.getArticleId();
        articleContentCount(articleId);

        articleContentRepository.save(articleContent);

        DtsEssay dynamic = new DtsEssay();
        dynamic.setText(article.getTitle());
        dynamic.setAuthorId(article.getAuthorId());
        dynamic.setUrl("/article/"+article.getArticleId());
        dynamicService.insert(dynamic);
        return saveArticle;
    }

    public void articleContentCount(String articleId){
        articleContentRepository.countByArticleId(articleId);
    }

    public void deleteByArticleIdAndAuthorId(String articleId, String authorId) {
        articleRepository.deleteByArticleIdAndAuthorId(articleId,authorId);
    }


    public DtsArticleDto selectArticleById(String id) {
        return articleDsl.selectArticleById(id);
    }

    public DtsArticleDto selectArticleAllById(String id) {
        return articleDsl.selectArticleAllById(id);
    }

    public DtsArticle selectArticleInfoById(String id) {
        return articleRepository.findById(id).orElseThrow();
    }

    public DtsArticle selectById(String id) {
        return articleRepository.findById(id).orElseThrow();
    }


    public List<DtsArticleDto> selectArticleListRandom() {
        List<DtsArticleDto> set = new ArrayList<>();
        DtsArticleService.cache = articleDsl.selectArticleList1000();
        while (set.size() <= 10) {
            Random random = new Random();
            int n = random.nextInt(DtsArticleService.cache.size());
            DtsArticleDto dtsArticleDto = DtsArticleService.cache.get(n);
            set.add(dtsArticleDto);
        }
        return set;
    }

    public DtsArticle updateSubject(String articleId, String subjectId) {
        DtsArticle article = new DtsArticle();
        article.setArticleId(articleId);
        article.setSubjectId(subjectId);
        return articleRepository.save(article);
    }

    public String authorId(String articleId) {
        return articleRepository.findById(articleId).orElseThrow().getAuthorId();
    }

    public PageInfo<DtsArticleDto> selectGzArticleList(String classId, Integer page,String authorId) {
        PageHelper.startPage(page, 10);
        return new PageInfo<>(articleDsl.selectGzArticleList(authorId));
    }
}
