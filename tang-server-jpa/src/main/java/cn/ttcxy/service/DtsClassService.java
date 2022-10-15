package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ttcxy.mapper.dsl.DtsClassDsl;
import cn.ttcxy.entity.model.DtsClass;

@Service
public class DtsClassService {

    @Autowired
    private DtsClassDsl classDsl;

    public List<DtsClass> selectClass(String type) {
        return classDsl.selectClass(type);
    }
}
