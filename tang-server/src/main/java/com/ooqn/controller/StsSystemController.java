package com.ooqn.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "api/open/**")
    public void allPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String url = request.getRequestURI();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> map = new HashMap<>();

        parameterMap.forEach((k,v) -> {
            map.put(k, v[0]);
        });

        Map<String,Object> params = new HashMap<>();
        params.put("request", map);

        System.out.println();
        String run = templateService.run(url, params);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(run);

    }
    
}
