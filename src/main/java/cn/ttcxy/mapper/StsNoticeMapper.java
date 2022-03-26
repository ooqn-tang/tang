package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.entity.model.StsNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StsNoticeMapper {
    long countByExample(StsNoticeExample example);

    int deleteByExample(StsNoticeExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(StsNotice row);

    int insertSelective(StsNotice row);

    List<StsNotice> selectByExample(StsNoticeExample example);

    StsNotice selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("row") StsNotice row, @Param("example") StsNoticeExample example);

    int updateByExample(@Param("row") StsNotice row, @Param("example") StsNoticeExample example);

    int updateByPrimaryKeySelective(StsNotice row);

    int updateByPrimaryKey(StsNotice row);
}