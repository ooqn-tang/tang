package net.ttcxy.tang.gateway.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class MyAbstractAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    private Object details;


    public MyAbstractAuthenticationToken(Object principal,Object details) {
        super(null);
        this.principal = principal;
        this.details = details;
        super.setAuthenticated(true);
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }


    @Override
    public Object getDetails() {
        return this.details;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
