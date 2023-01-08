package cn.ttcxy.dao.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.UtsFans;

@NoRepositoryBean
@Transactional
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    @Modifying
    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);
}
