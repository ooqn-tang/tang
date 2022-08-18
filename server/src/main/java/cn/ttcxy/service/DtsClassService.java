package cn.ttcxy.service;

import cn.ttcxy.entity.model.DtsClass;
import cn.ttcxy.entity.model.DtsClassExample;
import cn.ttcxy.mapper.DtsClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsClassService {

    @Autowired
    private DtsClassMapper classMapper;

    public List<DtsClass> selectClass(String type) {
        DtsClassExample classExample = new DtsClassExample();
        classExample.createCriteria().andTypeEqualTo(type);
        return classMapper.selectByExample(classExample);
    }
}
