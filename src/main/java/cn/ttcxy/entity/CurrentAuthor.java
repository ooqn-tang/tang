package cn.ttcxy.entity;

import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * 用户返回值
 */
public class CurrentAuthor implements UserDetails {

    private UtsAuthor author = new UtsAuthor();

    private List<UtsRoleDto> roles = new ArrayList<>();

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public long getRefreshTime() {
        return author.getRefreshTime().getTime();
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
    @JsonIgnore
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getUsername();
    }

    public UtsAuthor getAuthor() {
        return author;
    }

    public void setAuthor(UtsAuthor author) {
        this.author = author;
    }

    public List<UtsRoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<UtsRoleDto> roles) {
        this.roles = roles;
    }
}
