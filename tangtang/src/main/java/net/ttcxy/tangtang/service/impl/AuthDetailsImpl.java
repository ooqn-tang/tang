package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author ：HuangLei
 * @date ：2020/4/3 0003 17:28
 */
@Service
public class AuthDetailsImpl {

    public User getUser(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            return (User)authentication.getPrincipal();
        }catch(Exception ex){
            return null;
        }
    }

}
