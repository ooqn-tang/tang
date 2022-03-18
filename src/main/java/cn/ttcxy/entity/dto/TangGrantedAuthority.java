package cn.ttcxy.entity.dto;

import cn.ttcxy.entity.model.UtsRole;
import org.springframework.security.core.GrantedAuthority;

public class TangGrantedAuthority implements GrantedAuthority {

    private UtsRole utsRole;

    public TangGrantedAuthority(UtsRole utsRole) {
        this.utsRole = utsRole;
    }

    @Override
    public String getAuthority() {
        return utsRole.getRoleValue();
    }

    public UtsRole getUtsRole() {
        return utsRole;
    }

    public void setUtsRole(UtsRole utsRole) {
        this.utsRole = utsRole;
    }
}
