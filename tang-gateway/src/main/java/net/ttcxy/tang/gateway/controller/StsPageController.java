package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.entity.dto.DtsBlogDto;
import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.service.CurrentMemberService;
import net.ttcxy.tang.service.DtsBlogService;
import net.ttcxy.tang.service.UtsMemberService;
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
    private CurrentMemberService currentMemberService;

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private UtsMemberService authorService;

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
        model.addAttribute(blogService.getBlogList(page));
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
        UtsMemberLogin utsMemberLogin = authorService.selectMemberByName(username);
        if (utsMemberLogin == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }
        modelAndView.setViewName("author");
        modelAndView.addObject(utsMemberLogin);
        return modelAndView;
    }

    /**
     * 文章页面
     */
    @GetMapping("post/{id}")
    public ModelAndView toBlog(@PathVariable("id")String blogId, ModelAndView modelAndView){

        UtsMemberLogin utsMemberLogin = currentMemberService.getMember();

        DtsBlogDto dtsBlogDto = blogService.selectBlogById(blogId);

        if (dtsBlogDto == null){
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("404");
            return modelAndView;
        }

        if (utsMemberLogin !=null){
            String userId = utsMemberLogin.getId();
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
        modelAndView.addObject(currentMemberService.getMember());
        return modelAndView;
    }

    /**
     * 更新博客编辑器
     */
    @GetMapping("editor/{id}")
    public ModelAndView toEditor(ModelAndView modelAndView,@PathVariable("id") String id){
        modelAndView.setViewName("editor");
        return modelAndView;
    }

    @Autowired
    private CurrentMemberService currentMemberServiceImpl;

    /**
     * 添加博客编辑器
     */
    @GetMapping("editor")
    public String toEditor(){
        DtsBlog blog = new DtsBlog();

        DateTime date = DateUtil.date();
        String memberId = currentMemberServiceImpl.getMemberId();
        String uuid = IdUtil.fastSimpleUUID();

        blog.setId(uuid);
        blog.setUserId(memberId);
        blog.setUpdateDate(date);
        blog.setCreateDate(date);
        blog.setStateId(2);

        int count = blogService.insertBlog(blog);
        if (count > 0){
            return "redirect:/editor/" + uuid;
        }

        return "alert('添加失败')";
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
