package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.entity.Fans;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.mapper.FansMapper;
import net.ttcxy.tangtang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class FansServiceImpl {

    @Autowired
    private FansMapper fansMapper;

    @Autowired
    AuthDetailsImpl authDetails;

    @Autowired
    UserMapper userMapper;

    public Boolean selectFans(String fansName){
        Fans fans = getFans(fansName);
        if (fans==null){
            return false;
        }
        int isOk = fansMapper.selectFans(fans);
        if (isOk == 1){
            return true;
        }
        return false;
    }

    public Boolean insertFans(String fansName) {
        try{
            Fans fans = getFans(fansName);
            if (fans==null){
                return false;
            }
            int isOk = fansMapper.insertFans(fans);
            if (isOk == 1){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public Boolean deleteFans(String fansName){
        Fans fans = getFans(fansName);
        if (fans==null){
            return false;
        }
        int isOk = fansMapper.deleteFans(fans);
        if (isOk == 1){
            return true;
        }
        return false;
    }

    private Fans getFans(String fansName){
        User userAuth = authDetails.getUser();
        if (userAuth==null){
            return null;
        }
        User user = userMapper.selectUserByName(fansName);
        Fans fans = new Fans();
        fans.setId(IdUtil.fastSimpleUUID());
        fans.setUserId(userAuth.getId());
        fans.setFollower(user.getId());
        fans.setCreateDate(new Date());

        return fans;
    }


    public List<User> selectFansList(String userId) {
        return fansMapper.selectFansList(userId);
    }
}
