package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.gateway.dao.FansDao;
import net.ttcxy.tang.gateway.dao.UserDao;
import net.ttcxy.tang.gateway.entity.dto.FansDto;
import net.ttcxy.tang.gateway.entity.LoginUser;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
        }catch (DuplicateKeyException e){
            deleteFans(fansName);
            return 0;
        }
    }

    @Override
    public int deleteFans(String fansName){
        FansDto fansDto = getFans(fansName);
        return fansDao.deleteFans(fansDto);
    }

    @Override
    public List<LoginUser> selectFansList(String userId) {
        return fansDao.selectFansList(userId);
    }

    private FansDto getFans(String fansName){
        LoginUser loginUserAuth = authDetailsServiceImpl.getUser();
        if (loginUserAuth ==null){
            return null;
        }
        LoginUser loginUser = userDao.selectUserByName(fansName);
        FansDto fansDto = new FansDto();
        fansDto.setId(IdUtil.fastSimpleUUID());
        fansDto.setUserId(loginUserAuth.getId());
        fansDto.setFollower(loginUser.getId());
        fansDto.setCreateDate(new Date());

        return fansDto;
    }



}
