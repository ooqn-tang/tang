package com.jnnvc.vblog.service;

import com.jnnvc.vblog.entity.Blog;
import com.jnnvc.vblog.entity.BlogComment;

import java.util.List;

public interface BlogService {


    /**
     * 查询blog
     * @return
     */
    List<Blog> selectBlogCls(String cls);

    /**
     * 查询blog
     * @return
     */
    List<Blog> selectBlog();

    Blog getBlogByUUID(String uuid);

    //添加blog
    int addBlog(Blog blog);

    //更新博客
    int updateBlog();

    //删除博客
    int deleteBlog();

    int addComment(BlogComment blogComment) throws Exception;
}