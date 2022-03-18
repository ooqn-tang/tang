package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import cn.ttcxy.entity.dto.DtsViewDto;
import cn.ttcxy.entity.model.DtsView;
import cn.ttcxy.mapper.DtsViewMapper;
import cn.ttcxy.mapper.dao.DtsViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 访问记录
 */
@Service
public class DtsViewService {

    @Autowired
    private DtsViewMapper viewMapper;

    @Autowired
    private DtsViewDao viewDao;

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

    public PageInfo<DtsViewDto> list(String type) {
        List<DtsViewDto> viewList = viewDao.list(type);
        return new PageInfo<>(viewList);
    }
}