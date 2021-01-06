package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.model.DtsBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 博客
 * @author huanglei
 */
public interface DtsBlogDao {


    /**
     * 筛选Blog
     * @return 博客列表
     */
    List<DtsBlogDto> selectBlog();


    /**
     * 博客列表
     * @return 博客列表
     */
    List<DtsBlogDto> getBlogList();

    /**
     * 模糊查询
     * @param title 标题
     * @return 博客列表
     */
    List<DtsBlogDto> search(String title);

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
    DtsBlogDto selectByIdTitle(String id);

    /**
     * 通过ID获取blog信息
     * @param id 博客ID
     * @return 博客
     */
    DtsBlogDto selectBlogById(String id);


    List<DtsBlogDto> searchByUsernameAuthor(@Param("username") String username);

    /**
     * 通过用户名查询博客
     * @param username username
     * @return 博客列表
     */
    List<DtsBlogDto> searchByUsername(@Param("username") String username);

    /**
     * 通过用户ID 查询喜欢泪飙
     * @param username username
     * @return 博客列表
     */
    List<DtsBlogDto> selectLikeBlogs(@Param("username") String username);


    DtsBlog selectBlogInfoById(String id);

    DtsBlog selectBlogMsIsNull();
}
