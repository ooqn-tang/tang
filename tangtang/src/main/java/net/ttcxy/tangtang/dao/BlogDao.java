package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.BlogDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 博客
 * @author  huanglei
 */
public interface BlogDao {

    /**
     * 筛选Blog
     */
    List<BlogDto> selectBlog();

    /**
     * 模糊查询
     */
    List<BlogDto> search(@Param("title") String title);

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
