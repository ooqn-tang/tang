package net.ttcxy.tang.gateway.controller;

import net.ttcxy.tang.gateway.entity.BlogDto;
import net.ttcxy.tang.gateway.entity.UserDto;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.service.BlogService;
import net.ttcxy.tang.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private AuthDetailsService authDetailsServiceImpl;

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    /**
     * 首页
     */
    @GetMapping
    public String toHome(){
        return "index";
    }

    /**
     * 地图
     */
    @GetMapping("map")
    public String toMap(Model model,@RequestParam(defaultValue = "1") Integer page){
        model.addAttribute(blogService.showDt(page));
        return "map";
    }

    /**
     * 注册页面
     */
    @GetMapping("register")
    public String toRegister(){
        return "register";
    }



    /**
     * 搜索跳转页面
     */
    @GetMapping("so")
    public String toSearch(){
        return "index";
    }

    /**
     * 作者页面
     */
    @GetMapping("author/{username}")
    public ModelAndView toUserHome(@PathVariable("username")String username, ModelAndView modelAndView){
        UserDto userDto = userService.selectUserByName(username);
        if (userDto == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }
        modelAndView.setViewName("home");
        modelAndView.addObject("user",userDto);
        return modelAndView;
    }

    /**
     * 文章页面
     */
    @GetMapping("post/{id}")
    public ModelAndView toBlog(@PathVariable("id")String blogId, ModelAndView modelAndView){

        UserDto userDto = authDetailsServiceImpl.getUser();

        BlogDto blogDto = blogService.selectBlogById(blogId);

        if (blogDto == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }

        if (userDto !=null){
            String userId = userDto.getId();
            // 如果用户没有登陆，不需要查询是否喜欢或收藏
            // 是否喜欢了当前博客
            modelAndView.addObject("like",blogService.selectLike(userId,blogId));
        }

        //添加博客到试图中
        modelAndView.addObject("blog",blogDto);

        modelAndView.addObject("random",blogService.random());

        modelAndView.setViewName("blog");
        return modelAndView;
    }

    /**
     * 更改用户信息页面
     */
    @GetMapping("user/info")
    public ModelAndView updateUser(ModelAndView modelAndView){
        modelAndView.setViewName("info");
        modelAndView.addObject("user",authDetailsServiceImpl.getUser());
        return modelAndView;
    }

    /**
     * 登陆页面
     */
    @GetMapping("login")
    public ModelAndView toLogin( ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * 更改密码页面
     */
    @GetMapping("password")
    public ModelAndView toUpdatePwd(ModelAndView modelAndView){
        modelAndView.setViewName("password");
        modelAndView.addObject("user",authDetailsServiceImpl.getUser());
        return modelAndView;
    }

    /**
     * 编辑器
     */
    @GetMapping("editor")
    public ModelAndView toEditor(ModelAndView modelAndView){
        modelAndView.setViewName("editor");
        return modelAndView;
    }

}
