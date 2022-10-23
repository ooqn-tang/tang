package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsArticle;

@Repository
public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

}
