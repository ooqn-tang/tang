package net.ttcxy.tang.portal.service;

import net.ttcxy.tang.portal.entity.dto.UtsDynamicDto;
import net.ttcxy.tang.portal.mapper.dao.DtsDynamicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicService {

    @Autowired
    private DtsDynamicDao dtsDynamicDao;

    public List<UtsDynamicDto> authorDynamicList(String username,String type) {
        return dtsDynamicDao.selectAuthorFansDynamic(username,type);
    }
}
