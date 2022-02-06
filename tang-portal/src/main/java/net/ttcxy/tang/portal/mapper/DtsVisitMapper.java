package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsVisit;
import net.ttcxy.tang.portal.entity.model.DtsVisitExample;
import org.apache.ibatis.annotations.Param;

public interface DtsVisitMapper {
    long countByExample(DtsVisitExample example);

    int deleteByExample(DtsVisitExample example);

    int deleteByPrimaryKey(String visitId);

    int insert(DtsVisit record);

    int insertSelective(DtsVisit record);

    List<DtsVisit> selectByExample(DtsVisitExample example);

    DtsVisit selectByPrimaryKey(String visitId);

    int updateByExampleSelective(@Param("record") DtsVisit record, @Param("example") DtsVisitExample example);

    int updateByExample(@Param("record") DtsVisit record, @Param("example") DtsVisitExample example);

    int updateByPrimaryKeySelective(DtsVisit record);

    int updateByPrimaryKey(DtsVisit record);
}