package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsMessage;
import cn.ttcxy.entity.model.DtsMessageExample;
import org.apache.ibatis.annotations.Param;

public interface DtsMessageMapper {
    long countByExample(DtsMessageExample example);

    int deleteByExample(DtsMessageExample example);

    int deleteByPrimaryKey(String messageId);

    int insert(DtsMessage record);

    int insertSelective(DtsMessage record);

    List<DtsMessage> selectByExample(DtsMessageExample example);

    DtsMessage selectByPrimaryKey(String messageId);

    int updateByExampleSelective(@Param("record") DtsMessage record, @Param("example") DtsMessageExample example);

    int updateByExample(@Param("record") DtsMessage record, @Param("example") DtsMessageExample example);

    int updateByPrimaryKeySelective(DtsMessage record);

    int updateByPrimaryKey(DtsMessage record);
}