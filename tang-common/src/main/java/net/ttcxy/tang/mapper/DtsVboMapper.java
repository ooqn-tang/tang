package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.DtsVbo;
import net.ttcxy.tang.model.DtsVboExample;
import org.apache.ibatis.annotations.Param;

public interface DtsVboMapper {
    long countByExample(DtsVboExample example);

    int deleteByExample(DtsVboExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(DtsVbo record);

    int insertSelective(DtsVbo record);

    List<DtsVbo> selectByExample(DtsVboExample example);

    DtsVbo selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") DtsVbo record, @Param("example") DtsVboExample example);

    int updateByExample(@Param("record") DtsVbo record, @Param("example") DtsVboExample example);

    int updateByPrimaryKeySelective(DtsVbo record);

    int updateByPrimaryKey(DtsVbo record);
}