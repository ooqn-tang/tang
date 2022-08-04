package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章
 */
public interface DtsArticleDao {

    List<DtsArticleDto> selectArticleList(@Param("classId") String classId);

    List<DtsArticleDto> selectGzArticleList(@Param("authorId")String authorId);

    List<DtsArticleDto> selectArticleListSmall();

    List<DtsArticleDto> search(@Param("title") String title);

    DtsArticleDto selectArticleById(@Param("id") String id);

    DtsArticleDto selectArticleAllById(@Param("id") String id);

    List<DtsArticleDto> selectArticleListByUsername(@Param("username") String username);

    List<DtsArticleDto> selectArticleList1000();

}
