package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.dto.Fans;
import net.ttcxy.tangtang.entity.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huanglei
 */
public interface FansMapper {


    int selectFans(Fans fans);

    int insertFans(Fans fans);

    int deleteFans(Fans fans);

    List<User> selectFansList(@Param("userId")String userId);
}
