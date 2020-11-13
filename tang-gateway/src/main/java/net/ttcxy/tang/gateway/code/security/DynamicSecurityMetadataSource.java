package net.ttcxy.tang.gateway.code.security;

import net.ttcxy.tang.gateway.entity.dto.ResourceDto;
import net.ttcxy.tang.gateway.entity.dto.RoleDto;
import net.ttcxy.tang.gateway.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author huanglei
 */
@Component
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private ResourceService resourceService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<ResourceDto> resourceList = resourceService.resourceList();
        for (ResourceDto resourceDto : resourceList){
            if (antPathMatcher.match(resourceDto.getPath(),requestUrl)){
                List<RoleDto> roles = resourceDto.getRoleDtoList();
                String[] roleStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleStr[i] = "ROLE_" + roles.get(i).getValue();
                }
                return SecurityConfig.createList(roleStr);
            }
        }
        return SecurityConfig.createList("ROLE_ANONYMOUS");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
