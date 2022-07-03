package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.UtsRoleResourceDto;
import cn.ttcxy.entity.model.UtsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源
 */
public interface UtsResourceDao {

    List<UtsRoleResourceDto> selectAll();

    List<UtsResource> loadResourceUrlByRoleValue(@Param("roleValue") String roleValue);

    List<String> selectByRoleId(@Param("roleId") String roleId);

}