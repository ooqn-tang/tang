package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.Fing;
import net.ttcxy.tang.entity.model.FingExample;
import org.apache.ibatis.annotations.Param;

public interface FingMapper {
    long countByExample(FingExample example);

    int deleteByExample(FingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Fing record);

    int insertSelective(Fing record);

    List<Fing> selectByExample(FingExample example);

    Fing selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Fing record, @Param("example") FingExample example);

    int updateByExample(@Param("record") Fing record, @Param("example") FingExample example);

    int updateByPrimaryKeySelective(Fing record);

    int updateByPrimaryKey(Fing record);
}