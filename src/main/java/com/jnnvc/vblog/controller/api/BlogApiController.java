package com.jnnvc.vblog.controller.api;

import com.jnnvc.vblog.service.BlogService;
import com.jnnvc.vblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/blog")
public class BlogApiController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;





    //删除blog

    //程序blog

}
