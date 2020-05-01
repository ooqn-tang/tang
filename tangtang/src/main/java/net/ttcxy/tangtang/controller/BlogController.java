package net.ttcxy.tangtang.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.qiniu.util.Auth;
import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.entity.Comment;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.CommentService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 对博文的增删改查
 * @author huanglei
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AuthDetailsImpl authDetailsImpl;

    @Autowired
    private CommentService commentService;

    @GetMapping("userblog/{username}")
    @ResponseBody
    public CommonResult blogList(@PathVariable("username") String username, @RequestParam(value = "type",required = false) String type){

        if ("1".equals(type)){
            return CommonResult.success(blogService.searchByUserlike(username));
        } else if ("2".equals(type)){
            return CommonResult.success(blogService.searchByUserfavorite(username));
        }

        return  CommonResult.success(blogService.searchByUsername(username,type));
    }



    /**
     * 添加博客
     * @param blog blogParam
     * @return null
     */
    @PostMapping("insert")
    @ResponseBody
    public CommonResult add(@RequestBody Blog blog){

        User user = authDetailsImpl.getUser();

        if (blog!=null){
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
        blog.setUserId(user.getId());
        blog.setStateId("1");

        int influenceCount = blogService.addBlog(blog);

        if (influenceCount==1){
            return CommonResult.success("添加成功");
        }else{
            return  CommonResult.failed("添加失败");
        }
    }





    @PostMapping("comment/insert")
    @ResponseBody
    public CommonResult insertComment(@RequestBody Comment comment){

        comment.setId(IdUtil.fastSimpleUUID());
        comment.setUserId(authDetailsImpl.getUser().getId());
        comment.setCreateDate(new Date());
        comment.setStatus("1");
        comment.setUsername(authDetailsImpl.getUser().getUsername());
        comment.setNickname(authDetailsImpl.getUser().getNickname());


        if (commentService.insertComment(comment)){
            return CommonResult.success(comment);
        }

        return CommonResult.failed("添加失败；");

    }

    @GetMapping("comment/{blogId}")
    @ResponseBody
    public CommonResult selectComment(@PathVariable("blogId") String blogId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.selectComment(blogId));
        map.put("user",authDetailsImpl.getUser());
        return CommonResult.success(map);
    }

    @DeleteMapping("comment/{blogId}")
    @ResponseBody
    public CommonResult deleteComment(@PathVariable("blogId") String blogId){
        return CommonResult.success(commentService.deleteComment(blogId));
    }





    @GetMapping("load")
    @ResponseBody
    public CommonResult load(@RequestParam(name="blog",required = false) String blogId){

        Blog blogBody = blogService.getBlogByUUIDTextTit(blogId);
        User user = authDetailsImpl.getUser();
        if(blogBody.getUserId().equals(user.getId())){
            return CommonResult.success(blogBody);
        }else{
            return CommonResult.failed("无法修改别人的Blog");
        }
    }

    @PostMapping("update")
    @ResponseBody
    public CommonResult update(@RequestBody Blog blog){

        Blog blogBody = blogService.getBlogByUUIDTextTit(blog.getId());
        User user = authDetailsImpl.getUser();
        if(blogBody.getUserId().equals(user.getId())){
            return CommonResult.success(blogService.updateBlog(blog));
        }else{
            return CommonResult.failed("无法修改别人的Blog");
        }
    }



    /**
     * delete
     * @param id id
     * @return null
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable("id") String id){

        String userId = blogService.getBlogByUUIDTextTit(id).getUserId();
        if (authDetailsImpl.getUser()!=null){
            if(StrUtil.equals(authDetailsImpl.getUser().getId(),userId)){
                if(blogService.deleteBlog(id)){
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
     * 查询
     * @param id 查询ID
     * @return 结果
     */
    @GetMapping("query/{id}")
    public CommonResult query(@PathVariable("id") String id){
        System.out.println(id);
        return null;
    }

   //todo 图片上传
    @PostMapping("img/upload")
    @ResponseBody
    public Map<String,String> fileUpdate(@RequestParam(value="editormd-image-file") MultipartFile multipartFile){

        String accessKey = "M6qf3dVX9P5RY1fQWnFItPjw7q8ExvUhFmGRgyHq";
        String secretKey = "EoiEXLXG_GwLox4TA0W28bVCj3tXkZwT7Le_LK1z";
        String bucket = "bucket name";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);


        multipartFile.getName();
        return null;

    }



    /**
     * 喜欢blog.如果数据库不存在，推荐，如果存在就取消。
     * @param id id
     */
    @GetMapping("/like/{id}/insert")
    @ResponseBody
    public CommonResult like(@PathVariable("id") String id){
        User user = authDetailsImpl.getUser();
        return CommonResult.success(blogService.like(user.getId(),id));
    }

    /**
     * 如果数据库不存在，推荐，如果存在就取消。
     * @param id id
     */
    @GetMapping("/favorite/{id}/insert")
    @ResponseBody
    public CommonResult favorite(@PathVariable("id") String id){

        User user = authDetailsImpl.getUser();
        return CommonResult.success(blogService.favorite(user.getId(),id));
    }
}
