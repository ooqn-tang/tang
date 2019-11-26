package net.ttcxy.tangtang.controller.web;

import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关操作
 */
@Controller
public class UserController {

    //用户home页
    @GetMapping("user/{username}")
    public String toUserHome(@PathVariable("username")String username, Model model){
        model.addAttribute("username",username);
        return "page/userhome";
    }

    @GetMapping("register")
    public String toRegister(){
        return "register";
    }


    //登录

    //注册
    @GetMapping("register.html")
    public String register(){
        return "register";

    }

    @PostMapping("register")
    @ResponseBody
    public ResponseData register(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("password1") String password1,
                                 @RequestParam("mail") String mail){

        System.out.println(String.format("%s%s%s%s",username,password,password1,mail));

        return ResponseData.successful("OK");
    }



    //退出

    //点赞

    //评论

    //收藏

    //举报

}
