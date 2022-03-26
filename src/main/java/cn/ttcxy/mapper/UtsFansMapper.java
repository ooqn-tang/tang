package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.UtsFans;
import cn.ttcxy.entity.model.UtsFansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtsFansMapper {
    long countByExample(UtsFansExample example);

    int deleteByExample(UtsFansExample example);

    int deleteByPrimaryKey(String fansId);

    int insert(UtsFans row);

    int insertSelective(UtsFans row);

    List<UtsFans> selectByExample(UtsFansExample example);

    UtsFans selectByPrimaryKey(String fansId);

    int updateByExampleSelective(@Param("row") UtsFans row, @Param("example") UtsFansExample example);

    int updateByExample(@Param("row") UtsFans row, @Param("example") UtsFansExample example);

    int updateByPrimaryKeySelective(UtsFans row);

    int updateByPrimaryKey(UtsFans row);
}