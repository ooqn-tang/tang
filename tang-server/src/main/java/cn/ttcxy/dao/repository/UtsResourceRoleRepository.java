package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.UtsResourceRole;

@NoRepositoryBean
public interface UtsResourceRoleRepository extends CrudRepository<UtsResourceRole, String> {

    void deleteByRoleId(String roleId);
}
