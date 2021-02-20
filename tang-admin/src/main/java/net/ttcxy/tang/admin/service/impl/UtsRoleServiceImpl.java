package net.ttcxy.tang.admin.service.impl;

import net.ttcxy.tang.admin.dao.UtsRoleDao;
import net.ttcxy.tang.admin.entity.dto.UtsRoleDto;
import net.ttcxy.tang.admin.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
public class UtsRoleServiceImpl implements UtsRoleService {

    @Autowired
    private UtsRoleMapper utsRoleMapper;

    @Autowired
    public UtsRoleDao utsRoleDao;

    @Override
    public List<UtsRole> getRoles() {
        return utsRoleMapper.selectByExample(null);
    }

    @Override
    public List<UtsRoleDto> getTreeRoles() {
        return utsRoleDao.getTreeRoles();
    }

    @Override
    public int insertRole(UtsRole utsRole) {
        return utsRoleMapper.insertSelective(utsRole);
    }

    @Override
    public int updateRole(UtsRole utsRole) {
        return utsRoleMapper.updateByPrimaryKeySelective(utsRole);
    }

    @Override
    public int deleteRole(String id) {
        return utsRoleMapper.deleteByPrimaryKey(id);
    }
}
