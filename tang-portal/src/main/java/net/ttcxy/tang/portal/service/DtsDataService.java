package net.ttcxy.tang.portal.service;

import net.ttcxy.tang.portal.mapper.dao.DtsDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsDataService {

    @Autowired
    private DtsDataDao dataDao;

    public String selectDataAuthorId(String dataId){
        return dataDao.selectDataAuthorId(dataId);
    }
}
