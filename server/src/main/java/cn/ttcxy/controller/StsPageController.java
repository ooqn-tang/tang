package cn.ttcxy.controller;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.DtsArticleSubjectService;
import cn.ttcxy.service.StsNoticeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String toIndex(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        PageInfo<DtsArticleDto> dtsArticleDtoPageInfo = articleService.selectArticleListSmall(page, 50);
        model.addAttribute("articlePage", dtsArticleDtoPageInfo);
        model.addAttribute("notice", noticeService.selectAllNotice());
        return "articles";
    }

    @GetMapping("article/{id}")
    public String toArticle(@PathVariable("id") String id, Model model) {
        DtsArticleDto articleDto = articleService.selectArticleById(id);
        model.addAttribute("article", articleDto);
        String subjectId = articleSubjectService.selectSubjectIdByArticleId(id);
        
        if(subjectId!=null){
            DtsArticleSubjectDto selectSubjectArticleListById = articleSubjectService.selectSubjectArticleListById(subjectId);
            model.addAttribute("subject", selectSubjectArticleListById);
        }
       
        model.addAttribute("notice", noticeService.selectAllNotice());
        return "article";
    }

    @GetMapping("map")
    public String map(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        PageInfo<DtsArticleDto> dtsArticleDtoPageInfo = articleService.selectArticleList("", page, 50);
        model.addAttribute("articlePage", dtsArticleDtoPageInfo);
        return "map";
    }

    @GetMapping("subject/{id}")
    public String subject(@PathVariable("id") String id, Model model){
        DtsArticleSubjectDto dtsArticleSubjectDto = articleSubjectService.selectSubjectArticleListById(id);
        model.addAttribute("subject", dtsArticleSubjectDto);
        return "subject";
    }

    @GetMapping("subjects")
    public String subjects(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model){
        PageInfo<DtsArticleSubjectDto> dtsArticleSubjectDtoPageInfo = articleSubjectService.selectSubjectList(page,50);
        model.addAttribute("subjects", dtsArticleSubjectDtoPageInfo);
        return "subjects";
    }
}
