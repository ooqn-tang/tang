package cn.ttcxy.repository;

import cn.ttcxy.entity.dto.UtsFansDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.UtsFans;
import jakarta.transaction.Transactional;

@Transactional
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    @Modifying
    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);

    @Query(value = "select * from uts_fans where author_id = ?1 ?2", nativeQuery = true)
    public Long isFans(String authorId, String beAuthorId);

    @Query(value = "select * from uts_fans where author_id = ?1", nativeQuery = true)
    Page<UtsFansDto> findFansList(String userId, Pageable pageable);
}
