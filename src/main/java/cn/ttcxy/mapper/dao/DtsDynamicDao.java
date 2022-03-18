package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.UtsDynamicDto;

import java.util.List;

public interface DtsDynamicDao {
    public List<UtsDynamicDto> selectAuthorFansDynamic(String username,String type);
}
