package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.DtsVbo;
import net.ttcxy.tang.model.DtsVboExample;
import org.apache.ibatis.annotations.Param;

public interface DtsVboMapper {
    long countByExample(DtsVboExample example);

    int deleteByExample(DtsVboExample example);

    int deleteByPrimaryKey(String id);

    int insert(DtsVbo record);

    int insertSelective(DtsVbo record);

    List<DtsVbo> selectByExampleWithBLOBs(DtsVboExample example);

    List<DtsVbo> selectByExample(DtsVboExample example);

    DtsVbo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DtsVbo record, @Param("example") DtsVboExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsVbo record, @Param("example") DtsVboExample example);

    int updateByExample(@Param("record") DtsVbo record, @Param("example") DtsVboExample example);

    int updateByPrimaryKeySelective(DtsVbo record);

    int updateByPrimaryKeyWithBLOBs(DtsVbo record);

    int updateByPrimaryKey(DtsVbo record);
}