package net.ttcxy.tang.dao;

import net.ttcxy.tang.entity.BlogDto;
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
    List<BlogDto> selectBlog();

    List<BlogDto> selectBlogDt();

    /**
     * 模糊查询
     */
    List<BlogDto> search(String title);

    /**
     * 查询所有ID
     */
    Set<String> selectId();

    BlogDto selectByIdTitle(String id);

    /**
     * 通过ID获取blog信息
     */
    BlogDto selectBlogById(String id);

    /**
     * 通过用户名查询博客
     */
    List<BlogDto> searchByUsername(@Param("username")String username);

    /**
     * 通过用户ID 查询喜欢泪飙
     */
    List<BlogDto> selectLikeBlogs(@Param("userId")String userId);

    /**
     * 通过用户名查询所有数据
     */
    List<BlogDto> selectByUserFavorite(@Param("username")String username);




}
