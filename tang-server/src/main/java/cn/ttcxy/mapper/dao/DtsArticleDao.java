package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.DtsArticleDto;

/**
 * 文章
 */
public interface DtsArticleDao {

    List<DtsArticleDto> selectArticleList(String classId);

    List<DtsArticleDto> selectGzArticleList(String authorId);

    List<DtsArticleDto> selectArticleListSmall();

    List<DtsArticleDto> search(String title);

    DtsArticleDto selectArticleById(String id);

    DtsArticleDto selectArticleAllById(String id);

    List<DtsArticleDto> selectArticleListByUsername(String username);

    List<DtsArticleDto> selectArticleList1000();

}
