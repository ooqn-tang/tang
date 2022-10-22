package cn.ttcxy.controller;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.core.security.JwtProvider;
import cn.ttcxy.entity.dto.UtsAuthorDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.param.UtsLoginParam;
import cn.ttcxy.entity.param.UtsRePasswordParam;
import cn.ttcxy.entity.param.UtsRegisterParam;
import cn.ttcxy.service.UtsAuthorService;
import cn.ttcxy.service.UtsUserDetailsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录，注册，修改密码
 */
@RestController
@RequestMapping("/api")
public class UtsLoginController extends BaseController {

    public static Cache<String, String> fifoCache = CacheUtil.newTimedCache(6000);

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UtsUserDetailsService utsUserDetailsService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/authenticate")
    // http://localhost:8888/api/authenticate%3Cscript%3Ealert(%22hello%20XSS!%22)%3C/script%3E
    public String authorize(@RequestBody UtsLoginParam loginParam) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        boolean rememberMe = loginParam.getRememberMe() != null && loginParam.getRememberMe();
        if (authentication.getPrincipal() instanceof UserDetails){
            return jwtProvider.createToken(authentication.getPrincipal(), rememberMe);
        }
        throw new ApiException();
    }

    @PostMapping("/refresh")
    public String refresh(@RequestBody JSONObject jsonObject) {
        String jwt = jsonObject.getString("jwt");
        if (StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt)) {
            Authentication authentication = jwtProvider.getAuthentication(jwt);
            UtsAuthorDto oldAuthorDto = (UtsAuthorDto) authentication.getPrincipal();
            UtsAuthorDto authorDto = (UtsAuthorDto)utsUserDetailsService.loadUserByUsername(oldAuthorDto.getUsername());
            return jwtProvider.createToken(authorDto, true);
        }
        throw new ApiException("无效token");
    }

    @PostMapping("register")
    public String register(@RequestBody UtsRegisterParam param) {
        String mail = param.getMail();
        if (Validator.isEmail(mail)) {
            Boolean isTrue = authorService.selectMailIsTrue(mail);
            if (isTrue) {
                throw new ApiException("邮箱以存在");
            }
            UtsAuthor author = BeanUtil.toBean(param, UtsAuthor.class);
            String password = param.getPassword();
            author.setPassword(new BCryptPasswordEncoder().encode(password));
            author.setMail(mail);
            UtsAuthor utsAuthor = authorService.insertAuthor(author);
            if (utsAuthor != null) {
                return "注册成功";
            }
            throw new ApiException();
        } else {
            throw new ApiException("请输入邮箱号");
        }
    }

    @PostMapping("password")
    public String updatePassword(@RequestBody UtsRePasswordParam param) {
        String mail = param.getMail();
        Boolean isTrue = authorService.selectMailIsTrue(mail);
        if (!isTrue) {
            throw new ApiException("邮箱不存在");
        }
        String code = fifoCache.get(mail);
        if (code == null) {
            throw new ApiException("没有发送邮箱号");
        }
        if (StrUtil.equals(code, param.getCode())) {
            String password = param.getPassword();
            UtsAuthor author = BeanUtil.toBean(param, UtsAuthor.class);
            author.setPassword(new BCryptPasswordEncoder().encode(password));
            Long count = authorService.update(author);
            if (count > 0) {
                return "修改成功";
            }
        }
        throw new ApiException();
    }
}
