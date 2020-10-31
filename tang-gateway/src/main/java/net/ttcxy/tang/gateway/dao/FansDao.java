package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.FansDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 * @author huanglei
 */
public interface FansDao {


    /**
     * 查询是否为粉丝
     * @param fansDto 粉丝
     * @return 查询的行数
     */
    int selectFans(FansDto fansDto);

    /**
     * 添加粉丝
     * @param fansDto 粉丝
     * @return 影响的行数
     */
    int insertFans(FansDto fansDto);

    /**
     * 删除粉丝
     * @param fansDto 粉丝
     * @return 影响的行数
     */
    int deleteFans(FansDto fansDto);

    /**
     * 通过用户ID出现粉丝列表
     * @param userId id
     * @return 粉丝列表
     */
    List<AuthorLogin> selectFansList(@Param("userId")String userId);
}
