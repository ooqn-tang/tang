package net.ttcxy.tangtang.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.BlogDto;
import net.ttcxy.tangtang.entity.CommentDto;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.model.Blog;
import net.ttcxy.tangtang.model.BlogComment;
import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.CommentService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对博文的增删改查
 * @author huanglei
 */
@RestController
@RequestMapping("blog")
@Api(tags = "BlogController", description = "对博文的增删改查")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AuthDetailsImpl authDetailsImpl;

    @Autowired
    private CommentService commentService;

    @GetMapping("home/{username}")

    public CommonResult blogList(@PathVariable("username") String username){
        return  CommonResult.success(blogService.searchByUsername(username));
    }

    /**
     * 获取自己喜欢的文章
     * @return
     */
    @GetMapping("favorite/{username}")
    public CommonResult<List<BlogDto>> selectByUserFavorite(@PathVariable("username") String username){
        return CommonResult.success(blogService.selectByUserFavorite(username));
    }

    /**
     * 获取自己喜欢的文章
     * @return
     */
    @GetMapping("like")
    public CommonResult<List<BlogDto>> selectByUserLike(){
        String userId = authDetailsImpl.getUserId();
        List<BlogDto> likeBlogs = blogService.selectLikeBlogs(userId);
        return CommonResult.success(likeBlogs);
    }



    /**
     * 添加博客
     * @param blog blogParam
     * @return null
     */
    @PostMapping("insert")
    public CommonResult add(@RequestBody Blog blog){

        String userId = authDetailsImpl.getUserId();

        if (blog !=null){
            if (StrUtil.isBlank(blog.getTitle())){
                return CommonResult.failed("请正确输入内容");
            }
            if (StrUtil.isBlank(blog.getMarkdown())){
                return CommonResult.failed("请正确输入内容");
            }
            if (StrUtil.isBlank(blog.getText())){
                return CommonResult.failed("请正确输入内容");
            }
        }

        blog.setId(IdUtil.simpleUUID());
        blog.setUserId(userId);
        blog.setStateId(1);
        blog.setCreateDate(new Date());

        int influenceCount = blogService.insertBlog(blog);



        if (influenceCount==1){
            return CommonResult.success("添加成功");
        }else{
            return  CommonResult.failed("添加失败");
        }
    }





    @PostMapping("comment/insert")
    public CommonResult insertComment(@RequestBody BlogComment blogComment){

        String userId = authDetailsImpl.getUserId();
        blogComment.setId(IdUtil.fastSimpleUUID());
        blogComment.setUserId(userId);
        blogComment.setCreateDate(new Date());
        blogComment.setStatus(1);

        int count = commentService.insertComment(blogComment);

        if (count > 0){
            return CommonResult.success(blogComment);
        }

        return CommonResult.failed("添加失败；");

    }

    @GetMapping("comment/{blogId}")
    public CommonResult selectComment(@PathVariable("blogId") String blogId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.selectComment(blogId));
        map.put("user",authDetailsImpl.getUser());
        return CommonResult.success(map);
    }

    @DeleteMapping("comment/{id}")
    public CommonResult deleteComment(@PathVariable("id") String id){
        int count = commentService.deleteComment(id);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }

    @GetMapping("load")
    public CommonResult load(@RequestParam(name="blog",required = false) String blogId){

        Blog blog = blogService.selectByPrimaryId(blogId);
        UserDto userDto = authDetailsImpl.getUser();
        if(blog.getUserId().equals(userDto.getId())){
            return CommonResult.success(blog);
        }else{
            return CommonResult.failed("无法修改别人的Blog");
        }
    }

    @PostMapping("update")
    public CommonResult update(@RequestBody Blog blog){

        int count = blogService.updateBlog(blog);
        if (count > 0){
            return CommonResult.success(0);
        }
        return CommonResult.failed();

    }



    /**
     * delete
     * @param id id
     * @return null
     */
    @GetMapping("delete/{id}")
    public CommonResult delete(@PathVariable("id") String id){

        String userId = blogService.selectByPrimaryId(id).getUserId();
        if (authDetailsImpl.getUser()!=null){
            if(StrUtil.equals(authDetailsImpl.getUser().getId(),userId)){
                int count = blogService.deleteBlog(id);
                if(count > 0){
                    return CommonResult.success("成功删除");
                }else{
                    return CommonResult.failed("删除失败");
                }

            }else{
                return CommonResult.failed("请正确操作");
            }
        }else{
            return CommonResult.failed("请正确操作");
        }
    }

    /**
     * 喜欢blog.如果数据库不存在，推荐，如果存在就取消。
     * @param id id
     */
    @GetMapping("/like/{id}/insert")
    public CommonResult like(@PathVariable("id") String id){
        UserDto userDto = authDetailsImpl.getUser();
        return CommonResult.success(blogService.like(userDto.getId(),id));
    }

    /**
     * 如果数据库不存在，推荐，如果存在就取消。
     * @param blogId id
     */
    @GetMapping("/favorite/{blogId}/insert")
    public CommonResult favorite(@PathVariable("blogId") String blogId){
        String userId = authDetailsImpl.getUserId();
        int favorite = blogService.favorite(userId, blogId);
        return CommonResult.success(favorite);
    }
}
