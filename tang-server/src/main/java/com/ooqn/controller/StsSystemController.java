package com.ooqn.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.service.StsCodeService;
import com.ooqn.service.UtsAuthorService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/system")
@Tag(name = "系统")
public class StsSystemController {

    @Autowired
    private StsCodeService codeService;

    @Autowired
    private UtsAuthorService authorService;

    
    // init 提交保存 ，form表单提交，参数为json格式
    @PostMapping("/init")
    public void init(@RequestParam Map<String, String> params) {
        
        String systemName = params.get("systemName");
        String systemDescription = params.get("systemDescription");
        String adminName = params.get("adminName");
        String adminPassword = params.get("adminPassword");
        String adminEmail = params.get("adminEmail");

        codeService.insertCode("systemName", systemName);
        codeService.insertCode("systemDescription", systemDescription);

        UtsAuthor author = new  UtsAuthor();
        author.setAuthorId(IdUtil.objectId());
        author.setUsername(adminName);
        author.setPassword(new BCryptPasswordEncoder().encode(adminPassword));
        author.setCreateTime(DateUtil.date());
        author.setNickname(adminName);
        author.setRefreshTime(DateUtil.date());
        author.setMail(adminEmail);

        authorService.insertAuthor(author);
    }
    
    
}
