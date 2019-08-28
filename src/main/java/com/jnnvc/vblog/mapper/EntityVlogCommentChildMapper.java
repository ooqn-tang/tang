package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.EntityVlogCommentChild;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntityVlogCommentChildMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EntityVlogCommentChild record);

    int insertSelective(EntityVlogCommentChild record);


    EntityVlogCommentChild selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(EntityVlogCommentChild record);

    int updateByPrimaryKey(EntityVlogCommentChild record);
}