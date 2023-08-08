package com.ooqn.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.security.NotRole;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/system")
@Tag(name = "系统")
public class StsSystemController {

    @NotRole
    @PostMapping("/init")
    public void init(@RequestParam Map<String, String> params) {
        
    }
    
}
