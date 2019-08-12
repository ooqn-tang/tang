package com.jnnvc.vblog.service.impl;

import com.jnnvc.vblog.mapper.BlogMapper;
import com.jnnvc.vblog.entity.Blog;
import com.jnnvc.vblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

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
    public Blog getBlogByUUID(String uuid) {
        return blogMapper.getBlogByUUID(uuid);
    }
}
