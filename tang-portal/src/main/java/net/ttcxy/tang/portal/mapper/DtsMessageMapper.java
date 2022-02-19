package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsMessage;
import net.ttcxy.tang.portal.entity.model.DtsMessageExample;
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