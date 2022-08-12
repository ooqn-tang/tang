package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.mapper.DtsArticleMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
