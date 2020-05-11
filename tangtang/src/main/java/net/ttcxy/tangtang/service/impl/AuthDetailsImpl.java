package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.ttcxy.tangtang.entity.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author ：HuangLei
 * @date ：2020/4/3 0003 17:28
 */
@Service
public class AuthDetailsImpl {

    public UserDto getUser(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (UserDto)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

    public String getUserId(){
        UserDto userDto = getUser();
        if (ObjectUtil.isNotNull(userDto)){
            return userDto.getId();
        }
        return null;
    }

}
