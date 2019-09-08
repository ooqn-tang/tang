package com.jnnvc.vblog.controller.web;

import cn.hutool.core.util.IdUtil;
import com.jnnvc.vblog.entity.Blog;
import com.jnnvc.vblog.entity.BlogComment;
import com.jnnvc.vblog.entity.ResponseData;
import com.jnnvc.vblog.entity.User;
import com.jnnvc.vblog.security.model.SessionKey;
import com.jnnvc.vblog.service.BlogService;
import com.jnnvc.vblog.service.UserService;
import com.jnnvc.vblog.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 对博文的增删改查
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("add")
    public String toEditor(){
        return "page/editor";
    }

    //添加博客
    @PostMapping("add")
    @ResponseBody
    public ResponseData add(@RequestBody Map<String,String> requestBody){

        User user = ((User)httpSession.getAttribute(SessionKey.USER_INFO));

        String blogId = IdUtil.fastSimpleUUID();
        String title = requestBody.get("title");
        String text = requestBody.get("text");

        String summary = requestBody.get("summary");
        String state = requestBody.get("state");//1 发布，2 草稿
        String classId = requestBody.get("classId");

        if (ParamUtil.isNullParams(title,text,summary,state))
            return ResponseData.error("ParamsIsNull","参数不全");

        Blog blog = new Blog();
        blog.setId(blogId);
        blog.setUserId(user.getId());
        blog.setTitle(title);
        blog.setText(text);
        blog.setUsername(user.getUsername());
        blog.setSummary(summary);
        blog.setClassId(classId);
        blog.setStateId(state);

        return blogService.addBlog(blog)==1?ResponseData.successful("successful"):ResponseData.error("error","添加失败");
    }

    //添加评论
    @PostMapping("/comment")
    @ResponseBody
    public ResponseData addComment(@RequestBody Map<String,String> requestBody){

        User user = ((User)httpSession.getAttribute(SessionKey.USER_INFO));

        String comment = requestBody.get("comment");
        String userId = user.getId();
        String blogId = requestBody.get("blogId");

        BlogComment blogComment = new BlogComment();
        blogComment.setId(IdUtil.fastSimpleUUID());
        blogComment.setBlogId(blogId);
        blogComment.setCommentContent(comment);
        blogComment.setUserId(userId);

        ResponseData responseData = null;

        try {
            responseData = ResponseData.successful(blogService.addComment(blogComment));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error("BlogDoecNotExist","博客不存在，无法评论");
        }
        return ResponseData.successful(responseData);

    }

    /**
     * 通过博客ID获取博客页面
     * @param blogId
     * @return
     */
    @GetMapping("{blogId}")
    public String toBlogInfo(@PathVariable("blogId") String blogId, Model model){
        Blog blog = blogService.getBlogByUUID(blogId);

        model.addAttribute(blog);
        System.out.println("进入blog.html");
        return "page/blogInfo";
    }

    //删除博客
    @GetMapping("delete/{id}")
    public ResponseData delete(@PathVariable("id") String id){

        return null;
    }

    //删除博客
    @GetMapping("update/{id}")
    public ResponseData update(@PathVariable("id") String id){
        return null;
    }

    //删除博客
    @GetMapping("query/{id}")
    public ResponseData query(@PathVariable("id") String id){
        return null;
    }

    @GetMapping("queryList")
    public ResponseData queryList(@PathVariable("id") String id){



        return null;
    }





}
