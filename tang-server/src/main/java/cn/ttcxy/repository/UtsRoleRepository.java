package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.UtsRole;

public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);

    @Query(value="select * from uts_role t1 , uts_author_role t2 where t1.role_id = t2.role_id",nativeQuery = true)
    List<UtsRoleDto> findRoleListByAuthorId(String authorId);

    @Query(value="select role_id from uts_role_author where author_id = ?1",nativeQuery = true)
    List<String> findRoleIdList(String authorId);
}
