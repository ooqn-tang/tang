//package net.ttcxy.tang.admin.controller;
//
//
//import net.ttcxy.tang.entity.dto.UtsAuthorDto;
//
//import net.ttcxy.tang.api.ResponseResult;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author huanglei
// */
//@RestController
//@RequestMapping("login")
//public class LoginController {
//
//    @Autowired
//    private UtsAuthorServer utsAuthorServer;
//
//    @Autowired
//    private JwtTokenService jwtTokenService;
//
//    @PostMapping("token")
//    public ResponseResult<?> token(@RequestBody UtsAuthor utsAuthor){
//
//        UtsAuthorDto utsAuthorDto = utsAuthorServer.loadAuthorInfo(utsAuthor.getUsername());
//        if (utsAuthorDto == null){
//            return ResponseResult.failed("用户名不存在");
//        }
//        String pwd = utsAuthorDto.getUtsAuthor().getPassword();
//        boolean matches = new BCryptPasswordEncoder().matches(utsAuthor.getPassword(), pwd);
//        if (matches){
//            utsAuthorDto.setPassword(null);
//            return ResponseResult.success(jwtTokenService.generateToken(utsAuthorDto));
//        }
//        return ResponseResult.failed("密码不正确");
//    }
//}
