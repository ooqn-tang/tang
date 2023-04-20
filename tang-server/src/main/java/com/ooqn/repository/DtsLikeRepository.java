package com.ooqn.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsLike;

public interface DtsLikeRepository extends CrudRepository<DtsLike, String> {

    List<DtsLike> findByAuthorIdAndDataId(String authorId, String dataId);

    long countByAuthorIdAndDataId(String authorId, String dataId);

    void deleteByAuthorIdAndDataId(String authorId, String dataId);
}
