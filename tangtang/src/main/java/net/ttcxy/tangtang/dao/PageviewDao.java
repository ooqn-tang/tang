package net.ttcxy.tangtang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PageviewDao {

    /**
     * 阅读内容
     * @param userId 查询者ID
     * @param dataId 查询内容ID
     * @return
     */
    @Insert("insert into `pageview` (user_id,data_id,create_datetime) values (#{userId},#{dataId},now())")
    int insertPageview(String userId,String dataId);

    /**
     * 通过InfoId 查询 count
     * @param dataId
     * @return
     */
    @Select("SELECT count(1) FROM `pageview` where data_id = #{dataId}")
    int selectPageviewCount(String dataId);
}
