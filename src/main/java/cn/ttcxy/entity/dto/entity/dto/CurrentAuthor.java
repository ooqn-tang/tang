package cn.ttcxy.entity.dto.entity.dto;

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

    private List<UtsRole> roles = new ArrayList<>();

    private long refreshTime;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<TangGrantedAuthority> set = new HashSet<>();
        for (UtsRole role : roles) {
            set.add(new TangGrantedAuthority(role));
        }
        return set;
    }

    public long getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(long refreshTime) {
        this.refreshTime = refreshTime;
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

    public List<UtsRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UtsRole> roles) {
        this.roles = roles;
    }
}
