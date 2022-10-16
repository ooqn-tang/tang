package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.UtsFans;

@Repository
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);
}
