package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.EntityVlog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntityVlogMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EntityVlog record);

    int insertSelective(EntityVlog record);



    EntityVlog selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(EntityVlog record);

    int updateByPrimaryKey(EntityVlog record);
}