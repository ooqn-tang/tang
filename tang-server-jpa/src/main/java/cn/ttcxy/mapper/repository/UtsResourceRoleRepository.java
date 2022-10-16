package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.UtsResourceRole;

@Repository
public interface UtsResourceRoleRepository extends CrudRepository<UtsResourceRole, String> {

    void deleteByRoleId(String roleId);
}
