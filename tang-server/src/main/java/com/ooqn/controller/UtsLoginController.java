package com.ooqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ooqn.core.control.BaseController;
import com.ooqn.core.exception.ApiException;
import com.ooqn.core.security.JwtProvider;
import com.ooqn.core.security.NotRole;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.param.UtsLoginParam;
import com.ooqn.entity.param.UtsRePasswordParam;
import com.ooqn.entity.param.UtsRegisterParam;
import com.ooqn.service.UtsAuthorService;
import com.ooqn.service.UtsUserDetailsService;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 登录，注册，修改密码
 */
@RestController
@RequestMapping("/api")
@Tag(name = "登录", description = "通用返回对象")
public class UtsLoginController extends BaseController {

    public static Cache<String, String> fifoCache = CacheUtil.newTimedCache(6000);

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UtsUserDetailsService utsUserDetailsService;

    @NotRole
    @PostMapping("/authenticate")
    public String authorize(@RequestBody UtsLoginParam loginParam) {

        String username = loginParam.getUsername();
        String password = loginParam.getPassword();

        UtsAuthorDto authorDto = utsUserDetailsService.loadUserByUsername(username);
        if (authorDto == null) {
            throw new ApiException("用户不存在！");
        }

        if (!BCrypt.checkpw(password, authorDto.getPassword())) {
            throw new ApiException("密码错误！");
        }
        return jwtProvider.createToken(authorDto, true);

    }

    @NotRole
    @PostMapping("/refresh")
    public String refresh(@RequestBody JSONObject jsonObject) {
        String jwt = jsonObject.getString("jwt");
        if (jwtProvider.validateToken(jwt)) {
            UtsAuthorDto authorDto = jwtProvider.getAuthentication(jwt);
            UtsAuthorDto author = utsUserDetailsService.loadUserByUsername(authorDto.getUsername());
            return jwtProvider.createToken(author, true);
        }
        throw new ApiException("无效token！");
    }

    @NotRole
    @PostMapping("register")
    public String register(@RequestBody UtsRegisterParam param) {
        String mail = param.getMail();
        if (Validator.isEmail(mail)) {
            Boolean isTrue = authorService.selectMailIsTrue(mail);
            if (isTrue) {
                throw new ApiException("邮箱以存在！");
            }
            UtsAuthor author = BeanUtil.toBean(param, UtsAuthor.class);
            String password = param.getPassword();
            author.setPassword(BCrypt.hashpw(password));
            author.setMail(mail);
            author.setRefreshTime(DateUtil.date());
            author.setUpdateTime(DateUtil.date());
            UtsAuthor utsAuthor = authorService.insertAuthor(author);
            if (utsAuthor != null) {
                return "注册成功！";
            }
            throw new ApiException("注册失败！");
        } else {
            throw new ApiException("请输入邮箱号！");
        }
    }

    @NotRole
    @PostMapping("password")
    public String updatePassword(@RequestBody UtsRePasswordParam param) {
        String mail = param.getMail();
        Boolean isTrue = authorService.selectMailIsTrue(mail);
        if (!isTrue) {
            throw new ApiException("邮箱不存在！");
        }
        String code = fifoCache.get(mail);
        if (code == null) {
            throw new ApiException("没有发送邮箱号！");
        }
        if (StrUtil.equals(code, param.getCode())) {
            String password = param.getPassword();
            UtsAuthor update = authorService.updatePassword(authorId(), BCrypt.hashpw(password));
            if (update != null) {
                return "修改成功！";
            }
        }
        throw new ApiException();
    }

}
