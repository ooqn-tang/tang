package com.ooqn.repository;


import com.ooqn.entity.model.DtsSubjectRelevance;
import org.springframework.data.repository.CrudRepository;

public interface DtsArticleSubjectRelevanceRepository extends CrudRepository<DtsSubjectRelevance, String> {

    long countByArticleId(String articleId);

    DtsSubjectRelevance findByArticleId(String articleId);

}
