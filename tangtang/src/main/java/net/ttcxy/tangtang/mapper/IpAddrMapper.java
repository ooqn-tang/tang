package net.ttcxy.tangtang.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * @author ：HuangLei
 * @date ：2020/4/22 0022 20:32
 */
public interface IpAddrMapper {

    /**
     * 添加ipAddr
     * @param ip
     * @param userId
     * @return
     */
    @Insert("insert into user_ip (user_id,user_ip,create_date,url) values (#{userId},#{ip},NOW(),#{url})")
    int insertIpAddr(String userId,String ip,String url);
}
