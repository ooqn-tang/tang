package cn.ttcxy.dao.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsArticle;

@NoRepositoryBean
public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    @Modifying
    @Transactional
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

}
