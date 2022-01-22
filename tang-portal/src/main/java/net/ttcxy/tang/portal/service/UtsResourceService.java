package net.ttcxy.tang.portal.service;

import net.ttcxy.tang.portal.entity.model.UtsResource;
import net.ttcxy.tang.portal.mapper.UtsResourceMapper;
import net.ttcxy.tang.portal.mapper.dao.UtsResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtsResourceService {

    @Autowired
    private UtsResourceDao resourceDao;

    @Autowired
    private UtsResourceMapper resourceMapper;

    
    public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
        return resourceDao.loadResourceUrlByRoleValue(roleValue);
    }

    
    public List<UtsResource> select() {
        return resourceMapper.selectByExample(null);
    }

    
    public int insert(UtsResource resource) {
        return resourceMapper.insert(resource);
    }

    
    public int delete(String resourceId) {
        return resourceMapper.deleteByPrimaryKey(resourceId);
    }

    
    public UtsResource selectById(String resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    
    public int update(UtsResource resource) {
        return resourceMapper.updateByPrimaryKey(resource);
    }

    
    public List<String> selectByRoleId(String roleId) {
        return resourceDao.selectByRoleId(roleId);
    }
}
