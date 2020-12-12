package net.ttcxy.tang.admin.service.impl;

import net.ttcxy.tang.admin.dao.UtsResourceDao;
import net.ttcxy.tang.admin.entity.dto.UtsResourceDto;
import net.ttcxy.tang.admin.service.UtsResourceService;
import net.ttcxy.tang.mapper.UtsResourceMapper;
import net.ttcxy.tang.model.UtsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
