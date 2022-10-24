package cn.ttcxy.service;

import cn.ttcxy.dao.dsl.DtsClassDsl;
import cn.ttcxy.entity.model.DtsClass;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsClassService {

  @Autowired
  private DtsClassDsl classDsl;

  public List<DtsClass> selectClass(String type) {
    return classDsl.selectClass(type);
  }
}
