package net.ttcxy.tang.portal.controller;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.dto.DtsArticleSubjectDto;
import net.ttcxy.tang.portal.service.DtsArticleService;
import net.ttcxy.tang.portal.service.DtsArticleSubjectService;
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
    private DtsArticleService articleService;

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @GetMapping
    public String toIndex(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        PageInfo<DtsArticleDto> dtsArticleDtoPageInfo = articleService.selectArticleList("", page, 50);
        model.addAttribute("articlePage", dtsArticleDtoPageInfo);
        return "articles";
    }

    @GetMapping("article/{id}")
    public String toArticle(@PathVariable("id") String id, Model model) {
        DtsArticleDto articleDto = articleService.selectArticleById(id);
        model.addAttribute("article", articleDto);
        String subjectId = articleSubjectService.selectSubjectIdByArticleId(id);
        model.addAttribute("subject", articleSubjectService.selectSubjectArticleListById(subjectId));
        return "article";
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
