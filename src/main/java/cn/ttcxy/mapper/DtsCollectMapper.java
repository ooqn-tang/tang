package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.entity.model.DtsCollectExample;
import org.apache.ibatis.annotations.Param;

public interface DtsCollectMapper {
    long countByExample(DtsCollectExample example);

    int deleteByExample(DtsCollectExample example);

    int deleteByPrimaryKey(String collectId);

    int insert(DtsCollect record);

    int insertSelective(DtsCollect record);

    List<DtsCollect> selectByExample(DtsCollectExample example);

    DtsCollect selectByPrimaryKey(String collectId);

    int updateByExampleSelective(@Param("record") DtsCollect record, @Param("example") DtsCollectExample example);

    int updateByExample(@Param("record") DtsCollect record, @Param("example") DtsCollectExample example);

    int updateByPrimaryKeySelective(DtsCollect record);

    int updateByPrimaryKey(DtsCollect record);
}