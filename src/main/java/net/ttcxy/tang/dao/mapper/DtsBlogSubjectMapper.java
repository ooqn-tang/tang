package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.DtsBlogSubject;
import net.ttcxy.tang.entity.model.DtsBlogSubjectExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogSubjectMapper {
    long countByExample(DtsBlogSubjectExample example);

    int deleteByExample(DtsBlogSubjectExample example);

    int deleteByPrimaryKey(String blogSubjectId);

    int insert(DtsBlogSubject record);

    int insertSelective(DtsBlogSubject record);

    DtsBlogSubject selectByPrimaryKey(String blogSubjectId);

    int updateByExampleSelective(@Param("record") DtsBlogSubject record, @Param("example") DtsBlogSubjectExample example);

    int updateByExample(@Param("record") DtsBlogSubject record, @Param("example") DtsBlogSubjectExample example);

    int updateByPrimaryKeySelective(DtsBlogSubject record);

    int updateByPrimaryKey(DtsBlogSubject record);
}