package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DtsArticleContentRepository extends CrudRepository<DtsArticleContent, String> {

    long countByArticleId(String articleId);
}
