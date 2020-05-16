package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.BlogDto;
import net.ttcxy.tangtang.model.Blog;

import java.util.List;

public interface BlogService {

    /**
     * 查询blog
     * @return
     */
    List<BlogDto> selectBlog(Integer pag);

    /**
     * 模糊查询blog
     * @return
     */
    List<BlogDto> search(String title, Integer pag);

    /**
     * 通过用户名查询所有BLOG
     * @param username
     * @return
     */
    List<BlogDto> searchByUsername(String username);



    BlogDto getBlogByUUID(String uuid, String userId);

    /**
     * 添加blog
     */
    int insertBlog(Blog blog);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 删除博客
     * @return
     */
    Boolean deleteBlog(String id);

    /**
     * 喜欢blog
     * @param userId
     * @param blogId
     */
    int like(String userId,String blogId);

    /**
     * 更新博客，获取原始MD格式
     * @param blogId
     * @return
     */
    BlogDto getBlogByUUIDTextTit(String blogId);

    /**
     * 查询我是否喜欢了当前Blog
     * @param userId
     * @param dataId
     * @return
     */
    int selectLike(String userId, String dataId);

    /**
     * 查询用户喜欢的所有BLOG
     * @return
     */
    List<BlogDto> selectLikeBlogs(String userId);

    /**
     * 查询用户的所有收藏
     * @param username
     * @return
     */
    List<BlogDto> selectByUserFavorite(String username);

    /**
     * 查询所有的收藏
     * @param id
     * @param id1
     * @return
     */
    int favorite(String id, String id1);

    /**
     * 查询是否收藏
     * @param userId
     * @param blogId
     * @return
     */
    int selectFavorite(String userId, String blogId);
}