package net.ttcxy.tang.admin.code.controller;

import net.ttcxy.tang.admin.code.security.JwtTokenService;
import net.ttcxy.tang.admin.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.admin.server.UtsAuthorServer;
import net.ttcxy.tang.api.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UtsAuthorServer utsAuthorServer;

    @Autowired
    private JwtTokenService jwtTokenService;

    @GetMapping("token")
    public ResponseResult<?> token(@RequestParam("username")String username,@RequestParam("password")String password){

        UtsAuthorDto utsAuthorDto = utsAuthorServer.loadAuthorInfo(username);
        if (utsAuthorDto == null){
            return ResponseResult.failed("用户名不存在");
        }
        String pwd = utsAuthorDto.getUtsAuthor().getPassword();
        boolean matches = new BCryptPasswordEncoder().matches(pwd, new BCryptPasswordEncoder().encode(password));
        if (matches){
            return ResponseResult.success(jwtTokenService.generateToken(utsAuthorDto));
        }
        return ResponseResult.failed("密码不正确");
    }
}
