package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    /**
     * 筛选Blog
     * @param pag pageCount
     * @return Blogs
     */
    List<Blog> selectBlog(@Param("pag") Integer pag);

    /**
     * 模糊查询
     * @param title 标题
     * @param pag 页面
     * @return blogs
     */
    List<Blog> search(@Param("title") String title,@Param("pag") Integer pag);



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
    Blog selectBlogByUUID(String uuid);

    /**
     * 添加blog
     * @param blog blog
     * @return count
     */
    int addBlog(Blog blog);

    /**
     * 更新博客
     * @param blog blog
     * @return count
     */
    int updateBlog(Blog blog);

    /**
     * 删除博客
     * @return
     */
    int deleteBlog(@Param("id") String id);

    int deleteLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    int insertLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    Blog getBlogByUUIDTextTit(@Param("blogId") String uuid);

    int selelcLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    int selelcFavorite(@Param("userId") String userId,
                       @Param("dataId") String dataId);

    List<Blog> searchByUsername(@Param("username")String username);

    List<Blog> searchByUserlike(@Param("username")String username);

    List<Blog> searchByUserfavorite(@Param("username")String username);


    int insertFavorite(@Param("userId") String userId,
                       @Param("dataId") String dataId);

    int deleteFavorite(@Param("userId") String userId,
                       @Param("dataId") String dataId);


}
