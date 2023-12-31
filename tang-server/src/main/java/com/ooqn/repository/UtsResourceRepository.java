package com.ooqn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ooqn.entity.model.UtsResource;

public interface UtsResourceRepository extends JpaRepository<UtsResource, String> {

    UtsResource findByPathAndType(String path, String type);

    List<UtsResource> findByNameLikeAndPathLikeOrderByPath(String string, String string2);

    @Query("From UtsResource where resourceId in (select resourceId from UtsResourceRole where roleId = ?1)")
    List<UtsResource> findByRoleId(String roleId);

}
