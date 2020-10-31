package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.BlogDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 博客
 * @author huanglei
 */
public interface BlogDao {


    /**
     * 筛选Blog
     * @return 博客列表
     */
    List<BlogDto> selectBlog();


    /**
     * 博客列表
     * @return 博客列表
     */
    List<BlogDto> selectBlogDt();

    /**
     * 模糊查询
     * @param title 标题
     * @return 博客列表
     */
    List<BlogDto> search(String title);

    /**
     * 查询所有ID
     * @return 博客Id列表
     */
    Set<String> selectId();

    /**
     * 通过Id查询博客
     * @param id id
     * @return 博客列表
     */
    BlogDto selectByIdTitle(String id);

    /**
     * 通过ID获取blog信息
     * @param id 博客ID
     * @return 博客
     */
    BlogDto selectBlogById(String id);

    /**
     * 通过用户名查询博客
     * @param username username
     * @return 博客列表
     */
    List<BlogDto> searchByUsername(@Param("username")String username);

    /**
     * 通过用户ID 查询喜欢泪飙
     * @param username username
     * @return 博客列表
     */
    List<BlogDto> selectLikeBlogs(@Param("username")String username);




}
