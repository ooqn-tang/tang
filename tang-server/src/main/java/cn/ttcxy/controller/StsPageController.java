package cn.ttcxy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.DtsArticleSubjectService;
import cn.ttcxy.service.StsNoticeService;

@Controller
@RequestMapping
public class StsPageController {

    @Autowired
    private DtsArticleService articleService;

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @Autowired
    private StsNoticeService noticeService;

    @GetMapping
    public String toIndex(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model,HttpServletRequest request) {
        Pageable pageable = PageRequest.of(page,50);
        Page<DtsArticleDto> dtsArticleDtoPageInfo = articleService.selectArticleListSmall(pageable);
        model.addAttribute("articlePage", dtsArticleDtoPageInfo);
        model.addAttribute("notice", noticeService.selectAllNotice());
        System.out.println(JSONObject.toJSONString(dtsArticleDtoPageInfo));
        return "articles";
    }

    @GetMapping("article/{id}")
    public String toArticle(@PathVariable("id") String id, Model model) {
        DtsArticleDto articleDto = articleService.selectArticleById(id);
        model.addAttribute("article", articleDto);
        String subjectId = articleSubjectService.findSubjectIdByArticleId(id);
        
        if(subjectId!=null){
            DtsArticleSubjectDto selectSubjectArticleListById = articleSubjectService.findSubjectArticleListBySubjectId(subjectId);
            model.addAttribute("subject", selectSubjectArticleListById);
        }
       
        model.addAttribute("notice", noticeService.selectAllNotice());
        return "article";
    }

    @GetMapping("map")
    public String map(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 15);
        Page<DtsArticleDto> dtsArticleDtoPage = articleService.selectArticleList(pageable);
        model.addAttribute("articlePage", dtsArticleDtoPage);
        return "map";
    }

    @GetMapping("subject/{id}")
    public String subject(@PathVariable("id") String id, Model model){
        DtsArticleSubjectDto dtsArticleSubjectDto = articleSubjectService.findSubjectArticleListBySubjectId(id);
        model.addAttribute("subject", dtsArticleSubjectDto);
        return "subject";
    }

    @GetMapping("subjects")
    public String subjects(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model){
        Pageable pageable = PageRequest.of(page, 50);
        Page<DtsArticleSubjectDto> dtsArticleSubjectDtoPageInfo = articleSubjectService.selectSubjectList(pageable);
        model.addAttribute("subjects", dtsArticleSubjectDtoPageInfo);
        return "subjects";
    }
}
