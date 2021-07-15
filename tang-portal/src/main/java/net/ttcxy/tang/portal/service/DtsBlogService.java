package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsBlogDto;
import net.ttcxy.tang.portal.entity.model.DtsBlog;

import java.util.List;
import java.util.Set;

/**
 * 博客操作
 * @author huanglei
 */
public interface DtsBlogService {


    /**
     * 博客列表
     * @param tag 标签
     * @param page 页码
     */
    PageInfo<DtsBlogDto> selectBlogList(String tag, Integer page, Integer pageSize);

    /**
     * 模糊查询blog
     * @param title 标题
     * @param page 页码
     * @return  BlogDto list
     */
    PageInfo<DtsBlogDto> search(String title, Integer page, Integer pageSize);

    /**
     * 通过用户名查询所有BLOG
     * @param username 用户名
     * @return BlogDto list
     */
    PageInfo<DtsBlogDto> selectBlogByAuthorName(String username, Integer page, Integer pageSize);

    /**
     * 通过博客ID查询数据
     * @param id  id
     * @return 博客
     */
    DtsBlogDto selectBlogById(String id);

    /**
     * 通过博客ID查询数据
     * @param id  id
     * @return 博客
     */
    DtsBlog selectBlogInfoById(String id);

    /**
     * 添加blog
     */
    int insertBlog(DtsBlog blog , String subjectId , List<String> tagIdList);

    /**
     * 更新博客
     * @param blog blog
     * @return 影响的行数
     */
    int updateBlog(DtsBlog blog);

    /**
     * 删除博客
     * @return 影响的行数
     */
    int deleteBlog(String id);

    /**
     * 喜欢blog
     * @param userId 用户ID
     * @param blogId 博客ID
     */
    int like(String userId, String blogId);

    /**
     * 喜欢blog
     * @param userId 用户ID
     * @param blogId 博客ID
     */
    int unlike(String userId, String blogId);

    /**
     * 查询我是否喜欢了当前Blog
     * @param userId 用户ID
     * @param dataId 博客ID
     */
    long selectLike(String userId, String dataId);

    /**
     * 更新博客，获取原始MD格式
     * @param blogId 博客列表
     */
    DtsBlog selectByPrimaryId(String blogId);

    /**
     * 查询用户喜欢的所有BLOG
     * @return 喜欢的博客列表
     */
    PageInfo<DtsBlogDto> selectLikeBlogList(String username, Integer page, Integer pageSize);

    /**
     * 前一千条
     */
    Set<DtsBlogDto> selectBlogListRandom();
}