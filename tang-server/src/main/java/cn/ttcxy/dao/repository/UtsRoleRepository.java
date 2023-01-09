package cn.ttcxy.dao.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.UtsRole;

public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);
}
