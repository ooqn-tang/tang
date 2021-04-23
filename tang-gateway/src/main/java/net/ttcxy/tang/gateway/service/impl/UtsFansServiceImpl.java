package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.UtsAuthorDao;
import net.ttcxy.tang.gateway.dao.UtsFansDao;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.entity.dto.UtsFansDto;
import net.ttcxy.tang.gateway.entity.dto.UtsLoginDto;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsFansService;
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
    private CurrentAuthorService currentAuthorServiceImpl;

    @Autowired
    private UtsAuthorDao utsAuthorDao;

    @Override
    public PageInfo<UtsAuthorDto> selectFansList(String authorId){
        return null;
    }

    @Override
    public int insertFans(String fansName) {
        return 0;
    }

    @Override
    public int deleteFans(String fansName){
        return 0;
    }
}
