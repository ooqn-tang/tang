package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.dto.DtsDataDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsCollectDao {
    List<DtsDataDto> selectCollect(@Param("username") String username);
}
