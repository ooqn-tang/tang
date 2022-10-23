package cn.ttcxy.dao.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsLike;

@Repository
public interface DtsLikeRepository extends CrudRepository<DtsLike, String> {

    List<DtsLike> findByAuthorIdAndDataId(String authorId, String dataId);

    long countByAuthorIdAndDataId(String authorId, String dataId);

    void deleteByAuthorIdAndDataId(String authorId, String dataId);
}
