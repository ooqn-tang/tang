package net.ttcxy.tang.admin.controller;


import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.admin.security.component.AuthenticationTokenFilter;

import net.ttcxy.tang.api.ResponseResult;

import net.ttcxy.tang.entity.model.UtsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserDetailsService userDetailsService;


    @PostMapping("token")
    public ResponseResult<?> token(@RequestBody UtsMember utsMember){

        UserDetails userDetails = userDetailsService.loadUserByUsername(utsMember.getUsername());
        if (userDetails == null){
            return ResponseResult.failed("用户名不存在");
        }
        String pwd = userDetails.getPassword();
        boolean matches = new BCryptPasswordEncoder().matches(utsMember.getPassword(), pwd);
        if (matches){
            String uuid = IdUtil.fastSimpleUUID();
            AuthenticationTokenFilter.authorDtoMap.put(uuid,userDetails);
            return ResponseResult.success(uuid);
        }
        return ResponseResult.failed("密码不正确");
    }
}
