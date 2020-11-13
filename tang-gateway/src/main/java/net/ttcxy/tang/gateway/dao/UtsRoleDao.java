package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.UtsRoleDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsRoleDao {
    List<UtsRoleDto> selectRoleListByAuthorId(String authorId);
}
