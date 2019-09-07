package com.jnnvc.vblog.controller.web;

import cn.hutool.core.util.StrUtil;
import com.jnnvc.vblog.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Web项目用于页面跳转，普通用户页面的跳转
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogService blogServiceImpl;

    @GetMapping({"index","blog",""})
    public String toBlog( Model model,@RequestParam(name = "cls", required = false)String cls){

        if (StrUtil.isBlank(cls)){
            model.addAttribute("blogList",blogServiceImpl.selectBlog());
        }else{
            model.addAttribute("blogList",blogServiceImpl.selectBlogCls(cls));
        }

        return "page/blog";
    }

}
