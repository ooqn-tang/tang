package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsVideoDto;
import net.ttcxy.tang.portal.entity.param.DtsVideoParam;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DtsVideoDao {
    DtsVideoDto selectById(@Param("videoId") String videoId);

    List<DtsVideoDto> select(@Param("title") String title,@Param("videoClass") String videoClass);

    List<DtsVideoDto> selectByUsername(@Param("username") String username);

    List<DtsVideoDto> selectList(DtsVideoParam videoParam);

    List<DtsVideoDto> selectGz(@Param("authorId")String authorId);

    List<DtsVideoDto> search(@Param("wb") String wb);

    List<DtsVideoDto> ranking(@Param("date1")Date date1,@Param("date2")Date date2);
}
