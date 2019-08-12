package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.Blog;

import java.util.List;

public interface BlogMapper {

    //筛选Blog
    List<Blog> selectBlog();

    //通过UUID获取blog信息
    Blog getBlogByUUID(String uuid);

    //添加blog
    int addBlog(Blog blog);

    //更新博客
    int updateBlog();

    //删除博客
    int deleteBlog();
}
