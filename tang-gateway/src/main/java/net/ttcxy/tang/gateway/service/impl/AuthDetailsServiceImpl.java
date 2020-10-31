package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 获取当前用户
 * @author huanglei
 */
@Service
public class AuthDetailsServiceImpl implements AuthDetailsService {

    @Override
    public LoginUser getUser(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (LoginUser)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getUserId(){
        LoginUser loginUser = getUser();
        if (ObjectUtil.isNotNull(loginUser)){
            return loginUser.getId();
        }
        return "";
    }

}
