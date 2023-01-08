package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.UtsAuthorRole;

@NoRepositoryBean
public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    long deleteByAuthorId(String authorId);
}
