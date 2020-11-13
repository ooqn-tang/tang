package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.dao.ResourceDao;
import net.ttcxy.tang.gateway.entity.dto.ResourceDto;
import net.ttcxy.tang.gateway.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceDao resourceDao;


    @Override
    public List<ResourceDto> resourceList() {
        return resourceDao.selectResource();
    }
}
