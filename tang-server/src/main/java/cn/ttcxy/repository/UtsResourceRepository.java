package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.UtsRoleResourceDto;
import cn.ttcxy.entity.model.UtsResource;

public interface UtsResourceRepository extends CrudRepository<UtsResource, String> {

    List<UtsResource> findByNameLikeAndPathLike(String name, String path);

    @Query("update UtsResource ur set ur.name = ?1 where ur.name = ?1 ")
    void saveByPath(String urlStr);

    @Query(value = """
        select t1.resource_id as resourceId,t1.path as path,t1.name as name,t1.type as type,t1.create_time as createTime,t1.state as state,t2.role_id as roleId,t3.role_value as roleValue from uts_resource t1 , uts_role_resource t2 , uts_role t3 
        where t1.resource_id = t2.resource_id 
        and t2.role_id = t3.role_id 
        and t3.role_value = ?1
        """,nativeQuery = true)
    List<UtsRoleResourceDto> findAllInfo();

    @Query(value = """
        select 
        new cn.ttcxy.entity.model.UtsResource(t1.resourceId,t1.path,t1.name,t1.type,t1.createTime,t1.state)
        from UtsResource t1 , UtsResourceRole t2 , UtsRole t3 
        where t1.resourceId = t2.resourceId 
        and t2.roleId = t3.roleId 
        and t3.roleValue = ?1
        """)
    public List<UtsResource> loadResourceUrlByRoleValue(String roleValue);

    @Query(value = """
        select path from uts_resource t1 , uts_resource_role t2 , uts_role t3 
        where t1.resource_id = t2.resource_id 
        and t2.role_id = t3.role_id 
        and t3.role_value = ?1
        """,nativeQuery = true)
    public List<String> findByRoleId(String roleId);
}
