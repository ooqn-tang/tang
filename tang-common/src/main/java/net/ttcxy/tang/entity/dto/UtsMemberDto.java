package net.ttcxy.tang.entity.dto;

import net.ttcxy.tang.entity.model.UtsMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author huanglei
 */
public class UtsMemberDto implements UserDetails {

    private UtsMember utsMember;

    private Set<UtsRoleDto> utsRoleDto;

    public UtsMember getUtsMember() {
        return utsMember;
    }

    public void setUtsMember(UtsMember utsMember) {
        this.utsMember = utsMember;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return utsRoleDto;
    }

    @Override
    public String getPassword() {
        return utsMember.getPassword();
    }

    @Override
    public String getUsername() {
        return utsMember.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String o) {
        utsMember.setPassword(o);
    }
}
