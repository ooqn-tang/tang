package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.gateway.dao.FansDao;
import net.ttcxy.tang.gateway.dao.AuthorDao;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.FansDto;
import net.ttcxy.tang.gateway.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.FansService;
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
public class FansServiceImpl implements FansService {

    @Autowired
    private FansDao fansDao;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Autowired
    private AuthorDao authorDao;

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
    public List<AuthorLogin> selectFansList(String userId) {
        return fansDao.selectFansList(userId);
    }

    private FansDto getFans(String fansName){
        AuthorLogin authorAuth = currentAuthorServiceImpl.getAuthor();
        if (authorAuth ==null){
            return null;
        }
        AuthorLogin author = authorDao.selectAuthorByName(fansName);
        FansDto fansDto = new FansDto();
        fansDto.setId(IdUtil.fastSimpleUUID());
        fansDto.setUserId(authorAuth.getId());
        fansDto.setFollower(author.getId());
        fansDto.setCreateDate(new Date());

        return fansDto;
    }

}
