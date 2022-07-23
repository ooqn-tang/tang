package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.mapper.dao.DtsDynamicDao;
import cn.ttcxy.entity.dto.DtsDynamicDto;
import cn.ttcxy.entity.model.DtsDynamic;
import cn.ttcxy.mapper.DtsDynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsDynamicService {

    @Autowired
    private DtsDynamicMapper dynamicMapper;

    @Autowired
    private DtsDynamicDao dynamicDao;


    public Integer insert(DtsDynamic dynamic){
        dynamic.setDynamicId(IdUtil.objectId());
        dynamic.setCreateTime(DateUtil.date());
        return dynamicMapper.insertSelective(dynamic);
    }

    public Integer delete(String authorId){
        return dynamicMapper.deleteByPrimaryKey(authorId);
    }

    public List<DtsDynamicDto> select(String authorId, String type){
        return dynamicDao.select(authorId,type);
    }
}
