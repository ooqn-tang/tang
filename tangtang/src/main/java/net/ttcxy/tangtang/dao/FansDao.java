package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.FansDto;
import net.ttcxy.tangtang.entity.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huanglei
 */
public interface FansDao {


    int selectFans(FansDto fansDto);

    int insertFans(FansDto fansDto);

    int deleteFans(FansDto fansDto);

    List<UserDto> selectFansList(@Param("userId")String userId);
}
