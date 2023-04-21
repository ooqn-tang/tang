package com.ooqn.repository;


import com.ooqn.entity.model.DtsSubjectRelevance;
import org.springframework.data.repository.CrudRepository;

public interface DtsSubjectRelevanceRepository extends CrudRepository<DtsSubjectRelevance, String> {

    long countByDataId(String dataId);

    DtsSubjectRelevance findByDataId(String dataId);

}
