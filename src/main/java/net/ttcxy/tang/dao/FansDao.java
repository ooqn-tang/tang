package net.ttcxy.tang.dao;

import net.ttcxy.tang.entity.Fans;
import net.ttcxy.tang.entity.LoginUser;
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
    int selectFans(Fans fans);

    /**
     * 添加粉丝
     */
    int insertFans(Fans fans);

    /**
     * 删除粉丝
     */
    int deleteFans(Fans fans);

    List<LoginUser> selectFansList(@Param("userId")String userId);
}
