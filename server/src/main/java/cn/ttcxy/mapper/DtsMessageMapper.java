package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsMessage;
import cn.ttcxy.entity.model.DtsMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsMessageMapper {
    long countByExample(DtsMessageExample example);

    int deleteByExample(DtsMessageExample example);

    int deleteByPrimaryKey(String messageId);

    int insert(DtsMessage row);

    int insertSelective(DtsMessage row);

    List<DtsMessage> selectByExample(DtsMessageExample example);

    DtsMessage selectByPrimaryKey(String messageId);

    int updateByExampleSelective(@Param("row") DtsMessage row, @Param("example") DtsMessageExample example);

    int updateByExample(@Param("row") DtsMessage row, @Param("example") DtsMessageExample example);

    int updateByPrimaryKeySelective(DtsMessage row);

    int updateByPrimaryKey(DtsMessage row);
}