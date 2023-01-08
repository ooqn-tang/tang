package cn.ttcxy.dao.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsCollect;

@NoRepositoryBean
@Transactional
public interface DtsCollectRepository extends CrudRepository<DtsCollect, String> {

    long countByDataIdAndAuthorId(String dataId, String authorId);

    @Modifying
    @Query(value = "delete from dts_collect c where c.data_id = ?1 and c.author_id = ?2",
            nativeQuery = true)
    int deleteByDataIdAndAuthorId(String dataId, String authorId);
}
