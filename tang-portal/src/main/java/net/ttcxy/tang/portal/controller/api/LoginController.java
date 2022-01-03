package net.ttcxy.tang.portal.controller.api;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.core.security.filter.JwtFilter;
import net.ttcxy.tang.portal.core.security.jwt.TokenProvider;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsLoginParam;
import net.ttcxy.tang.portal.entity.param.UtsRePasswordParam;
import net.ttcxy.tang.portal.entity.param.UtsRegisterParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 登录，注册，修改密码
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    public static Cache<String, String> fifoCache = CacheUtil.newTimedCache(6000);

    private final TokenProvider tokenProvider;

    @Autowired
    private UtsAuthorService authorService;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public LoginController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtToken> authorize(@Valid @RequestBody UtsLoginParam loginParam) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        boolean rememberMe = loginParam.getRememberMe() != null && loginParam.getRememberMe();
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<CurrentAuthor> getActualUser() {
        return ResponseEntity.ok(CurrentUtil.author());
    }

    @PostMapping("register")
    public ResponseResult<?> register(@RequestBody UtsRegisterParam param) {
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
            int count = authorService.insertAuthor(author);
            if (count > 0) {
                return ResponseResult.success("注册成功");
            }
            throw new ApiException(ResponseCode.FAILED);
        } else {
            throw new ApiException("请输入邮箱号");
        }
    }

    @PostMapping("password")
    public ResponseResult<String> updatePassword(@RequestBody UtsRePasswordParam param) {
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
            int count = authorService.updateAuthorByName(author);
            if (count > 0) {
                return ResponseResult.success("修改成功");
            }
        }
        throw new ApiException();
    }

    /**
     * JWT Authentication.
     */
    static class JwtToken {

        private String jwtToken;

        JwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
        }

        @JsonProperty("jwt_token")
        String getJwtToken() {
            return jwtToken;
        }

        void setJwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
        }
    }
}
