package net.ttcxy.tang.portal.service;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.entity.model.DtsView;
import net.ttcxy.tang.portal.mapper.DtsViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 访问记录
 */
@Service
public class DtsViewService {

    @Autowired
    private DtsViewMapper viewMapper;

    public void insertView(String dataId, String authorId){
        String objectId = IdUtil.objectId();
        DtsView view = new DtsView();
        view.setViewId(objectId);
        view.setCreateDate(new Date());
        view.setCreateTime(new Date());
        view.setAuthorId(authorId);
        view.setDataId(dataId);
        try{
            viewMapper.insertSelective(view);
        }catch (Exception ignored){}

    }
}
