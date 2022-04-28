package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.param.DtsVideoParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsVideoDao {

    DtsVideoDto selectById(@Param("videoId") String videoId);

    List<DtsVideoDto> select(@Param("title") String title,@Param("classId") String classId);

    List<DtsVideoDto> selectByUsername(@Param("username") String username);

    List<DtsVideoDto> selectList(DtsVideoParam videoParam);

    List<DtsVideoDto> selectGz(@Param("authorId")String authorId);

    List<DtsVideoDto> search(@Param("wb") String wb);

    DtsVideoDto rand();

}
