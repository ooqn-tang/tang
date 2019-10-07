package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Pageview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PageviewMapper {

    /**
     * 阅读内容
     * @param userId 查询者ID
     * @param dataId 查询内容ID
     * @return
     */
    @Insert("insert into `entity_pageview` (user_id,data_id,create_datetime) values (#{userId},#{dataId},now())")
    int insertPageview(String userId,String dataId);

    /**
     * 通过InfoId 查询 count
     * @param dataId
     * @return
     */
    @Select("SELECT count(1) FROM `entity_pageview` where data_id = #{dataId}")
    int selectPageviewCount(String dataId);
}
