package net.ttcxy.tang.gateway.security;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public class CurrentAuthorServiceImpl implements CurrentAuthorService {

    @Override
    public AuthorLogin getUser(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (AuthorLogin)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getUserId(){
        AuthorLogin author = getUser();
        if (ObjectUtil.isNotNull(author)){
            return author.getId();
        }
        return "";
    }
}
