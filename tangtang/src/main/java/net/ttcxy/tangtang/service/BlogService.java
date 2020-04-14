package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.dto.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    /**
     * 查询blog
     * @return
     */
    List<Blog> selectBlog(String cls,Integer pag);

    /**
     * 模糊查询blog
     * @return
     */
    List<Blog> search(String title,Integer pag);

    /**
     * 通过用户名查询所有BLOG
     * @param username
     * @param type
     * @return
     */
    List<Blog> searchByUsername(String username,String type);



    Blog getBlogByUUID(String uuid,String userId);

    /**
     * 添加blog
     */
    int addBlog(Blog blog);

    List<Map<String,String>> optionList();

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
    int deleteBlog();

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
    Blog getBlogByUUIDTextTit(String blogId);

    /**
     * 查询我是否喜欢了当前Blog
     * @param userId
     * @param dataId
     * @return
     */
    int selelcLike(String userId,String dataId);

    /**
     * 查询用户喜欢的所有BLOG
     * @param username
     * @return
     */
    List<Blog> searchByUserlike(String username);

    /**
     * 查询用户的所有收藏
     * @param username
     * @return
     */
    List<Blog> searchByUserfavorite(String username);

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
    int selelcFavorite(String userId, String blogId);
}