package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsDataDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏
 */
public interface DtsCollectDao {

    List<DtsDataDto> selectCollect(String username);

}
