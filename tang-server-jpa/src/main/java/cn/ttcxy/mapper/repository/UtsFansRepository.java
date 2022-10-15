package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.UtsFans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);
}
