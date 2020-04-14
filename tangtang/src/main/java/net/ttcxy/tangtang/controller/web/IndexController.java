package net.ttcxy.tangtang.controller.web;

import net.ttcxy.tangtang.service.AdvertisementService;
import net.ttcxy.tangtang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Index页面跳转
 * @author ：HuangLei
 * @date ：2019/12/11 0011 21:55
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    AdvertisementService advertisementService;

    /**
     * 博客列表页面
     * @return page
     */
    @GetMapping({"index","blog",""})
    public ModelAndView toBlog(@RequestParam(name = "cls", required = false)String cls,
                               @RequestParam(name = "pg", required = false)Integer pg,
                               @RequestParam(name = "s", required = false)String s){

        ModelAndView modelAndView = new ModelAndView("page/blogList");
        modelAndView.addObject("clss",blogService.optionList());

        if (s!=null){
            modelAndView.addObject("blogs",blogService.search(s,pg));
        }else{
            modelAndView.addObject("blogs",blogService.selectBlog(cls,pg));
        }

        return modelAndView;
    }

}
