package cn.ttcxy.service;

import cn.ttcxy.entity.dto.UtsDynamicDto;
import cn.ttcxy.mapper.dao.DtsDynamicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的动态包括关注的作者，自己的内容等
 */
@Service
public class DtsDynamicService {

    @Autowired
    private DtsDynamicDao dtsDynamicDao;

    public List<UtsDynamicDto> authorDynamicList(String username,String type) {
        return dtsDynamicDao.selectAuthorFansDynamic(username,type);
    }
}
