package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsContent;
import net.ttcxy.tang.portal.entity.model.DtsContentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsContentMapper {
    long countByExample(DtsContentExample example);

    int deleteByExample(DtsContentExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(DtsContent record);

    int insertSelective(DtsContent record);

    List<DtsContent> selectByExampleWithBLOBs(DtsContentExample example);

    List<DtsContent> selectByExample(DtsContentExample example);

    DtsContent selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") DtsContent record, @Param("example") DtsContentExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsContent record, @Param("example") DtsContentExample example);

    int updateByExample(@Param("record") DtsContent record, @Param("example") DtsContentExample example);

    int updateByPrimaryKeySelective(DtsContent record);

    int updateByPrimaryKeyWithBLOBs(DtsContent record);
}