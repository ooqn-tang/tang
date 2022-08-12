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

    List<UtsResource> loadResourceUrlByRoleValue(String roleValue);

    List<String> selectByRoleId(String roleId);

}