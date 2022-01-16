package net.ttcxy.tang.portal.service;

import net.ttcxy.tang.portal.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Service("rbacService")
public class RbacService {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private UtsResourceService utsResourceService;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        boolean hasPermission = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            List<String> strings = utsResourceService.loadResourceUrlByRoleValue(role);
            for (String string : strings) {
                if (antPathMatcher.match(string,request.getRequestURI())){
                    return true;
                }
            }
        }
        return false;
    }
}
