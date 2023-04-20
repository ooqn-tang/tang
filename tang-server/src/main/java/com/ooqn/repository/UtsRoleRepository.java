package com.ooqn.repository;


import java.util.List;

import com.ooqn.entity.dto.UtsRoleDto;
import com.ooqn.entity.model.UtsRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);

}
