package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.param.DtsVideoParam;

/**
 * 视频
 */
public interface DtsVideoDao {

    DtsVideoDto selectById(String videoId);

    List<DtsVideoDto> select(String title,String classId);

    List<DtsVideoDto> selectByUsername(String username);

    List<DtsVideoDto> selectList(DtsVideoParam videoParam);

    List<DtsVideoDto> selectGz(String authorId);

    List<DtsVideoDto> search(String wb);

    DtsVideoDto rand();

}
