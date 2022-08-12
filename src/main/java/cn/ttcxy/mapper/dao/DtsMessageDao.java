package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsMessageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态
 */
public interface DtsMessageDao {

    List<DtsMessageDto> selectAuthorMessage(String authorId);

}
