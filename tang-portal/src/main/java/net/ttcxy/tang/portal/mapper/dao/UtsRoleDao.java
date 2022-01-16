package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.model.UtsRole;

import java.util.List;

public interface UtsRoleDao {

    List<UtsRole> selectRoleListByAuthorId(String authorId);

    List<String> selectRoleIdList(String authorId);
}
