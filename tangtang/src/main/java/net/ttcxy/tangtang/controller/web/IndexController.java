package net.ttcxy.tangtang.controller.web;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.impl.AdvertisementServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private BlogService blogService;

    @Autowired
    private AdvertisementServiceImpl advertisementService;

    @GetMapping({"index","blog",""})
    public String toBlog( Model model,
                          @RequestParam(name = "cls", required = false)String cls,
                          @RequestParam(name = "pag", required = false)Integer pag){

        model.addAttribute("blogList",blogService.selectBlog(cls,pag));
        model.addAttribute("clss",blogService.optionList());
        model.addAttribute("advertises",advertisementService.selectAllAdvertisement());
        return "page/blog";

    }

}
