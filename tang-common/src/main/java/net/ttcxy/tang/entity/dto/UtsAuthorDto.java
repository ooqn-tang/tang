package net.ttcxy.tang.entity.dto;

import net.ttcxy.tang.entity.model.UtsAuthor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author huanglei
 */
public class UtsAuthorDto implements UserDetails {

    private UtsAuthor utsAuthor;

    public UtsAuthor getUtsAuthor() {
        return utsAuthor;
    }

    public void setUtsAuthor(UtsAuthor utsAuthor) {
        this.utsAuthor = utsAuthor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
