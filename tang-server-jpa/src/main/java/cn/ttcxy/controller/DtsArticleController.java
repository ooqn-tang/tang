package cn.ttcxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.param.DtsArticleParam;
import cn.ttcxy.service.DtsArticleService;

@RestController
@RequestMapping("api/article")
public class DtsArticleController extends BaseController {

    @Autowired
    private DtsArticleService articleService;

    @GetMapping("list")
    public PageInfo<DtsArticleDto> selectArticleList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "classId",defaultValue = "")String classId){
        PageInfo<DtsArticleDto> articleList;
        if(StrUtil.equals("gz",classId)){
            articleList = articleService.selectGzArticleList(classId, page, authorId());
        }else{
            articleList = articleService.selectArticleList(classId, page, 10);
        }

        return articleList;
    }

    @GetMapping("list/{username}")
    public ResponseEntity<PageInfo<DtsArticleDto>> selectArticleListByUsername(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @PathVariable(value = "username")String username){
        PageInfo<DtsArticleDto> articleList = articleService.selectArticleByAuthorName(username, page, 10);
        return ResponseEntity.ok(articleList);
    }

    @GetMapping("recommend")
    public ResponseEntity<List<DtsArticleDto>> selectArticleListRecommend(){
        return ResponseEntity.ok(articleService.selectArticleListRandom());
    }

    @PostMapping
    public ResponseEntity<String> create(){
        DateTime dateTime = new DateTime();
        String authorId = authorId();
        DtsArticle article = new DtsArticle();
        article.setArticleId(IdUtil.objectId());
        article.setCreateDate(dateTime);
        article.setUpdateDate(dateTime);
        article.setState(5);
        article.setAuthorId(authorId);
        if (articleService.insertArticle(article) != null){
            return ResponseEntity.ok(article.getArticleId());
        }
        throw new ApiException(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{articleId}")
    public ResponseEntity<String> delete(@PathVariable("articleId") String articleId){
        String authorId = articleService.authorId(articleId);
        if (StrUtil.equals(authorId,authorId())){
            articleService.deleteByArticleIdAndAuthorId(articleId, authorId());
        }
        return ResponseEntity.ok("处理成功");
    }

    @PutMapping
    public String update(@RequestBody DtsArticleParam articleParam){
        DtsArticle article = BeanUtil.toBean(articleParam, DtsArticle.class);
        String articleId = article.getArticleId();
        String authorId= articleService.authorId(articleId);
        if (StrUtil.equals(authorId, authorId())){
            article.setState(1);
            DtsArticleContent articleContent = new DtsArticleContent();
            articleContent.setArticleId(article.getArticleId());
            articleContent.setMarkdown(articleParam.getMarkdown());
            articleContent.setText(articleParam.getText());
            article.setAuthorId(authorId);
            DtsArticle dtsArticle = articleService.updateArticle(article, articleContent);
            if (dtsArticle != null){
                return ResponseCode.SUCCESS.getMessage();
            }
        }
        throw new ApiException(ResponseCode.FORBIDDEN);
    }

    @GetMapping("load/{articleId}")
    public DtsArticleDto load(@PathVariable(name="articleId") String articleId){
        return articleService.selectArticleById(articleId);
    }

    @GetMapping("load/{articleId}/all")
    public DtsArticleDto loadAll(@PathVariable(name = "articleId") String articleId){
        DtsArticleDto articleDto = articleService.selectArticleAllById(articleId);
        if (articleDto == null){
            throw new ApiException();
        }
        return articleDto;
    }

    @GetMapping("so")
    public PageInfo<?> search(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam("wb") String wb){
        return articleService.search(wb,page,10);
    }
}
