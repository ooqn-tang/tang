package net.ttcxy.tang.gateway.controller;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.gateway.service.DtsBlogService;
import net.ttcxy.tang.gateway.service.DtsBlogSubjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class PageController {

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private DtsBlogSubjectService blogSubjectService;

    @GetMapping({"/",""})
    public String toIndex(){
        return "forward:/index.html";
    }

    @GetMapping("post/{id}")
    public String toBlog(@PathVariable("id") String id, Model model){
        DtsBlogDto blogDto = blogService.selectBlogById(id);
        model.addAttribute("blog",blogDto);

        String subjectId = blogSubjectService.selectSubjectIdByBlogId(id);
        model.addAttribute("subject",blogSubjectService.selectSubjectBlogListById(subjectId));
        return "blog";
    }

    @GetMapping("map")
    public String map(@RequestParam(value = "page",defaultValue = "1") Integer page, Model model){
        PageInfo<DtsBlogDto> dtsBlogDtoPageInfo = blogService.selectBlogList("", page, 50);
        model.addAttribute("blogPage",dtsBlogDtoPageInfo);
        return "map";
    }
}
