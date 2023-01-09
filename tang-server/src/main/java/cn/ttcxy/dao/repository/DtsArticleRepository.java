package cn.ttcxy.dao.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.DtsArticle;

public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    @Modifying
    @Transactional
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

}
