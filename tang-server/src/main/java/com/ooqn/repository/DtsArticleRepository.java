package com.ooqn.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsArticle;

public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    @Modifying
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

    void deleteByArticleId(String articleId);
}
