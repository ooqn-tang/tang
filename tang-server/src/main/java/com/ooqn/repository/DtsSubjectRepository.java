package com.ooqn.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsSubject;

public interface DtsSubjectRepository extends CrudRepository<DtsSubject, String> {

    @Query("From DtsSubject where subjectId in (select subjectId from DtsSubjectRelevance where dataId = ?1)")
    Optional<DtsSubject> findByArticleId(String articleId);

}
