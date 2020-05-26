package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.BlogDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author  huanglei
 */
public interface BlogDao {

    /**
     * 筛选Blog
     * @return Blogs
     */
    List<BlogDto> selectBlog();

    /**
     * 模糊查询
     * @param title 标题
     * @return blogs
     */
    List<BlogDto> search(@Param("title") String title);




    /**
     * 通过ID获取blog信息
     * @param id blog id
     * @return blog
     */
    BlogDto selectBlogById(String id);

    int selectLike(@Param("userId") String userId,
                   @Param("blogId") String blogId);

    int selectFavorite(@Param("userId") String userId,
                       @Param("blogId") String blogId);

    List<BlogDto> searchByUsername(@Param("username")String username);

    /**
     * 通过用户ID 查询喜欢泪飙
     * @param userId
     * @return
     */
    List<BlogDto> selectLikeBlogs(@Param("userId")String userId);

    /**
     * 通过用户名查询所有数据
     * @param username 用户名
     * @return blogDto list
     */
    List<BlogDto> selectByUserFavorite(@Param("username")String username);




}
