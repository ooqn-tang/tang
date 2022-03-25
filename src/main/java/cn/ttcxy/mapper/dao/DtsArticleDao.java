package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsArticleDao {

    List<DtsArticleDto> selectArticleList(@Param("tagName") String tagName);

    List<DtsArticleDto> selectArticleListSmall();

    List<DtsArticleDto> search(@Param("title") String title);

    DtsArticleDto selectArticleById(@Param("id") String id);

    DtsArticleDto selectArticleAllById(@Param("id") String id);

    List<DtsArticleDto> selectArticleListByUsername(@Param("username") String username);

    List<DtsArticleDto> selectArticleList1000();

}
