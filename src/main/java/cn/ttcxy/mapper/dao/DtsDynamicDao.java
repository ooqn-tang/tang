package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.UtsDynamicDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsDynamicDao {

    List<UtsDynamicDto> selectAuthorFansDynamic(@Param("username") String username, @Param("type") String type);

}
