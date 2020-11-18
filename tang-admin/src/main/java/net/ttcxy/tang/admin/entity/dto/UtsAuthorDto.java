package net.ttcxy.tang.admin.entity.dto;

import net.ttcxy.tang.model.UtsAuthor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author huanglei
 */
public class UtsAuthorDto implements UserDetails {

    private UtsAuthor utsAuthor;

    private Set<UtsRoleDto> utsRoleDto;

    public UtsAuthor getUtsAuthor() {
        return utsAuthor;
    }

    public void setUtsAuthor(UtsAuthor utsAuthor) {
        this.utsAuthor = utsAuthor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return utsRoleDto;
    }

    @Override
    public String getPassword() {
        return utsAuthor.getPassword();
    }

    @Override
    public String getUsername() {
        return utsAuthor.getUsername();
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
        utsAuthor.setPassword(o);
    }
}
