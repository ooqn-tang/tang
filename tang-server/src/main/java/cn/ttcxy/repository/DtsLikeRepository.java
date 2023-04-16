package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.DtsLike;
import org.springframework.stereotype.Repository;

public interface DtsLikeRepository extends CrudRepository<DtsLike, String> {

    List<DtsLike> findByAuthorIdAndDataId(String authorId, String dataId);

    long countByAuthorIdAndDataId(String authorId, String dataId);

    void deleteByAuthorIdAndDataId(String authorId, String dataId);
}
