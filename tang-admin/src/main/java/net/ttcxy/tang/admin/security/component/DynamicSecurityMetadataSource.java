package net.ttcxy.tang.admin.security.component;

import cn.hutool.core.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 动态权限数据源，用于获取动态权限规则
 * 主要功能返回当前资源需要的权限列表
 * @author huanglei
 */
@Component
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, Collection<ConfigAttribute>> configAttributeMap = null;

    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    /**
     * 刷新权限
     */
    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    /**
     * 需要对权限进行认证的请求，获取当前请求需要的权限
     * @param o 请求路径
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (configAttributeMap == null){
            this.loadDataSource();
        }
        Set<ConfigAttribute> configAttributes = new HashSet<>();
        //获取当前访问的路径
        String url = ((FilterInvocation) o).getRequestUrl();
        String path = URLUtil.getPath(url);
        PathMatcher pathMatcher = new AntPathMatcher();
        //获取访问该路径所需资源
        for (String pattern : configAttributeMap.keySet()) {
            if (pathMatcher.match(pattern, path)) {
                configAttributes.addAll(configAttributeMap.get(pattern));
            }
        }
        // 没有角色添加访客角色
        if (configAttributes.size() == 0){
            configAttributes.add(new SecurityConfig("ROLE_ANONYMOUS"));
        }
        // 未设置操作请求权限，返回空集合
        return configAttributes;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
