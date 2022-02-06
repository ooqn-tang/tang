package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.UtsDynamicDto;

import java.util.List;

public interface DtsDynamicDao {
    public List<UtsDynamicDto> selectAuthorFansDynamic(String username,String type);
}
