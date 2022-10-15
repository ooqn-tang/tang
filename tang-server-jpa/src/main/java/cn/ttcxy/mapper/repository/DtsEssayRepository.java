package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsEssay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {

}
