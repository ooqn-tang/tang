package cn.ttcxy.controller;

import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.CurrentAuthor;
import cn.ttcxy.entity.model.UtsAuthor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseController {

    public String authorId(){
        return author().getAuthorId();
    }

    public String authorName(){
        return author().getUsername();
    }

    public UtsAuthor author(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            return ((CurrentAuthor) authentication.getPrincipal()).getAuthor();
        }
        throw new ApiException(ResponseCode.UNAUTHORIZED);
    }

    public boolean isLogin(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal() instanceof UserDetails;
    }
}
