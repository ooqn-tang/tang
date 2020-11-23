package net.ttcxy.tang.service.impl;

import net.ttcxy.tang.db.dao.UtsResourceDao;
import net.ttcxy.tang.db.mapper.UtsResourceMapper;
import net.ttcxy.tang.entity.dto.UtsResourceDto;
import net.ttcxy.tang.entity.dto.UtsRoleDto;
import net.ttcxy.tang.entity.model.UtsResource;
import net.ttcxy.tang.entity.model.UtsResourceExample;
import net.ttcxy.tang.entity.model.UtsRole;
import net.ttcxy.tang.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanglei
 */
@Service
public class UtsResourceServiceImpl implements UtsResourceService {

    @Autowired
    private UtsResourceDao utsResourceDao;

    @Autowired
    private UtsResourceMapper utsResourceMapper;

    @Override
    public List<UtsResourceDto> listAll() {
        return utsResourceDao.selectResource();
    }

    @Override
    public List<UtsResource> resourceList() {
        return utsResourceMapper.selectByExample(null);
    }

    @Override
    public int insertResource(UtsResource resource) {
        return utsResourceMapper.insertSelective(resource);
    }

    @Override
    public int deleteResource(String id) {
        return utsResourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateResource(UtsResource resource) {
        return utsResourceMapper.updateByPrimaryKeySelective(resource);
    }
}
