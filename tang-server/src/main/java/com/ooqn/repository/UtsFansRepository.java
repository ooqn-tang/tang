package com.ooqn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsFans;

import jakarta.transaction.Transactional;

@Transactional
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    @Modifying
    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);

    Long countByAuthorIdAndBeAuthorId(String authorId, String beAuthorId);

    @Query("select ua From UtsAuthor ua where ua.authorId in (select uf.beAuthorId from UtsFans uf where uf.authorId = ?1) order by ua.createTime desc")
    Page<UtsAuthor> findFansList(String authorId, Pageable pageable);

}
