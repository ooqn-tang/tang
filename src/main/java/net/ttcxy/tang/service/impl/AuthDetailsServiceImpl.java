package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.entity.LoginUser;
import net.ttcxy.tang.service.AuthDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 获取当前用户
 * @author ：HuangLei
 * @date ：2020/4/3 0003 17:28
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
