package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsArticleContent;

@Repository
public interface DtsArticleContentRepository extends CrudRepository<DtsArticleContent, String> {

    long countByArticleId(String articleId);
}
