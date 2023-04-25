package com.ooqn.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsSubject;

public interface DtsSubjectRepository extends CrudRepository<DtsSubject, String> {

    @Query("From DtsSubject where subjectId in (select subjectId from DtsSubjectRelevance where dataId = ?1)")
    Optional<DtsSubject> findByDataId(String articleId);

    @Query("From DtsSubject where authorId in (select authorId from UtsAuthor where username = ?1)")
    List<DtsSubject> findByAuthorName(String username);

    Page<DtsSubject> findBySubjectName(String name, Pageable pageable);

    @Query("From DtsSubject")
    Page<DtsSubject> findSubjectList(Pageable pageable);

}
