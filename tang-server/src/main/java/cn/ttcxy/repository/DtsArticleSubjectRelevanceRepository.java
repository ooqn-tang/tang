package cn.ttcxy.repository;


import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;
import org.springframework.data.repository.CrudRepository;

public interface DtsArticleSubjectRelevanceRepository extends CrudRepository<DtsArticleSubjectRelevance, String> {

    int countByArticleId(String articleId);

    DtsArticleSubjectRelevance findByArticleId(String articleId);

}
