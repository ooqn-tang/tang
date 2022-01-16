package net.ttcxy.tang.portal.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * 用户返回值
 * @author huanglei
 */
public class CurrentAuthor implements UserDetails {

    private UtsAuthor utsAuthor = new UtsAuthor();

    private List<UtsRole> utsRoles = new ArrayList<>();

    private String updateToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<TangGrantedAuthority> set = new HashSet<>();
        for (UtsRole utsRole : utsRoles) {
            set.add(new TangGrantedAuthority(utsRole));
        }
        return set;
    }

    public String getUpdateToken() {
        return updateToken;
    }

    public void setUpdateToken(String updateToken) {
        this.updateToken = updateToken;
    }

    public UtsAuthor getUtsAuthor() {
        return utsAuthor;
    }

    public void setUtsAuthor(UtsAuthor utsAuthor) {
        this.utsAuthor = utsAuthor;
    }

    public List<UtsRole> getUtsRoles() {
        return utsRoles;
    }

    public void setUtsRoles(List<UtsRole> utsRoles) {
        this.utsRoles = utsRoles;
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
        return utsAuthor.getPassword();
    }

    @Override
    public String getUsername() {
        return utsAuthor.getUsername();
    }

}
