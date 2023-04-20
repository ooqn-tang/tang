package com.ooqn.repository;


import com.ooqn.entity.model.DtsArticle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    @Modifying
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

}
