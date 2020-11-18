package net.ttcxy.tang.db.dao;

import net.ttcxy.tang.entity.dto.UtsRoleDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsRoleDao {
    List<UtsRoleDto> selectRoleListByAuthorId(String authorId);
}
