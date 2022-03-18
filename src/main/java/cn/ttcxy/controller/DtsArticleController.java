package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.param.DtsArticleParam;
import cn.ttcxy.service.CtsCoinService;
import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.DtsViewService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/article")
public class DtsArticleController extends BaseController{

    @Autowired
    private DtsArticleService articleService;

    @Autowired
    private CtsCoinService coinService;

    @Autowired
    private DtsViewService viewService;

    @GetMapping("search")
    public ResponseEntity<PageInfo<DtsArticleDto>> searchArticleList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "title" ,defaultValue = "")String title){
        PageInfo<DtsArticleDto> articleList = articleService.search(title, page, 10);
        return ResponseEntity.ok(articleList);
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsArticleDto>> selectArticleList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "tag",defaultValue = "")String tagName){
        PageInfo<DtsArticleDto> articleList = articleService.selectArticleList(tagName,page, 10);
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

    @DeleteMapping("{articleId}")
    public ResponseEntity<String> delete(@PathVariable("articleId") String articleId){
        DtsArticle article = articleService.selectByPrimaryId(articleId);
        if (article == null){
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }
        String articleAuthorId = article.getAuthorId();
        String currentAuthorId = authorId();
        int count;

        if(StrUtil.equals(currentAuthorId,articleAuthorId)){
            count = articleService.deleteArticle(articleId);
            if(count > 0){
                return ResponseEntity.ok("处理成功");
            }
        }else{
            throw new ApiException("不能删除别入的文章");
        }
        throw new ApiException(HttpStatus.ACCEPTED);

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

    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Validated DtsArticleParam articleParam){
        DtsArticle article = BeanUtil.toBean(articleParam, DtsArticle.class);
        article.setState(1);

        List<String> tagIdList = articleParam.getTagIdList();
        String subjectId = articleParam.getSubjectId();
        // 当前博客信息
        DtsArticleDto articleDto = articleService.selectArticleById(article.getArticleId());
        if (articleDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String thisArticleUsername = articleDto.getUsername();

        String username = authorName();
        if (StrUtil.equals(username,thisArticleUsername)){
            DateTime date = DateUtil.date();
            article.setUpdateDate(date);
            int count = articleService.updateArticle(article,subjectId,tagIdList,authorId());
            if (count > 0){
                return ResponseEntity.ok(article.getArticleId());
            }
        }
        throw new ApiException(ResponseCode.FORBIDDEN);
    }




    @GetMapping("load/{articleId}")
    public ResponseEntity<DtsArticleDto> load(@PathVariable(name="articleId") String articleId){
        DtsArticleDto articleDto = articleService.selectArticleById(articleId);
        if (articleDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }

        // 每日使用获取金币
        coinService.useCoin(authorId());
        // 记录
        if (isLogin()){
            viewService.insertView(articleId,authorId());
        }

        return ResponseEntity.ok(articleDto);
    }

    @GetMapping("load/{articleId}/all")
    public ResponseEntity<DtsArticleDto> loadAll(@PathVariable(name = "articleId") String articleId){
        DtsArticleDto articleDto = articleService.selectArticleAllById(articleId);
        if (articleDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        return ResponseEntity.ok(articleDto);
    }
}
