package net.ttcxy.tang.portal.service;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.entity.model.UtsResource;
import net.ttcxy.tang.portal.entity.model.UtsResourceExample;
import net.ttcxy.tang.portal.mapper.UtsResourceMapper;
import net.ttcxy.tang.portal.mapper.dao.UtsResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UtsResourceService {

    @Autowired
    private UtsResourceDao resourceDao;

    @Autowired
    private UtsResourceMapper resourceMapper;

    
    public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
        return resourceDao.loadResourceUrlByRoleValue(roleValue);
    }

    
    public List<UtsResource> select(String queryData) {
        UtsResourceExample resourceExample = new UtsResourceExample();
        resourceExample.or().andNameLike("%"+queryData+"%");
        resourceExample.or().andPathLike("%"+queryData+"%");
        return resourceMapper.selectByExample(resourceExample);
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

    @Autowired
    private ApplicationContext applicationContext;

    public void urls() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        UtsResource resource = new UtsResource();
        resource.setState(9);
        UtsResourceExample example = new UtsResourceExample();
        resourceMapper.updateByExampleSelective(resource,example);

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entryInfo : map.entrySet()) {
            Set<String> patterns = entryInfo.getKey().getPatternsCondition().getPatterns();
            for (String url : patterns) {
                Set<RequestMethod> methods = entryInfo.getKey().getMethodsCondition().getMethods();
                for (RequestMethod method : methods) {
                    String urlStr = url.replaceAll("\\{[^}]*}", "*");
                    try {
                        UtsResource utsResource = new UtsResource();
                        utsResource.setResourceId(IdUtil.objectId());
                        utsResource.setType(method.name());
                        utsResource.setName(urlStr);
                        utsResource.setPath(urlStr);
                        utsResource.setCreateTime(new Date());
                        utsResource.setState(8);
                        insert(utsResource);
                    }catch (Exception e){
                        UtsResourceExample resourceExample = new UtsResourceExample();
                        resourceExample.createCriteria().andPathEqualTo(urlStr);
                        UtsResource utsResource = new UtsResource();
                        utsResource.setState(8);
                        resourceMapper.updateByExampleSelective(utsResource,resourceExample);
                        System.out.println("数据已经存在");
                    }
                }
            }
        }
    }
}
