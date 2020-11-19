package net.ttcxy.tang.service.impl;

import net.ttcxy.tang.db.dao.UtsResourceDao;
import net.ttcxy.tang.entity.dto.UtsResourceDto;
import net.ttcxy.tang.entity.model.UtsResource;
import net.ttcxy.tang.service.UtsResourceService;
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

    @Override
    public List<UtsResource> listAll() {
        return null;
    }
}
