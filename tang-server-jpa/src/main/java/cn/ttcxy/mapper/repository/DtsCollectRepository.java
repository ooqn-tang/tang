package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsCollect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DtsCollectRepository extends CrudRepository<DtsCollect, String> {

    long countByDataIdAndAuthorId(String dataId, String authorId);

    int deleteByDataIdAndAuthorId(String dataId, String authorId);
}
