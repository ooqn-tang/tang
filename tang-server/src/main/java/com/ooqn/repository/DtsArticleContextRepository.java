package com.ooqn.repository;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsArticleContext;

public interface DtsArticleContextRepository extends CrudRepository<DtsArticleContext, String> {

    void deleteByArticleId(String articleId);

    String findTextByArticleId(String articleId);

}
