package com.ooqn.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsSubjectRelevance;

public interface DtsSubjectRelevanceRepository extends CrudRepository<DtsSubjectRelevance, String> {

    long countByDataId(String dataId);
    
    Optional<DtsSubjectRelevance> findByDataId(String dataId);

    List<DtsSubjectRelevance> findBySubjectId(String subjectId);

    void deleteBySubjectIdAndDataId(String subjectId, String articleId);

    void deleteByDataId(String articleId);

    // 获取这个专辑的最新的OrderNum + 1
    @Query("select max(dsr.orderNum) + 1 from DtsSubjectRelevance dsr where dsr.subjectId = ?1")
    Integer findMaxOrderNumBySubjectId(String subjectId);

}
