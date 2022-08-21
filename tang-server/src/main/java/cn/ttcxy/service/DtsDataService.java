package cn.ttcxy.service;

import cn.ttcxy.mapper.dao.DtsDataDao;
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
