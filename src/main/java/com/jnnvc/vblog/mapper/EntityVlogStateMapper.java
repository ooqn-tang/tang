package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.EntityVlogState;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntityVlogStateMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EntityVlogState record);

    int insertSelective(EntityVlogState record);



    EntityVlogState selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntityVlogState record);

    int updateByPrimaryKey(EntityVlogState record);
}