package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.service.CurrentAuthorService;
import net.ttcxy.tang.entity.UtsAuthorLogin;
import net.ttcxy.tang.entity.dto.DtsCommentDto;
import net.ttcxy.tang.entity.param.DtsBlogCommentParam;
import net.ttcxy.tang.entity.param.DtsBlogParam;
import net.ttcxy.tang.service.DtsBlogService;
import net.ttcxy.tang.service.DtsCommentService;
import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.entity.model.DtsBlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客控制器
 * @author huanglei
 */
@RestController
@RequestMapping("blog")
@Api(tags = "BlogController")
@Validated
public class DtsBlogController {

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Autowired
    private DtsCommentService commentService;

    @GetMapping("home/{username}")
    @ApiOperation("用户首页")
    public ResponseResult<?> blogList(
            @PathVariable("username") String username,
            @RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return  ResponseResult.success(blogService.searchByUsername(username,page));
    }

    @GetMapping("random")
    @ApiOperation("随机获取一条")
    public ResponseResult<?> random(){
        return ResponseResult.success(blogService.random());
    }

    @GetMapping("so")
    @ApiOperation("搜索")
    public ResponseResult<?> toSearch(@RequestParam(name = "page", defaultValue = "1")Integer page,
                                                      @RequestParam(name = "search", defaultValue = "")String search ){
        return ResponseResult.success(blogService.search(search,page));
    }

    @GetMapping("like")
    @ApiOperation("获取自己喜欢的文章")
    public ResponseResult<?> selectByUserLike(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                              @RequestParam(value = "username") @NotBlank(message = "用户名不能为空") String username){
        return ResponseResult.success(blogService.selectLikeBlogs(username,page));
    }

    @PostMapping("insert")
    @ApiOperation("添加博客")
    public ResponseResult<?> insert(@RequestBody @Valid DtsBlogParam dtsBlogParam){
        DtsBlog blog = new DtsBlog();
        BeanUtil.copyProperties(dtsBlogParam,blog);

        Date date = DateUtil.date();
        String uuid = IdUtil.simpleUUID();
        blog.setId(uuid);
        blog.setUserId(currentAuthorServiceImpl.getAuthorId());
        blog.setStateId(1);
        blog.setCreateDate(date);
        blog.setUpdateDate(date);

        int count = blogService.insertBlog(blog);

        if (count > 0){
            return ResponseResult.success("添加成功");
        }else{
            return  ResponseResult.failed("添加失败");
        }
    }

    @GetMapping("delete/{id}")
    @ApiOperation("删除博客")
    public ResponseResult<?> delete(@PathVariable("id") String id){

        String userId = blogService.selectByPrimaryId(id).getUserId();
        if (currentAuthorServiceImpl.getAuthor()!=null){
            if(StrUtil.equals(currentAuthorServiceImpl.getAuthor().getId(),userId)){
                int count = blogService.deleteBlog(id);
                if(count > 0){
                    return ResponseResult.success("成功删除");
                }else{
                    return ResponseResult.failed("删除失败");
                }

            }else{
                return ResponseResult.failed("请正确操作");
            }
        }else{
            return ResponseResult.failed("请正确操作");
        }
    }

    @PostMapping("update")
    @ApiOperation("更新博客")
    public ResponseResult<?> update(@RequestBody DtsBlogParam dtsBlogParam){

        DtsBlog blog = new DtsBlog();
        BeanUtil.copyProperties(dtsBlogParam,blog);

        int count = blogService.updateBlog(blog);
        if (count > 0){
            return ResponseResult.success(0);
        }
        return ResponseResult.failed();

    }

    @GetMapping("blogs")
    @ApiOperation("查询博客")
    public ResponseResult<?> selectBlogs(@RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return ResponseResult.success(blogService.selectBlogs(page));
    }

    @PostMapping("comment/insert")
    @ApiOperation("添加博客评论")
    public ResponseResult<?> insertComment(@RequestBody @Valid DtsBlogCommentParam dtsBlogCommentParam){

        UtsAuthorLogin user = currentAuthorServiceImpl.getAuthor();

        DtsBlogComment blogComment = new DtsBlogComment();
        BeanUtil.copyProperties(dtsBlogCommentParam,blogComment);

        String commentId = IdUtil.fastSimpleUUID();
        blogComment.setId(commentId);
        blogComment.setUserId(user.getId());
        blogComment.setCreateDate(new Date());
        blogComment.setStatus(1);

        int count = commentService.insertComment(blogComment);

        if (count > 0){
            DtsCommentDto dtsCommentDto = commentService.selectComment(commentId);
            return ResponseResult.success(dtsCommentDto);
        }
        return ResponseResult.failed("添加失败");

    }

    @PostMapping("comment/delete/{id}")
    @ApiOperation("删除博客评论")
    public ResponseResult<?> deleteComment(@PathVariable("id") String id){
        int count = commentService.deleteComment(id);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    @GetMapping("comment/{blogId}")
    @ApiOperation("查询博客评论")
    public ResponseResult<?> selectComment(@PathVariable("blogId") String blogId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.selectComments(blogId));
        map.put("author", currentAuthorServiceImpl.getAuthor());
        return ResponseResult.success(map);
    }

    @GetMapping("load")
    @ApiOperation("加载博客信息，详细")
    public ResponseResult<?> load(@RequestParam(name="blog",required = false) String blogId){

        DtsBlog blog = blogService.selectByPrimaryId(blogId);
        UtsAuthorLogin author = currentAuthorServiceImpl.getAuthor();
        if(blog.getUserId().equals(author.getId())){
            return ResponseResult.success(blog);
        }else{
            return ResponseResult.failed("无法修改别人的Blog");
        }
    }

    @GetMapping("/like/{id}/insert")
    @ApiOperation("喜欢blog.如果数据库不存在，推荐，如果存在就取消。")
    public ResponseResult<?> like(@PathVariable("id") String id){
        UtsAuthorLogin author = currentAuthorServiceImpl.getAuthor();
        return ResponseResult.success(blogService.like(author.getId(),id));
    }
}
