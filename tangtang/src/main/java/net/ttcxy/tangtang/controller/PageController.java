package net.ttcxy.tangtang.controller;

import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.UserService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目的所有页面跳转
 * @author leilei
 * @date 2020/05/01
 */
@Controller
public class PageController {

    @Autowired
    private AuthDetailsImpl authDetailsImpl;

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    /**
     * 首页
     * @param pg 页码
     * @param modelAndView modelAndView
     * @return modelAndView
     */
    @GetMapping("")
    public ModelAndView toHome(@RequestParam(name = "pg", required = false)Integer pg,
                               ModelAndView modelAndView){

        modelAndView.setViewName("home");
        modelAndView.addObject("blogs",blogService.selectBlog(pg));

        return modelAndView;
    }

    /**
     * 搜索
     * @param pg 页面
     * @param s 搜索参数
     * @param modelAndView modelAndView
     * @return ModelAndView
     */
    @GetMapping("so")
    public ModelAndView toSearch(@RequestParam(name = "pg", required = false)Integer pg,
                                 @RequestParam(name = "s", required = false)String s ,
                                 ModelAndView modelAndView){
        modelAndView.setViewName("home");
        modelAndView.addObject("blogs",blogService.search(s,pg));
        return modelAndView;
    }

    /**
     * 用户home页
     * @param username username
     * @param modelAndView modelAndView
     * @return modelAndView
     */
    @GetMapping("us/{username}")
    public ModelAndView toUserHome(@PathVariable("username")String username, ModelAndView modelAndView){
        modelAndView.setViewName("userhome");
        modelAndView.addObject("user",userService.selectUserByName(username));
        return modelAndView;
    }




    /**
     * 打开Blog
     * @param blogId blogId
     * @param modelAndView modelAndView
     * @return modelAndView
     */
    @GetMapping("post/{id}")
    public ModelAndView toBlog(@PathVariable("id")String blogId,
                               ModelAndView modelAndView){
        modelAndView.setViewName("blog");
        User user = authDetailsImpl.getUser();

        String userId;

        if (user!=null){
            userId = user.getId();
            // 如果用户没有登陆，不需要查询是否喜欢或收藏
            // 是否喜欢了当前博客
            modelAndView.addObject("like",blogService.selelcLike(userId,blogId));
            // 是否以及该收藏
            modelAndView.addObject("favorite",blogService.selelcFavorite(userId,blogId));
        }else{
            userId = "0";
        }
        //添加博客到试图中
        modelAndView.addObject(blogService.getBlogByUUID(blogId,userId));
        return modelAndView;
    }

    @GetMapping("user")
    public ModelAndView toUserHome( ModelAndView modelAndView){
        modelAndView.setViewName("userhome");
        return modelAndView;
    }

    /**
     * 更改用户信息
     * @param modelAndView
     */
    @GetMapping("uu")
    public ModelAndView toUpdateUser( ModelAndView modelAndView){
        modelAndView.setViewName("userinfo");
        return modelAndView;
    }

    @GetMapping("password")
    public ModelAndView toUpdatePassword( ModelAndView modelAndView){
        modelAndView.setViewName("password");
        return modelAndView;
    }

    @GetMapping("login")
    public ModelAndView toLogin( ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("register")
    public ModelAndView toRegister( ModelAndView modelAndView){
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @GetMapping("editor")
    public ModelAndView toEditor(ModelAndView modelAndView){
        modelAndView.setViewName("editor");
        return modelAndView;
    }

}
