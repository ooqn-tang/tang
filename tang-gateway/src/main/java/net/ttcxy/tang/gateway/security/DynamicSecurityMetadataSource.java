package net.ttcxy.tang.gateway.security;

import net.ttcxy.tang.entity.dto.UtsResourceDto;
import net.ttcxy.tang.entity.dto.UtsRoleDto;
import net.ttcxy.tang.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huanglei
 */
@Component
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private UtsResourceService utsResourceService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<UtsResourceDto> resourceList = utsResourceService.listAll();
        Set<ConfigAttribute> resourceRole = new HashSet<>();
        for (UtsResourceDto utsResourceDto : resourceList){
            if (antPathMatcher.match(utsResourceDto.getPath(),requestUrl)){
                List<UtsRoleDto> roles = utsResourceDto.getRoleDtoList();
                resourceRole.addAll(roles);
            }
        }
        // 没有角色添加默认角色
        if (resourceList.size() == 0){
            return SecurityConfig.createList("ROLE_ANONYMOUS");
        }else{
            return resourceRole;
        }
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
