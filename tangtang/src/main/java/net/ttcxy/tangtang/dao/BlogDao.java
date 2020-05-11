package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.BlogDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogDao {

    /**
     * 筛选Blog
     * @return Blogs
     */
    List<BlogDto> selectBlog();

    /**
     * 模糊查询
     * @param title 标题
     * @param pag 页面
     * @return blogs
     */
    List<BlogDto> search(@Param("title") String title, @Param("pag") Integer pag);



    /**
     * 通过BlogId获取博客是否存在
     * @param blogId blogId
     * @return count
     */
    int isNotBlog(@Param("blogId")String blogId);

    /**
     * 通过UUID获取blog信息
     * @param uuid blog id
     * @return blog
     */
    BlogDto selectBlogByUUID(String uuid);

    /**
     * 添加blog
     * @param blogDto blogDto
     * @return count
     */
    int addBlog(BlogDto blogDto);

    /**
     * 更新博客
     * @param blogDto blogDto
     * @return count
     */
    int updateBlog(BlogDto blogDto);

    /**
     * 删除博客
     * @return
     */
    int deleteBlog(String id);

    int deleteLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    int insertLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    BlogDto getBlogByUUIDTextTit(@Param("blogId") String uuid);

    int selelcLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    int selelcFavorite(@Param("userId") String userId,
                       @Param("dataId") String dataId);

    List<BlogDto> searchByUsername(@Param("username")String username);

    List<BlogDto> getLikeBlogs(@Param("userId")String userId);

    List<BlogDto> searchByUserfavorite(@Param("username")String username);


    int insertFavorite(@Param("userId") String userId,
                       @Param("dataId") String dataId);

    int deleteFavorite(@Param("userId") String userId,
                       @Param("dataId") String dataId);


}
