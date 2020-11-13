package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.dao.UtsResourceDao;
import net.ttcxy.tang.gateway.entity.dto.UtsResourceDto;
import net.ttcxy.tang.gateway.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
public class UtsResourceServiceImpl implements UtsResourceService {

    @Autowired
    UtsResourceDao utsResourceDao;


    @Override
    public List<UtsResourceDto> resourceList() {
        return utsResourceDao.selectResource();
    }
}
