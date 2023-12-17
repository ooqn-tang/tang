package com.ooqn.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.security.NotLogin;
import com.ooqn.service.StsTemplateService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
@Tag(name = "系统")
public class StsSystemController {

    @Autowired
    private StsTemplateService templateService;

    @NotLogin
    @PostMapping("api/system/init")
    public void init(@RequestParam Map<String, String> params) {
        
    }

    // 所有页面
    @NotLogin
    @GetMapping(value = "tool/{toolName}")
    public void allPage(@PathVariable("toolName") String toolName, HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(templateService.run(toolName));
    }
    
}
