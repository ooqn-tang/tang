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
    List<UtsRoleResourceDto> selectAll();

    @Query(value = """
        select t1.resource_id as resourceId,t1.path as path,t1.name as name,t1.type as type,t1.create_time as createTime,t1.state as state,t2.role_id as roleId,t3.role_value as roleValue 
        from uts_resource t1 , uts_role_resource t2 , uts_role t3 
        where t1.resource_id = t2.resource_id 
        and t2.role_id = t3.role_id 
        and t3.role_value = ?1
    """,nativeQuery = true)
    public List<UtsResource> loadResourceUrlByRoleValue(String roleValue);

    @Query(value = """
        select path from uts_resource t1 , uts_role_resource t2 , uts_role t3 
        where t1.resource_id = t2.resource_id 
        and t2.role_id = t3.role_id 
        and t3.role_value = ?1
    """,nativeQuery = true)
    public List<String> selectByRoleId(String roleId);
}
