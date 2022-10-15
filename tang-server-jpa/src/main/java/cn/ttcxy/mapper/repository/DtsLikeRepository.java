package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DtsLikeRepository extends CrudRepository<DtsLike, String> {

    List<DtsLike> findByAuthorIdAndDataId(String authorId, String dataId);

    long countByAuthorIdAndDataId(String authorId, String dataId);

    void deleteByAuthorIdAndDataId(String authorId, String dataId);
}
