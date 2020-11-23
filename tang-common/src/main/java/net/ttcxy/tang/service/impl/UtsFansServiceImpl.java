package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.db.dao.UtsFansDao;
import net.ttcxy.tang.db.dao.UtsMemberDao;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.entity.dto.UtsFansDto;
import net.ttcxy.tang.service.CurrentMemberService;
import net.ttcxy.tang.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 粉丝相关服务
 * @author huanglei
 */
@Service
public class UtsFansServiceImpl implements UtsFansService {

    @Autowired
    private UtsFansDao utsFansDao;

    @Autowired
    private CurrentMemberService currentMemberServiceImpl;

    @Autowired
    private UtsMemberDao utsMemberDao;

    @Override
    public int selectFans(String fansName){
        UtsFansDto utsFansDto = getFans(fansName);
        return utsFansDao.selectFans(utsFansDto);
    }

    @Override
    public int insertFans(String fansName) {
        try{
            UtsFansDto utsFansDto = getFans(fansName);
            return utsFansDao.insertFans(utsFansDto);
        }catch (DuplicateKeyException e){
            deleteFans(fansName);
            return 0;
        }
    }

    @Override
    public int deleteFans(String fansName){
        UtsFansDto utsFansDto = getFans(fansName);
        return utsFansDao.deleteFans(utsFansDto);
    }

    @Override
    public List<UtsMemberLogin> selectFansList(String userId) {
        return utsFansDao.selectFansList(userId);
    }

    private UtsFansDto getFans(String fansName){
        UtsMemberLogin authorAuth = currentMemberServiceImpl.getMember();
        if (authorAuth ==null){
            return null;
        }
        UtsMemberLogin author = utsMemberDao.selectMemberByName(fansName);
        UtsFansDto utsFansDto = new UtsFansDto();
        utsFansDto.setId(IdUtil.fastSimpleUUID());
        utsFansDto.setUserId(authorAuth.getId());
        utsFansDto.setFollower(author.getId());
        utsFansDto.setCreateDate(new Date());

        return utsFansDto;
    }

}
