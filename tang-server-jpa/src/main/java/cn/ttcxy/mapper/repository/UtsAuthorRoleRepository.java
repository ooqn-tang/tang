package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.UtsAuthorRole;

@Repository
public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    long deleteByAuthorId(String authorId);
}
