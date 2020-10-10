package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.FansDto;
import net.ttcxy.tang.gateway.entity.LoginUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 * created by huanglei on 2020/10/10
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

    List<LoginUser> selectFansList(@Param("userId")String userId);
}
