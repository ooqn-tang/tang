package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.DtsMessageDto;

/**
 * 动态
 */
public interface DtsMessageDao {

    List<DtsMessageDto> selectAuthorMessage(String authorId);

}
