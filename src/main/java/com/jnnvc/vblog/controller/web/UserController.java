package com.jnnvc.vblog.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关操作
 */
@Controller
@RequestMapping("user")
public class UserController {

    //用户home页
    @GetMapping("{username}")
    public String toUserHome(@PathVariable("username")String username){

        return "page/userhome";
    }


    //登录

    //注册

    //退出

    //点赞

    //评论

    //收藏

    //举报

}
