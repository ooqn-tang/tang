package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsViewDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsViewDao {

    List<DtsViewDto> list(@Param("type") String type);

}
