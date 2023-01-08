package cn.ttcxy.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.UtsResource;

@NoRepositoryBean
public interface UtsResourceRepository extends CrudRepository<UtsResource, String> {

    List<UtsResource> findByNameLikeAndPathLike(String name, String path);

    @Query("update UtsResource ur set ur.name = ?1 where ur.name = ?1 ")
    void saveByPath(String urlStr);
}
