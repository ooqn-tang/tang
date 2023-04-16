package cn.ttcxy.repository;


import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.UtsAuthorRole;
import org.springframework.stereotype.Repository;

public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    long deleteByAuthorId(String authorId);
}
