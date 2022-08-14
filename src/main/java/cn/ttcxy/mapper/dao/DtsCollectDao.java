package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.DtsDataDto;

/**
 * 收藏
 */
public interface DtsCollectDao {

    List<DtsDataDto> selectCollect(String username);

}
