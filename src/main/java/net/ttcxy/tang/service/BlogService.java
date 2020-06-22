package net.ttcxy.tang.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.entity.BlogDto;
import net.ttcxy.tang.model.Blog;

/**
 * 博客操作
 * @author huanglei
 */
public interface BlogService {


    PageInfo<BlogDto> showDt(Integer page);


    /**
     * 模糊查询blog
     * @param title 标题
     * @param page 页码
     * @return  BlogDto list
     */
    PageInfo<BlogDto> search(String title, Integer page);

    /**
     * 通过用户名查询所有BLOG
     * @param username 用户名
     * @return BlogDto list
     */
    PageInfo<BlogDto> searchByUsername(String username,Integer page);


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
    PageInfo<BlogDto> selectLikeBlogs(String username,Integer page);


    PageInfo<BlogDto> selectBlogs(Integer page);

    /**
     * 随机获取一条博客
     * @return
     */
    BlogDto random();
}