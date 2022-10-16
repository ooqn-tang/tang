package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.mapper.dsl.UtsResourceDsl;
import cn.ttcxy.mapper.repository.UtsResourceRepository;

@Service
public class UtsResourceService {

    @Autowired
    private UtsResourceDsl resourceDls;

    @Autowired
    private UtsResourceRepository resourceRepository;

    
    public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
        return resourceDls.loadResourceUrlByRoleValue(roleValue);
    }

    
    public List<UtsResource> select(String queryData) {
        return resourceRepository.findByNameLikeAndPathLike("%"+queryData+"%","%"+queryData+"%");
    }

    public UtsResource insert(UtsResource resource) {
        return resourceRepository.save(resource);
    }

    
    public void delete(String resourceId) {
        resourceRepository.deleteById(resourceId);
    }

    
    public UtsResource selectById(String resourceId) {
        return resourceRepository.findById(resourceId).orElseThrow();
    }

    
    public UtsResource update(UtsResource resource) {
        return resourceRepository.save(resource);
    }

    
    public List<String> selectByRoleId(String roleId) {
        return resourceDls.selectByRoleId(roleId);
    }

    // @Autowired
    // private ApplicationContext applicationContext;

    public void urls() {
    //     RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
    //     // 获取url与类和方法的对应信息
    //     Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

    //     UtsResource resource = new UtsResource();
    //     resource.setState(9);
    //     resourceRepository.save(resource);

    //     for (Map.Entry<RequestMappingInfo, HandlerMethod> entryInfo : map.entrySet()) {
    //         assert entryInfo.getKey().getPathPatternsCondition() != null;
    //         Set<PathPattern> patterns = entryInfo.getKey().getPathPatternsCondition().getPatterns();
    //         for (PathPattern pathPattern : patterns) {
    //             String url = pathPattern.getPatternString();
    //             Set<RequestMethod> methods = entryInfo.getKey().getMethodsCondition().getMethods();
    //             for (RequestMethod method : methods) {
    //                 String urlStr = url.replaceAll("\\{[^}]*}", "*");
    //                 try {
    //                     UtsResource utsResource = new UtsResource();
    //                     utsResource.setResourceId(IdUtil.objectId());
    //                     utsResource.setType(method.name());
    //                     utsResource.setName(urlStr);
    //                     utsResource.setPath(urlStr);
    //                     utsResource.setCreateTime(new Date());
    //                     utsResource.setState(8);
    //                     insert(utsResource);
    //                 }catch (Exception e){
    //                     UtsResource utsResource = new UtsResource();
    //                     utsResource.setState(8);
    //                     resourceRepository.saveByPath(urlStr);
    //                     System.out.println("数据已经存在");
    //                 }
    //             }
    //         }
    //     }
    }
}
