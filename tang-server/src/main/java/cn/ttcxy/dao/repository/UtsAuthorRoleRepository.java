package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.UtsAuthorRole;

public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    long deleteByAuthorId(String authorId);
}
