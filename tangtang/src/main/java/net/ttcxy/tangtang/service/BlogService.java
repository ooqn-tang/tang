package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.entity.params.BlogParam;

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
    int addBlog(BlogParam blogParam);

    //更新博客
    int updateBlog();

    //删除博客
    int deleteBlog();

    int addComment(CommentParam commentParam) throws Exception;
}