package net.ttcxy.tangtang.controller.api;

import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.UserService;
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
