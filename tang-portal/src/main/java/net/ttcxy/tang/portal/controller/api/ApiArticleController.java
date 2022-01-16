package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.model.DtsArticle;
import net.ttcxy.tang.portal.entity.param.DtsArticleParam;
import net.ttcxy.tang.portal.service.DtsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/article")
public class ApiArticleController {

    @Autowired
    private DtsArticleService articleService;

    @GetMapping("search")
    public ResponseResult<PageInfo<DtsArticleDto>> searchArticleList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "title" ,defaultValue = "")String title){
        PageInfo<DtsArticleDto> articleList = articleService.search(title, page, 10);
        return ResponseResult.success(articleList);
    }

    @GetMapping("list")
    public ResponseResult<PageInfo<DtsArticleDto>> selectArticleList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "tag",defaultValue = "")String tagName){
        PageInfo<DtsArticleDto> articleList = articleService.selectArticleList(tagName,page, 10);
        return ResponseResult.success(articleList);
    }

    @GetMapping("list/{username}")
    public ResponseResult<PageInfo<DtsArticleDto>> selectArticleListByUsername(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @PathVariable(value = "username")String username){
        PageInfo<DtsArticleDto> articleList = articleService.selectArticleByAuthorName(username, page, 10);
        return ResponseResult.success(articleList);
    }

    @GetMapping("recommend")
    public ResponseResult<List<DtsArticleDto>> selectArticleListRecommend(){
        return ResponseResult.success(articleService.selectArticleListRandom());
    }

    @DeleteMapping("{articleId}")
    public ResponseResult<String> delete(@PathVariable("articleId") String articleId){
        DtsArticle article = articleService.selectByPrimaryId(articleId);
        if (article == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String articleAuthorId = article.getAuthorId();
        String currentAuthorId = CurrentUtil.id();
        int count;

        if(StrUtil.equals(currentAuthorId,articleAuthorId)){
            count = articleService.deleteArticle(articleId);
            if(count > 0){
                return ResponseResult.success("处理成功");
            }
        }else{
            throw new ApiException("不能删除别入的文章");
        }

        throw new ApiException(ResponseCode.FAILED);

    }

    @PostMapping
    public ResponseResult<String> create(){

        DateTime dateTime = new DateTime();
        String authorId = CurrentUtil.id();

        DtsArticle article = new DtsArticle();
        article.setArticleId(IdUtil.objectId());
        article.setCreateDate(dateTime);
        article.setUpdateDate(dateTime);
        article.setStateCode(1005);
        article.setAuthorId(authorId);
        if (articleService.insertArticle(article) > 0){
            return ResponseResult.success(article.getArticleId());
        }
        throw new ApiException("创建失败");

    }

    @PutMapping
    public ResponseResult<String> update(@RequestBody @Validated DtsArticleParam articleParam){
        DtsArticle article = BeanUtil.toBean(articleParam, DtsArticle.class);
        article.setStateCode(1001);

        List<String> tagIdList = articleParam.getTagIdList();
        String subjectId = articleParam.getSubjectId();
        // 当前博客信息
        DtsArticleDto articleDto = articleService.selectArticleById(article.getArticleId());
        if (articleDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String thisArticleUsername = articleDto.getUsername();

        String username = CurrentUtil.name();
        if (StrUtil.equals(username,thisArticleUsername)){
            DateTime date = DateUtil.date();
            article.setUpdateDate(date);
            int count = articleService.updateArticle(article,subjectId,tagIdList);
            if (count > 0){
                return ResponseResult.success(article.getArticleId());
            }
        }
        throw new ApiException(ResponseCode.FORBIDDEN);
    }

    @GetMapping("load")
    public ResponseResult<DtsArticleDto> load(@RequestParam(name="articleId") String articleId){
        DtsArticleDto articleDto = articleService.selectArticleById(articleId);
        if (articleDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        return ResponseResult.success(articleDto);
    }

    @GetMapping("load/all")
    public ResponseResult<DtsArticleDto> loadAll(@RequestParam(name = "articleId") String articleId){
        DtsArticleDto articleDto = articleService.selectArticleAllById(articleId);
        if (articleDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        return ResponseResult.success(articleDto);
    }

    @GetMapping("like")
    public ResponseResult<Long> getLike(@RequestParam("articleId") String articleId){
        String authorId = CurrentUtil.id();
        return ResponseResult.success(articleService.selectLike(authorId,articleId));
    }

    @GetMapping("like/list")
    public ResponseResult<PageInfo<DtsArticleDto>> listLike(
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        String username = CurrentUtil.author().getUsername();
        return ResponseResult.success(articleService.selectLikeArticleList(username, page, 10));
    }

    @PostMapping("like")
    public ResponseResult<Integer> postLike(@RequestParam("articleId") String articleId){
        String authorId = CurrentUtil.id();
        return ResponseResult.success(articleService.like(authorId,articleId));
    }

    @DeleteMapping("like")
    public ResponseResult<Integer> deleteLike(@RequestParam("articleId") String articleId){
        String authorId = CurrentUtil.id();
        return ResponseResult.success(articleService.unlike(authorId,articleId));
    }


}
