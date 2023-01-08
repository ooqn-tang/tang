package cn.ttcxy.dao.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.UtsRole;

@NoRepositoryBean
public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);
}
