package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.UtsResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtsResourceRepository extends CrudRepository<UtsResource, String> {

    List<UtsResource> findByNameLikeAndPathLike(String name, String path);

    @Query("update UtsResource ur set ur.name = ?1 where ur.name = ?1 ")
    void saveByPath(String urlStr);
}
