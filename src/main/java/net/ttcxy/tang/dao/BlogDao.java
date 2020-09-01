package net.ttcxy.tang.dao;

import net.ttcxy.tang.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 博客
 * @author  huanglei
 */
public interface BlogDao {

    /**
     * 筛选Blog
     */
    List<Blog> selectBlog();

    List<Blog> selectBlogDt();

    /**
     * 模糊查询
     */
    List<Blog> search(String title);

    /**
     * 查询所有ID
     */
    Set<String> selectId();

    Blog selectByIdTitle(String id);

    /**
     * 通过ID获取blog信息
     */
    Blog selectBlogById(String id);

    /**
     * 通过用户名查询博客
     */
    List<Blog> searchByUsername(@Param("username")String username);

    /**
     * 通过用户ID 查询喜欢泪飙
     */
    List<Blog> selectLikeBlogs(@Param("username")String username);




}
