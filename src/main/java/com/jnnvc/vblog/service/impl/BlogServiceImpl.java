package com.jnnvc.vblog.service.impl;

import cn.hutool.core.util.IdUtil;
import com.jnnvc.vblog.entity.BlogComment;
import com.jnnvc.vblog.entity.ResponseData;
import com.jnnvc.vblog.mapper.BlogMapper;
import com.jnnvc.vblog.entity.Blog;
import com.jnnvc.vblog.service.BlogService;
import com.jnnvc.vblog.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> selectBlogCls(String cls) {



        return blogMapper.selectBlogCls(cls);
    }

    @Override
    public List<Blog> selectBlog() {
        return blogMapper.selectBlog();
    }

    @Override
    public int addBlog(Blog blog) {
        return blogMapper.addBlog(blog);
    }

    @Override
    public int updateBlog() {
        return 0;
    }

    @Override
    public int deleteBlog() {
        return 0;
    }

    @Override
    public int addComment(BlogComment blogComment) throws Exception {


        if(1!=blogMapper.isNotBlog(blogComment.getBlogId())){
            throw new Exception("Blog does not exist，No comment");
        }

        return blogMapper.addComment(blogComment);
    }

    @Override
    public Blog getBlogByUUID(String uuid) {
        return blogMapper.getBlogByUUID(uuid);
    }
}
