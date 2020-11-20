package net.ttcxy.tang.service.impl;

import net.ttcxy.tang.db.dao.UtsResourceDao;
import net.ttcxy.tang.entity.dto.UtsResourceDto;
import net.ttcxy.tang.entity.dto.UtsRoleDto;
import net.ttcxy.tang.entity.model.UtsResource;
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
    UtsResourceDao utsResourceDao;


    @Override
    public List<UtsResourceDto> resourceList() {
        return utsResourceDao.selectResource();
    }

    @Override
    public List<UtsResourceDto> listAll() {
        List<UtsResourceDto> utsResourceDtoList = new ArrayList<>();
        UtsResourceDto utsResourceDto = new UtsResourceDto();
        utsResourceDto.setPath("/a");
        List<UtsRoleDto> utsRoleDtoList = new ArrayList<>();
        utsResourceDto.setRoleDtoList(utsRoleDtoList);
        return utsResourceDtoList;
    }
}
