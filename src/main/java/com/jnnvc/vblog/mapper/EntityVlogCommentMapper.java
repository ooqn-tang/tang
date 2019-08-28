package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.EntityVlogComment;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntityVlogCommentMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EntityVlogComment record);

    int insertSelective(EntityVlogComment record);


    EntityVlogComment selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(EntityVlogComment record);

    int updateByPrimaryKey(EntityVlogComment record);
}