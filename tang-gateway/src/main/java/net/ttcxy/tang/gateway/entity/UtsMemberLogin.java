package net.ttcxy.tang.gateway.entity;

import net.ttcxy.tang.gateway.entity.dto.UtsRoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 用户返回值
 * @author huanglei
 */
public class UtsMemberLogin implements UserDetails {

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 签名
     */
    private String signature;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 用户组
     */
    private List<UtsRoleDto> utsRoleDtoList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return utsRoleDtoList;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRoleDtoList(List<UtsRoleDto> utsRoleDtoList) {
        this.utsRoleDtoList = utsRoleDtoList;
    }
}
