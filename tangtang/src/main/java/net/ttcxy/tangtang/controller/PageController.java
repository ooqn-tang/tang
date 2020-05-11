package net.ttcxy.tangtang.controller;

import net.ttcxy.tangtang.entity.UserDto;
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

    @Autowired
    private AuthDetailsImpl authDetails;

    /**
     * 首页
     */
    @GetMapping("")
    public ModelAndView toHome(@RequestParam(name = "pg", defaultValue = "1")Integer pg,
                               ModelAndView modelAndView){

        modelAndView.setViewName("home");
        modelAndView.addObject("blogs",blogService.selectBlog(pg));

        return modelAndView;
    }

    /**
     * 搜索跳转页面
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
     * 作者页面
     */
    @GetMapping("author/{username}")
    public ModelAndView toUserHome(@PathVariable("username")String username, ModelAndView modelAndView){
        modelAndView.setViewName("userhome");
        modelAndView.addObject("user",userService.selectUserByName(username));
        return modelAndView;
    }

    /**
     * 作者列表页面
     */
    @GetMapping("authors")
    public  ModelAndView toAuthors(ModelAndView modelAndView){
        modelAndView.setViewName("authors");
        return modelAndView;
    }




    /**
     * 文章页面
     */
    @GetMapping("post/{id}")
    public ModelAndView toBlog(@PathVariable("id")String blogId,
                               ModelAndView modelAndView){
        modelAndView.setViewName("blog");
        UserDto userDto = authDetailsImpl.getUser();

        String userId;

        if (userDto !=null){
            userId = userDto.getId();
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

    /**
     * 更改用户信息页面
     */
    @GetMapping("userinfo")
    public ModelAndView updateUser(ModelAndView modelAndView){
        modelAndView.setViewName("userinfo");
        modelAndView.addObject("user",authDetails.getUser());
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
        modelAndView.addObject("user",authDetails.getUser());
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

    /**
     * 编辑器
     */
    @GetMapping("editor2")
    public ModelAndView toEditor2(ModelAndView modelAndView){
        modelAndView.setViewName("editor2");
        return modelAndView;
    }



}
