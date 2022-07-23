package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsDynamicDto;

import java.util.List;

public interface DtsDynamicDao {
    List<DtsDynamicDto> select(String authorId, String type);
}
