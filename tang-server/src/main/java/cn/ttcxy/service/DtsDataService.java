package cn.ttcxy.service;

import cn.ttcxy.mapper.dsl.DtsDataDsl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsDataService {

    @Autowired
    private DtsDataDsl dataDsl;

    public String selectDataAuthorId(String dataId){
        return dataDsl.selectDataAuthorId(dataId);
    }
}
