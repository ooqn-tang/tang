package cn.ttcxy.repository;


import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;

public interface DtsArticleSubjectRelevanceRepository
        extends CrudRepository<DtsArticleSubjectRelevance, String> {

    int countByArticleId(String articleId);

    DtsArticleSubjectRelevance findByArticleId(String articleId);

}
