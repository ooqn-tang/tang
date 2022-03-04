package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.StsNotice;
import net.ttcxy.tang.portal.entity.model.StsNoticeExample;
import org.apache.ibatis.annotations.Param;

public interface StsNoticeMapper {
    long countByExample(StsNoticeExample example);

    int deleteByExample(StsNoticeExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(StsNotice record);

    int insertSelective(StsNotice record);

    List<StsNotice> selectByExample(StsNoticeExample example);

    StsNotice selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("record") StsNotice record, @Param("example") StsNoticeExample example);

    int updateByExample(@Param("record") StsNotice record, @Param("example") StsNoticeExample example);

    int updateByPrimaryKeySelective(StsNotice record);

    int updateByPrimaryKey(StsNotice record);
}