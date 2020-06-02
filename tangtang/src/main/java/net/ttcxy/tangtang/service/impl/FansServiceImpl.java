package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.entity.FansDto;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.dao.FansDao;
import net.ttcxy.tangtang.dao.UserDao;
import net.ttcxy.tangtang.service.AuthDetailsService;
import net.ttcxy.tangtang.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 粉丝相关
 * @author huanglei
 */
@Service
public class FansServiceImpl implements FansService {

    @Autowired
    private FansDao fansDao;

    @Autowired
    private AuthDetailsService authDetailsServiceImpl;

    @Autowired
    private UserDao userDao;

    @Override
    public int selectFans(String fansName){
        FansDto fansDto = getFans(fansName);
        return fansDao.selectFans(fansDto);
    }

    @Override
    public int insertFans(String fansName) {
        try{
            FansDto fansDto = getFans(fansName);
            return fansDao.insertFans(fansDto);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int deleteFans(String fansName){
        FansDto fansDto = getFans(fansName);
        return fansDao.deleteFans(fansDto);
    }

    @Override
    public List<UserDto> selectFansList(String userId) {
        return fansDao.selectFansList(userId);
    }

    private FansDto getFans(String fansName){
        UserDto userDtoAuth = authDetailsServiceImpl.getUser();
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



}
