package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;

@Repository
public interface DtsArticleSubjectRelevanceRepository extends CrudRepository<DtsArticleSubjectRelevance, String> {

}
