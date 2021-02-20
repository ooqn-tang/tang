package net.ttcxy.tang.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目的所有页面跳转
 * @author huanglei
 */
@Controller
@Api("项目的所有页面跳转")
public class StsPageController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsAuthorService authorService;

    @GetMapping
    @ApiOperation("首页")
    public String toHome(){
        return "index";
    }

    @GetMapping("login.html")
    @ApiOperation("登录")
    public String toBlogList(){
        return "login";
    }


    @GetMapping("so")
    @ApiOperation("搜索跳转页面")
    public String toSearch(){
        return "index";
    }

    @GetMapping("author/{username}")
    @ApiOperation("作者页面")
    public ModelAndView toUserHome(@PathVariable("username")String username, ModelAndView modelAndView){
        UtsAuthorLogin utsAuthorLogin = authorService.selectAuthorByName(username);
        if (utsAuthorLogin == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }
        modelAndView.setViewName("author");
        modelAndView.addObject(utsAuthorLogin);
        return modelAndView;
    }


    @GetMapping("author/setting")
    @ApiOperation("更改用户信息页面")
    public ModelAndView updateUser(ModelAndView modelAndView){
        modelAndView.setViewName("setting");
        modelAndView.addObject(currentAuthorService.getAuthor());
        return modelAndView;
    }

}
