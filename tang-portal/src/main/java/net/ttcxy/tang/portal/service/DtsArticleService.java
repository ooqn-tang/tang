package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.model.DtsArticle;

import java.util.List;

/**
 * 博客操作
 * @author huanglei
 */
public interface DtsArticleService {


    /**
     * 博客列表
     * @param tag 标签
     * @param page 页码
     */
    PageInfo<DtsArticleDto> selectArticleList(String tag, Integer page, Integer pageSize);

    /**
     * 模糊查询article
     * @param title 标题
     * @param page 页码
     * @return  ArticleDto list
     */
    PageInfo<DtsArticleDto> search(String title, Integer page, Integer pageSize);

    /**
     * 通过用户名查询所有BLOG
     * @param username 用户名
     * @return ArticleDto list
     */
    PageInfo<DtsArticleDto> selectArticleByAuthorName(String username, Integer page, Integer pageSize);

    /**
     * 通过博客ID查询数据
     * @param id  id
     * @return 博客
     */
    DtsArticleDto selectArticleById(String id);

    /**
     * 通过博客ID查询数据
     * @param id id
     * @return 博客
     */
    DtsArticleDto selectArticleAllById(String id);

    /**
     * 通过博客ID查询数据
     * @param id  id
     * @return 博客
     */
    DtsArticle selectArticleInfoById(String id);

    /**
     * 添加article
     */
    int insertArticle(DtsArticle article );

    /**
     * 更新博客
     * @param article article
     * @return 影响的行数
     */
    int updateArticle(DtsArticle article , String subjectId , List<String> tagIdList);

    /**
     * 删除博客
     * @return 影响的行数
     */
    int deleteArticle(String id);

    /**
     * 喜欢article
     * @param userId 用户ID
     * @param articleId 博客ID
     */
    int like(String userId, String articleId);

    /**
     * 喜欢article
     * @param userId 用户ID
     * @param articleId 博客ID
     */
    int unlike(String userId, String articleId);

    /**
     * 查询我是否喜欢了当前Article
     * @param userId 用户ID
     * @param dataId 博客ID
     */
    long selectLike(String userId, String dataId);

    /**
     * 更新博客，获取原始MD格式
     * @param articleId 博客列表
     */
    DtsArticle selectByPrimaryId(String articleId);

    /**
     * 查询用户喜欢的所有BLOG
     * @return 喜欢的博客列表
     */
    PageInfo<DtsArticleDto> selectLikeArticleList(String username, Integer page, Integer pageSize);

    /**
     * 前一千条
     */
    List<DtsArticleDto> selectArticleListRandom();
}