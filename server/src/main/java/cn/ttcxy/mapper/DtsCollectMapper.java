package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.entity.model.DtsCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsCollectMapper {
    long countByExample(DtsCollectExample example);

    int deleteByExample(DtsCollectExample example);

    int deleteByPrimaryKey(String collectId);

    int insert(DtsCollect row);

    int insertSelective(DtsCollect row);

    List<DtsCollect> selectByExample(DtsCollectExample example);

    DtsCollect selectByPrimaryKey(String collectId);

    int updateByExampleSelective(@Param("row") DtsCollect row, @Param("example") DtsCollectExample example);

    int updateByExample(@Param("row") DtsCollect row, @Param("example") DtsCollectExample example);

    int updateByPrimaryKeySelective(DtsCollect row);

    int updateByPrimaryKey(DtsCollect row);
}