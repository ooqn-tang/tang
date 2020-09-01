package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tang.entity.UserDto;
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
    public UserDto getUser(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (UserDto)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public String getUserId(){
        UserDto userDto = getUser();
        if (ObjectUtil.isNotNull(userDto)){
            return userDto.getId();
        }
        return "";
    }

}
