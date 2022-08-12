package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.model.UtsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 */
public interface UtsRoleDao {

    List<UtsRole> selectRoleListByAuthorId(String authorId);

    List<String> selectRoleIdList(String authorId);

}
