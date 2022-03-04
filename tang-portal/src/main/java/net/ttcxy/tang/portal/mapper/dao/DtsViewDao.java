package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsViewDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsViewDao {
    List<DtsViewDto> list(@Param("type") String type);
}
