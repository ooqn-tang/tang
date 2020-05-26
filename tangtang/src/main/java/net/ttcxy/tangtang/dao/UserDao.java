package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huanglei
 */
public interface UserDao {

    /**
     * 通过邮箱查询用户是否存在
     * @param mail
     * @return
     */
    int selectEmailIsTrue(String mail);

    /**
     * 通过username查询用户是否存在
     * @param username
     * @return
     */
    int selectUsernameIsTrue(String username);

    /**
     * 查询用户详细信息
     * @param username
     * @return
     */
    UserDto selectUserByName(String username);





}
