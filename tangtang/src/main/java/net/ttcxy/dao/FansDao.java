package net.ttcxy.dao;

import net.ttcxy.entity.FansDto;
import net.ttcxy.entity.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 * @author huanglei
 */
public interface FansDao {


    /**
     * 查询是否为粉丝
     */
    int selectFans(FansDto fansDto);

    /**
     * 添加粉丝
     */
    int insertFans(FansDto fansDto);

    /**
     * 删除粉丝
     */
    int deleteFans(FansDto fansDto);

    List<UserDto> selectFansList(@Param("userId")String userId);
}
