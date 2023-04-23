package com.ooqn.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsSubjectRelevance;

public interface DtsSubjectRelevanceRepository extends CrudRepository<DtsSubjectRelevance, String> {

    long countByDataId(String dataId);

    DtsSubjectRelevance findByDataId(String dataId);

    List<DtsSubjectRelevance> findBySubjectId(String subjectId);

}
