package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.BlogDto;
import net.ttcxy.tangtang.model.Blog;

import java.util.List;

/**
 * 博客操作
 * @author huanglei
 */
public interface BlogService {


    /**
     * 查询blog
     * @param page 第几页
     * @return blogDto list
     */
    List<BlogDto> selectBlog(Integer page);

    void blogIsNull();

    /**
     * 模糊查询blog
     * @param title 标题
     * @param page 页码
     * @return  BlogDto list
     */
    List<BlogDto> search(String title, Integer page);

    /**
     * 通过用户名查询所有BLOG
     * @param username 用户名
     * @return BlogDto list
     */
    List<BlogDto> searchByUsername(String username);


    /**
     * 通过博客ID查询数据
     * @param id  id
     * @return 博客
     */
    BlogDto selectBlogById(String id);

    /**
     * 添加blog
     */
    int insertBlog(Blog blog);

    /**
     * 更新博客
     * @param blog blog
     * @return 影响的行数
     */
    int updateBlog(Blog blog);

    /**
     * 删除博客
     * @return
     */
    int deleteBlog(String id);

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
    Blog selectByPrimaryId(String blogId);

    /**
     * 查询我是否喜欢了当前Blog
     * @param userId
     * @param dataId
     * @return
     */
    long selectLike(String userId, String dataId);

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
     * 收藏，如果存在就删除收藏
     * @param userId 收藏人ID
     * @param blogId 收藏内容ID
     * @return count 0 表示没有收藏
     */
    int favorite(String userId, String blogId);

    /**
     * 查询是否收藏
     * @param userId userId
     * @param blogId blogId
     * @return long
     */
    long selectFavorite(String userId, String blogId);

    /**
     * 博客的数量
     * @return 行数
     */
    long selectBlogCount();

}