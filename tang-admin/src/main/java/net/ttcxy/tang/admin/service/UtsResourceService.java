package net.ttcxy.tang.admin.service;

import net.ttcxy.tang.admin.entity.dto.UtsResourceDto;
import net.ttcxy.tang.model.UtsResource;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsResourceService {

    /**
     * 获取资源列表，包含哪些权限拥有当前资源
     */
    List<UtsResourceDto> listAll();

    /**
     * 所有的资源列表
     */
    List<UtsResource> resourceList();

    /**
     * 添加资源
     */
    int insertResource(UtsResource resource);

    /**
     * 删除资源
     */
    int deleteResource(String id);

    /**
     * 修改资源
     */
    int updateResource(UtsResource resource);

}
