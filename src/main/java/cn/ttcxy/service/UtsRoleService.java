package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.model.*;
import cn.ttcxy.mapper.UtsResourceRoleMapper;
import cn.ttcxy.mapper.UtsRoleMapper;
import cn.ttcxy.mapper.dao.UtsRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UtsRoleService {

    @Autowired
    private UtsRoleDao roleDao;

    @Autowired
    private UtsRoleMapper roleMapper;

    @Autowired
    private UtsResourceRoleMapper resourceRoleMapper;

    public List<UtsRole> roleList(String authorId){
        return roleDao.selectRoleListByAuthorId(authorId);
    }

    public UtsRole selectById(String roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    public int delete(String roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    public int update(UtsRole role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    public int insert(UtsRole role) {
        return roleMapper.insert(role);
    }

    public List<UtsRole> select() {
        return roleMapper.selectByExample(null);
    }

    public void insertResource(String roleId, List<UtsResource> resourceList) {
        UtsResourceRoleExample resourceRoleExample = new UtsResourceRoleExample();
        resourceRoleExample.createCriteria().andRoleIdEqualTo(roleId);
        resourceRoleMapper.deleteByExample(resourceRoleExample);
        for (UtsResource utsResource : resourceList) {
            UtsResourceRole resourceRole = new UtsResourceRole();
            resourceRole.setRoleId(roleId);
            resourceRole.setResourceId(utsResource.getResourceId());
            resourceRole.setCreateTime(new Date());
            resourceRole.setResourceRoleId(IdUtil.objectId());
            resourceRoleMapper.insert(resourceRole);
        }
    }

    public List<String> selectRoleIdList(String authorId) {
        return roleDao.selectRoleIdList(authorId);
    }

    public List<UtsRole> selectByName(String roleName) {
        UtsRoleExample roleExample = new UtsRoleExample();
        roleExample.createCriteria().andRoleNameEqualTo(roleName);
        return roleMapper.selectByExample(roleExample);
    }
}
