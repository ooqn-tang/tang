package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.model.UtsRole;

import java.util.List;

public interface UtsRoleDao {

    List<UtsRole> selectRoleListByAuthorId(String authorId);

    List<String> selectRoleIdList(String authorId);
}
