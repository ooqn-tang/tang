package net.ttcxy.tang.gateway.entity.dto;

import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用户返回值
 * @author huanglei
 */
public class UtsLoginDto implements UserDetails {

    private UtsAuthor author;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

    @Override
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getPassword();
    }

    public UtsAuthor getAuthor() {
        return author;
    }

    public void setAuthor(UtsAuthor author) {
        this.author = author;
    }
}
