package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.model.DtsBlog;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
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
@Api("项目的所有页面跳转")
public class StsPageController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

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

    @GetMapping("map")
    @ApiOperation("地图 页面")
    public String toMap(Model model,@RequestParam(defaultValue = "1") Integer page){
        model.addAttribute(blogService.getBlogList(page,150));
        return "map";
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

    @GetMapping("post/{id}")
    @ApiOperation("文章页面")
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

    @GetMapping("author/setting")
    @ApiOperation("更改用户信息页面")
    public ModelAndView updateUser(ModelAndView modelAndView){
        modelAndView.setViewName("setting");
        modelAndView.addObject(currentAuthorService.getAuthor());
        return modelAndView;
    }

    @GetMapping("editor/{id}")
    @ApiOperation("更新博客编辑器")
    public ModelAndView toEditor(ModelAndView modelAndView,@PathVariable("id") String id){
        modelAndView.addObject("blogId",id);
        modelAndView.setViewName("editor");
        return modelAndView;
    }

    @GetMapping("editor")
    @ApiOperation("添加博客编辑器")
    public String toEditor(){
        DtsBlog blog = new DtsBlog();

        DateTime date = DateUtil.date();
        String memberId = currentAuthorServiceImpl.getAuthorId();
        String uuid = IdUtil.fastSimpleUUID();

        blog.setId(uuid);
        blog.setUserId(memberId);
        blog.setUpdateDate(date);
        blog.setCreateDate(date);
        blog.setStateCode(1002);

        int count = blogService.insertBlog(blog);
        if (count > 0){
            return "redirect:/editor/" + uuid;
        }

        return "alert('添加失败')";
    }

    @GetMapping("fast")
    @ApiOperation("编辑器")
    public ModelAndView toFast(ModelAndView modelAndView){
        modelAndView.setViewName("fast");
        return modelAndView;
    }

}
