package com.jnnvc.vblog.controller.web;

import com.jnnvc.vblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Web项目用于页面跳转，普通用户页面的跳转
 */
@Controller
public class PageController {

    @GetMapping("index")
    public String toIndex(){
        System.out.println("进入Index.html");
        return "index";
    }

    @Autowired
    private BlogService blogServiceImpl;

    @GetMapping("blog")
    public String toBlog( Model model){
        System.out.println("进入blog.html");
        model.addAttribute("blogList",blogServiceImpl.selectBlog());
        return "page/blog";
    }



    @GetMapping("vibo")
    public String toVibo(){
        System.out.println("进入vibo.html");
        return "page/vibo";
    }

    @GetMapping("vlog")
    public String toVlog(){
        System.out.println("进入vlog.html");
        return "page/vlog";
    }
    @GetMapping("cyun")
    public String toCyun(){
        System.out.println("进入cyun.html");
        return "page/cyun";
    }

    @GetMapping("editor")
    public String toEditor(){
        System.out.println("进入editor.html");
        return "page/editor";
    }
}
