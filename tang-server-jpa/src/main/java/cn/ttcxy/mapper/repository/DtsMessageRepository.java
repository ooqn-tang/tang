package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

}
