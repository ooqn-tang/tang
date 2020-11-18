package net.ttcxy.tang.db.dao;

import net.ttcxy.tang.entity.UtsAuthorLogin;
import net.ttcxy.tang.entity.dto.UtsFansDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 * @author huanglei
 */
public interface UtsFansDao {


    /**
     * 查询是否为粉丝
     * @param utsFansDto 粉丝
     * @return 查询的行数
     */
    int selectFans(UtsFansDto utsFansDto);

    /**
     * 添加粉丝
     * @param utsFansDto 粉丝
     * @return 影响的行数
     */
    int insertFans(UtsFansDto utsFansDto);

    /**
     * 删除粉丝
     * @param utsFansDto 粉丝
     * @return 影响的行数
     */
    int deleteFans(UtsFansDto utsFansDto);

    /**
     * 通过用户ID出现粉丝列表
     * @param userId id
     * @return 粉丝列表
     */
    List<UtsAuthorLogin> selectFansList(@Param("userId")String userId);
}
