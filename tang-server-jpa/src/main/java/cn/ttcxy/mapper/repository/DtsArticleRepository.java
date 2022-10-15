package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

    List<DtsArticle> findBySubjectId(String subjectId);
}
