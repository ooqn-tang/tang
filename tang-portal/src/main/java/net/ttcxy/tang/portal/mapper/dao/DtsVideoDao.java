package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsVideoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsVideoDao {
    DtsVideoDto selectById(@Param("videoId") String videoId);

    List<DtsVideoDto> select(@Param("title") String title,@Param("videoClass") String videoClass);

    List<DtsVideoDto> selectByUsername(@Param("username") String username);
}
