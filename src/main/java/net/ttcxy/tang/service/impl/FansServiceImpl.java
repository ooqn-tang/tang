package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.dao.FansDao;
import net.ttcxy.tang.dao.UserDao;
import net.ttcxy.tang.entity.Fans;
import net.ttcxy.tang.entity.LoginUser;
import net.ttcxy.tang.service.AuthDetailsService;
import net.ttcxy.tang.service.FansService;
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
        Fans fans = getFans(fansName);
        return fansDao.selectFans(fans);
    }

    @Override
    public int insertFans(String fansName) {
        try{
            Fans fans = getFans(fansName);
            return fansDao.insertFans(fans);
        }catch (DuplicateKeyException e){
            deleteFans(fansName);
            return 0;
        }
    }

    @Override
    public int deleteFans(String fansName){
        Fans fans = getFans(fansName);
        return fansDao.deleteFans(fans);
    }

    @Override
    public List<LoginUser> selectFansList(String userId) {
        return fansDao.selectFansList(userId);
    }

    private Fans getFans(String fansName){
        LoginUser loginUserAuth = authDetailsServiceImpl.getUser();
        if (loginUserAuth ==null){
            return null;
        }
        LoginUser loginUser = userDao.selectUserByName(fansName);
        Fans fans = new Fans();
        fans.setId(IdUtil.fastSimpleUUID());
        fans.setUserId(loginUserAuth.getId());
        fans.setFollower(loginUser.getId());
        fans.setCreateDate(new Date());

        return fans;
    }



}
