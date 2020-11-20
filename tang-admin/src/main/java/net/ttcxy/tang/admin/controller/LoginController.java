package net.ttcxy.tang.admin.controller;


import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.admin.security.component.AuthenticationTokenFilter;
import net.ttcxy.tang.entity.UtsAuthorLogin;
import net.ttcxy.tang.entity.dto.UtsAuthorDto;

import net.ttcxy.tang.api.ResponseResult;

import net.ttcxy.tang.entity.model.UtsAuthor;
import net.ttcxy.tang.service.UtsAuthorService;
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
    public ResponseResult<?> token(@RequestBody UtsAuthor utsAuthor){

        UserDetails userDetails = userDetailsService.loadUserByUsername(utsAuthor.getUsername());
        if (userDetails == null){
            return ResponseResult.failed("用户名不存在");
        }
        String pwd = userDetails.getPassword();
        boolean matches = new BCryptPasswordEncoder().matches(utsAuthor.getPassword(), pwd);
        if (matches){
            String uuid = IdUtil.fastSimpleUUID();
            AuthenticationTokenFilter.authorDtoMap.put(uuid,userDetails);
            return ResponseResult.success(uuid);
        }
        return ResponseResult.failed("密码不正确");
    }
}
