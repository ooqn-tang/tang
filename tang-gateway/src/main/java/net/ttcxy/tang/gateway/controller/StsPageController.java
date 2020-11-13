package net.ttcxy.tang.gateway.controller;

import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.gateway.code.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsBlogService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
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
 * @author huanglei
 */
@Controller
public class StsPageController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private UtsAuthorService authorService;

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
        UtsAuthorLogin utsAuthorLogin = authorService.selectUserByName(username);
        if (utsAuthorLogin == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }
        modelAndView.setViewName("author");
        modelAndView.addObject(utsAuthorLogin);
        return modelAndView;
    }

    /**
     * 文章页面
     */
    @GetMapping("post/{id}")
    public ModelAndView toBlog(@PathVariable("id")String blogId, ModelAndView modelAndView){

        UtsAuthorLogin utsAuthorLogin = currentAuthorService.getAuthor();

        DtsBlogDto dtsBlogDto = blogService.selectBlogById(blogId);

        if (dtsBlogDto == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }

        if (utsAuthorLogin !=null){
            String userId = utsAuthorLogin.getId();
            // 是否喜欢了当前博客
            modelAndView.addObject("like",blogService.selectLike(userId,blogId));
        }

        //添加博客到试图中
        modelAndView.addObject(dtsBlogDto);

        modelAndView.addObject("random",blogService.random());

        modelAndView.setViewName("blog");
        return modelAndView;
    }

    /**
     * 更改用户信息页面
     */
    @GetMapping("author/setting")
    public ModelAndView updateUser(ModelAndView modelAndView){
        modelAndView.setViewName("setting");
        modelAndView.addObject(currentAuthorService.getAuthor());
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
    @GetMapping("fast")
    public ModelAndView toFast(ModelAndView modelAndView){
        modelAndView.setViewName("fast");
        return modelAndView;
    }
    /**
     * 视频
     */
    @GetMapping("navigation")
    public ModelAndView toNavigation(ModelAndView modelAndView){
        modelAndView.setViewName("navigation");
        return modelAndView;
    }

}
