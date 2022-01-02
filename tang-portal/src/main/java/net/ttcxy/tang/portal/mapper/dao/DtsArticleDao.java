package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;

import java.util.List;

/**
 * 博客
 * @author huanglei
 */
public interface DtsArticleDao {

    /**
     * 博客列表
     * @return 博客列表
     */
    List<DtsArticleDto> selectArticleList(String tagName);

    /**
     * 模糊查询
     * @param title 标题
     * @return 博客列表
     */
    List<DtsArticleDto> search(String title);

    /**
     * 通过ID获取article信息
     * @param id 博客ID
     * @return 博客
     */
    DtsArticleDto selectArticleById(String id);

    /**
     * 通过ID获取article信息
     * @param id 博客ID
     * @return 博客
     */
    DtsArticleDto selectArticleAllById(String id);

    /**
     * 通过用户ID 查询喜欢泪飙
     * @param username username
     * @return 博客列表
     */
    List<DtsArticleDto> selectLikeArticles(String username);

    /**
     * 通过用户名查询博客
     * @param username username
     * @return 博客列表
     */
    List<DtsArticleDto> selectArticleListByUsername(String username);

    /**
     * 获取前1000条数据
     */
    List<DtsArticleDto> selectArticleList1000();


}