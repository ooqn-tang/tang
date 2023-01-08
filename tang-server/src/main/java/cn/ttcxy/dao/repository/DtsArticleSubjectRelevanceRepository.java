package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;

@NoRepositoryBean
public interface DtsArticleSubjectRelevanceRepository
        extends CrudRepository<DtsArticleSubjectRelevance, String> {

    int countByArticleId(String articleId);

    DtsArticleSubjectRelevance findByArticleId(String articleId);

}
