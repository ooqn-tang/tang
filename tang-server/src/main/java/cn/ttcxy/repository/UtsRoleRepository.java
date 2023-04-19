package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.UtsRole;

public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);

    @Query(value = """
            select new cn.ttcxy.entity.dto.UtsRoleDto(t1.roleId,t1.roleName,t1.roleValue,t1.createTime,t1.updateTime,t1.refreshTime)
            from UtsRole t1 , UtsAuthorRole t2 where t1.roleId = t2.roleId and t2.authorId = ?1
            """)
    List<UtsRoleDto> findRoleListByAuthorId(String authorId);

    @Query(value = "select role_id from uts_role_author where author_id = ?1", nativeQuery = true)
    List<String> findRoleIdList(String authorId);
}
