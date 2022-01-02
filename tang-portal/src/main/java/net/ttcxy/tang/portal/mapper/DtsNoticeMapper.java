package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsNotice;
import net.ttcxy.tang.portal.entity.model.DtsNoticeExample;
import org.apache.ibatis.annotations.Param;

public interface DtsNoticeMapper {
    long countByExample(DtsNoticeExample example);

    int deleteByExample(DtsNoticeExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(DtsNotice record);

    int insertSelective(DtsNotice record);

    DtsNotice selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("record") DtsNotice record, @Param("example") DtsNoticeExample example);

    int updateByExample(@Param("record") DtsNotice record, @Param("example") DtsNoticeExample example);

    int updateByPrimaryKeySelective(DtsNotice record);

    int updateByPrimaryKey(DtsNotice record);
}