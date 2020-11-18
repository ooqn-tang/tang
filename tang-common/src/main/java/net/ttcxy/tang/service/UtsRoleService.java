package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.model.UtsRole;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsRoleService {

    /**
     * 获取所有的角色
     * @return
     */
    List<UtsRole> getRoles();

}
