package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.param.DtsVideoParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
