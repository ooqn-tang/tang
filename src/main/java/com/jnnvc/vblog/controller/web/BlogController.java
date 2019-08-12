package com.jnnvc.vblog.controller.web;

import com.jnnvc.vblog.data.ResponseData;
import com.jnnvc.vblog.entity.Blog;
import com.jnnvc.vblog.service.BlogService;
import com.jnnvc.vblog.service.UserService;
import com.jnnvc.vblog.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * 对博文的增删改查
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    //博客，添加，删除，修改，查询
    //添加博客，
    @PostMapping("add")
    @ResponseBody
    public ResponseData add(@RequestBody Map<String,String> requestBody, Principal principal){

        String title = requestBody.get("title");
        String text = requestBody.get("text");
        String username = principal.getName();
        String summary = requestBody.get("summary");

        if (ParamUtil.isNullParams(title,text,username,summary))
            return ResponseData.error("参数不全");

        Blog blog = new Blog();
        blog.setUserId(userService.selectUserByName(username).getId());
        blog.setTitle(title);
        blog.setText(text);
        blog.setUsername(username);
        blog.setSummary(summary);
        blog.setTypeId("1");
        blog.setStateId("1");

        return blogService.addBlog(blog)==1?ResponseData.successful("添加成功"):ResponseData.error("添加失败");
    }




    /**
     * 通过博客ID获取博客页面
     * @param blogId
     * @return
     */
    @GetMapping("{blogId}")
    public String toBlogInfo(@PathVariable("blogId") String blogId, Model model){
        Blog blog = blogService.getBlogByUUID(blogId);

        model.addAttribute(blog);
        System.out.println("进入blog.html");
        return "page/blogInfo";
    }

    //删除博客
    @GetMapping("delete/{id}")
    public ResponseData delete(@PathVariable("id") String id){

        return null;
    }

    //删除博客
    @GetMapping("update/{id}")
    public ResponseData update(@PathVariable("id") String id){



        return null;
    }

    //删除博客
    @GetMapping("query/{id}")
    public ResponseData query(@PathVariable("id") String id){



        return null;
    }

    @GetMapping("queryList")
    public ResponseData queryList(@PathVariable("id") String id){



        return null;
    }





}
