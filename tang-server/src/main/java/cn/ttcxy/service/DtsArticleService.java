package cn.ttcxy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateUtil;
import cn.ttcxy.dao.dsl.DtsArticleDsl;
import cn.ttcxy.dao.repository.DtsArticleRepository;
import cn.ttcxy.dao.repository.DtsArticleSubjectRelevanceRepository;
import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;

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

    public Page<DtsArticleDto> selectArticleList(Pageable pageable) {
        return articleDsl.selectArticleList(pageable);
    }

    public Page<DtsArticleDto> selectArticleListSmall(Pageable pageable) {
        return articleDsl.selectArticleListSmall(pageable);
    }

    public Page<DtsArticleDto> search(String title, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return articleDsl.search(title,pageable);
    }

    public Page<DtsArticleDto> selectArticleByAuthorName(String username, Pageable pageable) {
        return articleDsl.selectArticleListByUsername(username,pageable);
    }

    public DtsArticle insertArticle(DtsArticle article) {
        return articleRepository.save(article);
    }

    @Autowired
    private DtsArticleSubjectRelevanceRepository subjectRelevanceRepository;

    public DtsArticle updateArticle(DtsArticle article,String subjectId) {
        DtsArticle saveArticle = articleRepository.save(article);
        DtsArticleSubjectRelevance articleSubjectRelevance = subjectRelevanceRepository.findByArticleId(article.getArticleId());
        
        if(articleSubjectRelevance == null){
            articleSubjectRelevance = new DtsArticleSubjectRelevance();
            articleSubjectRelevance.setArticleId(article.getArticleId());
            articleSubjectRelevance.setSubjectId(subjectId);
            articleSubjectRelevance.setCreateDate(DateUtil.date());
        }
        subjectRelevanceRepository.save(articleSubjectRelevance);
        return saveArticle;
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

    @Autowired
    private DtsArticleSubjectRelevanceRepository dtsArticleSubjectRepository;

    public DtsArticleSubjectRelevance saveSubjectId(String articleId, String subjectId) {
        DtsArticleSubjectRelevance articleSubjectRelevance = new DtsArticleSubjectRelevance();
        articleSubjectRelevance.setArticleId(articleId);
        articleSubjectRelevance.setSubjectId(subjectId);
        return dtsArticleSubjectRepository.save(articleSubjectRelevance);
    }

    public String authorId(String articleId) {
        return articleRepository.findById(articleId).orElseThrow().getAuthorId();
    }

    public Page<DtsArticleDto> selectGzArticleList(Pageable pageable,String authorId) {
        return articleDsl.selectGzArticleList(authorId,pageable);
    }

    public static void main(String[] args) {
        Pageable of = PageRequest.of(11, 10);
        PageImpl<Object> pageImpl = new PageImpl<>(new ArrayList<>(),of,100);

        System.out.println(pageImpl.hasNext());
        System.out.println(pageImpl.hasPrevious());
        System.out.println(pageImpl.getTotalElements());        
        System.out.println(pageImpl.getTotalPages());
        System.out.println(pageImpl);
    }
}
