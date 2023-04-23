package com.ooqn.repository;


import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.DtsSubjectRelevance;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DtsSubjectRelevanceRepository extends CrudRepository<DtsSubjectRelevance, String> {

    long countByDataId(String dataId);

    DtsSubjectRelevance findByDataId(String dataId);

    List<DtsSubjectRelevance> findBySubjectId(String subjectId);

}
