package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsCollect;

@Repository
public interface DtsCollectRepository extends CrudRepository<DtsCollect, String> {

    long countByDataIdAndAuthorId(String dataId, String authorId);

    int deleteByDataIdAndAuthorId(String dataId, String authorId);
}
