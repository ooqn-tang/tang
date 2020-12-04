package net.ttcxy.tang.admin.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

/**
 * 动态权限相关业务类
 * 加载所有资源需要的权限
 * @author huanglei
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, Collection<ConfigAttribute>> loadDataSource();
}