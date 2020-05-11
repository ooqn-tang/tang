package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.entity.FansDto;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.dao.FansDao;
import net.ttcxy.tangtang.dao.UserDao;
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
    private FansDao fansDao;

    @Autowired
    AuthDetailsImpl authDetails;

    @Autowired
    UserDao userDao;

    public Boolean selectFans(String fansName){
        FansDto fansDto = getFans(fansName);
        if (fansDto ==null){
            return false;
        }
        int isOk = fansDao.selectFans(fansDto);
        if (isOk == 1){
            return true;
        }
        return false;
    }

    public Boolean insertFans(String fansName) {
        try{
            FansDto fansDto = getFans(fansName);
            if (fansDto ==null){
                return false;
            }
            int isOk = fansDao.insertFans(fansDto);
            if (isOk == 1){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public Boolean deleteFans(String fansName){
        FansDto fansDto = getFans(fansName);
        if (fansDto ==null){
            return false;
        }
        int isOk = fansDao.deleteFans(fansDto);
        if (isOk == 1){
            return true;
        }
        return false;
    }

    private FansDto getFans(String fansName){
        UserDto userDtoAuth = authDetails.getUser();
        if (userDtoAuth ==null){
            return null;
        }
        UserDto userDto = userDao.selectUserByName(fansName);
        FansDto fansDto = new FansDto();
        fansDto.setId(IdUtil.fastSimpleUUID());
        fansDto.setUserId(userDtoAuth.getId());
        fansDto.setFollower(userDto.getId());
        fansDto.setCreateDate(new Date());

        return fansDto;
    }


    public List<UserDto> selectFansList(String userId) {
        return fansDao.selectFansList(userId);
    }



}
