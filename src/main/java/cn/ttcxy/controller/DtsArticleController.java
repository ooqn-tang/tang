package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsDynamic;
import cn.ttcxy.entity.param.DtsArticleParam;
import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.DtsDynamicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/article")
public class DtsArticleController extends BaseController {

    @Autowired
    private DtsArticleService articleService;

    @Autowired
    private DtsDynamicService dynamicService;

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsArticleDto>> selectArticleList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "classId",defaultValue = "")String classId){
        PageInfo<DtsArticleDto> articleList = articleService.selectArticleList(classId, page, 10);
        return ResponseEntity.ok(articleList);
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
        if (articleService.insertArticle(article) > 0){
            return ResponseEntity.ok(article.getArticleId());
        }
        throw new ApiException(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{articleId}")
    public ResponseEntity<String> delete(@PathVariable("articleId") String articleId){
        String authorId = articleService.authorId(articleId);
        if (StrUtil.equals(authorId,authorId())){
            int count = articleService.deleteArticle(articleId, authorId());
            if(count > 0){
                return ResponseEntity.ok("处理成功");
            }
        }
        throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody DtsArticleParam articleParam){
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
            int count  = articleService.updateArticle(article,articleContent);
            if (count > 0){
                return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
            }
        }
        throw new ApiException(ResponseCode.FORBIDDEN);
    }

    @GetMapping("load/{articleId}")
    public ResponseEntity<DtsArticleDto> load(@PathVariable(name="articleId") String articleId){
        DtsArticleDto article = articleService.selectArticleById(articleId);
        if (article == null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(article);
    }

    @GetMapping("load/{articleId}/all")
    public ResponseEntity<DtsArticleDto> loadAll(@PathVariable(name = "articleId") String articleId){
        DtsArticleDto articleDto = articleService.selectArticleAllById(articleId);
        if (articleDto == null){
            throw new ApiException();
        }
        return ResponseEntity.ok(articleDto);
    }
}
