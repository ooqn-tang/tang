package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsBlogDto;

import java.util.List;

/**
 * 博客
 * @author huanglei
 */
public interface DtsBlogDao {

    /**
     * 博客列表
     * @return 博客列表
     */
    List<DtsBlogDto> selectBlogList(String tagName);

    /**
     * 模糊查询
     * @param title 标题
     * @return 博客列表
     */
    List<DtsBlogDto> search(String title);

    /**
     * 通过ID获取blog信息
     * @param id 博客ID
     * @return 博客
     */
    DtsBlogDto selectBlogById(String id);

    /**
     * 通过ID获取blog信息
     * @param id 博客ID
     * @return 博客
     */
    DtsBlogDto selectBlogAllById(String id);

    /**
     * 通过用户ID 查询喜欢泪飙
     * @param username username
     * @return 博客列表
     */
    List<DtsBlogDto> selectLikeBlogs(String username);

    /**
     * 通过用户名查询博客
     * @param username username
     * @return 博客列表
     */
    List<DtsBlogDto> selectBlogListByUsername(String username);

    /**
     * 获取前1000条数据
     */
    List<DtsBlogDto> selectBlogList1000();


}
