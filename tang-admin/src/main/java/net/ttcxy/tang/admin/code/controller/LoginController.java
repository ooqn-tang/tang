package net.ttcxy.tang.admin.code.controller;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.admin.code.security.component.AuthenticationTokenFilter;
import net.ttcxy.tang.admin.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.admin.server.UtsAuthorServer;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.model.UtsAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UtsAuthorServer utsAuthorServer;

    //@Autowired
    //private JwtTokenService jwtTokenService;

    @PostMapping("token")
    public ResponseResult<?> token(@RequestBody UtsAuthor utsAuthor){

        UtsAuthorDto utsAuthorDto = utsAuthorServer.loadAuthorInfo(utsAuthor.getUsername());
        if (utsAuthorDto == null){
            return ResponseResult.failed("用户名不存在");
        }
        String pwd = utsAuthorDto.getUtsAuthor().getPassword();
        boolean matches = new BCryptPasswordEncoder().matches(utsAuthor.getPassword(), pwd);
        if (matches){
            utsAuthorDto.setPassword(null);
            String simpleUUID = IdUtil.fastSimpleUUID();
            AuthenticationTokenFilter.authorDtoMap.put(simpleUUID,utsAuthorDto);
            return ResponseResult.success("");
        }
        return ResponseResult.failed("密码不正确");
    }
}
