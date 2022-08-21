package cn.ttcxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsDataDto;
import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.entity.model.DtsCollectExample;
import cn.ttcxy.mapper.DtsCollectMapper;
import cn.ttcxy.mapper.dao.DtsCollectDao;
import cn.ttcxy.mapper.dao.DtsDataDao;

@Service
public class DtsCollectService {

    @Autowired
    private DtsCollectMapper collectMapper;

    @Autowired
    private DtsCollectDao collectDao;

    @Autowired
    private DtsDataDao dataDao;

    public long select(String authorId, String dataId) {
        DtsCollectExample collectExample = new DtsCollectExample();
        collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
        return collectMapper.countByExample(collectExample);
    }

    public PageInfo<DtsDataDto> selectCollect(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(collectDao.selectCollect(username));
    }

    public int insert(String authorId, String dataId) {
        Integer type = dataDao.selectDataType(dataId);
        try{
            DtsCollectExample collectExample = new DtsCollectExample();
            collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
            DtsCollect dtsCollect = new DtsCollect();
            String id = IdUtil.objectId();
            dtsCollect.setAuthorId(authorId);
            dtsCollect.setDataId(dataId);
            dtsCollect.setCollectId(id);
            dtsCollect.setType(type);
            dtsCollect.setCreateDate(DateUtil.date());
            return collectMapper.insert(dtsCollect);
        }catch (DuplicateKeyException e){
            return 1;
        }
    }

    public int unCollect(String authorId, String dataId) {
        DtsCollectExample collectExample = new DtsCollectExample();
        collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
        return collectMapper.deleteByExample(collectExample);
    }
}
