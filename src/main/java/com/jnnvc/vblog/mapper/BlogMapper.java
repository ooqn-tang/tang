package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.Blog;
import com.jnnvc.vblog.entity.BlogComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    //筛选Blog
    List<Blog> selectBlogCls(@Param("cls") String cls);

    //查询Blog
    List<Blog> selectBlog();

    //通过BlogId获取博客是否存在
    int isNotBlog(@Param("blogId")String blogId);


    //通过UUID获取blog信息
    Blog getBlogByUUID(String uuid);

    //添加blog
    int addBlog(Blog blog);

    //更新博客
    int updateBlog();

    //删除博客
    int deleteBlog();

    int addComment(BlogComment blogComment);
}
